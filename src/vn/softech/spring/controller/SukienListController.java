package vn.softech.spring.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.softech.dao.SuKienDao;
import vn.softech.hibernate.TblSuKien;
import vn.softech.form.SuKienForm;

@Controller
@RequestMapping("/admin/sukien")
public class SukienListController  {
	SuKienDao sukiendao= new SuKienDao();
	List<TblSuKien> listsukien;
	TblSuKien sukien = new TblSuKien();
	private static Logger logger = Logger.getLogger(SukienListController.class);	

	@RequestMapping(value = "/list")
	public String showListSuKien (@ModelAttribute("sukien") SuKienForm form, Model model) throws Exception {
		logger.debug("showListSuKien called.");	
		listsukien=sukiendao.get();
		logger.debug(listsukien.size());		
		model.addAttribute("listsukien",listsukien);
		return "admin/sukien/sukienlist";
	}
	
	@RequestMapping(value = "/action")
	public String actionSuKien(@ModelAttribute("sukien") SuKienForm form, Model model) throws Exception{
		logger.info("actionSuKien called.");
		String action = form.getAction();
		//debug
		logger.debug("=============BBEGIN FORM==================");
		logger.debug("SuKien Form sukienID : " + form.getSuKienId());
		logger.debug("SuKien Form name   : " + form.getName());
		logger.debug("SuKien Form action  : " + form.getAction());
		logger.debug("=============END FORM==================");
		Date now = new Date();
		
		if("".equals(action)){ //add new sukien
			logger.info("called Add new.");
			sukien.setName(form.getName());
			sukien.setPathImage(form.getPathImage());
			sukien.setActive(form.isActive());
			sukien.setStatus((byte)1);
			sukien.setCreated(now);
			sukien.setModified(now);
			long suKienId = sukiendao.save(sukien);
			logger.info("suKienId add New : " + suKienId);
			if (suKienId> 0) {
				logger.debug("Thêm sự kiện thành công");
			} else {
				logger.debug("Thêm sự kiện thất bại");
			}
			
		} else if("update".equals(action)){ // Update sukien
			long suKienId = form.getSuKienId();
			logger.info("called Update.");
			logger.info("suKienId update : " + suKienId);
			if (suKienId >= 0) {
				sukien = sukiendao.getSuKien(suKienId);
				if(sukien != null){
					sukien.setSuKienId(suKienId);
					sukien.setName(form.getName());
					sukien.setActive(form.isActive());
					sukien.setModified(now);
					sukiendao.update(sukien);
				} else {
					logger.info("SuKien này không tồn tại.");
				}
			} else {
				logger.info("called update. suKienId is null.");
			}
			
		} else if("delete".equals(action)){ // Delele sukien
			logger.info("called Dalete.");
			long suKienId = form.getSuKienId();
			if (suKienId >= 0) {
				sukien = sukiendao.getSuKien(suKienId);
				if(sukien != null){
					sukien.setStatus((byte)3);
					sukien.setModified(now);
					sukiendao.update(sukien);
				} else {
					logger.info("Sự kiện này không tồn tại.");
				}
			} else {
				logger.debug("Delete sự kiện fail");
			}
		}
		
		//load sukien list
		listsukien=sukiendao.get();
		logger.debug(listsukien.size());		
		model.addAttribute("listsukien",listsukien);
		return "admin/sukien/sukienlist";
	}
	
	@RequestMapping(value = "/deleteAjax")
	public String deleteSuKien(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String arrSuKienId = request.getParameter("suKienId");
		if ((arrSuKienId == null) || ("".equals(arrSuKienId))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"suKienId là rỗng\"");
			response.getWriter().write("}");
			return null;
		}
		
		logger.debug("arrSuKienId: " + arrSuKienId);

		String error = sukiendao.updateBatch(arrSuKienId);
		if ((error == null) || ("".equals(error))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"\"");
			response.getWriter().write("}");
			return null;
		}
		response.getWriter().write("{");
		response.getWriter().write("\"error\":\"" + error + "\"");
		response.getWriter().write("}");
		return null;
	}
}
