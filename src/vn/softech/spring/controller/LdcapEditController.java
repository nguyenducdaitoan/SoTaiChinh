package vn.softech.spring.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.softech.dao.LdCapDao;
import vn.softech.dao.PhanMemDao;
import vn.softech.hibernate.TblLdCap;

@Controller
public class LdcapEditController {
	LdCapDao ldcapdao= new LdCapDao();
	private static Logger log = Logger.getLogger(LdcapEditController.class);
	@RequestMapping(value = "/admin/ldcap/edit")
	public String editLdcapForm (@RequestParam("ldCapId")String id, Model model) {
		log.info("editLdcapForm called. with Id: "+id);
		TblLdCap ldcap= ldcapdao.get(Short.parseShort(id));
		model.addAttribute("ldcap", ldcap);
		return "admin/ldcap/ldcapedit";
	}
	
	@RequestMapping(value = "/admin/ldcap/submitedit")
	public String submitEditLdcap(@ModelAttribute("ldcap")TblLdCap form) throws Exception{
		log.info("submitEditLdcap");
		TblLdCap tblldcap= ldcapdao.get(form.getLdCapId());
		tblldcap.setName(form.getName());
		tblldcap.setMacDinh(form.isMacDinh());
		tblldcap.setModified(new Date());
		ldcapdao.update(tblldcap);
		return "redirect:/admin/ldcap/list.html";
	}

}
