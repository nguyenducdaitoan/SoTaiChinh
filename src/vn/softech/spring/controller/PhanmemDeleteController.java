package vn.softech.spring.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.PhanMemDao;
import vn.softech.form.PhanmemForm;
import vn.softech.hibernate.TblPhanmem;

@Controller
public class PhanmemDeleteController {
	PhanMemDao phanmemdao= new PhanMemDao();
	
	private static Logger log = Logger.getLogger(PhanmemDeleteController.class);
	
	@RequestMapping(value= "/admin/phanmem/delete")
	public String deletePhanmem(){
		log.info("deletePhanmem called.");
		try {
			PhanmemForm form= PhanmemListController.phanmem;
			TblPhanmem tblphanmem= phanmemdao.get(form.getPhanmemId());
			tblphanmem.setStatus((byte)3);
			tblphanmem.setModified(new Date());
			phanmemdao.update(tblphanmem);
			return "redirect:/admin/phanmem/list.html";
		} catch (Exception e) {
			// TODO: handle exception
			log.info("qua trinh xoa phat sinh loi.");
			return "redirect:/admin/phanmem/list.html";
		}
		
	}

}
