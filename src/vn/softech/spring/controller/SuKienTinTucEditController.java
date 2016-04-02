package vn.softech.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import vn.softech.dao.SuKienDao;
import vn.softech.form.SuKienTinTucForm;
import vn.softech.hibernate.TblSuKien;
import vn.softech.hibernate.TblSuKienTinTuc;
 
@Controller
public class SuKienTinTucEditController {
	private static final Logger logger = Logger.getLogger(SuKienTinTucEditController.class);
	private SuKienTinTucForm suKienTinTucForm = null;
	@RequestMapping(value = "admin/sukientintuc/edit.html", method = RequestMethod.GET)
	public String showForm(Map model, HttpServletRequest request) throws Exception {
		logger.debug("showForm called");
		long suKienTinTucId = Long.parseLong(request.getParameter("suKienTinTucId"));
		logger.debug("suKienTinTucId: " + suKienTinTucId);
		SuKienDao dao = new SuKienDao();
		TblSuKienTinTuc suKienTinTuc = dao.getSuKienTinTuc(suKienTinTucId);
		if (suKienTinTuc == null) {
			throw new Exception("suKienTinTucId: " + suKienTinTucId + " is not exist!");
		}
		suKienTinTucForm = new SuKienTinTucForm();
		suKienTinTucForm.setSuKienTinTucId(suKienTinTucId);
		suKienTinTucForm.setTitle(suKienTinTuc.getTitle());
		suKienTinTucForm.setSummary(suKienTinTuc.getSummary());
		suKienTinTucForm.setPathImage(suKienTinTuc.getPathImage());
		suKienTinTucForm.setActive(suKienTinTuc.isActive());
		suKienTinTucForm.setContent(suKienTinTuc.getContent());
		suKienTinTucForm.setSuKienId(suKienTinTuc.getSuKienId());
		model.put("suKienTinTucForm", suKienTinTucForm);
		return "admin/sukientintuc/edit";
	}
	
	@ModelAttribute(value="listSuKien")
	public List<TblSuKien> getListSuKien() {
		logger.debug("getListSuKien called");
		List<TblSuKien> listSuKien = new ArrayList<TblSuKien>();
		SuKienDao dao = new SuKienDao();
		listSuKien = dao.getSuKien();
		return listSuKien;
	}
	
	@ExceptionHandler({ Exception.class })
	public String handleException(Exception e, HttpServletRequest request) {
		logger.error(e.getMessage(), e);
		request.setAttribute("errorMessage", e.getMessage());
		return "admin/sukientintuc/error";
	}

	@RequestMapping(value = "admin/sukientintuc/edit.html", method = RequestMethod.POST)
	public String processForm(@Valid SuKienTinTucForm suKienTinTucForm,@RequestParam("txtFCKContent") String content, BindingResult result) throws Exception {
		logger.debug("processForm called");
		logger.debug("SuKienTinTucId: " + suKienTinTucForm.getSuKienTinTucId());
		logger.debug("Title: " + suKienTinTucForm.getTitle());
		logger.debug("Summary: " + suKienTinTucForm.getSummary());
		logger.debug("PathImage" + suKienTinTucForm.getPathImage());
		
		SuKienDao dao = new SuKienDao();
		TblSuKienTinTuc suKienTinTuc = dao.getSuKienTinTuc(suKienTinTucForm.getSuKienTinTucId());
		suKienTinTuc.setTitle(suKienTinTucForm.getTitle());
		suKienTinTuc.setSummary(suKienTinTucForm.getSummary());
		suKienTinTuc.setContent(content);
		suKienTinTuc.setPathImage(suKienTinTucForm.getPathImage());
		suKienTinTuc.setActive(suKienTinTucForm.isActive());
		suKienTinTuc.setSuKienId(suKienTinTucForm.getSuKienId());
		suKienTinTuc.setModified(new Date());
		dao.update(suKienTinTuc);
		this.suKienTinTucForm = null;
		return "redirect:/admin/sukientintuc/list.html";
	}
}