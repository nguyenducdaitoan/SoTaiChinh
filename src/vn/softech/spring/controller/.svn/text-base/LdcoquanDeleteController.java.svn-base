package vn.softech.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdCoQuanDao;

@Controller
public class LdcoquanDeleteController {
	LdCoQuanDao ldcoquandao= new LdCoQuanDao();
	private static Logger log = Logger.getLogger(LdcoquanDeleteController.class);
	
	@RequestMapping (value = "/admin/ldcoquan/deleteajaxldcoquan")
	public void deleteajax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String ldCoQuanId = request.getParameter("ldCoQuanId");
		if ((ldCoQuanId == null) || ("".equals(ldCoQuanId))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"ldCoQuanId là rỗng\"");
			response.getWriter().write("}");
		}		
		log.debug("ldCapId: " + ldCoQuanId);		
		String error = ldcoquandao.updateBatch(ldCoQuanId);
		if ((error == null) || ("".equals(error))) {			
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"\"");
			response.getWriter().write("}");
		}else{
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"" + error + "\"");
			response.getWriter().write("}");
		}
	}
	
	
	
}
