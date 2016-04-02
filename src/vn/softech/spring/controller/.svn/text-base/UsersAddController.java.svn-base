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
public class UsersAddController {
	private static final Logger logger = Logger.getLogger(UsersAddController.class);
	
	@RequestMapping(value = "admin/users/add.html", method = RequestMethod.GET)
	public String showForm(Map model) throws Exception {
		logger.debug("showForm called");		
		UsersForm usersForm = new UsersForm();
		model.put("usersForm", usersForm);
		return "admin/users/add";
	}
	
	@ModelAttribute(value="listPhongBan")
	public List<TblPhongBan> getListPhongBan() {
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

	@RequestMapping(value = "admin/users/add.html", method = RequestMethod.POST)
	public String processForm(@Valid UsersForm usersForm, BindingResult result) throws Exception {
		logger.debug("processForm called");
		logger.debug("FirstName: " + usersForm.getFirstName());
		logger.debug("LastName: " + usersForm.getLastName());
		logger.debug("PhongBanId: " + usersForm.getPhongBanId());
		UsersDao dao = new UsersDao();
		TblUsers users = new TblUsers();		
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
		users.setCreated(new Date());
		users.setModified(new Date());
		users.setStatus((byte)1);
		dao.save(users);
		return "redirect:/admin/users/list.html";
	}
}