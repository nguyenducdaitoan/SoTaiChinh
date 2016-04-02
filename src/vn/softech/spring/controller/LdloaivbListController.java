package vn.softech.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdLoaiVbDao;
import vn.softech.hibernate.TblLdLinhVuc;
import vn.softech.hibernate.TblLdLoaiVb;

@Controller
public class LdloaivbListController {
	LdLoaiVbDao ldloaivbdao= new LdLoaiVbDao();
	List<TblLdLoaiVb> listldloaivb;
	private static Logger log = Logger.getLogger(LdloaivbListController.class);
	
	@RequestMapping (value= "/admin/ldloaivb/list")
	public String showLdloaivbList(Model model) {
		log.info("showLdloaivbList called.");
		listldloaivb= ldloaivbdao.get();
		model.addAttribute("listldloaivb", listldloaivb);
		return "admin/ldloaivb/ldloaivblist";
	}

}
