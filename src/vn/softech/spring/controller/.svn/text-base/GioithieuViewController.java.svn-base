package vn.softech.spring.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import vn.softech.dao.GioiThieuDao;
import vn.softech.hibernate.TblGioiThieu;

@Controller
public class GioithieuViewController  {
	GioiThieuDao gioithieudao= new GioiThieuDao();
	List<TblGioiThieu> listgioithieu;
	private static Logger log = Logger.getLogger(GioithieuViewController.class);	

//-----------------------------------------------------------------------------------		
	@RequestMapping(value = "/admin/gioithieu/list")
	public String showListgioithieu (Model model) {
		log.info("showListgioithieu called.");	
		listgioithieu=gioithieudao.get();
		log.debug(listgioithieu.size());		
		model.addAttribute("listgioithieu",listgioithieu);
		return "admin/gioithieu/gioithieulist";
	}
	
//----------------------------------------------------------------------------------------
	@ExceptionHandler({ Exception.class })
	 public String handleException(Exception e, HttpServletRequest request) {
	  log.error(e.getMessage(), e);
	  request.setAttribute("errorMessage", e.getMessage());
	  return "error";
	 }
}
