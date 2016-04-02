package vn.softech.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdLinhVucDao;

@Controller
public class VbHanhChinhLinhvucDeleteController {
	LdLinhVucDao ldlinhvucdao= new LdLinhVucDao();
	private static Logger log = Logger.getLogger(VbHanhChinhLinhvucDeleteController.class);

	@RequestMapping (value = "/admin/vbhanhchinhlinhvuc/delete")
	public void deleteajaxLdlinhvuc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String ldLinhVucId = request.getParameter("ldLinhVucId");
		if ((ldLinhVucId == null) || ("".equals(ldLinhVucId))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"ldLinhVucId là rỗng\"");
			response.getWriter().write("}");
		}		
		log.debug("ldLinhVucId: " + ldLinhVucId);		
		String error = ldlinhvucdao.updateBatch(ldLinhVucId);
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
