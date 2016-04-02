package vn.softech.spring.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vn.softech.dao.PublicDichVuCongDao;
import vn.softech.dao.ThongBaoDao;
import vn.softech.form.DVCXdcbForm;
import vn.softech.hibernate.TblCongDan;
import vn.softech.hibernate.TblDocument;
import vn.softech.hibernate.TblThongBao;
import vn.softech.hibernate.TblToChuc;
import vn.softech.hibernate.TblTtcgcndkmsxdcb;
import vn.softech.hibernate.TblTtcgcndkmsxdcbDinhKem;
import vn.softech.util.MailServiceUtil;
import vn.softech.util.StringUtils;

@Controller
public class PublicDvcXdcbController {
	private static Logger log = Logger.getLogger(PublicDvcXdcbController.class);	
	ThongBaoDao thongbaoDao = new ThongBaoDao();
	int rowOfPage = 20;
	int page = 1;
	long totalRecordByCm = 0;
	long totalPage = 1; 

	@RequestMapping(value = "/dvc/list.html")
		public String listDVC(Model model) throws Exception {
			log.info("listDVC called.");
			List<TblThongBao> listThongBao = thongbaoDao.getByPage(10,1);
			log.debug("listThongBao.sze() :" + listThongBao.size());
			model.addAttribute("listRecentThongBao",listThongBao);
			return "dvc/list";
		}
		
	@RequestMapping(value = "/dvc/xdcb.html")
	public String dvcXDCB(@ModelAttribute("xdcb") DVCXdcbForm xdcbForm , HttpServletRequest request ) throws IOException {
		return "dvc/xdcb";
	}
	@RequestMapping(value = "/dvc/actionxdcb.html")
	public String dvcActionXDCB(@ModelAttribute("xdcb") DVCXdcbForm xdcbForm, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.info("dvcXDCB called.");
		log.debug("===============Info Submit=============");
		log.debug("- HoTen : " + xdcbForm.getHoTen());
		log.debug("- CMND  : " + xdcbForm.getSoCmnd());
		log.debug("- Noi cap : " + xdcbForm.getNoiCapCmnd());
		log.debug("- Ngay cap : " + xdcbForm.getNgayCapCmnd());
		log.debug("- Dia chi : " + xdcbForm.getDiaChiCaNhan());
		log.debug("- Dien Thoai : " + xdcbForm.getDienThoaiCaNhan());
		log.debug("- Email : " + xdcbForm.getEmailCaNhan());
		log.debug("===============End Info Submit=============");
		log.info("dvcXDCB called.");
		PublicDichVuCongDao dao = new PublicDichVuCongDao();
		TblTtcgcndkmsxdcb xdcb = new TblTtcgcndkmsxdcb();
		Date now = new Date();
		ServletContext servletContext = request.getSession().getServletContext();
		String path= servletContext.getRealPath("/null/");
		log.debug("PATH: "+path);
		HttpSession session = request.getSession(false);
		Long congDanId = (Long)session.getAttribute("congDanId");
		//default
		congDanId = (long)81;
		if ((congDanId != null) && (congDanId.longValue() <= 0)) {
			return "dvc/xdcb.html";
		}
		//Thong tin cong dan dang ky
		TblCongDan congDan = dao.getDVCCongDan(congDanId);
		// To Chuc
		TblToChuc toChuc = new TblToChuc();
		toChuc.setTenCoQuan(xdcbForm.getTenCoQuan());
		toChuc.setDiaChi(xdcbForm.getDiaChi());
		toChuc.setEmail(xdcbForm.getEmail());
		toChuc.setSoDienThoai(xdcbForm.getSoDienThoai());
		toChuc.setSoFax(xdcbForm.getSoFax());
		toChuc.setCreated(now);
		toChuc.setModified(now);
		toChuc.setStatus((byte)1);
		Long toChucId = dao.save(toChuc);
		log.debug("toChucId: " + toChucId);
		if ((toChucId != null) && (toChucId.longValue() > 0)) {
			xdcb.setTblCongDan(congDan);
			//Thong tin to chuc
			toChuc = dao.getDVCToChu(toChucId);
			xdcb.setTblToChuc(toChuc);
			
			//Thong tin xay dung co ban
			String soBienNhan = "DKCSLD-" + System.currentTimeMillis();
			xdcb.setSoBienNhan(soBienNhan);
			xdcb.setTrangThai((byte)1);
			xdcb.setNgayThuLy(null);
			xdcb.setNgayXuLy(null);
			xdcb.setNgayHoanThanh(null);
			xdcb.setCreated(now);
			xdcb.setModified(now);
			xdcb.setStatus((byte)1);
			xdcb.setLanSua((byte)0);
			
			xdcb.setCodeTraCuu(StringUtils.randomPassword());
			Long xdcbId = dao.save(xdcb);
			log.debug("xdcbId: " + xdcbId);
			if ((xdcbId != null) && (xdcbId.longValue() > 0)) {
				// save document and file attach
				List<CommonsMultipartFile> listFormFile = xdcbForm.getFiles();
				if ((listFormFile != null) && (listFormFile.size()>0)) {
					log.debug("listFormFile = " + listFormFile.size());
					for (int i = 0; i < listFormFile.size(); i++) {
						MultipartFile ff = (MultipartFile) listFormFile.get(i);		
						if ((ff != null) && (ff.getName().length() > 0) && (ff.getSize() > 0)) {							
							TblDocument document = new TblDocument();
							//Lấy thông tin luu vao document
							document.setName(ff.getOriginalFilename());
							//Upload File
							byte[] bytes= ff.getBytes();
							File newFile=null;
							if ((bytes != null) && (bytes.length > 0)) {
					            try {	            	
					                newFile = new File(path+"\\"+ff.getOriginalFilename());
					                FileOutputStream fileOutputStream = new FileOutputStream(newFile);                         
					                fileOutputStream.write(bytes, 0, bytes.length);                   
					                fileOutputStream.close();
					            }
					            catch (FileNotFoundException e) {
					                log.error("File Not Found.");                            
					            }
					            catch (IOException e1){
					            	log.error("Error Reading The File.");               
					            }
					        }
							document.setData(ff.getBytes());
							document.setCreated(now);
							document.setStatus((byte)1);
							Long documentId = dao.save(document);
							log.debug("documentId: " + documentId);
							if ((documentId != null) && (documentId.longValue() > 0)) {
								//lay thông tin luu vao van ban dinh ken
								TblTtcgcndkmsxdcbDinhKem xdcbDinhKem = new TblTtcgcndkmsxdcbDinhKem();
								document = dao.getDVCDocument(documentId);
								xdcbDinhKem.setTblDocument(document);
								xdcb = dao.getDVCXDCB(xdcbId);
								xdcbDinhKem.setTblTtcgcndkmsxdcb(xdcb);
								xdcbDinhKem.setTenHoSo(xdcbForm.getTenHoSo().get(i));
								
								//Nguoi dinh kem
//								long usersId = 0;
//								UsersDao userDao = new UsersDao();
//								TblUsers tblUsers = userDao.get(usersId);
								xdcbDinhKem.setTblUsers(null);
								xdcbDinhKem.setCreated(now);
								xdcbDinhKem.setModified(now);
								xdcbDinhKem.setStatus((byte)1);
								Long xdcbDinhKemId = dao.save(xdcbDinhKem);
								log.debug("xdcbDinhKemId: " + xdcbDinhKemId);
								if ((xdcbDinhKemId != null) && (xdcbDinhKemId.longValue() > 0)) {
									log.debug("save xdcbDinhKem is okie " + xdcbDinhKemId);
								} else{
									log.debug("save xdcbDinhKem  flase" + xdcbDinhKemId);
								}
							
							}
						}
					} //end for
					model.addAttribute("soBienNhan",soBienNhan);
					model.addAttribute("tenDvc","Đăng ký dịch vụ công xây dựng cơ bản thành công");
//					MailServiceUtil mail = new MailServiceUtil();
//					mail.messageSoBienNhan(xdcbId, "TTCGCNDKMSXDCB");
//					mail.start();
					return "dvc/thanks";
				} else {
					log.debug("Save fail");
					return "dvc/xdcb";
				}
			}
		} else {
			log.debug("Save fail");
		}
		return "dvc/xdcb";
	}
	@RequestMapping(value = "/dvc/thanks.html")
	public String thanksDVC(Model model) {
		log.info("thanksDVC called.");
		return "dvc/thanks";
	}	
		//----------------------------------------------------------------------------------------
		@ExceptionHandler({ Exception.class })
		 public String handleException(Exception e, HttpServletRequest request) {
		  log.error(e.getMessage(), e);
		  request.setAttribute("errorMessage", e.getMessage());
		  return "error";
		 }
}
