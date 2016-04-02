package vn.softech.spring.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.softech.dao.GioiThieuDao;
import vn.softech.dao.VbHuongDanDao;
import vn.softech.hibernate.TblGioiThieu;
import vn.softech.hibernate.TblVbHuongDan;
import vn.softech.spring.validator.VbhuongdanValidator;

@Controller
public class VBHuongdanEditController {
	VbHuongDanDao vbhuongdandao= new VbHuongDanDao();
	List<TblVbHuongDan> listvbhuongdan;
	private static Logger log = Logger.getLogger(GioithieuEditController.class);	
	VbhuongdanValidator vbhuongdanvalidator= new VbhuongdanValidator();

	//-----------------------------------------------------------------------------------	
		@RequestMapping(value = "/admin/vbhuongdan/edit")
		public String editVbhuongdan(Model model, @RequestParam("vbHuongDanId")Long id) {
			log.debug("editVbhuongdan called; id: "+id);
			vbhuongdandao= new VbHuongDanDao();
			TblVbHuongDan vbhuongdan = vbhuongdandao.get(id);		
			model.addAttribute("vbhuongdan", vbhuongdan);
			return "admin/vbhuongdan/vbhuongdanedit";
		}
		
		@RequestMapping(value = "/admin/vbhuongdan/submitedit")
		public String submitEditVbhuongdan(@ModelAttribute("vbhuongdan") TblVbHuongDan form,
				@RequestParam("txtFCKContent") String content, Model model, BindingResult result) throws Exception{
			log.info("submitEditVbhuongdan called. with: "+ form.getVbHuongDanId());
			
			TblVbHuongDan vbhuongdan= vbhuongdandao.get(form.getVbHuongDanId());
			vbhuongdan.setTitle(form.getTitle());
			vbhuongdan.setSummary(form.getSummary());
			vbhuongdan.setActive(form.isActive());
			Date modified= new Date();
			vbhuongdan.setModified(modified);
			vbhuongdan.setContent(content);					
			vbhuongdanvalidator.validate(vbhuongdan, result);
			if (result.hasErrors()) {
				return "admin/vbhuongdan/vbhuongdanedit";
			} else {
				vbhuongdandao.update(vbhuongdan);			
				//load gioithieu list
				listvbhuongdan=vbhuongdandao.get();		
				model.addAttribute("listvbhuongdan",listvbhuongdan);
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
