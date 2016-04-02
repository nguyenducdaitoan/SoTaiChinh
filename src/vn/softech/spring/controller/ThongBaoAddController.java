package vn.softech.spring.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import vn.softech.form.LoginForm;
import vn.softech.form.ThongbaoForm;
import vn.softech.hibernate.TblPhongBan;
import vn.softech.util.StringUtils;

import vn.softech.dao.ThongBaoDao;
import vn.softech.domain.Pager;
import vn.softech.hibernate.TblThongBao;

@Controller
public class ThongBaoAddController {
	private static final Logger logger = Logger.getLogger(ThongBaoAddController.class);
	
	@RequestMapping(value = "admin/thongbao/add.html", method = RequestMethod.GET)
	public String showForm(Map model) throws Exception {
		logger.debug("showForm called");		
		ThongbaoForm thongbaoForm = new ThongbaoForm();
		model.put("thongbaoForm", thongbaoForm);
		return "admin/thongbao/add";
	}
	
	
	@ExceptionHandler({ Exception.class })
	public String handleException(Exception e, HttpServletRequest request) {
		logger.error(e.getMessage(), e);
		request.setAttribute("errorMessage", e.getMessage());
		return "admin/thongbao/error";
	}

	@RequestMapping(value = "admin/thongbao/add.html", method = RequestMethod.POST)
	public String processForm(@Valid ThongbaoForm thongbaoForm, @RequestParam("txtFCKContent") String content, BindingResult result) throws Exception {
		logger.debug("processForm called");
		ThongBaoDao dao = new ThongBaoDao();
		TblThongBao thongbao = new TblThongBao();		
		thongbao.setTitle(thongbaoForm.getTitle());
		thongbao.setActive(thongbaoForm.isActive());
		thongbao.setContent(content);
		thongbao.setCreated(new Date());
		thongbao.setModified(new Date());
		thongbao.setStatus((byte)1);
		thongbao.setUsersId((byte)0);
			
		Date tungay = null;
		if ((thongbaoForm.getTuNgay() != null) && (!"".equals(thongbaoForm.getTuNgay()))) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			try {
				tungay = format.parse(thongbaoForm.getTuNgay());
				logger.debug("Format tungay : " + tungay);
	        } catch(ParseException pe) {
	        	logger.error("ERROR: Cannot parse \"" + thongbaoForm.getTuNgay() + "\"");
	        }
		}
		thongbao.setTuNgay(tungay);
		
		Date dengay = null;
		if ((thongbaoForm.getDenNgay() != null) && (!"".equals(thongbaoForm.getDenNgay()))) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			try {
				dengay = format.parse(thongbaoForm.getDenNgay());
				logger.debug("Format dengay : " + dengay);
	        } catch(ParseException pe) {
	        	logger.error("ERROR: Cannot parse \"" + thongbaoForm.getDenNgay() + "\"");
	        }
		}
		thongbao.setDenNgay(dengay);
		
		dao.save(thongbao);
		return "redirect:/admin/thongbao/list.html";
	}
}