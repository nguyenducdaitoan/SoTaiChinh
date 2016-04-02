package vn.softech.spring.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.PhanMemDao;
import vn.softech.form.PhanmemForm;
import vn.softech.hibernate.TblPhanmem;

@Controller
public class PhanmemEditController {
	PhanMemDao phanmemdao= new PhanMemDao();
	private static Logger log = Logger.getLogger(PhanmemEditController.class);
	
	@RequestMapping(value = "/admin/phanmem/update")
	public String updatePhanmem() throws Exception{
		log.info("updatePhanmem called.");
		PhanmemForm form= PhanmemListController.phanmem;
		TblPhanmem tblphanmem= phanmemdao.get(form.getPhanmemId());
		tblphanmem.setTitle(form.getTitle());
		tblphanmem.setUrl(form.getUrl());
		tblphanmem.setPriority(form.getPriority());
		tblphanmem.setPhienBan(form.getPhienBan());
		tblphanmem.setMoTa(form.getMoTa());
		Date date= new Date();
		tblphanmem.setModified(date);
		phanmemdao.update(tblphanmem);
		return "redirect:/admin/phanmem/list.html";
	}
}
