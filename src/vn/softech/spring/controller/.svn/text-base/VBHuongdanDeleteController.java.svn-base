package vn.softech.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.GioiThieuDao;
import vn.softech.dao.VbHuongDanDao;
import vn.softech.hibernate.TblGioiThieu;
import vn.softech.hibernate.TblVbHuongDan;

@Controller
public class VBHuongdanDeleteController {
	VbHuongDanDao vbhuongdandao= new VbHuongDanDao();
	private static Logger log = Logger.getLogger(VBHuongdanDeleteController.class);
	
	//--------------------------------------------------------------------------------------
		@RequestMapping(value= "/admin/vbhuongdan/delete")
		public void execute(HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			log.info("executeDelete Called.");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setCharacterEncoding("UTF-8");
			String arrGioiThieu = request.getParameter("vbHuongDanId");
			if ((arrGioiThieu == null) || ("".equals(arrGioiThieu))) {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"vbHuongDanId là rỗng\"");
				response.getWriter().write("}");
			}		
			log.debug("vbHuongDanId: " + arrGioiThieu);
			String error = vbhuongdandao.updateBatch(arrGioiThieu);
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
