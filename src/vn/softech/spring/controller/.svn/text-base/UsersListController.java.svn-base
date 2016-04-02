package vn.softech.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.softech.dao.AdminSystemDao;
import vn.softech.dao.UsersDao;
import vn.softech.hibernate.TblUrls;
import vn.softech.hibernate.TblUsers;

@Controller
public class UsersListController {
	private static Logger logger = Logger.getLogger(UsersListController.class);
	
	/**
	 * Hiển thị danh sách người dùng chức năng quản trị hệ thống
	 * @author vulh
	 * Created: 2012-11-01 
	 * */
	@RequestMapping(value = "admin/users/list.html", method = RequestMethod.GET)
	public String showListPage(HttpServletRequest request, HttpServletResponse reponse) {
		logger.debug("showLeftAdminPage called");
		return "admin/users/list";
	}
	
	@ModelAttribute(value="listUsers")
	public List<TblUsers> getListUsers(HttpServletRequest request) {
		List<TblUsers> listUsers = new ArrayList<TblUsers>();
		UsersDao dao = new UsersDao();
		listUsers = dao.get();
		return listUsers;
	}
	@RequestMapping(value="admin/users/delete.html", method = RequestMethod.POST)
	public void processDeleteUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		StringBuffer ret = new StringBuffer();
		logger.debug("usersId: " + request.getParameter("usersId"));
		if ((request.getParameter("usersId") == null) || ("".equals(request.getParameter("usersId")))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"usersId là rỗng\"");
			response.getWriter().write("}");
		} else {
			UsersDao dao = new UsersDao();
			String error = dao.updateBatch(request.getParameter("usersId"));
			if ((error == null) || ("".equals(error))) {   
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"\"");
				response.getWriter().write("}");
			} else {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"" + error + "\"");
				response.getWriter().write("}");
			}
		}
	}
}
