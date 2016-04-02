package vn.softech.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.VbHuongDanDao;
import vn.softech.hibernate.TblVbHuongDan;

@Controller
public class VBHuongdanViewController {
	List<TblVbHuongDan> listVbHuongdan;
	VbHuongDanDao vbhuongdandao= new VbHuongDanDao();
	private static Logger log = Logger.getLogger(VBHuongdanViewController.class);
	
	//----------------------------------------------------------------------------------------
	@RequestMapping(value = "/admin/vbhuongdan/list")
	public String showVbhuongdan (Model model) {
		log.info("showVbhuongdan");
		listVbHuongdan= vbhuongdandao.getall();
		log.debug(listVbHuongdan.get(0).getTitle());
		model.addAttribute("listvbhuongdan",listVbHuongdan);
		return "admin/vbhuongdan/vbhuongdanlist";
	}
	
	//----------------------------------------------------------------------------------------
			@ExceptionHandler({ Exception.class })
			 public String handleException(Exception e, HttpServletRequest request) {
			  log.error(e.getMessage(), e);
			  request.setAttribute("errorMessage", e.getMessage());
			  return "error";
			 }
				

}
