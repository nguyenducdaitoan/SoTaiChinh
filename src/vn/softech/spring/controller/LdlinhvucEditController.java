package vn.softech.spring.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.softech.dao.LdCapDao;
import vn.softech.dao.LdLinhVucDao;
import vn.softech.hibernate.TblLdCap;
import vn.softech.hibernate.TblLdLinhVuc;

@Controller
public class LdlinhvucEditController {
	LdLinhVucDao ldlinhvucdao= new LdLinhVucDao();
	private static Logger log = Logger.getLogger(LdlinhvucEditController.class);
	
	@RequestMapping(value = "/admin/ldlinhvuc/edit")
	public String editLdlinhvucForm (@RequestParam("ldLinhVucId")String id, Model model) {
		log.info("editLdlinhvucForm called. with Id: "+id);
		TblLdLinhVuc ldlinhvuc= ldlinhvucdao.get(Short.parseShort(id));
		log.debug("Ten Linh vuc: "+ ldlinhvuc.getName());
		model.addAttribute("ldlinhvuc", ldlinhvuc);
		return "admin/ldlinhvuc/ldlinhvucedit";
	}
	
	@RequestMapping(value = "/admin/ldlinhvuc/submitedit")
	public String submitEditLdlinhvuc(@ModelAttribute("ldlinhvuc")TblLdLinhVuc form) throws Exception{
		log.info("submitEditLdlinhvuc called.");
		TblLdLinhVuc tblldlinhvuc= ldlinhvucdao.get(form.getLdLinhVucId());
		tblldlinhvuc.setName(form.getName());
		tblldlinhvuc.setMacDinh(form.isMacDinh());
		tblldlinhvuc.setModified(new Date());
		ldlinhvucdao.update(tblldlinhvuc);
		return "redirect:/admin/ldlinhvuc/list.html";
	}

}
