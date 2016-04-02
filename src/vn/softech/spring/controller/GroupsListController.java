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
import vn.softech.dao.GroupsDao;
import vn.softech.dao.UsersDao;
import vn.softech.hibernate.TblGroups;
import vn.softech.hibernate.TblUrls;
import vn.softech.hibernate.TblUsers;

@Controller
public class GroupsListController {
	private static Logger logger = Logger.getLogger(GroupsListController.class);
	
	@RequestMapping(value = "admin/groups/list.html", method = RequestMethod.GET)
	public String showListGroupsPage(HttpServletRequest request, HttpServletResponse reponse) {
		logger.debug("showListGroupsPage called");
		return "admin/groups/list";
	}
	
	@ModelAttribute(value="listGroups")
	public List<TblGroups> getListGroups() {
		List<TblGroups> listGroups = new ArrayList<TblGroups>();
		GroupsDao dao = new GroupsDao();
		listGroups = dao.get();
		return listGroups;
	}
	
	@RequestMapping(value="admin/groups/delete.html", method = RequestMethod.POST)
	public void processDeleteUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
//		StringBuffer ret = new StringBuffer();
		logger.debug("groupsId: " + request.getParameter("groupsId"));
		if ((request.getParameter("groupsId") == null) || ("".equals(request.getParameter("groupsId")))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"groupsId là rỗng\"");
			response.getWriter().write("}");
		} else {
			GroupsDao dao = new GroupsDao();
			String error = dao.updateBatch(request.getParameter("groupsId"));
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
