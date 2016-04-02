package vn.softech.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LegalDocumentsDao;

@Controller
public class LegalDocumentsAdminDeleteController {
	private static Logger log = Logger.getLogger(LegalDocumentsAdminDeleteController.class);
	
	
	@RequestMapping (value = "/admin/legaldocuments/deleteajaxlegaldocuments")
	public void deleteajaxlegaldocuments(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String legalDocumentsId = request.getParameter("legalDocumentsId");
		if ((legalDocumentsId == null) || ("".equals(legalDocumentsId))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"legalDocumentsId là rỗng\"");
			response.getWriter().write("}");
		}		
		log.debug("legalDocumentsId: " + legalDocumentsId);
		LegalDocumentsDao dao= new LegalDocumentsDao();
		String error = dao.updateBatch(legalDocumentsId);
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
