package vn.softech.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdCoQuanDao;
import vn.softech.hibernate.TblLdCoQuan;

@Controller
public class LdcoquanListController {
	LdCoQuanDao ldcoquandao= new LdCoQuanDao();
	List<TblLdCoQuan> listldcoquan;
	private static Logger log = Logger.getLogger(LdcoquanListController.class);
	
	@RequestMapping (value = "/admin/ldcoquan/list")
	public String showLdcoquanList(Model model) {
		log.info("showLdcoquanList called.");
		listldcoquan= ldcoquandao.get();
		model.addAttribute("listldcoquan", listldcoquan);
		return "admin/ldcoquan/ldcoquanlist";
	}
}
