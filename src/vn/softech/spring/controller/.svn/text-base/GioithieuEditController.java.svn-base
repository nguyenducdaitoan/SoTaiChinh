package vn.softech.spring.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.softech.dao.GioiThieuDao;
import vn.softech.hibernate.TblGioiThieu;

@Controller
public class GioithieuEditController {
	GioiThieuDao gioithieudao= new GioiThieuDao();
	List<TblGioiThieu> listgioithieu;
	private static Logger log = Logger.getLogger(GioithieuEditController.class);	

	//-----------------------------------------------------------------------------------	
		@RequestMapping(value = "/admin/gioithieu/edit")
		public String editGioithieu(Model model, @RequestParam("gioiThieuId")Long id) {
			log.info("editGioithieu called.");
			log.debug("editGioithieu called; id: "+id);
			gioithieudao= new GioiThieuDao();
			TblGioiThieu gioithieu = gioithieudao.get(id);		
			model.addAttribute("gioithieu", gioithieu);
			return "admin/gioithieu/gioithieuEdit";
		}
		
		@RequestMapping(value = "/admin/gioithieu/submitedit")
		public String submitEditGioithieu(@ModelAttribute("gioithieu") TblGioiThieu form,
				@RequestParam("txtFCKContent") String content, Model model) throws Exception{
			log.info("submitEditGioithieu called.");
			TblGioiThieu gioithieu= gioithieudao.get(form.getGioiThieuId());
			gioithieu.setTitle(form.getTitle());
			gioithieu.setTitleMenu(form.getTitleMenu());
			gioithieu.setActive(form.isActive());
			Date modified= new Date();
			gioithieu.setModified(modified);
			gioithieu.setPriority(form.getPriority());
			gioithieudao.update(gioithieu);			
			//load gioithieu list
			listgioithieu=gioithieudao.get();		
			model.addAttribute("listgioithieu",listgioithieu);
			return "admin/gioithieu/gioithieulist";
		}	
		
		//----------------------------------------------------------------------------------------
		@ExceptionHandler({ Exception.class })
		 public String handleException(Exception e, HttpServletRequest request) {
		  log.error(e.getMessage(), e);
		  request.setAttribute("errorMessage", e.getMessage());
		  return "error";
		 }
		

}
