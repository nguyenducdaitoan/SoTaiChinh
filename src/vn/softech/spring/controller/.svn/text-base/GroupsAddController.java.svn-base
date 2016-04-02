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
import vn.softech.dao.UsersDao;
import vn.softech.form.GroupsForm;
import vn.softech.form.LoginForm;
import vn.softech.form.UsersForm;
import vn.softech.hibernate.TblGroups;
import vn.softech.hibernate.TblPhongBan;
import vn.softech.hibernate.TblUsers;
import vn.softech.util.StringUtils;
 
@Controller
public class GroupsAddController {
	private static final Logger logger = Logger.getLogger(GroupsAddController.class);
	
	@RequestMapping(value = "admin/groups/add.html", method = RequestMethod.GET)
	public String showForm(Map model) throws Exception {
		logger.debug("showForm called");		
		GroupsForm groupsForm = new GroupsForm();
		model.put("groupsForm", groupsForm);
		return "admin/groups/add";
	}
/*	
	@ModelAttribute(value="listPhongBan")
	public List<TblPhongBan> getListPhongBan() {
		logger.debug("getListPhongBan called");
		List<TblPhongBan> listPhongBan = new ArrayList<TblPhongBan>();
		UsersDao dao = new UsersDao();
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

	@RequestMapping(value = "admin/groups/add.html", method = RequestMethod.POST)
	public String processForm(@Valid GroupsForm groupsForm, BindingResult result) throws Exception {
		logger.debug("processForm called");
		logger.debug("Groups Name: " + groupsForm.getName());
		GroupsDao dao = new GroupsDao();
		TblGroups groups = new TblGroups();		
		groups.setName(groupsForm.getName());
		groups.setPriority(groupsForm.getPriority());
		groups.setCreated(new Date());
		groups.setModified(new Date());
		groups.setStatus((byte)1);
		dao.save(groups);
		return "redirect:/admin/groups/list.html";
	}
}