package vn.softech.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import vn.softech.dao.TthcDmDao;
import vn.softech.dao.TthcDao;
import vn.softech.hibernate.TblTthcDm;
import vn.softech.hibernate.TblTthc;
import vn.softech.form.TthcDmForm;


@Controller
public class ThuTucHanhChinhListController {
	private static Logger logger = Logger.getLogger(ThuTucHanhChinhListController.class);	
	private static List<TblTthc> listThuTucHanhChinh = null;
	
	@RequestMapping(value = "admin/thutuchanhchinh/list.html", method = RequestMethod.GET)
	public String showListPage(HttpServletRequest request, HttpServletResponse reponse, Model model) {
		logger.debug("showListPage ThuTucHanhChinh called");
		TthcDmForm form= new TthcDmForm();
		model.addAttribute("danhmuc", form);
		return "admin/thutuchanhchinh/list";
	}
	
	@ModelAttribute(value="listThuTucHanhChinh")
	public List<TblTthc> getlistThuTucHanhChinh(HttpServletRequest request) {
		listThuTucHanhChinh = new ArrayList<TblTthc>();
		TthcDao dao = new TthcDao();
		logger.debug("listThuTucHanhChinh called");
		logger.debug("Danh Muc ID =  " + request.getParameter("tthcDmId"));
		if ((request.getParameter("tthcDmId") == null) || ("".equals(request.getParameter("tthcDmId")))) {
			listThuTucHanhChinh = dao.get();
		}
		else
		{
			Long tthcDmId = Long.parseLong(request.getParameter("tthcDmId"));
			logger.debug("listThuTucHanhChinh called by Danh Muc ID");
			listThuTucHanhChinh = dao.getByThuTucByChuyenMucId(tthcDmId);
		}
		return listThuTucHanhChinh;
	}
	
	@ModelAttribute(value="listDanhMuc")
	public List<TblTthcDm> getlistDanhMuc() {
		logger.debug("getlistDanhMuc called");
		List<TblTthcDm> listDanhMuc = new ArrayList<TblTthcDm>();
		TthcDmDao dao = new TthcDmDao();
		listDanhMuc = dao.get();
		return listDanhMuc;
	}
	
	@RequestMapping(value="admin/thutuchanhchinh/delete.html", method = RequestMethod.POST)
	public void processDeleteThuTucHanhChinh(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		StringBuffer ret = new StringBuffer();
		logger.debug("DeleteThuTucHanhChinh Called Id = : " + request.getParameter("tthcId"));
		if ((request.getParameter("tthcId") == null) || ("".equals(request.getParameter("tthcId")))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"tthcId là rỗng\"");
			response.getWriter().write("}");
		} else {
			TthcDao dao = new TthcDao();
			String error = dao.updateBatch((request.getParameter("tthcId")));
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
