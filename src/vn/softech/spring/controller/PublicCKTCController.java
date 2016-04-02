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

import vn.softech.dao.CktcDao;
import vn.softech.hibernate.TblCktc;

@Controller
public class PublicCKTCController {
	private static Logger log = Logger.getLogger(PublicCKTCController.class);	
	CktcDao cktcDao = new CktcDao();
	int rowOfPage = 20;
	int page = 1;
	long totalRecordByCm = 0;
	long totalPage = 1; 
	long cktcCmId;
		
	@RequestMapping(value = "/cktc/category.html")
	public String categoryTTHC(Model model, @RequestParam("cktcCmId")Long cktcCmId) throws Exception {
		log.info("categoryTTHC called.");
		log.debug("categoryTTHC called; tthcDmId: "+cktcCmId);
		
		List<TblCktc> listCKTC = new ArrayList<TblCktc>();
		if(cktcCmId != null){
			listCKTC = cktcDao.getCktcByCHuyenMuc(rowOfPage, page, cktcCmId);
			if ((listCKTC != null) && (listCKTC.size() > 0)){
				model.addAttribute("listCKTC", listCKTC);
				log.debug("listCKTC.size() = " + listCKTC.size());
			}
			totalRecordByCm = cktcDao.countCm(cktcCmId).intValue();
			log.debug("totalRecord : "+ totalRecordByCm);
			totalPage = totalRecordByCm/rowOfPage;
			if ((totalRecordByCm%rowOfPage) > 0) {
				totalPage += 1;
			}
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", page);
			model.addAttribute("cktcCmId", cktcCmId);
		}
		else{
			//
			listCKTC = cktcDao.getCktcPage(rowOfPage, page);
			if ((listCKTC != null) && (listCKTC.size() > 0)){
				model.addAttribute("listCKTC", listCKTC);
				log.debug("listCKTC.size() = " + listCKTC.size());
			}
			model.addAttribute("totalPage", 0);
			model.addAttribute("page", page);
		}
			
		return "cktc/category";
	}
	
	
	@RequestMapping(value = "/cktc/ajaxcategory.html")
	public String ajaxCmCKTC(Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("ajaxCcTTHC called.");
		log.debug("ajaxCcTTHC called; id: "+request.getParameter("cktcCmId"));
		Long cktcCmId = null;
		String strCktcCmId = request.getParameter("cktcCmId");
		log.debug("Get by strChuyenMucId :"+strCktcCmId);
		if ((strCktcCmId != null) && (!"".equals(strCktcCmId))) {
			try {
				cktcCmId = Long.parseLong(strCktcCmId);
			} catch (Exception e) {
				log.debug("strTthcDmId khong phai la so", e);
				cktcCmId =  null;
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
		List<TblCktc> listCKTCByChuyenMuc = new ArrayList<TblCktc>();
		listCKTCByChuyenMuc = cktcDao.getCktcByCktcCmId( cktcCmId);
		if ((listCKTCByChuyenMuc != null) && (listCKTCByChuyenMuc.size() > 0)){
			model.addAttribute("listCKTCByChuyenMuc", listCKTCByChuyenMuc);
			log.debug("listCKTCByChuyenMuc.size() = " + listCKTCByChuyenMuc.size());
		}
		return "/cktc/ajaxcategory";
	}
	
	@RequestMapping(value = "/cktc/detail.html")
	public String detailCKTC(Model model, @RequestParam("cktcId")Long cktcId) {
		log.info("detailCKTC called.");
		log.debug("detailCKTC called; cktcId: "+cktcId);
		
		TblCktc cktc = cktcDao.getCktc(cktcId);
		model.addAttribute("cktc", cktc);
		
		//get recent su kien tin tuc
		if(cktcId != null){
			//get tin theo chuyen muc
			List<TblCktc> listCKTCByChuyenMuc = new ArrayList<TblCktc>();
			//list Thu tuc theo chuyen muc
			listCKTCByChuyenMuc = cktcDao.getCktcByCktcCmId(cktc.getTblCktcCm().getCktcCmId());
			if ((listCKTCByChuyenMuc != null) && (listCKTCByChuyenMuc.size() > 0)){
				model.addAttribute("listCKTCByChuyenMuc", listCKTCByChuyenMuc);
				log.debug("listCKTCByChuyenMuc.size() = " + listCKTCByChuyenMuc.size());
			}
		}
		return "cktc/detail";
	}

	
	@RequestMapping(value = "/cktc/printdetail.html")
	public String printCKTC(Model model, @RequestParam("cktcId")Long cktcId) {
		log.info("printCKTC called.");
		log.debug("printCKTC called; cktcId: "+cktcId);
		
		TblCktc cktc = cktcDao.getCktc(cktcId);
		model.addAttribute("cktc", cktc);
		return "cktc/printdetail";
	}	
		//----------------------------------------------------------------------------------------
		@ExceptionHandler({ Exception.class })
		 public String handleException(Exception e, HttpServletRequest request) {
		  log.error(e.getMessage(), e);
		  request.setAttribute("errorMessage", e.getMessage());
		  return "error";
		 }
}
