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
import vn.softech.dao.UsersDao;
import vn.softech.form.LoginForm;
import vn.softech.form.UsersForm;
import vn.softech.hibernate.TblPhongBan;
import vn.softech.hibernate.TblUsers;
import vn.softech.util.StringUtils;
 
@Controller
public class UsersEditController {
	private static final Logger logger = Logger.getLogger(UsersEditController.class);
	
	@RequestMapping(value = "admin/users/edit.html", method = RequestMethod.GET)
	public String showForm(Map model, HttpServletRequest request) throws Exception {
		logger.debug("showForm called");
		long usersId = Long.parseLong(request.getParameter("usersId"));
		logger.debug("usersId: " + usersId);
		UsersDao dao = new UsersDao();
		TblUsers users = dao.get(usersId);
		if (users == null) {
			throw new Exception("usersId: " + usersId + " is not exist!");
		}
		UsersForm usersForm = new UsersForm();
		usersForm.setUsersId(usersId);
		usersForm.setFirstName(users.getFirstName());
		usersForm.setLastName(users.getLastName());
		usersForm.setUsername(users.getUsername());
		usersForm.setEmail(users.getEmail());
		usersForm.setActive(users.isActive());
		if (users.getTblPhongBan() != null) {
			usersForm.setPhongBanId(users.getTblPhongBan().getPhongBanId());
		}
		model.put("usersForm", usersForm);
		return "admin/users/edit";
	}
	
	@ModelAttribute(value="listPhongBan")
	public List<TblPhongBan> getListPhongBan(HttpServletRequest request) {
		logger.debug("getListPhongBan called");
		List<TblPhongBan> listPhongBan = new ArrayList<TblPhongBan>();
		UsersDao dao = new UsersDao();
		listPhongBan = dao.getPhongBan();
		return listPhongBan;
	}
	@ExceptionHandler({ Exception.class })
	public String handleException(Exception e, HttpServletRequest request) {
		logger.error(e.getMessage(), e);
		request.setAttribute("errorMessage", e.getMessage());
		return "admin/users/error";
	}

	@RequestMapping(value = "admin/users/edit.html", method = RequestMethod.POST)
	public String processForm(@Valid UsersForm usersForm, BindingResult result,	Map model, HttpServletRequest request) throws Exception {
		logger.debug("processForm called");
		logger.debug("FirstName: " + usersForm.getFirstName());
		logger.debug("LastName: " + usersForm.getLastName());
		logger.debug("PhongBanId: " + usersForm.getPhongBanId());
		UsersDao dao = new UsersDao();
		TblUsers users = dao.get(usersForm.getUsersId());
		if (users == null) {
			throw new Exception("usersId: " + usersForm.getUsersId() + " is not exist!");
		}
		users.setFirstName(usersForm.getFirstName());
		users.setLastName(usersForm.getLastName());
		users.setUsername(usersForm.getUsername());
		if ((usersForm.getPassword() != null) && (!"".equals(usersForm.getPassword()))) {
			String newpassword = StringUtils.md5Hex(usersForm.getPassword());
			users.setPassword(newpassword);
		}
		users.setEmail(usersForm.getEmail());
		users.setActive(usersForm.isActive());
		TblPhongBan phongBan = dao.getPhongBan(usersForm.getPhongBanId());
		users.setTblPhongBan(phongBan);
		users.setModified(new Date());
		dao.update(users);
		return "redirect:/admin/users/list.html";
	}
}