package vn.softech.spring.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdCapDao;
import vn.softech.dao.LdLinhVucDao;
import vn.softech.hibernate.TblLdCap;
import vn.softech.hibernate.TblLdLinhVuc;

@Controller
public class LdlinhvucAddController {
private static Logger log = Logger.getLogger(LdlinhvucAddController.class);
	
	@RequestMapping(value = "/admin/ldlinhvuc/add")
	public String addLdLinhvucForm(Model model) {
		log.info("addLdLinhvucForm called.");
		TblLdLinhVuc ldlinhvuc= new TblLdLinhVuc();
		model.addAttribute("ldlinhvuc",ldlinhvuc);
		return "admin/ldlinhvuc/ldlinhvucadd";
	}
	
	@RequestMapping(value = "/admin/ldlinhvuc/submitadd")
	public String submitAddLdlinhvuc(@ModelAttribute("ldlinhvuc")TblLdLinhVuc form) {
		log.info("submitAddLdlinhvuc called.");
		form.setStatus((byte)1);
		form.setCreated(new Date());
		form.setModified(new Date());
		LdLinhVucDao dao= new LdLinhVucDao();
		dao.save(form);		
		return "redirect:/admin/ldlinhvuc/list.html";
	}
}
