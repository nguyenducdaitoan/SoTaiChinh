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

import vn.softech.dao.AdvertDao;
import vn.softech.hibernate.TblAdvert;

@Controller
public class PublicAdvertController {
	private static Logger log = Logger.getLogger(PublicAdvertController.class);	
	AdvertDao advertDao = new AdvertDao();
	int rowOfPage = 2;
	int page = 1;
	@RequestMapping(value = "/advert/list.html")
		public String listAdvert(Model model) throws Exception {
			log.info("listAdvert called.");
			List<TblAdvert> listAdvert = advertDao.getByPage(rowOfPage, page);
			log.debug("listAdvert.sze() :" + listAdvert.size());
			model.addAttribute("listAdvert",listAdvert);
			return "/advert/list";
		}
		
	//----------------------------------------------------------------------------------------
	@ExceptionHandler({ Exception.class })
	 public String handleException(Exception e, HttpServletRequest request) {
	  log.error(e.getMessage(), e);
	  request.setAttribute("errorMessage", e.getMessage());
	  return "error";
	 }
}
