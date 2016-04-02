package vn.softech.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import vn.softech.dao.TthcDmDao;
import vn.softech.dao.TthcDao;
import vn.softech.hibernate.TblTthcDm;
import vn.softech.hibernate.TblTthc;
import vn.softech.form.TthcForm;
 
@Controller
public class ThuTucHanhChinhEditController {
	private static final Logger logger = Logger.getLogger(ThuTucHanhChinhEditController.class);
	private TthcForm thuTucHanhChinhForm = null;
	@RequestMapping(value = "admin/thutuchanhchinh/edit.html", method = RequestMethod.GET)
	public String showForm(Map model, HttpServletRequest request) throws Exception {
		logger.debug("showForm called");
		long thuTucHanhChinhId = Long.parseLong(request.getParameter("tthcId"));
		logger.debug("tthcId: " + thuTucHanhChinhId);
		TthcDao dao = new TthcDao();
		TblTthc thutuchanhchinh = dao.get(thuTucHanhChinhId);
		if (thutuchanhchinh == null) {
			throw new Exception("thuTucHanhChinhId: " + thuTucHanhChinhId + " is not exist!");
		}
		thuTucHanhChinhForm = new TthcForm();
		thuTucHanhChinhForm.setTthcId(thutuchanhchinh.getTthcId());
		thuTucHanhChinhForm.setTitle(thutuchanhchinh.getTitle());
		thuTucHanhChinhForm.setFileName(thutuchanhchinh.getFileName());
		thuTucHanhChinhForm.setActive(thutuchanhchinh.isActive());
		thuTucHanhChinhForm.setContent(thutuchanhchinh.getContent());
		thuTucHanhChinhForm.setTthcDmId(thutuchanhchinh.getTblTthcDm().getTthcDmId());
		thuTucHanhChinhForm.setCreated(thutuchanhchinh.getCreated());
		thuTucHanhChinhForm.setStatus(thutuchanhchinh.getStatus());
		model.put("thuTucHanhChinhForm", thuTucHanhChinhForm);
		return "admin/thutuchanhchinh/edit";
	}
	
	@ModelAttribute(value="listDanhMuc")
	public List<TblTthcDm> getListDanhMuc() {
		logger.debug("getListDanhMuc called");
		List<TblTthcDm> listDanhMuc = new ArrayList<TblTthcDm>();
		TthcDmDao dao = new TthcDmDao();
		listDanhMuc = dao.get();
		return listDanhMuc;
	}
	
	@ExceptionHandler({ Exception.class })
	public String handleException(Exception e, HttpServletRequest request) {
		logger.error(e.getMessage(), e);
		request.setAttribute("errorMessage", e.getMessage());
		return "admin/thutuchanhchinh/error";
	}

	@RequestMapping(value = "admin/thutuchanhchinh/edit.html", method = RequestMethod.POST)
	public String processForm(@Valid TthcForm thuTucHanhChinhForm,@RequestParam("txtFCKContent") String content, BindingResult result) throws Exception {
		logger.debug("processForm called");
		logger.debug("Thu tuc hanh chinh ID: " + thuTucHanhChinhForm.getTthcId());
		logger.debug("Title: " + thuTucHanhChinhForm.getTitle());
		logger.debug("File Name: " + thuTucHanhChinhForm.getFileName());
		logger.debug("Danh Muc ID: " + thuTucHanhChinhForm.getTthcDmId());
		
		TthcDao dao = new TthcDao();
		TblTthc thuTucHanhChinh = dao.get(thuTucHanhChinhForm.getTthcId());
		thuTucHanhChinh.setTthcId(thuTucHanhChinhForm.getTthcId());
		thuTucHanhChinh.setTitle(thuTucHanhChinhForm.getTitle());
		thuTucHanhChinh.setContent(content);
		thuTucHanhChinh.setFileName(thuTucHanhChinhForm.getFileName());
		thuTucHanhChinh.setActive(thuTucHanhChinhForm.isActive());
		TthcDmDao dmdao = new TthcDmDao();
		TblTthcDm tblTthcDm = dmdao.get(thuTucHanhChinhForm.getTthcDmId());
		thuTucHanhChinh.setTblTthcDm(tblTthcDm);
		thuTucHanhChinh.setModified(new Date());
		dao.update(thuTucHanhChinh);
		this.thuTucHanhChinhForm = null;
		return "redirect:/admin/thutuchanhchinh/list.html";
	}
}