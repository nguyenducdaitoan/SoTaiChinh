package vn.softech.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PublicVideoController {
	private static Logger log = Logger.getLogger(PublicVideoController.class);	
	//VideoDao videoDao = new VideoDao();
	@RequestMapping(value = "/video/list.html")
		public String listVideo(Model model) throws Exception {
			log.info("listVideo called.");
//			List<TblVideo> listThongBao = videoDao.getByPage(10,1);
//			log.debug("listThongBao.sze() :" + listThongBao.size());
//			model.addAttribute("listRecentThongBao",listThongBao);
			return "/video/list";
		}
		
		//----------------------------------------------------------------------------------------
		@ExceptionHandler({ Exception.class })
		 public String handleException(Exception e, HttpServletRequest request) {
		  log.error(e.getMessage(), e);
		  request.setAttribute("errorMessage", e.getMessage());
		  return "error";
		 }
}
