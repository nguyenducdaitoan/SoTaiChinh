package vn.softech.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.softech.dao.LdLinhVucDao;
import vn.softech.hibernate.TblLdLinhVuc;

@Controller
public class VbHanhChinhLinhvucListController {
	LdLinhVucDao ldlinhvucdao= new LdLinhVucDao();
	List<TblLdLinhVuc> listldlinhvuc;
	private static Logger log = Logger.getLogger(VbHanhChinhLinhvucListController.class);
	
	@RequestMapping (value= "/admin/vbhanhchinhlinhvuc/list")
	public String showLdlinhvucList(Model model) {
		log.info("showLdlinhvucList called.");
		listldlinhvuc= ldlinhvucdao.getByType((byte)2);
		model.addAttribute("listldlinhvuc", listldlinhvuc);
		return "admin/vbhanhchinhlinhvuc/vbhanhchinhlinhvuclist";
	}

}
