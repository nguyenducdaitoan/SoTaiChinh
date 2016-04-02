package vn.softech.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class TinTucAddController {
	private static final Logger logger = Logger.getLogger(TinTucAddController.class);
	
	@RequestMapping(value = "admin/tintuc/add.html", method = RequestMethod.GET)
	public String showForm(Map model) throws Exception {
		logger.debug("showForm called!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");		
		TinTucForm tinTucForm = new TinTucForm();
		model.put("tinTucForm", tinTucForm);
		return "admin/tintuc/add";
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

	@RequestMapping(value = "admin/tintuc/add.html", method = RequestMethod.POST)
	public String processForm(@Valid TinTucForm tinTucForm,@RequestParam("txtFCKContent") String content, BindingResult result) throws Exception {
		logger.debug("processForm called");
		logger.debug("Title: " + tinTucForm.getTitle());
		logger.debug("Summary" + tinTucForm.getSummary());
		logger.debug("Danh Muc ID" + tinTucForm.getChuyenMucId());
		TinTucDao dao = new TinTucDao();
		TblTinTuc tinTuc = new TblTinTuc();		
		tinTuc.setTitle(tinTucForm.getTitle());
		tinTuc.setSummary(tinTucForm.getSummary());
		tinTuc.setContent(content);
		tinTuc.setPathImage(tinTucForm.getPathImage());
		if(tinTucForm.getActive())
		tinTuc.setActive((byte)1);
		else
		tinTuc.setActive((byte)0);	
		tinTuc.setCreated(new Date());
		tinTuc.setModified(new Date());
		tinTuc.setStatus((byte)1);
		UsersDao userdao = new UsersDao(); 
		tinTuc.setUsersApprover(userdao.get(tinTucForm.getUsersCreaterId()));
		ChuyenMucDao chuyenmucdao = new ChuyenMucDao(); 
		tinTuc.setTblChuyenMuc(chuyenmucdao.get(tinTucForm.getChuyenMucId()));
		dao.save(tinTuc);
		return "redirect:/admin/tintuc/list.html";
	}
	
}