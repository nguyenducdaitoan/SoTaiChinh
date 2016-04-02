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
public class GioithieuAddController {
	private static Logger log = Logger.getLogger(GioithieuAddController.class);	
	GioiThieuDao gioithieudao;
	List<TblGioiThieu> listgioithieu;
	
	//-----------------------------------------------------------------------------------	
		@RequestMapping(value = "/admin/gioithieu/add")
		public String addGioithieu(Model model) {
			log.info("addGioithieu called.");
			model.addAttribute("gioithieu",new TblGioiThieu());
			return "admin/gioithieu/gioithieuAdd";
		}
		
		@RequestMapping(value = "/admin/gioithieu/submitadd")
		public String submitAddGioithieu(@ModelAttribute("gioithieu") TblGioiThieu form,
				@RequestParam("txtFCKContent") String content, Model model) {
			log.info("submitAddGioithieu called.");
			TblGioiThieu gioithieu= new TblGioiThieu();
			gioithieu.setTitle(form.getTitle());
			gioithieu.setTitleMenu(form.getTitleMenu());
			gioithieu.setActive(form.isActive());
			gioithieu.setContent(content);
			gioithieu.setCreated(new Date());
			gioithieu.setModified(new Date());
			gioithieu.setPriority((byte)0);
			gioithieu.setStatus((byte)1);
			gioithieu.setUsersId((byte)0);
			gioithieudao= new GioiThieuDao();
			long gioithieuId= gioithieudao.save(gioithieu);		
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
