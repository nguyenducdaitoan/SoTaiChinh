package vn.softech.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.softech.dao.AdminSystemDao;
import vn.softech.dao.SuKienDao;
import vn.softech.form.SuKienForm;
import vn.softech.hibernate.TblPhongBan;
import vn.softech.hibernate.TblSuKien;
import vn.softech.hibernate.TblSuKienTinTuc;;

@Controller
public class SukienTinTucListController {
	private static Logger logger = Logger.getLogger(SukienTinTucListController.class);	
	private static List<TblSuKienTinTuc> listSuKienTinTuc = null;
	
	@RequestMapping(value = "admin/sukientintuc/list.html", method = RequestMethod.GET)
	public String showListPage(HttpServletRequest request, HttpServletResponse reponse, Model model) {
		logger.debug("showListPage SukienTinTuc called");
		SuKienForm form= new SuKienForm();
		model.addAttribute("sukien", form);
		return "admin/sukientintuc/list";
	}
	
	@ModelAttribute(value="listSuKienTinTuc")
	public List<TblSuKienTinTuc> getlistSuKienTinTuc(HttpServletRequest request) {
		listSuKienTinTuc = new ArrayList<TblSuKienTinTuc>();
		SuKienDao dao = new SuKienDao();
		logger.debug("listSuKienTinTuc called");
		logger.debug("Su Kien ID =  " + request.getParameter("suKienId"));
		if ((request.getParameter("suKienId") == null) || ("".equals(request.getParameter("suKienId")))) {
			listSuKienTinTuc = dao.getSuKienTinTuc();
		}
		else
		{
			Long suKienId = Long.parseLong(request.getParameter("suKienId"));
			listSuKienTinTuc = dao.getSuKienTinTucBySuKienId(suKienId);
		}
		return listSuKienTinTuc;
	}
	
	@ModelAttribute(value="listSuKien")
	public List<TblSuKien> getlistSuKien() {
		logger.debug("getlistSuKien called");
		List<TblSuKien> listSuKien = new ArrayList<TblSuKien>();
		SuKienDao dao = new SuKienDao();
		listSuKien = dao.get();
		return listSuKien;
	}
	
	@RequestMapping(value="admin/sukientintuc/delete.html", method = RequestMethod.POST)
	public void processDeleteSuKienTinTuc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		StringBuffer ret = new StringBuffer();
		logger.debug("suKienTinTucIdTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT: " + request.getParameter("suKienTinTucId"));
		if ((request.getParameter("suKienTinTucId") == null) || ("".equals(request.getParameter("suKienTinTucId")))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"suKienTinTucId là rỗng\"");
			response.getWriter().write("}");
		} else {
			SuKienDao dao = new SuKienDao();
			String error = dao.updateBatchSKTT(request.getParameter("suKienTinTucId"));
			if ((error == null) || ("".equals(error))) {   
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"\"");
				response.getWriter().write("}");
			} else {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"" + error + "\"");
				response.getWriter().write("}");
			}
		}
	}
}
