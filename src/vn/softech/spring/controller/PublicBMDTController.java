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

import vn.softech.dao.BmdtDao;
import vn.softech.hibernate.TblBmdt;

@Controller
public class PublicBMDTController {
	private static Logger log = Logger.getLogger(PublicBMDTController.class);	
	BmdtDao bmdtDao = new BmdtDao();
	int rowOfPage = 20;
	int page = 1;
	long totalRecordByCm = 0;
	long totalPage = 1; 
	long bmdtCmId;
		
	@RequestMapping(value = "/bmdt/category.html")
	public String categoryBMDT(Model model, @RequestParam("bmdtDmId")Long bmdtDmId) throws Exception {
		log.info("categoryBMDT called.");
		log.debug("categoryBMDT called; tthcDmId: "+bmdtDmId);
		
		List<TblBmdt> listbmdt = new ArrayList<TblBmdt>();
		if(bmdtDmId != null){
			listbmdt = bmdtDao.getByBmdtPublic(rowOfPage, page, bmdtDmId);
			if ((listbmdt != null) && (listbmdt.size() > 0)){
				model.addAttribute("listbmdt", listbmdt);
				log.debug("listbmdt.size() = " + listbmdt.size());
			}
			totalRecordByCm = bmdtDao.countCm(bmdtCmId).intValue();
			log.debug("totalRecord : "+ totalRecordByCm);
			totalPage = totalRecordByCm/rowOfPage;
			if ((totalRecordByCm%rowOfPage) > 0) {
				totalPage += 1;
			}
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", page);
			model.addAttribute("bmdtCmId", bmdtCmId);
		}
		else{
			//
			listbmdt = bmdtDao.getByPagePublic(rowOfPage, page);
			if ((listbmdt != null) && (listbmdt.size() > 0)){
				model.addAttribute("listbmdt", listbmdt);
				log.debug("listbmdt.size() = " + listbmdt.size());
			}
			model.addAttribute("totalPage", 0);
			model.addAttribute("page", page);
		}
			
		return "bmdt/category";
	}
	
	
	@RequestMapping(value = "/bmdt/ajaxcategory.html")
	public String ajaxCmbmdt(Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("ajaxCcTTHC called.");
		log.debug("ajaxCcTTHC called; id: "+request.getParameter("bmdtCmId"));
		Long bmdtCmId = null;
		String strbmdtCmId = request.getParameter("bmdtCmId");
		log.debug("Get by strChuyenMucId :"+strbmdtCmId);
		if ((strbmdtCmId != null) && (!"".equals(strbmdtCmId))) {
			try {
				bmdtCmId = Long.parseLong(strbmdtCmId);
			} catch (Exception e) {
				log.debug("strTthcDmId khong phai la so", e);
				bmdtCmId =  null;
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
		List<TblBmdt> listbmdt = new ArrayList<TblBmdt>();
		listbmdt = bmdtDao.getByBmdtPublic(rowOfPage,page, bmdtCmId);
		if ((listbmdt != null) && (listbmdt.size() > 0)){
			model.addAttribute("listbmdt", listbmdt);
			log.debug("listbmdt.size() = " + listbmdt.size());
		}
		return "/bmdt/ajaxcategory";
	}
	
	@RequestMapping(value = "/bmdt/detail.html")
	public String detailbmdt(Model model, @RequestParam("bmdtId")Long bmdtId) {
		log.info("detailbmdt called.");
		log.debug("detailbmdt called; bmdtId: "+bmdtId);
		
		TblBmdt bmdt = bmdtDao.get(bmdtId);
		model.addAttribute("bmdt", bmdt);
		
		//get recent su kien tin tuc
		if(bmdtId != null){
			//get tin theo chuyen muc
			List<TblBmdt> listbmdtByChuyenMuc = new ArrayList<TblBmdt>();
			//list Thu tuc theo chuyen muc
			listbmdtByChuyenMuc = bmdtDao.getByBmdtPublic(rowOfPage,page,bmdt.getTblBmdtDm().getBmdtDmId());
			if ((listbmdtByChuyenMuc != null) && (listbmdtByChuyenMuc.size() > 0)){
				model.addAttribute("listbmdtByChuyenMuc", listbmdtByChuyenMuc);
				log.debug("listbmdtByChuyenMuc.size() = " + listbmdtByChuyenMuc.size());
			}
		}
		return "bmdt/detail";
	}

	
	@RequestMapping(value = "/bmdt/printdetail.html")
	public String printbmdt(Model model, @RequestParam("bmdtId")Long bmdtId) {
		log.info("printbmdt called.");
		log.debug("printbmdt called; bmdtId: "+bmdtId);
		
		TblBmdt bmdt = bmdtDao.get(bmdtId);
		model.addAttribute("bmdt", bmdt);
		return "bmdt/printdetail";
	}	
		//----------------------------------------------------------------------------------------
		@ExceptionHandler({ Exception.class })
		 public String handleException(Exception e, HttpServletRequest request) {
		  log.error(e.getMessage(), e);
		  request.setAttribute("errorMessage", e.getMessage());
		  return "error";
		 }
}
