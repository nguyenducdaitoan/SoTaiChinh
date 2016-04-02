package vn.softech.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import vn.softech.form.ThongbaoForm;
import vn.softech.dao.ThongBaoDao;
import vn.softech.hibernate.TblThongBao;

 
@Controller
public class ThongBaoEditController {
	private static final Logger logger = Logger.getLogger(ThongBaoEditController.class);
	
	@RequestMapping(value = "admin/thongbao/edit.html", method = RequestMethod.GET)
	public String showForm(Map model, HttpServletRequest request) throws Exception {
		logger.debug("showForm called");
		long thongbaoId = Long.parseLong(request.getParameter("thongbaoId"));
		logger.debug("thongbaoId: " + thongbaoId);
		ThongBaoDao dao = new ThongBaoDao();
		TblThongBao thongbao = dao.get(thongbaoId);
		if (thongbao == null) {
			throw new Exception("thongbaoId: " + thongbaoId + " is not exist!");
		}
		ThongbaoForm thongbaoForm = new ThongbaoForm();
		thongbaoForm.setThongBaoId(thongbao.getThongBaoId());
		thongbaoForm.setTitle(thongbao.getTitle());
		thongbaoForm.setActive(thongbao.isActive());
		thongbaoForm.setContent(thongbao.getContent());
	
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
		thongbaoForm.setTuNgay(format.format(thongbao.getTuNgay()));
		thongbaoForm.setDenNgay(format.format(thongbao.getDenNgay()));
		
		model.put("thongbaoForm", thongbaoForm);
		return "admin/thongbao/edit";
	}
	
	@ExceptionHandler({ Exception.class })
	public String handleException(Exception e, HttpServletRequest request) {
		logger.error(e.getMessage(), e);
		request.setAttribute("errorMessage", e.getMessage());
		return "admin/thongbao/error";
	}

	@RequestMapping(value = "admin/thongbao/edit.html", method = RequestMethod.POST)
	public String processForm(@Valid ThongbaoForm thongbaoForm, @RequestParam("txtFCKContent") String content, BindingResult result,Map model, HttpServletRequest request) throws Exception {
		logger.debug("showForm processForm thongbaoid "+thongbaoForm.getThongBaoId());
		ThongBaoDao dao = new ThongBaoDao();
		TblThongBao thongbao = dao.get(thongbaoForm.getThongBaoId());
		if (thongbao == null) {
			throw new Exception("thongbaoId: " + thongbaoForm.getThongBaoId() + " is not exist!");
		}
		thongbao.setTitle(thongbaoForm.getTitle());
		thongbao.setActive(thongbaoForm.isActive());
		thongbao.setContent(content);
		thongbao.setModified(new Date());
		
		try {
			SimpleDateFormat formatday = new SimpleDateFormat("dd/MM/yyyy");
			thongbao.setTuNgay(formatday.parse(thongbaoForm.getTuNgay()));
			thongbao.setDenNgay(formatday.parse(thongbaoForm.getDenNgay()));
			logger.debug("Format Tu Ngay + Den Ngay");
			} catch(ParseException pe) {
				logger.error("ERROR: Cannot parse DATE THONG BAO");
		    }
		dao.update(thongbao);
		return "redirect:/admin/thongbao/list.html";
	}
}