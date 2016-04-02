package vn.softech.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdCapDao;
import vn.softech.hibernate.TblLdCap;

@Controller
public class LdcapListController {
	LdCapDao ldcapdao= new LdCapDao();
	List<TblLdCap> listldcap;
	private static Logger log = Logger.getLogger(LdcapListController.class);
	@RequestMapping (value = "/admin/ldcap/list")
	public String showLdcapList (Model model) {
		log.info("showLdcapList called.");
		listldcap= ldcapdao.get();
		model.addAttribute("listldcap", listldcap);
		return "admin/ldcap/ldcaplist";
	}
}
