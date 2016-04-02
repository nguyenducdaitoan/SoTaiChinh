package vn.softech.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import vn.softech.dao.BmdtDao;
import vn.softech.dao.LegalDocumentsDao;
import vn.softech.dao.PhanMemDao;
import vn.softech.dao.TinTucDao;
import vn.softech.dao.TthcDao;
import vn.softech.dao.VbHanhChinhDao;
import vn.softech.dao.VbHuongDanDao;
import vn.softech.form.AdvertForm;
import vn.softech.form.SearchForm;
import vn.softech.hibernate.TblLegalDocuments;
import vn.softech.hibernate.TblTinTuc;
import vn.softech.hibernate.TblVbHanhChinh;

@Controller
@RequestMapping("")
public class HomePageController {
	private String message;
	private static Logger log = Logger.getLogger(HomePageController.class);
	TinTucDao tintucDao = new TinTucDao();
	
	
	@RequestMapping(value = "/welcome.html")
	protected String showWelcomePage(Model model,  HttpServletRequest arg0,	HttpServletResponse arg1) throws Exception {
		//List Top Post All Category
		List<TblTinTuc> listTopPostAllChuyenMuc;
		listTopPostAllChuyenMuc = tintucDao.getTopRecentPostAllChuyenMuc((int)6);
		if ((listTopPostAllChuyenMuc != null) && (listTopPostAllChuyenMuc.size() > 0)){
			model.addAttribute("listTopPostAllChuyenMuc",listTopPostAllChuyenMuc);
			log.debug("listTopTinTuc.size() = " + listTopPostAllChuyenMuc.size());
		}
		
		//List Top View
		List<TblTinTuc> listTopTinTuc = new ArrayList<TblTinTuc>();
		listTopTinTuc = tintucDao.getTopRecentPost(9);
		if ((listTopTinTuc != null) && (listTopTinTuc.size() > 0)){
			model.addAttribute("listTopTinTuc",listTopTinTuc);
			log.debug("listTopTinTuc.size() = " + listTopTinTuc.size());
		}
		
		//Van Ban Moi Ban Hanh
		int rowOfPage = 10;
		LegalDocumentsDao dao = new LegalDocumentsDao();
		List<TblLegalDocuments> listLegalDocuments = new ArrayList<TblLegalDocuments>();
		listLegalDocuments = dao.getSearch(null, null, null, null, null, null, null, null, rowOfPage, 1);
		if ((listLegalDocuments != null) && (listLegalDocuments.size() > 0)) {
			model.addAttribute("listLegalDocuments",listLegalDocuments);
			log.debug("listLegalDocuments.size(): " + listLegalDocuments.size());
		}
		VbHanhChinhDao daovbhc = new VbHanhChinhDao();
		List<TblVbHanhChinh> listVbhc = new ArrayList<TblVbHanhChinh>();
		listVbhc = daovbhc.getSearch(null, null, null, null, null, null, null, rowOfPage, 1);
		if ((listVbhc != null) && (listVbhc.size() > 0)) {
			model.addAttribute("listVbhc",listVbhc);
			log.debug("listVbhc.size(): " + listVbhc.size());
		}
		return "welcome";
		
	}
	
	@RequestMapping(value = "/searchform.html")
	public String searchFrom(@ModelAttribute("search") SearchForm form, Model model) throws Exception{
		log.debug("Call search form");
		return "/searchform";
	}
	
	@RequestMapping(value = "/searchformaction.html")
	public String actionSearch(@ModelAttribute("search") SearchForm form, Model model) throws Exception{
		int page = 1;
		int rowOfPage = 10;
		log.debug("searchForm.getQuery(): " + form.getQuery());
		model.addAttribute("keyword",form.getQuery());
		//search tin tuc
		TinTucDao ttdao = new TinTucDao(); 
		model.addAttribute("listTinTuc", ttdao.getSearch(form.getQuery(), rowOfPage, page));
		
		//search thu tuc hanh chinh
		TthcDao tthcdao = new TthcDao();
		model.addAttribute("listTTHC",tthcdao.getSearch(form.getQuery(), rowOfPage, page));
		
		//search bieu mau dien tu
		BmdtDao bmdtDao = new BmdtDao();
		model.addAttribute("listBMDT",bmdtDao.getSearch(form.getQuery(), rowOfPage, page));
		
		//search văn bản pháp quy
		LegalDocumentsDao vbpqDao = new LegalDocumentsDao();
		model.addAttribute("listVBPQ",vbpqDao.getSearch(form.getQuery(), form.getQuery(), rowOfPage, page));
		

//		//search phan mem
//		PhanMemDao phanMemDao = new PhanMemDao();
//		model.addAttribute("listPhanMem",phanMemDao.getSearch(form.getQuery(), rowOfPage, page));
//		
//		//search văn bản hướng dẫn
//		VbHuongDanDao vbHuongDanDao = new VbHuongDanDao();
//		model.addAttribute("listVBHD",vbHuongDanDao.getSearch(form.getQuery(), rowOfPage, page));	
		return "search";
	}
	
	
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@RequestMapping(value = "office.html")
	protected ModelAndView showOfficePage(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		return new ModelAndView("office", "officeMessage", message);
	}
	
	@RequestMapping(value = "friends.html")
	protected ModelAndView showFriendsPage(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		return new ModelAndView("friends", "friendsMessage", message);
	}
	
}
