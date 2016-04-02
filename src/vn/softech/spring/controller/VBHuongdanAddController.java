package vn.softech.spring.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import vn.softech.dao.GioiThieuDao;
import vn.softech.dao.VbHuongDanDao;
import vn.softech.hibernate.TblGioiThieu;
import vn.softech.hibernate.TblVbHuongDan;
import vn.softech.spring.validator.VbhuongdanValidator;

@Controller
public class VBHuongdanAddController {
	
	private static Logger log = Logger.getLogger(VBHuongdanAddController.class);	
	VbHuongDanDao vbhuongdandao= new VbHuongDanDao();
	List<TblVbHuongDan> listVbHuongdan;
	VbhuongdanValidator vbhuongdanvalidator= new VbhuongdanValidator();
		
	
	//-----------------------------------------------------------------------------------	
		@RequestMapping(value = "/admin/vbhuongdan/add")
		public String addVbHuongdan(Model model) {
			log.info("addVbHuongdan called.");
			model.addAttribute("vbhuongdan",new TblVbHuongDan());
			return "admin/vbhuongdan/vbhuongdanadd";
		}
		
		@RequestMapping(value = "/admin/vbhuongdan/submitadd")
		public String submitAddVbHuongdan(@ModelAttribute("vbhuongdan") TblVbHuongDan form,
				@RequestParam("txtFCKContent") String content, Model model, BindingResult result, SessionStatus status) {
			log.info("submitAddGioithieu called.");				
			//load gioithieu list
			form.setContent(content);
			vbhuongdanvalidator.validate(form, result);	
			if (result.hasErrors()) {
				// if validator failed
				return "admin/vbhuongdan/vbhuongdanadd";
			} else {				
				// form success				
				form.setStatus((byte)1);
				form.setUsersId((long)1);
				Date date= new Date();
				form.setCreated(date);
				form.setModified(date);
				vbhuongdandao.save(form);
				//load vbhuongdanlist			
				listVbHuongdan= vbhuongdandao.get();
				model.addAttribute("listvbhuongdan",listVbHuongdan);
				status.setComplete();
				return "admin/vbhuongdan/vbhuongdanlist";
			}
						
		}
		//----------------------------------------------------------------------------------------
		@ExceptionHandler({ Exception.class })
		 public String handleException(Exception e, HttpServletRequest request) {
		  log.error(e.getMessage(), e);
		  request.setAttribute("errorMessage", e.getMessage());
		  return "error";
		 }
		
}
