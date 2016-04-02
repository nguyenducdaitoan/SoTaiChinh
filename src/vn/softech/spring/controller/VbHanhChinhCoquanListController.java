package vn.softech.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.softech.dao.LdCoQuanDao;
import vn.softech.hibernate.TblLdCoQuan;

@Controller
public class VbHanhChinhCoquanListController {
	LdCoQuanDao ldcoquandao= new LdCoQuanDao();
	List<TblLdCoQuan> listldcoquan;
	private static Logger log = Logger.getLogger(VbHanhChinhCoquanListController.class);
	
	@RequestMapping (value = "/admin/vbhanhchinhcoquan/list")
	public String showLdcoquanList(Model model,@RequestParam("type")String type) {
		log.info("showLdcoquanList called.");
		listldcoquan= ldcoquandao.getByType((byte)2);
		model.addAttribute("listldcoquan", listldcoquan);
		return "admin/vbhanhchinhcoquan/vbhanhchinhcoquanlist";
	}
}
