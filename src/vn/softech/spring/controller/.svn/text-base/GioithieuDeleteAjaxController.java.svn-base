package vn.softech.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.softech.dao.GioiThieuDao;
import vn.softech.hibernate.TblGioiThieu;

@Controller
public class GioithieuDeleteAjaxController {
	GioiThieuDao gioithieudao= new GioiThieuDao();
	List<TblGioiThieu> listgioithieu;
	private static Logger log = Logger.getLogger(GioithieuDeleteAjaxController.class);
	
	//--------------------------------------------------------------------------------------
		@RequestMapping(value= "/admin/gioithieu/deleteajaxgioithieu")
		public void execute(HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setCharacterEncoding("UTF-8");
			String arrGioiThieu = request.getParameter("gioiThieuId");
			if ((arrGioiThieu == null) || ("".equals(arrGioiThieu))) {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"gioiThieuId là rỗng\"");
				response.getWriter().write("}");
			}		
			log.debug("gioiThieuId: " + arrGioiThieu);
			GioiThieuDao dao = new GioiThieuDao();
			String error = dao.updateBatch(arrGioiThieu);
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
		
		//----------------------------------------------------------------------------------------
		@ExceptionHandler({ Exception.class })
		 public String handleException(Exception e, HttpServletRequest request) {
		  log.error(e.getMessage(), e);
		  request.setAttribute("errorMessage", e.getMessage());
		  return "error";
		 }	
		
}
