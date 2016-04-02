package vn.softech.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.softech.dao.AdminSystemDao;
import vn.softech.dao.UsersDao;
import vn.softech.hibernate.TblUrls;
import vn.softech.hibernate.TblUsers;

@Controller
public class LeftAdminPageController {
	private static Logger logger = Logger.getLogger(LeftAdminPageController.class);
	
	@RequestMapping(value = "admin/left.html", method = RequestMethod.GET)
	public String showLeftAdminPage(HttpServletRequest request, HttpServletResponse reponse) {
		logger.debug("showLeftAdminPage called");
		return "admin/left";
	}
	
	@ModelAttribute(value="listUrls")
	public List<TblUrls> getListUrls(HttpServletRequest request) {
		List<TblUrls> listUrls = new ArrayList<TblUrls>();
		HttpSession session = request.getSession(false);
		Long usersId = (Long)session.getAttribute("UsersId");
		if ((usersId != null) && (usersId.longValue() > 0)) {
			UsersDao usersDao = new UsersDao();
			TblUsers usersLogin = usersDao.get(usersId);
			if (usersLogin != null) {
				AdminSystemDao dao = new AdminSystemDao();
				listUrls = dao.getUrlsByUsersId(usersId);				
			}
		}
		return listUrls;
	}
}
