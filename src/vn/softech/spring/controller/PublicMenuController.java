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

import vn.softech.dao.BmdtDmDao;
import vn.softech.dao.ChuyenMucDao;
import vn.softech.dao.CktcDao;
import vn.softech.dao.GioiThieuDao;
import vn.softech.dao.TthcDmDao;
import vn.softech.hibernate.TblBmdtDm;
import vn.softech.hibernate.TblChuyenMuc;
import vn.softech.hibernate.TblCktcCm;
import vn.softech.hibernate.TblGioiThieu;
import vn.softech.hibernate.TblTthcDm;


@Controller
public class PublicMenuController {
	private static Logger log = Logger.getLogger(PublicMenuController.class);	

	@RequestMapping(value = "/menu/list.html")
	public String listMenu(Model model) throws Exception {
		log.info("listMenu called.");
		//Menu Giới thiệu
		GioiThieuDao gioithieuDao = new GioiThieuDao();
		List<TblGioiThieu> listMenuGioiThieu = gioithieuDao.get();
		log.debug("listMenuGioiThieu.size() : "+listMenuGioiThieu.size());
		model.addAttribute("listMenuGioiThieu",listMenuGioiThieu);
		
		//Menu Tin Tuc
		ChuyenMucDao chuyenMucDao = new ChuyenMucDao();
		List<TblChuyenMuc> listMenuChuyenMuc = chuyenMucDao.get();
		log.debug("listMenuChuyenMuc.size() : "+listMenuChuyenMuc.size());
		model.addAttribute("listMenuChuyenMuc",listMenuChuyenMuc);

		//Menu Thủ tục hành chính
		TthcDmDao tthcDao = new TthcDmDao();
		List<TblTthcDm> listMenuTTHC = tthcDao.get();
		log.debug("listMenuTTHC.size() : "+listMenuTTHC.size());
		model.addAttribute("listMenuTTHC",listMenuTTHC);

		//Menu Công khai tài chính
		CktcDao cktcDao = new CktcDao();
		List<TblCktcCm> listMenuCKTC= cktcDao.getCktcCm();
		log.debug("listMenuCKTC.size() : "+listMenuCKTC.size());
		model.addAttribute("listMenuCKTC",listMenuCKTC);
		
		//Bieu mau điện tu
		
		//Menu Công khai tài chính
		BmdtDmDao bmdtDmDao = new BmdtDmDao();
		List<TblBmdtDm> listMenuBmdtDm= bmdtDmDao.getMenuHeader();
		log.debug("listMenuBmdtDm.size() : "+listMenuCKTC.size());
		model.addAttribute("listMenuBmdtDm",listMenuBmdtDm);
		
		return "/menu/list";
	}
	//----------------------------------------------------------------------------------------
	@ExceptionHandler({ Exception.class })
	 public String handleException(Exception e, HttpServletRequest request) {
	  log.error(e.getMessage(), e);
	  request.setAttribute("errorMessage", e.getMessage());
	  return "error";
	 }
}
