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


import vn.softech.dao.TinTucDao;
import vn.softech.dao.ChuyenMucDao;
import vn.softech.dao.UsersDao;
import vn.softech.hibernate.TblTinTuc;
import vn.softech.hibernate.TblChuyenMuc;
import vn.softech.form.TinTucForm;;
 
@Controller
public class TinTucEditController {
	private static final Logger logger = Logger.getLogger(TinTucEditController.class);
	private TinTucForm tinTucForm = null;
	@RequestMapping(value = "admin/tintuc/edit.html", method = RequestMethod.GET)
	public String showForm(Map model, HttpServletRequest request) throws Exception {
		logger.debug("showForm called");
		long tinTucId = Long.parseLong(request.getParameter("tinTucId"));
		logger.debug("tinTucId: " + tinTucId);
		TinTucDao dao = new TinTucDao();
		TblTinTuc tinTuc = dao.get(tinTucId);
		if (tinTuc == null) {
			throw new Exception("tinTucId: " + tinTucId + " is not exist!");
		}
		tinTucForm = new TinTucForm();
		tinTucForm.setTinTucId(tinTuc.getTinTucId());
		tinTucForm.setTitle(tinTuc.getTitle());
		tinTucForm.setPathImage(tinTuc.getPathImage());
		if(tinTuc.getActive() == 1)
		tinTucForm.setActive(true);
		else
		tinTucForm.setActive(false);
		if(tinTuc.getApproved() == 1)
		tinTucForm.setApproved(true);
		else
		tinTucForm.setApproved(false);
		tinTucForm.setContent(tinTuc.getContent());
		tinTucForm.setSummary(tinTuc.getSummary());
		tinTucForm.setChuyenMucId(tinTuc.getTblChuyenMuc().getChuyenMucId());
		tinTucForm.setCreated(tinTuc.getCreated());
		tinTucForm.setStatus(tinTuc.getStatus());
		model.put("tinTucForm", tinTucForm);
		return "admin/tintuc/edit";
	}
	
	@ModelAttribute(value="listDanhMuc")
	public List<TblChuyenMuc> getListDanhMuc() {
		logger.debug("getListDanhMuc called");
		List<TblChuyenMuc> listDanhMuc = new ArrayList<TblChuyenMuc>();
		ChuyenMucDao dao = new ChuyenMucDao();
		listDanhMuc = dao.get();
		return listDanhMuc;
	}
	
	@ExceptionHandler({ Exception.class })
	public String handleException(Exception e, HttpServletRequest request) {
		logger.error(e.getMessage(), e);
		request.setAttribute("errorMessage", e.getMessage());
		return "admin/tintuc/error";
	}

	@RequestMapping(value = "admin/tintuc/edit.html", method = RequestMethod.POST)
	public String processForm(@Valid TinTucForm tinTucForm,@RequestParam("txtFCKContent") String content, BindingResult result) throws Exception {
		logger.debug("processForm called");
		logger.debug("Thu tuc hanh chinh ID: " + tinTucForm.getTinTucId());
		logger.debug("Title: " + tinTucForm.getTitle());
		logger.debug("Image path: " + tinTucForm.getPathImage());
		logger.debug("Danh Muc ID: " + tinTucForm.getChuyenMucId());
		
		TinTucDao dao = new TinTucDao();
		TblTinTuc tinTuc = dao.get(tinTucForm.getTinTucId());
		tinTuc.setTinTucId(tinTucForm.getTinTucId());
		tinTuc.setTitle(tinTucForm.getTitle());
		tinTuc.setContent(content);
		tinTuc.setSummary(tinTucForm.getSummary());
		tinTuc.setPathImage(tinTucForm.getPathImage());
		if (tinTucForm.getActive())
		tinTuc.setActive((byte)1);
		else
		tinTuc.setActive((byte)0);	
		if(tinTucForm.getApproved())
		tinTuc.setApproved((byte)1);
		else
		tinTuc.setApproved((byte)0);	
		ChuyenMucDao dmdao = new ChuyenMucDao();
		TblChuyenMuc tblChuyenMuc = dmdao.get(tinTucForm.getChuyenMucId());
		tinTuc.setTblChuyenMuc(tblChuyenMuc);
		tinTuc.setModified(new Date());
		dao.update(tinTuc);
		this.tinTucForm = null;
		return "redirect:/admin/tintuc/list.html";
	}
}