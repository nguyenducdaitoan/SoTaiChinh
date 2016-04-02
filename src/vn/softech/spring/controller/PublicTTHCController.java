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

import vn.softech.dao.TthcDao;
import vn.softech.hibernate.TblTthc;

@Controller
public class PublicTTHCController {
	private static Logger log = Logger.getLogger(PublicTTHCController.class);	
	TthcDao tthcDao = new TthcDao();
	int rowOfPage = 20;
	int page = 1;
	long totalRecordByCm = 0;
	long totalPage = 1; 
	long chuyenMucId;
		
	@RequestMapping(value = "/tthc/category.html")
	public String categoryTTHC(Model model, @RequestParam("tthcDmId")Long tthcDmId) throws Exception {
		log.info("categoryTTHC called.");
		log.debug("categoryTTHC called; tthcDmId: "+tthcDmId);
		
		List<TblTthc> listThuTucByChuyenMuc = new ArrayList<TblTthc>();
		if(tthcDmId != null){
			listThuTucByChuyenMuc = tthcDao.getTthcActiveByChuyenMucId(rowOfPage, page, tthcDmId);
			if ((listThuTucByChuyenMuc != null) && (listThuTucByChuyenMuc.size() > 0)){
				model.addAttribute("listThuTucByChuyenMuc", listThuTucByChuyenMuc);
				log.debug("listThuTucByChuyenMuc.size() = " + listThuTucByChuyenMuc.size());
			}
			totalRecordByCm = tthcDao.countCmActive(tthcDmId).intValue();
			log.debug("totalRecord : "+ totalRecordByCm);
			totalPage = totalRecordByCm/rowOfPage;
			if ((totalRecordByCm%rowOfPage) > 0) {
				totalPage += 1;
			}
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", page);
			model.addAttribute("chuyenMucId", chuyenMucId);
		}
		else{
			//
			listThuTucByChuyenMuc = tthcDao.getTopTthcAllChuyenMuc((int)10);
			if ((listThuTucByChuyenMuc != null) && (listThuTucByChuyenMuc.size() > 0)){
				model.addAttribute("listThuTucByChuyenMuc", listThuTucByChuyenMuc);
				log.debug("listThuTucByChuyenMuc.size() = " + listThuTucByChuyenMuc.size());
			}
			totalRecordByCm = tthcDao.countAll();
			totalPage = totalRecordByCm/rowOfPage;
			if ((totalRecordByCm%rowOfPage) > 0) {
				totalPage += 1;
			}
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", page);
		}
			
		return "tthc/category";
	}
	
	
	@RequestMapping(value = "/tthc/ajaxcategory.html")
	public String ajaxCmTTHC(Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("ajaxCcTTHC called.");
		log.debug("ajaxCcTTHC called; id: "+request.getParameter("tthcCmId"));
		Long tthcCmId = null;
		String strTthcDmId = request.getParameter("tthcCmId");
		log.debug("Get by strChuyenMucId :"+strTthcDmId);
		if ((strTthcDmId != null) && (!"".equals(strTthcDmId))) {
			try {
				tthcCmId = Long.parseLong(strTthcDmId);
			} catch (Exception e) {
				log.debug("strTthcDmId khong phai la so", e);
				tthcCmId =  null;
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
		List<TblTthc> listThuTucByChuyenMuc = new ArrayList<TblTthc>();
		listThuTucByChuyenMuc = tthcDao.getTthcActiveByChuyenMucId(rowOfPage, page, tthcCmId);
		if ((listThuTucByChuyenMuc != null) && (listThuTucByChuyenMuc.size() > 0)){
			model.addAttribute("listThuTucByChuyenMuc", listThuTucByChuyenMuc);
			log.debug("listThuTucByChuyenMuc.size() = " + listThuTucByChuyenMuc.size());
		}
		return "/tthc/ajaxcategory";
	}
	
	@RequestMapping(value = "/tthc/detail.html")
	public String detailTTHC(Model model, @RequestParam("tthcId")Long tthcId) {
		log.info("detailTTHC called.");
		log.debug("detailTTHC called; tthcId: "+tthcId);
		
		TblTthc thuTucHanhChinh = tthcDao.get(tthcId);	
		model.addAttribute("tthc", thuTucHanhChinh);
		
		//get recent su kien tin tuc
		if(tthcId != null){
			//get tin theo chuyen muc
			List<TblTthc> listTthcByChuyenMuc = new ArrayList<TblTthc>();
			//list Thu tuc theo chuyen muc
			listTthcByChuyenMuc = tthcDao.getTthcActiveByChuyenMucId(10, 1, thuTucHanhChinh.getTblTthcDm().getTthcDmId());
			if ((listTthcByChuyenMuc != null) && (listTthcByChuyenMuc.size() > 0)){
				model.addAttribute("listTthcByChuyenMuc", listTthcByChuyenMuc);
				log.debug("listTthcByChuyenMuc.size() = " + listTthcByChuyenMuc.size());
			}
		}
		return "tthc/detail";
	}

	
	@RequestMapping(value = "/tthc/printdetail.html")
	public String printTTHC(Model model, @RequestParam("tthcId")Long tthcId) {
		log.info("printTTHC called.");
		log.debug("printTTHC called; id: "+tthcId);
		TblTthc thuTucHanhChinh = tthcDao.get(tthcId);	
		model.addAttribute("tthc", thuTucHanhChinh);
		return "tthc/printdetail";
	}	
		//----------------------------------------------------------------------------------------
		@ExceptionHandler({ Exception.class })
		 public String handleException(Exception e, HttpServletRequest request) {
		  log.error(e.getMessage(), e);
		  request.setAttribute("errorMessage", e.getMessage());
		  return "error";
		 }
}
