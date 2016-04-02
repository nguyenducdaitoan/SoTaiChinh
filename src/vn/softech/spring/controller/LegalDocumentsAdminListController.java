package vn.softech.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdCapDao;
import vn.softech.dao.LdCoQuanDao;
import vn.softech.dao.LdLinhVucDao;
import vn.softech.dao.LdLoaiVbDao;
import vn.softech.dao.LegalDocumentsDao;
import vn.softech.form.LegalDocumentsForm;
import vn.softech.hibernate.TblLdCap;
import vn.softech.hibernate.TblLdCoQuan;
import vn.softech.hibernate.TblLdLinhVuc;
import vn.softech.hibernate.TblLdLoaiVb;
import vn.softech.hibernate.TblLegalDocuments;

@Controller
public class LegalDocumentsAdminListController {
	private static Logger log = Logger.getLogger(LegalDocumentsAdminListController.class);
	
	@RequestMapping(value = "/admin/legaldocuments/list")
	public String ShowLegalDocumentsList(Model model, HttpServletRequest request, HttpServletResponse response) 
	throws Exception
	{
		log.info("ShowLegalDocumentsList called.");

//		LegalDocumentsForm legalDocumentsForm = (LegalDocumentsForm)form;
		LegalDocumentsForm legalDocumentsForm = new LegalDocumentsForm();
		LegalDocumentsDao dao = new LegalDocumentsDao();
		List<TblLegalDocuments> listLegalDocuments = new ArrayList<TblLegalDocuments>();
		int page = 1;
		int rowOfPage = 20;
		String query = null;
		if ((request.getParameter("page") != null) && (!"".equals(request.getParameter("page")))) {
			try {
				page = Integer.parseInt(request.getParameter("page"));				
			} catch (Exception e) {}			
		}
		legalDocumentsForm.setPage(page); 
		if ((request.getParameter("query") != null) && (!"".equals(request.getParameter("query")))) {
//			query = request.getParameter("query");
			query = new String(request.getParameter("query").getBytes("ISO-8859-1"), "UTF-8");
			legalDocumentsForm.setQuery(query);
		}
		String soHieuVb = null;
		if ((request.getParameter("sohieuvb") != null) && (!"".equals(request.getParameter("sohieuvb")))) {
			soHieuVb = request.getParameter("sohieuvb");
			legalDocumentsForm.setSoHieuVb(soHieuVb);
		}
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatFull = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date from = null;
		
		if ((request.getParameter("tungay") != null) && (!"".equals(request.getParameter("tungay")))) {
			legalDocumentsForm.setTuNgay(request.getParameter("tungay"));
			from = formatFull.parse(request.getParameter("tungay") + " 00:00:00");
		}
		Date to = null;
		if ((request.getParameter("denngay") != null) && (!"".equals(request.getParameter("denngay")))) {
			legalDocumentsForm.setDenNgay(request.getParameter("denngay"));
			to = formatFull.parse(request.getParameter("denngay") + " 23:59:59");
		}
		Short ldLinhVucId = null;
		if ((request.getParameter("ldlinhvucid") != null) && (!"".equals(request.getParameter("ldlinhvucid")))) {
			try {
				ldLinhVucId = Short.parseShort(request.getParameter("ldlinhvucid"));
				legalDocumentsForm.setLdLinhVucId(ldLinhVucId); 
			} catch (Exception e) {}
		}
		Short ldLoaiVbId = null;
		if ((request.getParameter("ldloaivbid") != null) && (!"".equals(request.getParameter("ldloaivbid")))) {
			try {
				ldLoaiVbId = Short.parseShort(request.getParameter("ldloaivbid"));
				legalDocumentsForm.setLdLoaiVbId(ldLoaiVbId);
			} catch (Exception e) {}
		}
		Short ldCoQuanId = null;
		if ((request.getParameter("ldcoquanid") != null) && (!"".equals(request.getParameter("ldcoquanid")))) {
			try {
				ldCoQuanId = Short.parseShort(request.getParameter("ldcoquanid"));
				legalDocumentsForm.setLdCoQuanId(ldCoQuanId);
			} catch (Exception e) {}
		}
		Short ldCapId = null;
		if ((request.getParameter("ldcapid") != null) && (!"".equals(request.getParameter("ldcapid")))) {
			try {
				ldCapId = Short.parseShort(request.getParameter("ldcapid"));
				legalDocumentsForm.setLdCapId(ldCapId);
			} catch (Exception e) {}
		}
		
		listLegalDocuments = dao.getSearch(ldCoQuanId, ldLinhVucId, ldLoaiVbId, ldCapId, from, to, soHieuVb, query, rowOfPage, page);
		if ((listLegalDocuments != null) && (listLegalDocuments.size() > 0)) {
			legalDocumentsForm.setListLegalDocuments(listLegalDocuments);
			int totalPage = 1;
			int totalRecord = dao.countSearch(ldCoQuanId, ldLinhVucId, ldLoaiVbId, ldCapId, from, to, soHieuVb, query);
			log.debug("totalRecord: " + totalRecord);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
			log.debug("totalPage: " + totalPage);
			legalDocumentsForm.setTotalPage(totalPage);
			legalDocumentsForm.setTotalRecord(totalRecord);
			request.setAttribute("totalPage", totalPage);
		} else {
			legalDocumentsForm.setListLegalDocuments(null);
			legalDocumentsForm.setTotalPage(1);
			legalDocumentsForm.setTotalRecord(0);
		}
		
		log.debug("size: "+listLegalDocuments.size());		
		model.addAttribute("listLegalDocuments", listLegalDocuments);
		model.addAttribute("legaldocumentform", legalDocumentsForm);
		return "admin/legaldocuments/legaldocumentslist";
	}
	
	
	
	@ModelAttribute(value = "listcoquan")
	public List<TblLdCoQuan> listldcoquan() {
		log.info("listldcoquan called.");
		LdCoQuanDao dao= new LdCoQuanDao();
		return dao.getByType((byte)1);
	}
	
	@ModelAttribute(value = "listcap")
	public List<TblLdCap> listldcap() {
		log.info("listldcap called.");
		LdCapDao dao= new LdCapDao();
		return dao.get();
	}
	
	@ModelAttribute(value = "listloaivb")
	public List<TblLdLoaiVb> listloaivb() {
		log.info("listloaivb called.");
		LdLoaiVbDao dao= new LdLoaiVbDao();
		return dao.getByType((byte)1);
	}
	
	@ModelAttribute(value = "listlinhvuc")
	public List<TblLdLinhVuc> listlinhvuc() {
		log.info("listlinhvuc called.");
		LdLinhVucDao dao = new LdLinhVucDao();
		return dao.getByType((byte)1);
	}
	
//	@ModelAttribute(value = "totalPage")
//	public int totalPage() {
//		log.info("totalPage called.");
//		LegalDocumentsDao ldao = new LegalDocumentsDao();
//		return ldao.get().size();
//	}
}
