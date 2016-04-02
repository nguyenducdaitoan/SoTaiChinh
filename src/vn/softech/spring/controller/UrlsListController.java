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
import vn.softech.hibernate.TblUrls;
import vn.softech.hibernate.TblUsers;

@Controller
public class UrlsListController {
	private static Logger logger = Logger.getLogger(UrlsListController.class);
	
	/**
	 * Hiển thị danh sách urls
	 * @author vulh
	 * Created: 2012-11-01 
	 * */
	@RequestMapping(value = "admin/urls/list.html", method = RequestMethod.GET)
	public String showListPage(HttpServletRequest request, HttpServletResponse reponse) {
		logger.debug("showLeftAdminPage called");
		return "admin/urls/list";
	}
	
	@ModelAttribute(value="listUrls")
	public List<TblUrls> getListUrls(HttpServletRequest request) {
		List<TblUrls> listUrls = new ArrayList<TblUrls>();
		AdminSystemDao dao = new AdminSystemDao();
		List<TblUrls> listUrlsParent = dao.getUrlsParent();
		if ((listUrlsParent != null) && (listUrlsParent.size() > 0)) {
			for (TblUrls urls: listUrlsParent) {
				listUrls.add(urls);
				List<TblUrls> listUrlsTemp = getListUrlsChild(urls.getUrlsId());
				if ((listUrlsTemp != null) && (listUrlsTemp.size() > 0)) {
					listUrls.addAll(listUrlsTemp);
				}
			}
		}
		return listUrls;
	}
	
	private List<TblUrls> getListUrlsChild(Long parentId) {
		List<TblUrls> listUrlsChild = new ArrayList<TblUrls>();
		AdminSystemDao dao = new AdminSystemDao();
		List<TblUrls> listUrls = dao.getUrlsChild(parentId);
		if ((listUrls != null) && (listUrls.size() > 0)) {
			for (TblUrls urls: listUrls) {
				listUrlsChild.add(urls);
				List<TblUrls> listUrlsTemp = getListUrlsChild(urls.getUrlsId());
				if ((listUrlsTemp != null) && (listUrlsTemp.size() > 0)) {
					listUrlsChild.addAll(listUrlsTemp);
				}
			}
		}
		return listUrlsChild;
	}
	
	@RequestMapping(value="admin/urls/moveup.html", method = RequestMethod.POST)
	public void processMoveUpUrls(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		logger.debug("urlsId: " + request.getParameter("urlsId"));
		logger.debug("beforeUrlsId: " + request.getParameter("beforeUrlsId"));
		if ((request.getParameter("urlsId") == null) || 
				("".equals(request.getParameter("urlsId"))) || 
				(request.getParameter("beforeUrlsId") == null) || 
				("".equals(request.getParameter("beforeUrlsId")))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"Lỗi phát sinh trong quá trình truyền tham số xử lý\"");
			response.getWriter().write("}");
		} else {
			Long urlsId = null;
			Long beforeUrlsId = null;
			try {
				urlsId = Long.parseLong(request.getParameter("urlsId"));
				beforeUrlsId = Long.parseLong(request.getParameter("beforeUrlsId"));
			} catch(Exception e) {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"" + e.getMessage() + "\"");
				response.getWriter().write("}");
				return;
			}
			
			AdminSystemDao dao = new AdminSystemDao();
			TblUrls urls = dao.getUrls(urlsId);
			if (urls == null) {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"urlsId = [" + urlsId + "] là không tồn tại\"");
				response.getWriter().write("}");
				return;
			}
			TblUrls beforeUrls = dao.getUrls(beforeUrlsId);
			if (beforeUrls == null) {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"beforeUrlsId = [" + beforeUrlsId + "] là không tồn tại\"");
				response.getWriter().write("}");
				return;
			}
			Byte urlsPriority = beforeUrls.getPriority();
			beforeUrls.setPriority(urls.getPriority());
			urls.setPriority(urlsPriority);
			try {
				dao.update(urls);
				dao.update(beforeUrls);
			} catch(Exception e) {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"" + e.getMessage() + "\"");
				response.getWriter().write("}");
				return;
			}
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"\"");
			response.getWriter().write("}");
		}
	}
	@RequestMapping(value="admin/urls/movedown.html", method = RequestMethod.POST)
	public void processMoveDownUrls(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		logger.debug("urlsId: " + request.getParameter("urlsId"));
//		logger.debug("beforeUrlsId: " + request.getParameter("beforeUrlsId"));
		if ((request.getParameter("urlsId") == null) || ("".equals(request.getParameter("urlsId")))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"Lỗi phát sinh trong quá trình truyền tham số xử lý\"");
			response.getWriter().write("}");
		} else {
			Long urlsId = null;
			try {
				urlsId = Long.parseLong(request.getParameter("urlsId"));
			} catch(Exception e) {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"" + e.getMessage() + "\"");
				response.getWriter().write("}");
				return;
			}
			
			AdminSystemDao dao = new AdminSystemDao();
			TblUrls urls = dao.getUrls(urlsId);
			if (urls == null) {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"urlsId = [" + urlsId + "] là không tồn tại\"");
				response.getWriter().write("}");
				return;
			}
			TblUrls afterUrls = dao.getUrlsAfter(urls.getParentId(), urls.getPriority());
			if (afterUrls == null) {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"Không thể di chuyển xuống\"");
				response.getWriter().write("}");
				return;
			}
			Byte urlsPriority = afterUrls.getPriority();
			afterUrls.setPriority(urls.getPriority());
			urls.setPriority(urlsPriority);
			try {
				dao.update(urls);
				dao.update(afterUrls);
			} catch(Exception e) {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"" + e.getMessage() + "\"");
				response.getWriter().write("}");
				return;
			}
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"\"");
			response.getWriter().write("}");
		}
	}
}
