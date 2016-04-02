package vn.softech.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LegalDocumentsDao;
import vn.softech.dao.VbHanhChinhDao;

@Controller
public class VbHanhChinhAdminDeleteController {
private static Logger log = Logger.getLogger(VbHanhChinhAdminDeleteController.class);
	
	
	@RequestMapping (value = "/admin/vbhanhchinhadmin/deleteajaxlegaldocuments")
	public void deleteajaxvbhanhchinh(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String documentsId = request.getParameter("documentsId");
		if ((documentsId == null) || ("".equals(documentsId))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"documentsId là rỗng\"");
			response.getWriter().write("}");
		}		
		log.debug("legalDocumentsId: " + documentsId);
		VbHanhChinhDao dao= new VbHanhChinhDao();
		String error = dao.updateBatch(documentsId);
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
