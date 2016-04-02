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

import vn.softech.dao.TthcDmDao;
import vn.softech.dao.TthcDao;
import vn.softech.hibernate.TblTthcDm;
import vn.softech.hibernate.TblTthc;
import vn.softech.form.TthcForm;
 
@Controller
public class ThuTucHanhChinhAddController {
	private static final Logger logger = Logger.getLogger(ThuTucHanhChinhAddController.class);
	
	@RequestMapping(value = "admin/thutuchanhchinh/add.html", method = RequestMethod.GET)
	public String showForm(Map model) throws Exception {
		logger.debug("showForm called!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");		
		TthcForm thuTucHanhChinhForm = new TthcForm();
		model.put("thuTucHanhChinhForm", thuTucHanhChinhForm);
		return "admin/thutuchanhchinh/add";
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

	@RequestMapping(value = "admin/thutuchanhchinh/add.html", method = RequestMethod.POST)
	public String processForm(@Valid TthcForm thuTucHanhChinhForm,@RequestParam("txtFCKContent") String content, BindingResult result) throws Exception {
		logger.debug("processForm called");
		logger.debug("Title: " + thuTucHanhChinhForm.getTitle());
		logger.debug("File Name" + thuTucHanhChinhForm.getFileName());
		logger.debug("Danh Muc ID" + thuTucHanhChinhForm.getTthcDmId());
		TthcDao dao = new TthcDao();
		TblTthc thuTucHanhChinh = new TblTthc();		
		thuTucHanhChinh.setTitle(thuTucHanhChinhForm.getTitle());
		thuTucHanhChinh.setContent(content);
		thuTucHanhChinh.setFileName(thuTucHanhChinhForm.getFileName());
		thuTucHanhChinh.setActive(thuTucHanhChinhForm.isActive());
		TthcDmDao dmdao = new TthcDmDao();
		TblTthcDm tblTthcDm = dmdao.get(thuTucHanhChinhForm.getTthcDmId());
		thuTucHanhChinh.setTblTthcDm(tblTthcDm);
		thuTucHanhChinh.setCreated(new Date());
		thuTucHanhChinh.setModified(new Date());
		thuTucHanhChinh.setStatus((byte)1);
		thuTucHanhChinh.setUsersId(1);
		dao.save(thuTucHanhChinh);
		return "redirect:/admin/thutuchanhchinh/list.html";
	}
}