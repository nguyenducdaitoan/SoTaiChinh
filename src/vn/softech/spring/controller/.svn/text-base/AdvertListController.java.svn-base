package vn.softech.spring.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import vn.softech.hibernate.TblAdvert;
import vn.softech.dao.AdvertDao;
import vn.softech.form.AdvertForm;

@Controller
@RequestMapping("/admin/adverts")
public class AdvertListController  {
	AdvertDao advertdao= new AdvertDao();
	List<TblAdvert> listadvert;
	TblAdvert advert = new TblAdvert();
	private static Logger log = Logger.getLogger(AdvertListController.class);	

	@RequestMapping(value = "/list")
	public String showListAdvert (@ModelAttribute("advert") AdvertForm form, Model model) throws Exception {
		log.debug("showListAAdvert called.");	
		listadvert=advertdao.get();
		log.debug(listadvert.size());		
		model.addAttribute("listadvert",listadvert);
		return "admin/adverts/advertlist";
	}
	
	@RequestMapping(value = "/action")
	public String actionAdvert(@ModelAttribute("advert") AdvertForm form, Model model) throws Exception{
		log.info("action advert called.");
		String action = form.getAction();
		//debug
		log.debug("=============BBEGIN FORM==================");
		log.debug("Advert Form advertID : " + form.getAdvertId());
		log.debug("Advert Form name   : " + form.getName());
		log.debug("Advert Form Link     : " + form.getLink());
		log.debug("Advert Form Path Image     : " + form.getPathImage());
		log.debug("Advert Form Exprire : " + form.getStrExprire());
		log.debug("Advert Form Priorty : " + form.getPriority());
		log.debug("Advert Form action  : " + form.getAction());
		log.debug("=============END FORM==================");
		Date now = new Date();
		Date dExprire = null;
		if ((form.getStrExprire() != null) && (!"".equals(form.getStrExprire()))) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			try {
				dExprire = format.parse(form.getStrExprire());
				log.debug("Format Exprire : " + dExprire);
	        } catch(ParseException pe) {
	            log.error("ERROR: Cannot parse \"" + form.getStrExprire() + "\"");
	        }
		}
		//String[] strExprire = form.getExprire().split("/");
		if("".equals(action)){ //add new ardvert
			log.info("called Add new.");
			advert.setName(form.getName());
			advert.setLink(form.getLink());
			advert.setPathImage(form.getPathImage());
			advert.setExprire(form.getExprire());
			advert.setExprire(dExprire);
			advert.setPriority(form.getPriority());
			advert.setPathImage(form.getPathImage());
			advert.setStatus((byte)1);
			advert.setCreated(now);
			advert.setModified(now);
			long advertId = advertdao.save(advert);
			log.info("advertId add New : " + advertId);
			if (advertId> 0) {
				log.debug("Add new advert success");
			} else {
				log.debug("Add new advert fail");
			}
			
		} else if("update".equals(action)){ // Update
			long advertId = form.getAdvertId();
			log.info("called Update.");
			log.info("advertId update : " + advertId);
			if (advertId >= 0) {
				advert = advertdao.get(advertId);
				if(advert != null){
					advert.setAdvertId(advertId);
					advert.setName(form.getName());
					advert.setLink(form.getLink());
					advert.setPathImage(form.getPathImage());
					//advert.setExprire(form.getExprire());
					advert.setExprire(dExprire);
					advert.setPriority(form.getPriority());
					advert.setPathImage(form.getPathImage());
					advert.setStatus((byte)1);
					advert.setModified(now);
					advertdao.update(advert);
				} else {
					log.info("advert này không tồn tại.");
				}
			} else {
				log.info("called update. ardvertId is null.");
			}
			
		} else if("delete".equals(action)){ // Delele
			log.info("called Dalete.");
			long advertId = form.getAdvertId();
			if (advertId >= 0) {
				advert = advertdao.get(advertId);
				if(advert != null){
					advert.setStatus((byte)3);
					advert.setModified(now);
					advertdao.update(advert);
				} else {
					log.info("advert này không tồn tại.");
				}
			} else {
				log.debug("Delete advert fail");
			}
		}
		
		//load advert list
		listadvert=advertdao.get();
		log.debug(listadvert.size());		
		model.addAttribute("listadvert",listadvert);
		return "admin/adverts/advertlist";
	}
	
	@RequestMapping(value = "/deleteAjax")
	public String deleteAdvert(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String arrAdvertId = request.getParameter("advertId");
		if ((arrAdvertId == null) || ("".equals(arrAdvertId))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"advertId là rỗng\"");
			response.getWriter().write("}");
			return null;
		}
		
		log.debug("arrAdvertId: " + arrAdvertId);

		String error = advertdao.updateBatch(arrAdvertId);
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
