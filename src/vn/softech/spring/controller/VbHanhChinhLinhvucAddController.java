package vn.softech.spring.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdLinhVucDao;
import vn.softech.hibernate.TblLdLinhVuc;

@Controller
public class VbHanhChinhLinhvucAddController {
private static Logger log = Logger.getLogger(VbHanhChinhLinhvucAddController.class);
	
	@RequestMapping(value = "/admin/vbhanhchinhlinhvuc/add")
	public String addLdLinhvucForm(Model model) {
		log.info("addLdLinhvucForm called.");
		TblLdLinhVuc ldlinhvuc= new TblLdLinhVuc();
		model.addAttribute("ldlinhvuc",ldlinhvuc);
		return "admin/vbhanhchinhlinhvuc/vbhanhchinhlinhvucadd";
	}
	
	@RequestMapping(value = "/admin/vbhanhchinhlinhvuc/submitadd")
	public String submitAddLdlinhvuc(@ModelAttribute("ldlinhvuc")TblLdLinhVuc form) {
		log.info("submitAddLdlinhvuc called.");
		form.setStatus((byte)1);
		form.setCreated(new Date());
		form.setModified(new Date());
		form.setType((byte)2);
		LdLinhVucDao dao= new LdLinhVucDao();
		dao.save(form);		
		return "redirect:/admin/vbhanhchinhlinhvuc/list.html";
	}

}
