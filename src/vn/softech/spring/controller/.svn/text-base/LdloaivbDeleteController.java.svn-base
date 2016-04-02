package vn.softech.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdLinhVucDao;
import vn.softech.dao.LdLoaiVbDao;

@Controller
public class LdloaivbDeleteController {
	LdLoaiVbDao ldloaivbdao= new LdLoaiVbDao();
	private static Logger log = Logger.getLogger(LdloaivbDeleteController.class);

	@RequestMapping (value = "/admin/ldloaivb/delete")
	public void deleteajaxLdloaivb(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String ldLoaiVbId = request.getParameter("ldLoaiVbId");
		if ((ldLoaiVbId == null) || ("".equals(ldLoaiVbId))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"ldLoaiVbId là rỗng\"");
			response.getWriter().write("}");
		}		
		log.debug("ldLoaiVbId: " + ldLoaiVbId);		
		String error = ldloaivbdao.updateBatch(ldLoaiVbId);
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
