package vn.softech.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.softech.dao.AdminSystemDao;
import vn.softech.form.LoginForm;
import vn.softech.util.StringUtils;
 
@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value = "admin/login.html", method = RequestMethod.GET)
	public String showForm(Map model, HttpServletRequest request) {
		logger.debug("showForm called");
		HttpSession session = request.getSession(false);
		Boolean isLogin = Boolean.FALSE;
		if ((session != null) && (session.getAttribute("isLogin") != null)) {
			isLogin = (Boolean)session.getAttribute("isLogin");
		}
		if (isLogin) {
			return "redirect:index.html";
		}
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginForm";
	}

	@RequestMapping(value = "admin/login.html", method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,	Map model, HttpServletRequest request) {
		logger.debug("processForm called");
		String userName = "UserName";
		String password = "password";
		if (result.hasErrors()) {
			return "loginForm";
		}
		loginForm = (LoginForm) model.get("loginForm");
		logger.debug("Username: " + loginForm.getUserName());
		logger.debug("Password: " + loginForm.getPassword());
		AdminSystemDao dao = new AdminSystemDao();
		boolean exist = dao.existUsers(loginForm.getUserName());
		logger.debug("[" + loginForm.getUserName() + "] exist = " + exist);
		if (!exist) {
			result.rejectValue("userName", "message.error.loginForm.userName.notexist");
			return "loginForm";
		}
		String passwordMd5 = StringUtils.md5HexByPasswordMd5(loginForm.getPasswordMd5());
		logger.debug("passwordMd5: " + passwordMd5);
		vn.softech.hibernate.TblUsers users = dao.login(loginForm.getUserName(), passwordMd5);
		if (users != null) {
			HttpSession session = request.getSession(false);
			session.setAttribute("isLogin", Boolean.TRUE);
			session.setAttribute("UsersId", users.getUsersId());
			session.setAttribute("Username", users.getUsername());
			session.setAttribute("Password", users.getPassword());
			session.setAttribute("FirstName", users.getFirstName());
			session.setAttribute("LastName", users.getLastName());
			session.setAttribute("Email", users.getEmail());
			session.setAttribute("cntLogin", null);
//			model.put("loginForm", loginForm);
			model.clear();
			return "redirect:index.html";
		} else {
			result.rejectValue("userName", "message.error.loginForm.password.notcorrect");
			return "loginForm";
		}
	}
	@RequestMapping(value = "admin/logout.html", method = RequestMethod.GET)
	public String logoutProcess(Map model, HttpServletRequest request) {
		logger.debug("logout called");
		LoginForm loginForm = new LoginForm();
		HttpSession session = request.getSession(false);
		session.setAttribute("isLogin", Boolean.FALSE);
		session.removeAttribute("UsersId");
		session.removeAttribute("Username");
		session.removeAttribute("Password");
		session.removeAttribute("FirstName");
		session.removeAttribute("LastName");
		session.removeAttribute("Email");
		session.removeAttribute("cntLogin");
		model.put("loginForm", loginForm);
		return "loginForm";
	}
}