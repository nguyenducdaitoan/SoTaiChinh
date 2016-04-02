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


import vn.softech.dao.ChuyenMucDao;
import vn.softech.hibernate.TblChuyenMuc;
import vn.softech.form.ChuyenMucForm;

@Controller
@RequestMapping("/admin/tintuc/")
public class TinTucDanhMucListController  {
	private static ChuyenMucDao danhmucdao  = null;
	private static List<TblChuyenMuc> listdanhmuc = null;
	private static TblChuyenMuc danhmuc = new TblChuyenMuc();
	private static Logger logger = Logger.getLogger(TinTucDanhMucListController.class);	

	@RequestMapping(value = "/danhmuclist")
	public String showListDanhMuc (@ModelAttribute("danhmuc") ChuyenMucForm form, Model model) throws Exception {
		logger.debug("showListDanhMuc called.");
		danhmucdao = new ChuyenMucDao();
		listdanhmuc=danhmucdao.get();
		logger.debug(listdanhmuc.size());		
		model.addAttribute("listdanhmuc",listdanhmuc);
		return "admin/tintuc/danhmuclist";
	}
	
	@RequestMapping(value = "/action")
	public String actionDanhMuc(@ModelAttribute("danhmuc") ChuyenMucForm form, Model model) throws Exception{
		logger.info("actionDanhMuc called.");
		String action = form.getAction();
		//debug
		logger.debug("=============BEGIN FORM==================");
		logger.debug("ChuyenMucForm ID : " + form.getChuyenMucId());
		logger.debug("ChuyenMucForm Title   : " + form.getTitle());
		logger.debug("ChuyenMucForm Priority  : " + form.getPriority());
		logger.debug("ChuyenMucForm action  : " + form.getAction());
		logger.debug("=============END FORM==================");
		Date now = new Date();
		danhmucdao = new ChuyenMucDao();
		danhmuc = new TblChuyenMuc();
		if("".equals(action)){ //add new danhmuc
			logger.info("called Add new.");
			danhmuc.setTitle(form.getTitle());
			danhmuc.setPriority(form.getPriority());
			danhmuc.setStatus((byte)1);
			danhmuc.setCreated(now);
			danhmuc.setModified(now);
			long chuyenMucId = danhmucdao.save(danhmuc);
			logger.info("chuyenMucId add New : " + chuyenMucId);
			if (chuyenMucId> 0) {
				logger.debug("Thêm danh mục thủ tục hành chính thành công");
			} else {
				logger.debug("Thêm danh mục thủ tục hành chính thất bại");
			}
			
		} else if("update".equals(action)){ // Update danhmuc
			short chuyenMucId = form.getChuyenMucId();
			logger.info("called Update.");
			logger.info("chuyenMucId update : " + chuyenMucId);
			if (chuyenMucId >= 0) {
				danhmuc = danhmucdao.get(chuyenMucId);
				if(danhmuc != null){
					danhmuc.setChuyenMucId(chuyenMucId);
					danhmuc.setTitle(form.getTitle());
					danhmuc.setPriority(form.getPriority());
					danhmuc.setModified(now);
					danhmucdao.update(danhmuc);
				} else {
					logger.info("Chuyên mục này không tồn tại.");
				}
			} else {
				logger.info("called update Danh Muc TTHC. chuyenMucId is null.");
			}
			
		} else if("delete".equals(action)){ // Delele danhmuc
			logger.info("called Dalete.");
			short chuyenMucId = form.getChuyenMucId();
			if (chuyenMucId >= 0) {
				danhmuc = danhmucdao.get(chuyenMucId);
				if(danhmuc != null){
					danhmuc.setStatus((byte)3);
					danhmuc.setModified(now);
					danhmucdao.update(danhmuc);
				} else {
					logger.info("Danh mục thủ tục hành chính này không tồn tại.");
				}
			} else {
				logger.debug("Delete danh mục thủ tục hành chính fail");
			}
		}
		//load danhmuc list
		listdanhmuc=danhmucdao.get();
		logger.debug(listdanhmuc.size());		
		model.addAttribute("listdanhmuc",listdanhmuc);
		return "admin/tintuc/danhmuclist";
	}
	
	@RequestMapping(value = "/deleteAjax")
	public String deleteDanhMuc(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String arrchuyenMucId = request.getParameter("chuyenMucId");
		if ((arrchuyenMucId == null) || ("".equals(arrchuyenMucId))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"chuyenMucId là rỗng\"");
			response.getWriter().write("}");
			return null;
		}
		
		logger.debug("arrchuyenMucId: " + arrchuyenMucId);
		danhmucdao = new ChuyenMucDao();
		String error = danhmucdao.updateBatch(arrchuyenMucId);
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
