package vn.softech.spring.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.softech.dao.LdLinhVucDao;
import vn.softech.dao.LdLoaiVbDao;
import vn.softech.form.LdloaivbForm;
import vn.softech.hibernate.TblLdLinhVuc;
import vn.softech.hibernate.TblLdLoaiVb;

@Controller
public class LdloaivbEditController {
	LdLoaiVbDao ldloaivbdao= new LdLoaiVbDao();
	private static Logger log = Logger.getLogger(LdloaivbEditController.class);
	
	@RequestMapping(value = "/admin/ldloaivb/edit")
	public String editldloaivbForm (@RequestParam("ldLoaiVbId")String id, Model model) {
		log.info("editldloaivbForm called. with Id: "+id);
		TblLdLoaiVb tbl= ldloaivbdao.get(Short.parseShort(id));
		LdloaivbForm form= new LdloaivbForm();
		form.setLdLoaiVbId(tbl.getLdLoaiVbId());
		form.setName(tbl.getName());
		if (tbl.getMacDinh()==0) {
			form.setMacDinhBool(false);
		} else form.setMacDinhBool(true);
		model.addAttribute("ldloaivb", form);
		return "admin/ldloaivb/ldloaivbedit";
	}
	
	@RequestMapping(value = "/admin/ldloaivb/submitedit")
	public String submitEditldloaivb(@ModelAttribute("ldLoaiVbId")LdloaivbForm form) throws Exception{
		log.info("submitEditldloaivb called.");
		TblLdLoaiVb tbl= ldloaivbdao.get(form.getLdLoaiVbId());
		tbl.setModified(new Date());
		tbl.setName(form.getName());
		if (!form.isMacDinhBool()) {
			tbl.setMacDinh((byte)0);
		} else tbl.setMacDinh((byte)1);
		
		ldloaivbdao.update(tbl);
		return "redirect:/admin/ldloaivb/list.html";
	}
}
