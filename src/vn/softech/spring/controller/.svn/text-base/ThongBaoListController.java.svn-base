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

import vn.softech.dao.ThongBaoDao;
import vn.softech.domain.Pager;
import vn.softech.hibernate.TblThongBao;

@Controller
public class ThongBaoListController {
	int rowOfPage=10;
	private static Logger logger = Logger.getLogger(ThongBaoListController.class);
	
	@RequestMapping(value = "admin/thongbao/list.html", method = RequestMethod.GET)
	public String showListThongBao(HttpServletRequest request, HttpServletResponse reponse) {
		logger.debug("showListThongBao called");
		return "admin/thongbao/list";
	}
	
	@ModelAttribute(value="listThongBao")
	public List<TblThongBao> getListThongBao(@RequestParam(value="page", required=false) String reqPage, 
											@RequestParam(value="query", required=false) String query) {
		logger.info("getListThongBao called");
		logger.debug("page: " + reqPage);
		ThongBaoDao dao = new ThongBaoDao();
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
		ThongBaoDao dao = new ThongBaoDao();
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