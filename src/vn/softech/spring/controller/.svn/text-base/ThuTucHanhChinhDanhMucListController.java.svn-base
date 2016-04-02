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


import vn.softech.dao.TthcDmDao;
import vn.softech.hibernate.TblTthcDm;
import vn.softech.form.TthcDmForm;

@Controller
@RequestMapping("/admin/thutuchanhchinh")
public class ThuTucHanhChinhDanhMucListController  {
	private static TthcDmDao danhmucdao  = null;
	private static List<TblTthcDm> listdanhmuc = null;
	private static TblTthcDm danhmuc = new TblTthcDm();
	private static Logger logger = Logger.getLogger(ThuTucHanhChinhDanhMucListController.class);	

	@RequestMapping(value = "/danhmuclist")
	public String showListDanhMuc (@ModelAttribute("danhmuc") TthcDmForm form, Model model) throws Exception {
		logger.debug("showListDanhMuc called.");
		danhmucdao = new TthcDmDao();
		listdanhmuc=danhmucdao.get();
		logger.debug(listdanhmuc.size());		
		model.addAttribute("listdanhmuc",listdanhmuc);
		return "admin/thutuchanhchinh/danhmuclist";
	}
	
	@RequestMapping(value = "/action")
	public String actionDanhMuc(@ModelAttribute("danhmuc") TthcDmForm form, Model model) throws Exception{
		logger.info("actionDanhMuc called.");
		String action = form.getAction();
		//debug
		logger.debug("=============BEGIN FORM==================");
		logger.debug("DanhMuc TTHC Form ID : " + form.getTthcDmId());
		logger.debug("DanhMuc TTHC Form name   : " + form.getName());
		logger.debug("DanhMuc TTHC Form action  : " + form.getAction());
		logger.debug("=============END FORM==================");
		Date now = new Date();
		danhmucdao = new TthcDmDao();
		danhmuc = new TblTthcDm();
		if("".equals(action)){ //add new danhmuc
			logger.info("called Add new.");
			danhmuc.setName(form.getName());
			danhmuc.setStatus((byte)1);
			danhmuc.setCreated(now);
			danhmuc.setModified(now);
			long tthcDmId = danhmucdao.save(danhmuc);
			logger.info("tthcDmId add New : " + tthcDmId);
			if (tthcDmId> 0) {
				logger.debug("Thêm danh mục thủ tục hành chính thành công");
			} else {
				logger.debug("Thêm danh mục thủ tục hành chính thất bại");
			}
			
		} else if("update".equals(action)){ // Update danhmuc
			long tthcDmId = form.getTthcDmId();
			logger.info("called Update.");
			logger.info("tthcDmId update : " + tthcDmId);
			if (tthcDmId >= 0) {
				danhmuc = danhmucdao.get(tthcDmId);
				if(danhmuc != null){
					danhmuc.setTthcDmId(tthcDmId);
					danhmuc.setName(form.getName());
					danhmuc.setModified(now);
					danhmucdao.update(danhmuc);
				} else {
					logger.info("Danh Muc TTHC này không tồn tại.");
				}
			} else {
				logger.info("called update Danh Muc TTHC. tthcDmId is null.");
			}
			
		} else if("delete".equals(action)){ // Delele danhmuc
			logger.info("called Dalete.");
			long tthcDmId = form.getTthcDmId();
			if (tthcDmId >= 0) {
				danhmuc = danhmucdao.get(tthcDmId);
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
		return "admin/thutuchanhchinh/danhmuclist";
	}
	
	@RequestMapping(value = "/deleteAjax")
	public String deleteDanhMuc(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String arrTthcDmId = request.getParameter("tthcDmId");
		if ((arrTthcDmId == null) || ("".equals(arrTthcDmId))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"tthcDmId là rỗng\"");
			response.getWriter().write("}");
			return null;
		}
		
		logger.debug("arrTthcDmId: " + arrTthcDmId);
		danhmucdao = new TthcDmDao();
		String error = danhmucdao.updateBatch(arrTthcDmId);
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
