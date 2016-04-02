package vn.softech.spring.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.softech.dao.LdCapDao;
import vn.softech.dao.LdCoQuanDao;
import vn.softech.form.LdcoquanForm;
import vn.softech.hibernate.TblLdCap;
import vn.softech.hibernate.TblLdCoQuan;

@Controller
public class VbHanhChinhCoquanEditController {
	LdCoQuanDao ldcoquandao= new LdCoQuanDao();
	private static Logger log = Logger.getLogger(VbHanhChinhCoquanEditController.class);
	
	@RequestMapping (value = "/admin/vbhanhchinhcoquan/edit")
	public String editLdcoquanForm(@RequestParam("ldCoQuanId")String coquanid, Model model) {
		LdcoquanForm form= new LdcoquanForm();
		TblLdCoQuan tblldcoquan=ldcoquandao.get(Short.parseShort(coquanid));
		form.setLdCoQuanId(tblldcoquan.getLdCoQuanId());
		form.setName(tblldcoquan.getName());
		form.setMacDinh(tblldcoquan.isMacDinh());
		form.setStatus(tblldcoquan.getStatus());
		form.setCreated(tblldcoquan.getCreated());
		form.setModified(tblldcoquan.getModified());
		form.setTblLdCap(tblldcoquan.getTblLdCap());
		form.setLdCapId(tblldcoquan.getTblLdCap().getLdCapId());
		form.setType(tblldcoquan.getType());
		
		model.addAttribute("ldcoquan", form);
		return "admin/vbhanhchinhcoquan/vbhanhchinhcoquanedit";
	}

	
	@ModelAttribute(value="listldcap")
	public List<TblLdCap> getListLdcap() {
		LdCapDao ldcapdao= new LdCapDao();
		return ldcapdao.get();
	}
	
	@RequestMapping(value = "/admin/vbhanhchinhcoquan/submitedit")
	public String submitEditLdcoquan(@ModelAttribute("ldcoquan")LdcoquanForm form, Model model) throws Exception{
		log.info("submitEditLdcoquan called.");
		LdCapDao dao= new LdCapDao();
		TblLdCoQuan tblldcoquan= ldcoquandao.get(form.getLdCoQuanId());
		tblldcoquan.setName(form.getName());		
		tblldcoquan.setTblLdCap(dao.get(form.getLdCapId()));
		tblldcoquan.setMacDinh(form.isMacDinh());
		tblldcoquan.setModified(new Date());
		ldcoquandao.update(tblldcoquan);
		 
		List<TblLdCoQuan> listldcoquan= ldcoquandao.getByType((byte)2);
		model.addAttribute("listldcoquan", listldcoquan);
		return "admin/vbhanhchinhcoquan/vbhanhchinhcoquanlist";
	}
}
