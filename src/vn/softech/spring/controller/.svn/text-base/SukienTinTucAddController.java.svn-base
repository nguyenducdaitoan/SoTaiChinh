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
public class SukienTinTucAddController {
	private static final Logger logger = Logger.getLogger(SukienTinTucAddController.class);
	
	@RequestMapping(value = "admin/sukientintuc/add.html", method = RequestMethod.GET)
	public String showForm(Map model) throws Exception {
		logger.debug("showForm called");		
		SuKienTinTucForm suKienTinTucForm = new SuKienTinTucForm();
		model.put("suKienTinTucForm", suKienTinTucForm);
		return "admin/sukientintuc/add";
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

	@RequestMapping(value = "admin/sukientintuc/add.html", method = RequestMethod.POST)
	public String processForm(@Valid SuKienTinTucForm suKienTinTucForm,@RequestParam("txtFCKContent") String content, BindingResult result) throws Exception {
		logger.debug("processForm called");
		logger.debug("Title: " + suKienTinTucForm.getTitle());
		logger.debug("Summary: " + suKienTinTucForm.getSummary());
		logger.debug("PathImage" + suKienTinTucForm.getPathImage());
		SuKienDao dao = new SuKienDao();
		TblSuKienTinTuc suKienTinTuc = new TblSuKienTinTuc();		
		suKienTinTuc.setTitle(suKienTinTucForm.getTitle());
		suKienTinTuc.setSummary(suKienTinTucForm.getSummary());
		suKienTinTuc.setContent(content);
		suKienTinTuc.setPathImage(suKienTinTucForm.getPathImage());
		suKienTinTuc.setActive(suKienTinTucForm.isActive());
		suKienTinTuc.setSuKienId(suKienTinTucForm.getSuKienId());
		suKienTinTuc.setCreated(new Date());
		suKienTinTuc.setModified(new Date());
		suKienTinTuc.setStatus((byte)1);
		dao.save(suKienTinTuc);
		return "redirect:/admin/sukientintuc/list.html";
	}
}