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

import vn.softech.dao.AdminSystemDao;
import vn.softech.form.HinhAnhForm;
import vn.softech.form.LoginForm;
import vn.softech.hibernate.TblPhongBan;
import vn.softech.util.StringUtils;

import vn.softech.dao.HinhAnhDao;
import vn.softech.domain.Pager;
import vn.softech.hibernate.TblHinhAnh;

@Controller
public class HinhAnhAddController {
	private static final Logger logger = Logger.getLogger(HinhAnhAddController.class);
	
	@RequestMapping(value = "admin/hinhanh/add.html", method = RequestMethod.GET)
	public String showForm(Map model) throws Exception {
		logger.debug("showForm called");		
		HinhAnhForm hinhanhForm = new HinhAnhForm();
		model.put("hinhanhForm", hinhanhForm);
		return "admin/hinhanh/add";
	}
	
	
	@ExceptionHandler({ Exception.class })
	public String handleException(Exception e, HttpServletRequest request) {
		logger.error(e.getMessage(), e);
		request.setAttribute("errorMessage", e.getMessage());
		return "admin/hinhanh/error";
	}

	@RequestMapping(value = "admin/hinhanh/add.html", method = RequestMethod.POST)
	public String processForm(@Valid HinhAnhForm hinhanhForm, BindingResult result) throws Exception {
		logger.debug("processForm called");
		HinhAnhDao dao = new HinhAnhDao();
		TblHinhAnh hinhanh = new TblHinhAnh();		
		hinhanh.setTitle(hinhanhForm.getTitle());
		hinhanh.setPath(hinhanhForm.getPath());
		hinhanh.setCreated(new Date());
		hinhanh.setModified(new Date());
		hinhanh.setStatus((byte)1);
		hinhanh.setUsersId(1);

		dao.save(hinhanh);
		return "redirect:/admin/hinhanh/list.html";
	}
}