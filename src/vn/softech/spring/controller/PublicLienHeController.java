package vn.softech.spring.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.multipart.MultipartFile;

import vn.softech.dao.LienHeDao;
import vn.softech.dao.ThongBaoDao;
import vn.softech.form.AdvertForm;
import vn.softech.form.LienHeForm;
import vn.softech.hibernate.TblLienHe;
import vn.softech.hibernate.TblThongBao;

@Controller
public class PublicLienHeController {
	private static Logger log = Logger.getLogger(PublicLienHeController.class);	
	
	@RequestMapping(value = "/lienhe/detail.html")
	public String detailLienHe(@ModelAttribute("lienhe") LienHeForm form, Model model) {
		log.debug("Call detailLienHe");
		return "lienhe/detail";
	}
	
	@RequestMapping(value = "/lienhe/action.html")
	public String actionLienHe(@ModelAttribute("lienhe") LienHeForm form, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		log.debug("Call actionLienHe");
		log.debug("===============================");
		log.debug("Ho Ten : "+ form.getHoTen());
		log.debug("Ho Chuc danh : "+ form.getChucDanh());
		log.debug("Ho Địa chi : "+ form.getDiaChi());
		log.debug("Ho SoDienThoai : "+ form.getSoDienThoai());
		log.debug("Ho Email : "+ form.getEmail());
		log.debug("Ho NoiDung : "+ form.getNoiDung());
		log.debug("===============================");
		MultipartFile ff=form.getDulieu();
		
		ServletContext servletContext = request.getSession().getServletContext();
		String path= servletContext.getRealPath("/null/");
		log.debug("PATH: "+path);
		LienHeDao lienHeDao = new LienHeDao();
		Date now = new Date();
		TblLienHe lienhe = new TblLienHe();
		if(ff != null){
			//Upload File
			byte[] bytes= ff.getBytes();
			File newFile=null;
			if ((bytes != null) && (bytes.length > 0)) {
	            try {	            	
	                newFile = new File(path+"\\"+ff.getOriginalFilename());
	                FileOutputStream fileOutputStream = new FileOutputStream(newFile);                         
	                fileOutputStream.write(bytes, 0, bytes.length);                   
	                fileOutputStream.close();
	                lienhe.setFileData(ff.getBytes());
	                lienhe.setFileName(ff.getName());
	            }
	            catch (FileNotFoundException e) {
	                log.error("File Not Found.");                            
	            }
	            catch (IOException e1){
	            	log.error("Error Reading The File.");               
	            }
	        }
		}

		lienhe.setHoTen(form.getHoTen());
		lienhe.setChucDanh(form.getChucDanh());
		lienhe.setDiaChi(form.getDiaChi());
		lienhe.setSoDienThoai(form.getSoDienThoai());
		lienhe.setEmail(form.getEmail());
		lienhe.setNoiDung(form.getNoiDung());
		lienhe.setCreated(now);
		lienhe.setModified(now);
		Long lienHeId = lienHeDao.save(lienhe);
		if (lienHeId != null){
			log.debug("Sava success");
			return "lienhe/thanks";
		} else {
			log.debug("Save fail");
			return "lienhe/detail";
		}
		
	}
	@RequestMapping(value = "/lienhe/thanks.html")
	public String thanksLienHe() {
		log.debug("Call thanksLienHe");
		return "lienhe/thanks";
	}
		//----------------------------------------------------------------------------------------
		@ExceptionHandler({ Exception.class })
		 public String handleException(Exception e, HttpServletRequest request) {
		  log.error(e.getMessage(), e);
		  request.setAttribute("errorMessage", e.getMessage());
		  return "error";
		 }
}
