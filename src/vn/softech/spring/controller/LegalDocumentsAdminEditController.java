package vn.softech.spring.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
public class LegalDocumentsAdminEditController {
	private static Logger log = Logger.getLogger(LegalDocumentsAdminAddController.class);
	LegalDocumentsDao legalDocumentsDao= new LegalDocumentsDao();
	
	
	@RequestMapping (value = "/admin/legaldocuments/edit")
	public String editLegalDocumentForm (@RequestParam("legalDocumentsId")String Id, Model model) {
		TblLegalDocuments tbl= legalDocumentsDao.get(Long.parseLong(Id));
		LegalDocumentsForm form= new LegalDocumentsForm();
		form.setLegalDocumentsId(tbl.getLegalDocumentsId());
		form.setLdCoQuanId(tbl.getTblLdCoQuan().getLdCoQuanId());
		form.setLdLinhVucId(tbl.getTblLdLinhVuc().getLdLinhVucId());
		form.setLdLoaiVbId(tbl.getTblLdLoaiVb().getLdLoaiVbId());
		form.setSoHieuVb(tbl.getSoHieuVb());
		int day=tbl.getNgayBh().getDate();
		int month= tbl.getNgayBh().getMonth()+1;
		int year= tbl.getNgayBh().getYear()+1900;
		form.setNgaybanhanh(day+"/"+month+"/"+year);
		if (day<10) {
			form.setNgaybanhanh("0"+day+"/"+month+"/"+year);
		}
		int day2=tbl.getNgayHieuLuc().getDate();
		int month2= tbl.getNgayHieuLuc().getMonth()+1;
		int year2= tbl.getNgayHieuLuc().getYear()+1900;
		form.setNgayhieuluc(day2+"/"+month2+"/"+year2);
		if (day2<10) {
			form.setNgayhieuluc("0"+day2+"/"+month+"/"+year);
		} 
		form.setTenVb(tbl.getTenVb());		
		model.addAttribute("legalDocument", form);
		return "/admin/legaldocuments/legaldocumentsedit";
	}
	
	
//----------------------------------------------------------------------------	
	@RequestMapping (value = "/admin/legaldocuments/submitedit")
	public String submiteditLegalDocumentForm(@ModelAttribute("legalDocument") LegalDocumentsForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("submiteditLegalDocumentForm called.");
		LegalDocumentsDao dao = new LegalDocumentsDao();
		MultipartFile ff=form.getDulieu();		
		ServletContext servletContext = request.getSession().getServletContext();
		String path= servletContext.getRealPath("/null/documents/");
		log.debug("PATH: "+path);
				
		if (ff != null) {
			if ((ff.getName() != null) && (!"".equals(ff.getName())) && (ff.getSize() > 0)) {
				log.debug("tenVb: " + form.getTenVb());
				log.debug("soHieuVb: " + form.getSoHieuVb());
				log.debug("fileName: " + ff.getOriginalFilename());
				log.debug("fileType: " + ff.getContentType());
				log.debug("file: " + ff.getName());
				log.debug("ngayBh: " + form.getNgaybanhanh());
				log.debug("ngayHieuLuc: " + form.getNgayhieuluc());				
				log.debug("getLdLoaiVbId: " + form.getLdLoaiVbId());
				log.debug("getLdCoQuanId: " + form.getLdCoQuanId());
				log.debug("getLdLinhVucId: " + form.getLdLinhVucId());
				
				//Upload File
				byte[] bytes= ff.getBytes();
				File newFile=null;
				if ((bytes != null) && (bytes.length > 0)) {
		            try {	            	
		                newFile = new File(path+"\\"+ff.getOriginalFilename());
		                FileOutputStream fileOutputStream = new FileOutputStream(newFile);                         
		                fileOutputStream.write(bytes, 0, bytes.length);                   
		                fileOutputStream.close();
		            }
		            catch (FileNotFoundException e) {
		                log.error("File Not Found.");                            
		            }
		            catch (IOException e1){
		            	log.error("Error Reading The File.");               
		            }
		        }
				
				LdLoaiVbDao ldLoaiVbDao = new LdLoaiVbDao();
				TblLdLoaiVb ldLoaiVb =  ldLoaiVbDao.get(form.getLdLoaiVbId());
				LdCoQuanDao ldCoQuanDao = new LdCoQuanDao();
				TblLdCoQuan ldCoQuan =  ldCoQuanDao.get(form.getLdCoQuanId());
				LdLinhVucDao ldLinhVucDao = new LdLinhVucDao();
				TblLdLinhVuc ldLinhVuc =  ldLinhVucDao.get(form.getLdLinhVucId());
				
				TblLegalDocuments legalDocuments = dao.get(form.getLegalDocumentsId()) ;				
				legalDocuments.setTblLdLoaiVb(ldLoaiVb);
				legalDocuments.setTblLdCoQuan(ldCoQuan);
				legalDocuments.setTblLdLinhVuc(ldLinhVuc);
				
				legalDocuments.setData(ff.getBytes());
				log.debug("getFileData: " + ff.getBytes());
				legalDocuments.setFileName(ff.getOriginalFilename());	
				log.debug("getFileName: " + ff.getOriginalFilename());
				legalDocuments.setFilePath("/null/documents/"+ff.getOriginalFilename());
				
				legalDocuments.setTenVb(form.getTenVb());
				legalDocuments.setSoHieuVb(form.getSoHieuVb());
				Date dNgayBh = null;
				if ((form.getNgaybanhanh() != null) && (!"".equals(form.getNgaybanhanh()))) {
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					try {
						dNgayBh = format.parse(form.getNgaybanhanh());
			        } catch(ParseException pe) {
			            log.error("ERROR: Cannot parse \"" + form.getNgaybanhanh() + "\"");
			        }
				}
				legalDocuments.setNgayBh(dNgayBh);
				
				Date dNgayHieuLuc = null;
				if ((form.getNgayhieuluc() != null) && (!"".equals(form.getNgayhieuluc()))) {
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					try {
						dNgayHieuLuc = format.parse(form.getNgayhieuluc());
			        } catch(ParseException pe) {
			            log.error("ERROR: Cannot parse \"" + form.getNgayhieuluc() + "\"");
			        }
				}
				legalDocuments.setNgayHieuLuc(dNgayHieuLuc);
				legalDocuments.setNguoiKyVb(form.getNguoiKyVb() + "&nbsp;");
	
				Date now = new Date();
				legalDocuments.setModified(now);	
				
				
				Long legalDocumentsId = dao.save(legalDocuments);
				if ((legalDocumentsId != null) && (legalDocumentsId.longValue() > 0)) {
					return "redirect:/admin/legaldocuments/list.html";
				} else {
					return "redirect:/admin/legaldocuments/add.html";
				}
			}
		}
		
		
		return "redirect:/admin/legaldocuments/list.html";
	}
	
	//----------------------------------------------------------------------------		
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
}
