package vn.softech.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.GioiThieuDao;
import vn.softech.dao.LdCapDao;

@Controller
public class LdcapDeleteController {
	LdCapDao ldcapdao= new LdCapDao();
	private static Logger log = Logger.getLogger(LdcapDeleteController.class);

	@RequestMapping (value = "/admin/ldcap/delete")
	public void deleteajaxLdcap(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String arrLdcap = request.getParameter("ldCapId");
		if ((arrLdcap == null) || ("".equals(arrLdcap))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"ldCapId là rỗng\"");
			response.getWriter().write("}");
		}		
		log.debug("ldCapId: " + arrLdcap);		
		String error = ldcapdao.updateBatch(arrLdcap);
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
