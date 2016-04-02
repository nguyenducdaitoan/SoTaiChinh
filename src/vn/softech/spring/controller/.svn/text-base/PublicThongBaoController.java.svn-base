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

import vn.softech.dao.ThongBaoDao;
import vn.softech.hibernate.TblThongBao;

@Controller
public class PublicThongBaoController {
	private static Logger log = Logger.getLogger(PublicThongBaoController.class);	
	ThongBaoDao thongbaoDao = new ThongBaoDao();
	int rowOfPage = 20;
	int page = 1;
	long totalRecordByCm = 0;
	long totalPage = 1; 

	@RequestMapping(value = "/thongbao/list.html")
		public String listThongBao(Model model) throws Exception {
			log.info("listThongBao called.");
			List<TblThongBao> listThongBao = thongbaoDao.getByPage(10,1);
			log.debug("listThongBao.sze() :" + listThongBao.size());
			model.addAttribute("listRecentThongBao",listThongBao);
			return "/thongbao/list";
		}
		
	@RequestMapping(value = "/thongbao/detail.html")
	public String detailThongBao(Model model, @RequestParam("thongBaoId")Long id) {
		log.info("detailThongBao called.");
		log.debug("detailThongBao called; id: "+id);
		TblThongBao thongbao = thongbaoDao.get(id);
		model.addAttribute("detailThongBao", thongbao);
		return "thongbao/detail";
	}
	@RequestMapping(value = "/thongbao/printdetail.html")
	public String printThongBao(Model model, @RequestParam("thongBaoId")Long id) {
		log.info("detailThongBao called.");
		log.debug("detailThongBao called; id: "+id);
		TblThongBao thongbao = thongbaoDao.get(id);
		model.addAttribute("detailThongBao", thongbao);
		return "thongbao/printdetail";
	}	
		//----------------------------------------------------------------------------------------
		@ExceptionHandler({ Exception.class })
		 public String handleException(Exception e, HttpServletRequest request) {
		  log.error(e.getMessage(), e);
		  request.setAttribute("errorMessage", e.getMessage());
		  return "error";
		 }
}
