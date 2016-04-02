package vn.softech.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.softech.dao.HinhAnhDao;
import vn.softech.domain.Pager;
import vn.softech.hibernate.TblHinhAnh;

@Controller
public class HinhAnhListController {
	int rowOfPage=10;
	private static Logger logger = Logger.getLogger(HinhAnhListController.class);
	
	@RequestMapping(value = "admin/hinhanh/list.html", method = RequestMethod.GET)
	public String showListHinhAnh(HttpServletRequest request, HttpServletResponse reponse) {
		logger.debug("showListHinhAnh called");
		return "admin/hinhanh/list";
	}
	
	@ModelAttribute(value="listHinhAnh")
	public List<TblHinhAnh> getListHinhAnh(@RequestParam(value="page", required=false) String reqPage, 
											@RequestParam(value="query", required=false) String query) {
		logger.info("getListHinhAnh called");
		logger.debug("page: " + reqPage);
		HinhAnhDao dao = new HinhAnhDao();
		int page = 1;
		if (reqPage != null) {
			try {
				page = Integer.parseInt(reqPage);
			} catch(Exception e) {
				logger.error("fail page", e);
				e.printStackTrace();
			}
			
		}
		return dao.getByPage(rowOfPage, page);		
	}
	@ModelAttribute(value="pager")
	public Pager getPager(@RequestParam(value="page", required=false) String reqPage, @RequestParam(value="query", required=false) String query) {
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
		HinhAnhDao dao = new HinhAnhDao();
		if ((query != null) && (!"".equals(query))) {
			int results = 0;
			try {
				results = dao.countSearch(query).intValue();
			} catch(Exception e) {
				e.printStackTrace();
			}
			int rowOfPage = 5;
			int totalPage = results / rowOfPage;
			if ((results % rowOfPage) > 0) {
				totalPage += 1;
			}
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
			int rowOfPage = 5;
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
}