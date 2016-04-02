package vn.softech.spring.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdCapDao;
import vn.softech.dao.LdCoQuanDao;
import vn.softech.form.LdcoquanForm;
import vn.softech.hibernate.TblLdCap;
import vn.softech.hibernate.TblLdCoQuan;

@Controller
public class LdcoquanAddController {
	LdCoQuanDao ldcoquandao= new LdCoQuanDao();
	private static Logger log = Logger.getLogger(LdcoquanAddController.class);
	
	@RequestMapping (value = "/admin/ldcoquan/add")
	public String addLdcoquanForm(Model model) {
		log.info("addLdcoquanForm called.");
		LdcoquanForm form= new LdcoquanForm();
		model.addAttribute("ldcoquan", form);
		return "admin/ldcoquan/ldcoquanadd";
	}
	
	@ModelAttribute(value="listldcap")
	public List<TblLdCap> getListLdcap() {
		LdCapDao ldcapdao= new LdCapDao();
		return ldcapdao.get();
	}
	
	@RequestMapping (value = "/admin/ldcoquan/submitadd")
	public String submitAddLdCoquan(@ModelAttribute("ldcoquan") LdcoquanForm form) {
		log.info("submitAddLdCoquan called. with Id: "+form.getLdCoQuanId());
		TblLdCoQuan tblldcoquan= new TblLdCoQuan();
		tblldcoquan.setName(form.getName());
		tblldcoquan.setMacDinh(form.isMacDinh());
		LdCapDao dao= new LdCapDao();
		tblldcoquan.setTblLdCap(dao.get(form.getLdCapId()));
		tblldcoquan.setStatus((byte)1);
		tblldcoquan.setCreated(new Date());
		tblldcoquan.setModified(new Date());
		ldcoquandao.save(tblldcoquan);
		return "redirect:/admin/ldcoquan/list.html";
	}
}
