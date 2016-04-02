package vn.softech.spring.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.PhanMemDao;
import vn.softech.form.PhanmemForm;
import vn.softech.hibernate.TblPhanmem;

@Controller
public class PhanmemAddController {
	PhanMemDao phanmemdao= new PhanMemDao();
	private static Logger log = Logger.getLogger(PhanmemAddController.class);
	@RequestMapping (value = "/admin/phanmem/add")
	public String addPhanmem() {
		log.info("addPhanmem called.");
		PhanmemForm form = PhanmemListController.phanmem;	
		TblPhanmem tblphanmem= new TblPhanmem();
		tblphanmem.setTitle(form.getTitle());
		tblphanmem.setUrl(form.getUrl());
		tblphanmem.setPriority(form.getPriority());
		tblphanmem.setStatus((byte)1);
		tblphanmem.setPhienBan(form.getPhienBan());
		tblphanmem.setPhanmemId(form.getPhanmemId());
		tblphanmem.setMoTa(form.getMoTa());
		Date date= new Date();
		tblphanmem.setCreated(date);
		tblphanmem.setModified(date);
		phanmemdao.save(tblphanmem);		
		return "redirect:/admin/phanmem/list.html";
	}
}
