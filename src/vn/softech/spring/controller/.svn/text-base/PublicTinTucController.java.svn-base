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

import vn.softech.dao.TinTucDao;
import vn.softech.hibernate.TblTinTuc;

@Controller
public class PublicTinTucController {
	private static Logger log = Logger.getLogger(PublicTinTucController.class);	
	TinTucDao tinTucDao = new TinTucDao();
	int rowOfPage = 20;
	int page = 1;
	long totalRecordByCm = 0;
	long totalPage = 1; 
	Short chuyenMucId ;
	//-----------------------------------------------------------------------------------	
		@RequestMapping(value = "/tintuc/detail.html")
		public String detailTinTuc(Model model, @RequestParam("tinTucId")Long id) {
			log.info("detailTinTuc called.");
			log.debug("detailTinTuc called; id: "+id);
			TblTinTuc tintuc = tinTucDao.get(id);		
			model.addAttribute("tintuc", tintuc);
			//Relate post
			Short chuyenMucId = tintuc.getTblChuyenMuc().getChuyenMucId();
			if(chuyenMucId != null){
				//get tin theo chuyen muc
				List<TblTinTuc> listTinTucByChuyenMuc = new ArrayList<TblTinTuc>();
				//list Tin Tuc
				listTinTucByChuyenMuc = tinTucDao.getByPage((int)10, (int)1, chuyenMucId);
				if ((listTinTucByChuyenMuc != null) && (listTinTucByChuyenMuc.size() > 0)){
					model.addAttribute("tintucByChuyenMuc", listTinTucByChuyenMuc);
					log.debug("Relate Post:  listTopTinTuc.size() = " + listTinTucByChuyenMuc.size());
				}
			}
			return "tintuc/detail";
		}

		@RequestMapping(value = "/tintuc/printdetail.html")
		public String printTinTuc(Model model, @RequestParam("tinTucId")Long id) {
			log.info("detailTinTuc called.");
			log.debug("detailTinTuc called; id: "+id);
			TblTinTuc tintuc = tinTucDao.get(id);		
			model.addAttribute("tintuc", tintuc);
			return "tintuc/printdetail";
		}
		
		@RequestMapping(value = "/tintuc/category.html")
		public String categoryTinTuc(Model model, @RequestParam("catId")Short id) throws Exception {
			log.info("categoryTinTuc called.");
			log.debug("categoryTinTuc called; id: "+id);
			if(id != null && !("".equals(id))){
				//get tin theo chuyen muc
				List<TblTinTuc> listTinTucByChuyenMuc = new ArrayList<TblTinTuc>();
				//list Tin Tuc
				listTinTucByChuyenMuc = tinTucDao.getByPage(rowOfPage, page, id);
				if ((listTinTucByChuyenMuc != null) && (listTinTucByChuyenMuc.size() > 0)){
					model.addAttribute("tintucByChuyenMuc", listTinTucByChuyenMuc);
					log.debug("tintucByChuyenMuc.size() = " + listTinTucByChuyenMuc.size());
					totalRecordByCm = tinTucDao.countCm(id);
					
					totalPage = totalRecordByCm/rowOfPage;
					if ((totalRecordByCm%rowOfPage) > 0) {
						totalPage += 1;
					}
					log.debug("totalRecordByCm : "+totalRecordByCm);
					log.debug("totalPage : "+totalPage);
					model.addAttribute("totalPage", totalPage);
					model.addAttribute("chuyenMucId", id);
				}
			}
			return "tintuc/category";
		}
		
		@RequestMapping(value = "/tintuc/ajaxcategory.html")
		public String ajaxTinTucByChuyenMuc(Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
			log.info("ajaxTinTucByChuyenMuc called.");
			log.debug("ajaxTinTucByChuyenMuc called; id: "+request.getParameter("catId"));
			
			
			chuyenMucId = null;
			String strChuyenMucId = request.getParameter("catId");
			log.debug("Get by TTHCCm :"+strChuyenMucId);
			if ((strChuyenMucId != null) && (!"".equals(strChuyenMucId))) {
				try {
					chuyenMucId = Short.parseShort(strChuyenMucId);
				} catch (Exception e) {
					log.debug("strTinTucId khong phai la so", e);
					chuyenMucId =  null;
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
			if(chuyenMucId != null) {
				log.debug("Ajax - chuyenMucId: " + chuyenMucId);
				log.debug("Ajax - page: " + page);
				List<TblTinTuc> listTinTucByChuyenMuc = new ArrayList<TblTinTuc>();				
				listTinTucByChuyenMuc = tinTucDao.getByTinTucByChuyenMucId(rowOfPage, page, chuyenMucId);
				log.debug("Ajax - totalRecord: " + listTinTucByChuyenMuc.size());
				if ((listTinTucByChuyenMuc != null) && (listTinTucByChuyenMuc.size() > 0)){
					model.addAttribute("tintucByChuyenMuc", listTinTucByChuyenMuc);
					log.debug("listTopTinTuc.size() = " + listTinTucByChuyenMuc.size());
				}
			}
			return "/tintuc/ajaxcategory";
		}
		//----------------------------------------------------------------------------------------
		@ExceptionHandler({ Exception.class })
		 public String handleException(Exception e, HttpServletRequest request) {
		  log.error(e.getMessage(), e);
		  request.setAttribute("errorMessage", e.getMessage());
		  return "error";
		 }
}
