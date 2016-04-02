package vn.softech.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.softech.dao.GioiThieuDao;
import vn.softech.hibernate.TblGioiThieu;

@Controller
public class PublicGioiThieuController {
	private static Logger log = Logger.getLogger(PublicGioiThieuController.class);	
	GioiThieuDao gioiThieuDao = new GioiThieuDao();		
	@RequestMapping(value = "/gioithieu/detail.html")
	public String detailGioiThieu(Model model, @RequestParam("gioiThieuId")Long id) {
		log.info("detailThongBao called.");
		log.debug("detailThongBao called; id: "+id);
		TblGioiThieu gioithieu = gioiThieuDao.get(id);
		model.addAttribute("gioithieu", gioithieu);
		List<TblGioiThieu> listGioiThieu = gioiThieuDao.get();
		model.addAttribute("listGioiThieu", listGioiThieu);
		return "gioithieu/detail";
	}
	@RequestMapping(value = "/gioithieu/printdetail.html")
	public String printGioiThieu(Model model, @RequestParam("gioiThieuId")Long id) {
		log.info("printGioiThieu called.");
		log.debug("printGioiThieu called; id: "+id);
		TblGioiThieu gioithieu = gioiThieuDao.get(id);
		model.addAttribute("gioithieu", gioithieu);
		return "gioithieu/printdetail";
	}	
	//----------------------------------------------------------------------------------------
	@ExceptionHandler({ Exception.class })
	 public String handleException(Exception e, HttpServletRequest request) {
	  log.error(e.getMessage(), e);
	  request.setAttribute("errorMessage", e.getMessage());
	  return "error";
	 }
}
