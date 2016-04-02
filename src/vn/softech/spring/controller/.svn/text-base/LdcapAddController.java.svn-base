package vn.softech.spring.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdCapDao;
import vn.softech.hibernate.TblLdCap;

@Controller
public class LdcapAddController {
	private static Logger log = Logger.getLogger(LdcapAddController.class);
	
	@RequestMapping(value = "/admin/ldcap/add")
	public String addLdcapForm(Model model) {
		log.info("addLdcapForm called.");
		TblLdCap ldcap= new TblLdCap();
		model.addAttribute("ldcap",ldcap);
		return "admin/ldcap/ldcapadd";
	}
	
	@RequestMapping(value = "/admin/ldcap/submitadd")
	public String submitAddLdcap(@ModelAttribute("ldcap")TblLdCap form) {
		log.info("submitAddLdcap called.");
		form.setStatus((byte)1);
		form.setCreated(new Date());
		form.setModified(new Date());
		LdCapDao ldcapdao= new LdCapDao();
		ldcapdao.save(form);		
		return "redirect:/admin/ldcap/list.html";
	}

}
