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

import vn.softech.dao.SuKienDao;
import vn.softech.dao.TinTucDao;
import vn.softech.hibernate.TblSuKien;
import vn.softech.hibernate.TblSuKienTinTuc;
import vn.softech.hibernate.TblTinTuc;

@Controller
public class PublicSuKienController {
	private static Logger log = Logger.getLogger(PublicSuKienController.class);	
	SuKienDao suKienDao = new SuKienDao();
	int rowOfPage = 20;
	int page = 1;
	long totalRecordByCm = 0;
	long totalPage = 1; 

	@RequestMapping(value = "/sukien/list.html")
		public String listSuKien(Model model) throws Exception {
			log.info("listSuKien called.");
			List<TblSuKien> listSuKien = suKienDao.getActive();
			log.debug("listSuKien.sze() :" + listSuKien.size());
			model.addAttribute("listRecentsukien",listSuKien);
			return "/sukien/list";
		}
		
	@RequestMapping(value = "/sukien/category.html")
	public String categorySuKien(Model model, @RequestParam("suKienId")Long id) {
		log.info("detailsukien called.");
		log.debug("detailsukien called; id: "+id);
		if(id != null){
			//get Su Kien Category
			TblSuKien sukien = suKienDao.getSuKien(id);
			model.addAttribute("detailSuKien", sukien);
			
			//list Su Kien TIn Tuc
			List<TblSuKienTinTuc> listSuKienTinTuc = new ArrayList<TblSuKienTinTuc>();
			listSuKienTinTuc = suKienDao.getSuKienTinTucBySuKienId(id, rowOfPage, page);
			if ((listSuKienTinTuc != null) && (listSuKienTinTuc.size() > 0)){
				model.addAttribute("listSuKienTinTuc",listSuKienTinTuc);
				log.debug("listSuKienTinTuc.size() = " + listSuKienTinTuc.size());
			} else{
				
				log.debug("listSuKienTinTuc.size() = 0");
			}
			//Count tin tức by chuyên mục
			totalRecordByCm = suKienDao.countSuKienTinTucBySuKienId(id).intValue();
			totalPage = totalRecordByCm/rowOfPage;
			if ((totalRecordByCm%rowOfPage) > 0) {
				totalPage += 1;
			}
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", page);
			model.addAttribute("suKienId", id);
		} 
		return "sukien/category";
	}
	
	
	@RequestMapping(value = "/sukien/ajaxcategory.html")
	public String ajaxSuKienTinTuc(Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("ajaxSuKienTinTuc called.");
		log.debug("ajaxSuKienTinTuc called; id: "+request.getParameter("suKienId"));
		Long suKienId = null;
		String strSuKienId = request.getParameter("suKienId");
		log.debug("Get by strSuKienId :"+strSuKienId);
		if ((strSuKienId != null) && (!"".equals(strSuKienId))) {
			try {
				suKienId = Long.parseLong(strSuKienId);
			} catch (Exception e) {
				log.debug("strTinTucId khong phai la so", e);
				suKienId =  null;
			}
		}
		if ((request.getParameter("page") != null) && (!"".equals(request.getParameter("page")))) {
			try {
				page = Short.parseShort(request.getParameter("page"));
			} catch (Exception e) {
				log.debug("page khong phai la so", e);
				page = 1;
			}
		}
		
		
		if(suKienId != null) {
			log.debug("Ajax - suKienId: " + suKienId);
			log.debug("Ajax - page: " + page);
			
			List<TblSuKienTinTuc> listTinTucSuKien = suKienDao.getSuKienTinTucBySuKienId(suKienId, rowOfPage, page);
			if ((listTinTucSuKien != null) && (listTinTucSuKien.size() > 0)){
				model.addAttribute("listTinTucSuKien", listTinTucSuKien);
				log.debug("listTinTucSuKien.size() = " + listTinTucSuKien.size());
			}
		}
		
		
		return "/sukien/ajaxcategory";
	}
	
	@RequestMapping(value = "/sukien/detail.html")
	public String detailSuKienTinTuc(Model model, @RequestParam("suKienTinTucId")Long id) {
		log.info("detailSuKienTinTuc called.");
		log.debug("detailSuKienTinTuc called; id: "+id);
		
		TblSuKienTinTuc suKienTinTuc = suKienDao.getSuKienTinTuc(id);		
		model.addAttribute("suKienTinTuc", suKienTinTuc);
		
		//get recent su kien tin tuc
		List<TblSuKienTinTuc> listRecentSuKienTinTuc = new ArrayList<TblSuKienTinTuc>();
		listRecentSuKienTinTuc = suKienDao.getSuKienTinTucBySuKienId(suKienTinTuc.getSuKienId(), 10, 1);
		log.debug("Su kien tin tuc "+ listRecentSuKienTinTuc.size());
		if(listRecentSuKienTinTuc != null && listRecentSuKienTinTuc.size()>0){
			model.addAttribute("listRecentSuKienTinTuc", listRecentSuKienTinTuc);
		}
		return "sukien/detail";
	}

	
	@RequestMapping(value = "/sukien/printdetail.html")
	public String printsukien(Model model, @RequestParam("suKienId")Long id) {
		log.info("detailsukien called.");
		log.debug("detailsukien called; id: "+id);
		TblSuKienTinTuc suKienTinTuc = suKienDao.getSuKienTinTuc(id);
		model.addAttribute("suKienTinTuc", suKienTinTuc);
		return "sukien/printdetail";
	}	
		//----------------------------------------------------------------------------------------
		@ExceptionHandler({ Exception.class })
		 public String handleException(Exception e, HttpServletRequest request) {
		  log.error(e.getMessage(), e);
		  request.setAttribute("errorMessage", e.getMessage());
		  return "error";
		 }
}
