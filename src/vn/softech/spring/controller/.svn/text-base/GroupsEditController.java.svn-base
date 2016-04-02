package vn.softech.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.softech.dao.AdminSystemDao;
import vn.softech.dao.GroupsDao;
import vn.softech.form.LoginForm;
import vn.softech.form.GroupsForm;
import vn.softech.hibernate.TblPhongBan;
import vn.softech.hibernate.TblGroups;
import vn.softech.util.StringUtils;
 
@Controller
public class GroupsEditController {
	private static final Logger logger = Logger.getLogger(GroupsEditController.class);
	
	@RequestMapping(value = "admin/groups/edit.html", method = RequestMethod.GET)
	public String showForm(Map model, HttpServletRequest request) throws Exception {
		logger.debug("showForm called");
		long groupsId = Long.parseLong(request.getParameter("groupsId"));
		logger.debug("groupsId: " + groupsId);
		GroupsDao dao = new GroupsDao();
		TblGroups groups = dao.get(groupsId);
		if (groups == null) {
			throw new Exception("groupsId: " + groupsId + " is not exist!");
		}
		GroupsForm groupsForm = new GroupsForm();
		groupsForm.setGroupsId(groupsId);
		groupsForm.setName(groups.getName());
		groupsForm.setPriority(groups.getPriority());		
		model.put("groupsForm", groupsForm);
		return "admin/groups/edit";
	}
/*	
	@ModelAttribute(value="listPhongBan")
	public List<TblPhongBan> getListPhongBan(HttpServletRequest request) {
		logger.debug("getListPhongBan called");
		List<TblPhongBan> listPhongBan = new ArrayList<TblPhongBan>();
		GroupsDao dao = new GroupsDao();
		listPhongBan = dao.getPhongBan();
		return listPhongBan;
	}
*/	
	@ExceptionHandler({ Exception.class })
	public String handleException(Exception e, HttpServletRequest request) {
		logger.error(e.getMessage(), e);
		request.setAttribute("errorMessage", e.getMessage());
		return "admin/groups/error";
	}

	@RequestMapping(value = "admin/groups/edit.html", method = RequestMethod.POST)
	public String processForm(@Valid GroupsForm groupsForm, BindingResult result,	Map model, HttpServletRequest request) throws Exception {
		logger.debug("processForm called");
		logger.debug("Groups Name: " + groupsForm.getName());
		GroupsDao dao = new GroupsDao();
		TblGroups groups = dao.get(groupsForm.getGroupsId());
		if (groups == null) {
			throw new Exception("groupsId: " + groupsForm.getGroupsId() + " is not exist!");
		}
		groups.setName(groupsForm.getName());
		groups.setPriority(groupsForm.getPriority());
		groups.setModified(new Date());
		dao.update(groups);
		return "redirect:/admin/groups/list.html";
	}
}