package vn.softech.spring.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdLoaiVbDao;
import vn.softech.form.LdloaivbForm;
import vn.softech.hibernate.TblLdLoaiVb;

@Controller
public class VbHanhChinhLoaiVbAddController {
	LdLoaiVbDao ldloaivbdao= new LdLoaiVbDao();
	private static Logger log = Logger.getLogger(VbHanhChinhLoaiVbAddController.class);
	
	@RequestMapping (value = "/admin/vbhanhchinhloaivb/add")
	public String addLdloaivbForm(Model model) {
		LdloaivbForm form= new LdloaivbForm();
		model.addAttribute("ldloaivb", form);
		return "admin/vbhanhchinhloaivb/vbhanhchinhloaivbadd";
	}
	
	@RequestMapping(value = "/admin/vbhanhchinhloaivb/submitadd")
	public String submitAddldloaivb(@ModelAttribute("ldloaivb")LdloaivbForm form) {
		log.info("submitAddldloaivb called.");
		if (form.isMacDinhBool()) {
			form.setMacDinh((byte)1);
		} else form.setMacDinh((byte)0);		
		TblLdLoaiVb tbl= new TblLdLoaiVb();
		tbl.setStatus((byte)1);
		tbl.setCreated(new Date());
		tbl.setModified(new Date());
		tbl.setName(form.getName());
		tbl.setType((byte)2);
		tbl.setMacDinh(form.getMacDinh());		
		ldloaivbdao.save(tbl);		
		return "redirect:/admin/vbhanhchinhloaivb/list.html";
	}
}
