package vn.softech.spring.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.softech.dao.LinkDao;
import vn.softech.dao.VideoDao;
import vn.softech.form.LinkFrom;
import vn.softech.hibernate.TblLink;

@Controller
@RequestMapping("/admin/links")
public class LinkListController  {
	LinkDao linkdao= new LinkDao();
	List<TblLink> listlink;
	TblLink link = new TblLink();
	private static Logger log = Logger.getLogger(LinkListController.class);	

	@RequestMapping(value = "/list")
	public String showlistlink (@ModelAttribute("link") LinkFrom form, Model model) throws Exception {
		log.debug("showlistlink called.");	
		listlink=linkdao.get();
		log.debug(listlink.size());		
		model.addAttribute("listlink",listlink);
		return "admin/links/linklist";
	}
	
	@RequestMapping(value = "/action")
	public String actionLienKet(@ModelAttribute("link")LinkFrom form, Model model) throws Exception{
		log.info("action called.");
		String action = form.getAction();
		//debug
		log.debug("=============BBEGIN FORM==================");
		log.debug("Link Form linkID      : " + form.getLinkId());
		log.debug("Link Form name        : " + form.getName());
		log.debug("Link Form hrfe        : " + form.getHref());
		log.debug("Link Form Description : " + form.getDescription());
		log.debug("Link Form action      : " + form.getAction());
		log.debug("=============END FORM==================");
		Date now = new Date();
		
		if("".equals(action)){ //add new video
			log.info("called Add new.");
			link.setName(form.getName());
			link.setHref(form.getHref());
			link.setDescription(form.getDescription());
			link.setStatus((byte)1);
			link.setCreated(now);
			link.setModified(now);
			long linkId = linkdao.save(link);
			log.info("linkId add New : " + linkId);
			if (linkId> 0) {
				log.debug("Add new link success");
			} else {
				log.debug("Add new link fail");
			}
			
		} else if("update".equals(action)){ // Update
			long linkId = form.getLinkId();
			log.info("called Update.");
			log.info("linkId update : " + linkId);
			if (linkId >= 0) {
				link = linkdao.get(linkId);
				if(link != null){
					link.setLinkId(linkId);
					link.setName(form.getName());
					link.setHref(form.getHref());
					link.setDescription(form.getDescription());
					link.setStatus((byte)1);
					link.setModified(now);
					linkdao.update(link);
				} else {
					log.info("link này không tồn tại.");
				}
			} else {
				log.info("called update. linkId is null.");
			}
			
		} else if("delete".equals(action)){ // Delele
			log.info("called Dalete.");
			long linkId = form.getLinkId();
			if (linkId >= 0) {
				link = linkdao.get(linkId);
				if(link != null){
					link.setStatus((byte)3);
					link.setModified(now);
					linkdao.update(link);
				} else {
					log.info("link này không tồn tại.");
				}
			} else {
				log.debug("Delete link fail");
			}
		}
		
		//load link list
		listlink=linkdao.get();
		log.debug(listlink.size());		
		model.addAttribute("listlink",listlink);
		return "admin/links/linklist";
	}
	
	@RequestMapping(value = "/deleteAjax")
	public String deletelink(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String arrLinkId = request.getParameter("linkId");
		if ((arrLinkId == null) || ("".equals(arrLinkId))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"linkId là rỗng\"");
			response.getWriter().write("}");
			return null;
		}
		
		log.debug("arrLinkId: " + arrLinkId);

		String error = linkdao.updateBatch(arrLinkId);
		if ((error == null) || ("".equals(error))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"\"");
			response.getWriter().write("}");
			return null;
		}
		response.getWriter().write("{");
		response.getWriter().write("\"error\":\"" + error + "\"");
		response.getWriter().write("}");
		return null;
	}
}
