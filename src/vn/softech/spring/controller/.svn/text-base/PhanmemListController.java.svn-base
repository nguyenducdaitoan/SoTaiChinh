package vn.softech.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.PhanMemDao;
import vn.softech.form.PhanmemForm;
import vn.softech.hibernate.TblPhanmem;

@Controller
public class PhanmemListController {
	PhanMemDao phanmemdao= new PhanMemDao();
	List<TblPhanmem> listphanmem;
	public static PhanmemForm phanmem= new PhanmemForm();
	
	private static Logger log = Logger.getLogger(PhanmemListController.class);
	
	@RequestMapping(value = "/admin/phanmem/list")
	public String viewPhanmemList(Model model,@ModelAttribute("phanmem")PhanmemForm form) {	
		if (form.getAction()==null) {
			listphanmem = phanmemdao.get();
			model.addAttribute("listphanmem", listphanmem);
			PhanmemForm phanmem= new PhanmemForm();
			model.addAttribute("phanmem",phanmem);
			return "admin/phanmem/phanmemList";
		}
		else if (form.getAction().equals("update")) {
			phanmem=form;
			return "redirect:/admin/phanmem/update.html";
		}
		else if (form.getAction().equals("delete")) {
			phanmem=form;
			return "redirect:/admin/phanmem/delete.html";
		}
		else {
			phanmem=form;
			return "redirect:/admin/phanmem/add.html";
		}
			
	}
	

}
