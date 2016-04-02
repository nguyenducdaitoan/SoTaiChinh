package vn.softech.spring.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.softech.dao.ChuyenMucDao;
import vn.softech.dao.TinTucDao;
import vn.softech.domain.Pager;
import vn.softech.form.ChuyenMucForm;
import vn.softech.form.TinTucForm;
import vn.softech.hibernate.TblChuyenMuc;
import vn.softech.hibernate.TblTinTuc;

@Controller
public class TinTucListController {
	int rowOfPage=30;
	private static Logger logger = Logger.getLogger(TinTucListController.class);
	
	@RequestMapping(value = "admin/tintuc/list.html", method = RequestMethod.GET)
	public String showListTinTucs(HttpServletRequest request, HttpServletResponse reponse, Map model) {
		logger.debug("showListTinTucs called");
		ChuyenMucForm chuyeMucForm = new ChuyenMucForm();
		model.put("chuyenMucForm", chuyeMucForm);
		return "admin/tintuc/list";
	}
	
	@ModelAttribute(value="listTinTuc")
	public List<TblTinTuc> getListTinTuc(@RequestParam(value="page", required=false) String reqPage, 
											@RequestParam(value="query", required=false) String query,
											@RequestParam(value="chuyenmucid", required=false) String chuyenmucid,
											@RequestParam(value="approved", required=false) String approved,
											@RequestParam(value="tungay", required=false) String tungay,
											@RequestParam(value="denngay", required=false) String denngay
											) {
		logger.info("getListTinTuc called!");
		logger.debug("page: " + reqPage);
		TinTucDao dao = new TinTucDao();
		int page = 1;
		if (reqPage != null) {
			try {
				page = Integer.parseInt(reqPage);
			} catch(Exception e) {
				logger.error("fail page", e);
				e.printStackTrace();
			}		
		}
		
		if (query != null){
			try {
				Short chuyenmucId;
				Byte approvedId;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date tuNgay;
				Date denNgay;
				if (chuyenmucid.trim().equals("-1"))
					chuyenmucId = null;
				else
					chuyenmucId = Short.parseShort(chuyenmucid);
				
				if (approved.trim().equals("-1"))
					approvedId = null;
				else
					approvedId = Byte.parseByte(approved);
				
				if (tungay.trim().equals(""))
					tuNgay = null;
				else
					tuNgay = sdf.parse(tungay);
				
				if (denngay.trim().equals(""))
					denNgay = null;
				else
					denNgay = sdf.parse(denngay);
				
				List<TblTinTuc> listtintuc = dao.getByPage(rowOfPage, 1, chuyenmucId, approvedId, null, null, query);
				logger.debug("Query call : " + query);
				logger.debug("Chuyen muc " + chuyenmucId);
				logger.debug("Trang thai Phe Duyet : " + approvedId);
				logger.debug("Tu ngay : " + tuNgay);
				logger.debug("Den Ngay : " + denNgay);
				for (TblTinTuc tintuc : listtintuc) {
					logger.debug("Title : " + tintuc.getTitle());
				}
				return listtintuc;
			} catch (Exception e) {
				logger.error("fail page", e);
				e.printStackTrace();
			}
		}
		return dao.getByPage(rowOfPage, page);	
	}
	
	@ModelAttribute(value="listDanhMuc")
	public List<TblChuyenMuc> getListDanhMuc() {
		logger.debug("getListDanhMuc called");
		List<TblChuyenMuc> listDanhMuc = new ArrayList<TblChuyenMuc>();
		ChuyenMucDao dao = new ChuyenMucDao();
		listDanhMuc = dao.get();
		return listDanhMuc;
	}
	
	@ModelAttribute(value="pager")
	public Pager getPager(@RequestParam(value="page", required=false) String reqPage,
							@RequestParam(value="query", required=false) String query,
							@RequestParam(value="chuyenmucid", required=false) String chuyenmucid,
							@RequestParam(value="approved", required=false) String approved,
							@RequestParam(value="tungay", required=false) String tungay,
							@RequestParam(value="denngay", required=false) String denngay) {
		logger.info("getPaper called");
		logger.debug("page: " + reqPage);
		logger.debug("query: " + query);
		Pager pager = new Pager();
		if (reqPage != null) {
			try {
				pager.setPage(Integer.parseInt(reqPage));
			} catch(Exception e) {
				logger.error("fail page", e);
				e.printStackTrace();
				pager.setPage(1);
			}
		} else {
			pager.setPage(1);
		}
		TinTucDao dao = new TinTucDao();
		if ((query != null) && (!"".equals(query))) {
			int results = 0;
			try {
				Short chuyenmucId;
				Byte approvedId;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date tuNgay;
				Date denNgay;
				if (chuyenmucid.trim().equals("-1"))
					chuyenmucId = null;
				else
					chuyenmucId = Short.parseShort(chuyenmucid);
				
				if (approved.trim().equals("-1"))
					approvedId = null;
				else
					approvedId = Byte.parseByte(approved);
				
				if (tungay.trim().equals(""))
					tuNgay = null;
				else
					tuNgay = sdf.parse(tungay);
				
				if (denngay.trim().equals(""))
					denNgay = null;
				else
					denNgay = sdf.parse(denngay);
				//results = dao.countSearch(query).intValue();
				results = dao.countByPage(chuyenmucId,approvedId,tuNgay,denNgay,query);
				logger.debug("results : " + results);
			} catch(Exception e) {
				e.printStackTrace();
			}
			int totalPage = results / rowOfPage;
			if ((results % rowOfPage) > 0) {
				totalPage += 1;
			}
			logger.debug("totalPage : " + totalPage);
			pager.setTotalPage(totalPage);
			pager.setRowOfPage(rowOfPage);
			pager.setResults(results);
			pager.setSortOrder("ASC");
			pager.setSortColumn("name");
			return pager;
		} else {			
			int results = 0;
			try {
				results = dao.countAll().intValue();
			} catch(Exception e) {
				e.printStackTrace();
			}
			int totalPage = results / rowOfPage;
			if ((results % rowOfPage) > 0) {
				totalPage += 1;
			}
			pager.setTotalPage(totalPage);
			pager.setRowOfPage(rowOfPage);
			pager.setResults(results);
			pager.setSortOrder("ASC");
			pager.setSortColumn("title");
			return pager;
		}
	}
	
	@RequestMapping(value="admin/tintuc/delete.html", method = RequestMethod.POST)
	public void processDeleteTinTuc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		StringBuffer ret = new StringBuffer();
		logger.debug("DeleteTinTuc Called Id = : " + request.getParameter("tinTucId"));
		if ((request.getParameter("tinTucId") == null) || ("".equals(request.getParameter("tinTucId")))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"tinTucId là rỗng\"");
			response.getWriter().write("}");
		} else {
			TinTucDao dao = new TinTucDao();
			String error = dao.updateBatch((request.getParameter("tinTucId")));
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
	@RequestMapping(value="admin/tintuc/unapproved.html")
	public void processUnApprovedTinTuc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		StringBuffer ret = new StringBuffer();
		logger.debug("UnApprovedTinTuc Called Id = : " + request.getParameter("tinTucId"));
		if ((request.getParameter("tinTucId") == null) || ("".equals(request.getParameter("tinTucId")))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"tinTucId là rỗng\"");
			response.getWriter().write("}");
		} else {
			TinTucDao dao = new TinTucDao();
			String error = dao.updateUnApprovedBatch((request.getParameter("tinTucId")));
			if ((error == null) || ("".equals(error))) {   
				response.getWriter().write("{");
				response.getWriter().write("\"Hủy phê duyệt thành công\"");
				response.getWriter().write("}");
			} else {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"" + error + "\"");
				response.getWriter().write("}");
			}
		}
	}
	@RequestMapping(value="admin/tintuc/approved.html")
	public void processApprovedTinTuc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		StringBuffer ret = new StringBuffer();
		logger.debug("ApprovedTinTuc Called Id = : " + request.getParameter("tinTucId"));
		if ((request.getParameter("tinTucId") == null) || ("".equals(request.getParameter("tinTucId")))) {
			response.getWriter().write("{");
			response.getWriter().write("\"error\":\"tinTucId là rỗng\"");
			response.getWriter().write("}");
		} else {
			TinTucDao dao = new TinTucDao();
			String error = dao.updateApprovedBatch((request.getParameter("tinTucId")));
			if ((error == null) || ("".equals(error))) {   
				response.getWriter().write("{");
				response.getWriter().write("\"Phê duyệt thành công\":\"\"");
				response.getWriter().write("}");
			} else {
				response.getWriter().write("{");
				response.getWriter().write("\"error\":\"" + error + "\"");
				response.getWriter().write("}");
			}
		}
	}
}
