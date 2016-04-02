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

import vn.softech.dao.AdminSystemDao;
import vn.softech.form.LoginForm;
import vn.softech.form.UrlsForm;
import vn.softech.hibernate.TblPhongBan;
import vn.softech.hibernate.TblUrls;
import vn.softech.util.StringUtils;
 
@Controller
public class UrlsEditController {
	private static final Logger logger = Logger.getLogger(UrlsEditController.class);
	
	@RequestMapping(value = "admin/urls/edit.html", method = RequestMethod.GET)
	public String showForm(Map model, HttpServletRequest request) throws Exception {
		logger.debug("showForm called");
		long urlsId = Long.parseLong(request.getParameter("urlsId"));
		logger.debug("urlsId: " + urlsId);
		AdminSystemDao dao = new AdminSystemDao();
		TblUrls urls = dao.getUrls(urlsId);
		if (urls == null) {
			throw new Exception("urlsId: " + urlsId + " is not exist!");
		}
		UrlsForm urlsForm = new UrlsForm();
		urlsForm.setName(urls.getName());
		urlsForm.setUrlsId(urls.getUrlsId());
		urlsForm.setPriority(urls.getPriority());
		model.put("urlsForm", urlsForm);
		return "admin/urls/edit";
	}
/*	
	@ModelAttribute(value="listPhongBan")
	public List<TblPhongBan> getListPhongBan(HttpServletRequest request) {
		logger.debug("getListPhongBan called");
		List<TblPhongBan> listPhongBan = new ArrayList<TblPhongBan>();
		GroupsDao dao = new GroupsDao();
		listPhongBan = dao.getPhongBan();
		return listPhongBan;
	}
*/	
	@ExceptionHandler({ Exception.class })
	public String handleException(Exception e, HttpServletRequest request) {
		logger.error(e.getMessage(), e);
		request.setAttribute("errorMessage", e.getMessage());
		return "admin/urls/error";
	}

	@RequestMapping(value = "admin/urls/edit.html", method = RequestMethod.POST)
	public String processForm(@Valid UrlsForm urlsForm, BindingResult result,	Map model, HttpServletRequest request) throws Exception {
		logger.debug("processForm called");
		logger.debug("Urls Name: " + urlsForm.getName());
		AdminSystemDao dao = new AdminSystemDao();
		TblUrls urls = dao.getUrls(urlsForm.getUrlsId());
		if (urls == null) {
			throw new Exception("urlsId: " + urlsForm.getUrlsId() + " is not exist!");
		}
		urls.setName(urlsForm.getName());
		urls.setPriority(urlsForm.getPriority());
		dao.update(urls);
		return "redirect:/admin/urls/edit.html";
	}
}