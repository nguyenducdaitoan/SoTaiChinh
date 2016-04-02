package vn.softech.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.softech.dao.ThongBaoDao;
 
@Controller
public class ThongBaoDeleteController {
	private static final Logger logger = Logger.getLogger(ThongBaoDeleteController.class);
	
	@RequestMapping(value = "admin/thongbao/delete.html", method=RequestMethod.GET)
	public void deleteThongbao(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.debug("deleteThongbao called");		
		logger.debug("thongbaoId: " + request.getParameter("thongBaoId"));
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		String arrThongBao = request.getParameter("thongBaoId");
		if ((arrThongBao == null) || ("".equals(arrThongBao))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"thongBaoId là rỗng\"");
			response.getWriter().write("}");
		}		
		ThongBaoDao dao = new ThongBaoDao();
		String error = dao.updateBatch(arrThongBao);
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