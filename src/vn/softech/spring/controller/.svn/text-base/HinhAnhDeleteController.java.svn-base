package vn.softech.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.softech.dao.HinhAnhDao;
 
@Controller
public class HinhAnhDeleteController {
	private static final Logger logger = Logger.getLogger(HinhAnhDeleteController.class);
	
	@RequestMapping(value = "admin/hinhanh/delete.html", method=RequestMethod.GET)
	public void deletehinhAnh(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.debug("deletehinhAnh called");		
		logger.debug("hinhanhId: " + request.getParameter("hinhAnhId"));
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String arrHinhAnh = request.getParameter("hinhAnhId");
		if ((arrHinhAnh == null) || ("".equals(arrHinhAnh))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"hinhAnhId là rỗng\"");
			response.getWriter().write("}");
		}		
		HinhAnhDao dao = new HinhAnhDao();
		String error = dao.updateBatch(arrHinhAnh);
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