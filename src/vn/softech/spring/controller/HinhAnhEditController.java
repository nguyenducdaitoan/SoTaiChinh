package vn.softech.spring.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.softech.form.HinhAnhForm;
import vn.softech.dao.HinhAnhDao;
import vn.softech.hibernate.TblHinhAnh;

 
@Controller
public class HinhAnhEditController {
	private static final Logger logger = Logger.getLogger(HinhAnhEditController.class);
	
	@RequestMapping(value = "admin/hinhanh/edit.html", method = RequestMethod.GET)
	public String showForm(Map model, HttpServletRequest request) throws Exception {
		logger.debug("showForm called");
		int hinhanhId = Integer.parseInt(request.getParameter("hinhanhId"));
		logger.debug("hinhanhId: " + hinhanhId);
		HinhAnhDao dao = new HinhAnhDao();
		TblHinhAnh hinhanh = dao.get(hinhanhId);
		if (hinhanh == null) {
			throw new Exception("hinhanhId: " + hinhanhId + " is not exist!");
		}
		HinhAnhForm hinhanhForm = new HinhAnhForm();
		hinhanhForm.setHinhAnhId(hinhanhId);
		hinhanhForm.setTitle(hinhanh.getTitle());
		hinhanhForm.setPath(hinhanh.getPath());	
		
		model.put("hinhanhForm", hinhanhForm);
		return "admin/hinhanh/edit";
	}
	
	@ExceptionHandler({ Exception.class })
	public String handleException(Exception e, HttpServletRequest request) {
		logger.error(e.getMessage(), e);
		request.setAttribute("errorMessage", e.getMessage());
		return "admin/hinhanh/error";
	}

	@RequestMapping(value = "admin/hinhanh/edit.html", method = RequestMethod.POST)
	public String processForm(@Valid HinhAnhForm hinhanhForm, BindingResult result,Map model, HttpServletRequest request) throws Exception {
		logger.debug("showForm processForm hinhanhid "+hinhanhForm.getHinhAnhId());
		HinhAnhDao dao = new HinhAnhDao();
		TblHinhAnh hinhanh = dao.get(hinhanhForm.getHinhAnhId());
		if (hinhanh == null) {
			throw new Exception("hinhanhId: " + hinhanhForm.getHinhAnhId() + " is not exist!");
		}
		hinhanh.setTitle(hinhanhForm.getTitle());
		hinhanh.setPath(hinhanhForm.getPath());
		hinhanh.setModified(new Date());
		dao.update(hinhanh);
		return "redirect:/admin/hinhanh/list.html";
	}
}