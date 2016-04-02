package vn.softech.spring.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdLinhVucDao;
import vn.softech.dao.LdLoaiVbDao;
import vn.softech.form.LdloaivbForm;
import vn.softech.hibernate.TblLdLinhVuc;
import vn.softech.hibernate.TblLdLoaiVb;

@Controller
public class LdloaivbAddController {
	LdLoaiVbDao ldloaivbdao= new LdLoaiVbDao();
	private static Logger log = Logger.getLogger(LdloaivbAddController.class);
	
	@RequestMapping (value = "/admin/ldloaivb/add")
	public String addLdloaivbForm(Model model) {
		LdloaivbForm form= new LdloaivbForm();
		model.addAttribute("ldloaivb", form);
		return "admin/ldloaivb/ldloaivbadd";
	}
	
	@RequestMapping(value = "/admin/ldloaivb/submitadd")
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
		tbl.setMacDinh(form.getMacDinh());		
		ldloaivbdao.save(tbl);		
		return "redirect:/admin/ldloaivb/list.html";
	}
	
}
