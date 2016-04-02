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

import vn.softech.dao.HinhAnhDao;
import vn.softech.dao.SuKienDao;
import vn.softech.dao.TinTucDao;
import vn.softech.hibernate.TblHinhAnh;
import vn.softech.hibernate.TblSuKien;
import vn.softech.hibernate.TblSuKienTinTuc;
import vn.softech.hibernate.TblTinTuc;

@Controller
public class PublicGallaryController {
	private static Logger log = Logger.getLogger(PublicGallaryController.class);	
	HinhAnhDao hinhAnhDao = new HinhAnhDao();
	int rowOfPage = 20;
	int page = 1;
	long totalRecordByCm = 0;
	long totalPage = 1; 

	@RequestMapping(value = "/gallary/list.html")
		public String listGallary(Model model) throws Exception {
			log.info("listGallary called.");
			List<TblHinhAnh> listGallary = hinhAnhDao.getByPage(rowOfPage, page);
			log.debug("listGallary.sze() :" + listGallary.size());
			model.addAttribute("listGallary",listGallary);
			return "/gallary/list";
		}
		
	@RequestMapping(value = "/gallary/category.html")
	public String categoryGallary(Model model) throws Exception {
		log.info("categoryGallary called.");
			//list Gallary
			List<TblHinhAnh> listCategoryGallary = new ArrayList<TblHinhAnh>();
			listCategoryGallary = hinhAnhDao.getByPage(rowOfPage, page);
			if ((listCategoryGallary != null) && (listCategoryGallary.size() > 0)){
				model.addAttribute("listCategoryGallary",listCategoryGallary);
				log.debug("listCategoryGallary.size() = " + listCategoryGallary.size());
			} else{
				
				log.debug("listCategoryGallary.size() = 0");
			}
			//Count tin tức by chuyên mục
			totalRecordByCm = hinhAnhDao.countAll();
			totalPage = totalRecordByCm/rowOfPage;
			if ((totalRecordByCm%rowOfPage) > 0) {
				totalPage += 1;
			}
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", page);
		return "gallary/category";
	}
	
	
	@RequestMapping(value = "/gallary/ajaxcategory.html")
	public String ajaxGallary(Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("ajaxGallary called.");

		if ((request.getParameter("page") != null) && (!"".equals(request.getParameter("page")))) {
			try {
				page = Short.parseShort(request.getParameter("page"));
			} catch (Exception e) {
				log.debug("page khong phai la so", e);
				page = 1;
			}
		}
		
		log.debug("Ajax - page: " + page);
		
		List<TblHinhAnh> listCategoryGallary = hinhAnhDao.getByPage(rowOfPage,page);
		if ((listCategoryGallary != null) && (listCategoryGallary.size() > 0)){
			model.addAttribute("listCategoryGallary", listCategoryGallary);
			log.debug("listCategoryGallary.size() = " + listCategoryGallary.size());
		}
		
		
		return "/gallary/ajaxcategory";
	}
	
	//----------------------------------------------------------------------------------------
	@ExceptionHandler({ Exception.class })
	 public String handleException(Exception e, HttpServletRequest request) {
	  log.error(e.getMessage(), e);
	  request.setAttribute("errorMessage", e.getMessage());
	  return "error";
	 }
}
