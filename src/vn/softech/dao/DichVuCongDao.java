package vn.softech.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.Sumproduct;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.bean.DichVuCongBean;
import vn.softech.hibernate.HibernateSessionFactory;
import vn.softech.hibernate.TblCongDan;
import vn.softech.hibernate.TblDocument;
import vn.softech.hibernate.TblToChuc;
import vn.softech.hibernate.TblTtcgcndkmsxdcb;
import vn.softech.hibernate.TblTtcgcndkmsxdcbButPhe;
import vn.softech.hibernate.TblTtcgcndkmsxdcbChuyenhs;
import vn.softech.hibernate.TblTtcgcndkmsxdcbDinhKem;
import vn.softech.hibernate.TblTtcmsdvsdns;
import vn.softech.hibernate.TblTtcmsdvsdnsButPhe;
import vn.softech.hibernate.TblTtcmsdvsdnsChuyenhs;
import vn.softech.hibernate.TblTtcmsdvsdnsDinhKem;
import vn.softech.hibernate.TblTtpapbdtns;
import vn.softech.hibernate.TblTtpapbdtnsButPhe;
import vn.softech.hibernate.TblTtpapbdtnsChuyenhs;
import vn.softech.hibernate.TblTtpapbdtnsDinhKem;
import vn.softech.hibernate.TblTtpdgmsts;
import vn.softech.hibernate.TblTtpdgmstsButPhe;
import vn.softech.hibernate.TblTtpdgmstsChuyenhs;
import vn.softech.hibernate.TblTtpdgmstsDinhKem;
import vn.softech.util.DichVuCongComparator;


public class DichVuCongDao {
	private static Logger log = Logger.getLogger(DichVuCongDao.class);
	
	public List<TblTtcgcndkmsxdcb> get() {
		log.debug("Call get List<TblTtcgcndkmsxdcb>");
		List<TblTtcgcndkmsxdcb> list = new ArrayList<TblTtcgcndkmsxdcb>();		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcgcndkmsxdcb.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblTtcgcndkmsxdcb> failed", re);
		}
		return list;
	}
	
	public List<DichVuCongBean> getTiepNhan(String loaidvc, Byte trangThai, Date from, Date to, String query, String radioDate) {
		log.debug("Call getTiepNhan List<DichVuCongBean>");
		List<DichVuCongBean> list = new ArrayList<DichVuCongBean>();
		log.debug("loaidvc: " + loaidvc);
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + query);
		log.debug("radioDate: " + radioDate);
		try {
			if ((loaidvc == null) || ("TTCGCNDKMSXDCB".equals(loaidvc))) {
				List<TblTtcgcndkmsxdcb> listTtcgcndkmsxdcb = getTtcgcndkmsxdcbTiepNhan(trangThai, from, to, query, radioDate);
				for (TblTtcgcndkmsxdcb object: listTtcgcndkmsxdcb) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTCGCNDKMSXDCB");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtcgcndkmsxdcbId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getTenDuAn());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTCMSDVSDNS".equals(loaidvc))) {
				List<TblTtcmsdvsdns> listTtcmsdvsdns = getTtcmsdvsdnsTiepNhan(trangThai, from, to, query, radioDate);
				for (TblTtcmsdvsdns object: listTtcmsdvsdns) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTCMSDVSDNS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtcmsdvsdnsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getNoiDung());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTPAPBDTNS".equals(loaidvc))) {
				List<TblTtpapbdtns> listTtpapbdtns = getTtpapbdtnsTiepNhan(trangThai, from, to, query, radioDate);
				for (TblTtpapbdtns object: listTtpapbdtns) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTPAPBDTNS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtpapbdtnsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getNoiDung());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTPDGMSTS".equals(loaidvc))) {
				List<TblTtpdgmsts> listTtpdgmsts = getTtpdgmstsTiepNhan(trangThai, from, to, query, radioDate);
				for (TblTtpdgmsts object: listTtpdgmsts) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTPDGMSTS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtpdgmstsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getNoiDung());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
		} catch (RuntimeException re) {
			list = new ArrayList<DichVuCongBean>();
			log.error("getTiepNhan List<DichVuCongBean> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}

	public List<DichVuCongBean> getTiepNhanHoanThanh(String loaidvc, Date from, Date to) {
		log.debug("Call getTiepNhan List<DichVuCongBean>");
		List<DichVuCongBean> list = new ArrayList<DichVuCongBean>();
		log.debug("loaidvc: " + loaidvc);
		log.debug("from: " + from);
		log.debug("to: " + to);
		try {
			List<Byte> trangThais = new ArrayList<Byte>();
			trangThais.add((byte)3);
			trangThais.add((byte)4);
			if ((loaidvc == null) || ("TTCGCNDKMSXDCB".equals(loaidvc))) {
				List<TblTtcgcndkmsxdcb> listTtcgcndkmsxdcb = getTtcgcndkmsxdcbWithTrangThais(from, to, trangThais);
				for (TblTtcgcndkmsxdcb object: listTtcgcndkmsxdcb) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTCGCNDKMSXDCB");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtcgcndkmsxdcbId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTCMSDVSDNS".equals(loaidvc))) {
				List<TblTtcmsdvsdns> listTtcmsdvsdns = getTtcmsdvsdnsWithTrangThais(from, to, trangThais);
				for (TblTtcmsdvsdns object: listTtcmsdvsdns) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTCMSDVSDNS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtcmsdvsdnsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTPAPBDTNS".equals(loaidvc))) {
				List<TblTtpapbdtns> listTtpapbdtns = getTtpapbdtnsWithTrangThais(from, to, trangThais);
				for (TblTtpapbdtns object: listTtpapbdtns) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTPAPBDTNS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtpapbdtnsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTPDGMSTS".equals(loaidvc))) {
				List<TblTtpdgmsts> listTtpdgmsts = getTtpdgmstsWithTrangThais(from, to, trangThais);
				for (TblTtpdgmsts object: listTtpdgmsts) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTPDGMSTS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtpdgmstsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					list.add(dvcBean);
				}
			}
		} catch (RuntimeException re) {
			list = new ArrayList<DichVuCongBean>();
			log.error("getTiepNhan List<DichVuCongBean> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}

	
	public List<DichVuCongBean> getXuLy(Long userXuLyId, String loaidvc, Byte trangThai, Date from, Date to, String query) {
		log.debug("Call getXuLy List<DichVuCongBean>");
		List<DichVuCongBean> list = new ArrayList<DichVuCongBean>();
		log.debug("userXuLyId: " + userXuLyId);
		log.debug("loaidvc: " + loaidvc);
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + query);
		try {
			if ((loaidvc == null) || ("TTCGCNDKMSXDCB".equals(loaidvc))) {
				List<TblTtcgcndkmsxdcb> listTtcgcndkmsxdcb = getTtcgcndkmsxdcbXuLy(userXuLyId, trangThai, from, to, query);
				for (TblTtcgcndkmsxdcb object: listTtcgcndkmsxdcb) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTCGCNDKMSXDCB");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtcgcndkmsxdcbId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getTenDuAn());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTCMSDVSDNS".equals(loaidvc))) {
				List<TblTtcmsdvsdns> listTtcmsdvsdns = getTtcmsdvsdnsXuLy(userXuLyId, trangThai, from, to, query);
				for (TblTtcmsdvsdns object: listTtcmsdvsdns) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTCMSDVSDNS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtcmsdvsdnsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getNoiDung());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTPAPBDTNS".equals(loaidvc))) {
				List<TblTtpapbdtns> listTtpapbdtns = getTtpapbdtnsXuLy(userXuLyId, trangThai, from, to, query);
				for (TblTtpapbdtns object: listTtpapbdtns) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTPAPBDTNS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtpapbdtnsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getNoiDung());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTPDGMSTS".equals(loaidvc))) {
				List<TblTtpdgmsts> listTtpdgmsts = getTtpdgmstsXuLy(userXuLyId, trangThai, from, to, query);
				for (TblTtpdgmsts object: listTtpdgmsts) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTPDGMSTS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtpdgmstsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getNoiDung());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
		} catch (RuntimeException re) {
			list = new ArrayList<DichVuCongBean>();
			log.error("getXuLy List<DichVuCongBean> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	public List<DichVuCongBean> getXuLy(Long userXuLyId, String loaidvc, Byte trangThai, Date from, Date to, String query, String radioDate) {
		log.debug("Call getXuLy List<DichVuCongBean>");
		List<DichVuCongBean> list = new ArrayList<DichVuCongBean>();
		log.debug("userXuLyId: " + userXuLyId);
		log.debug("loaidvc: " + loaidvc);
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + query);
		log.debug("radioDate: " + radioDate);
		try {
			if ((loaidvc == null) || ("TTCGCNDKMSXDCB".equals(loaidvc))) {
				List<TblTtcgcndkmsxdcb> listTtcgcndkmsxdcb = getTtcgcndkmsxdcbXuLy(userXuLyId, trangThai, from, to, query, radioDate);
				for (TblTtcgcndkmsxdcb object: listTtcgcndkmsxdcb) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTCGCNDKMSXDCB");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtcgcndkmsxdcbId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getTenDuAn());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTCMSDVSDNS".equals(loaidvc))) {
				List<TblTtcmsdvsdns> listTtcmsdvsdns = getTtcmsdvsdnsXuLy(userXuLyId, trangThai, from, to, query, radioDate);
				for (TblTtcmsdvsdns object: listTtcmsdvsdns) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTCMSDVSDNS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtcmsdvsdnsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getNoiDung());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTPAPBDTNS".equals(loaidvc))) {
				List<TblTtpapbdtns> listTtpapbdtns = getTtpapbdtnsXuLy(userXuLyId, trangThai, from, to, query, radioDate);
				for (TblTtpapbdtns object: listTtpapbdtns) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTPAPBDTNS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtpapbdtnsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getNoiDung());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTPDGMSTS".equals(loaidvc))) {
				List<TblTtpdgmsts> listTtpdgmsts = getTtpdgmstsXuLy(userXuLyId, trangThai, from, to, query, radioDate);
				for (TblTtpdgmsts object: listTtpdgmsts) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTPDGMSTS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtpdgmstsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getNoiDung());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
		} catch (RuntimeException re) {
			list = new ArrayList<DichVuCongBean>();
			log.error("getXuLy List<DichVuCongBean> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	public List<TblTtcgcndkmsxdcb> getTtcgcndkmsxdcbTiepNhan(Byte trangThai, Date from, Date to, String query, String radioDate) {
		log.debug("Call getTtcgcndkmsxdcbTiepNhan List<TblTtcgcndkmsxdcb>");
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + query);
		log.debug("trangThai: " + trangThai);
		log.debug("radioDate: " + radioDate);
		List<TblTtcgcndkmsxdcb> list = new ArrayList<TblTtcgcndkmsxdcb>();		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcgcndkmsxdcb.class).createAlias("tblCongDan","tblCongDan").createAlias("tblToChuc","tblToChuc");
			criteria.add(Restrictions.eq("status", (byte)1));
			if ("2".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayThuLy", from, to));
				criteria.addOrder(Order.desc("ngayThuLy"));
			} else if ("3".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHenTra", from, to));
				criteria.addOrder(Order.desc("ngayHenTra"));
			} else if ("4".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHoanThanh", from, to));
				criteria.addOrder(Order.desc("ngayHoanThanh"));
			} else {
				criteria.add(Restrictions.between("modified", from, to));
				criteria.addOrder(Order.desc("modified"));
			}
			
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				criteria.add(Restrictions.eq("trangThai", trangThai));
			}
			if ((query != null) && (!"".equals(query))) {
				log.debug("query is not null");
//				criteria.add(Restrictions.or(Restrictions.like("tblCongDan.ten", "%" + query + "%"),Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%"),Restrictions.like("tenDuAn", "%" + query + "%")));
			    Disjunction disjunction = Restrictions.disjunction();
			    disjunction.add(Restrictions.like("tblCongDan.ten", "%" + query + "%"));
			    disjunction.add(Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%"));
			    disjunction.add(Restrictions.like("tenDuAn", "%" + query + "%"));
			    criteria.add(disjunction);
			}
			
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtcgcndkmsxdcbTiepNhan List<TblTtcgcndkmsxdcb> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	public List<TblTtcmsdvsdns> getTtcmsdvsdnsWithTrangThais(Date from, Date to, Collection<Byte> trangThais) {
		log.debug("Call getTtcmsdvsdnsWithTrangThais List<TblTtcmsdvsdns>");
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("trangThais: " + trangThais.toString());
		List<TblTtcmsdvsdns> list = new ArrayList<TblTtcmsdvsdns>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcmsdvsdns.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.between("created", from, to));
			criteria.add(Restrictions.in("trangThai", trangThais));
			criteria.addOrder(Order.asc("created"));
			list = criteria.list();
/*			
			String queryString = "FROM TblTtcmsdvsdns a WHERE a.created BETWEEN :from AND :to AND a.trangThai IN (:trangThais)";
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery (queryString);
			query.setDate("from", from);
			query.setDate("to", to);
			query.setParameterList("trangThais", trangThais);
*/			
		} catch (RuntimeException re) {
			log.error("getTtcmsdvsdnsWithTrangThais List<TblTtcmsdvsdns> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	public List<TblTtcgcndkmsxdcb> getTtcgcndkmsxdcbWithTrangThais(Date from, Date to, Collection trangThais) {
		log.debug("Call getTtcgcndkmsxdcbWithTrangThais List<TblTtcgcndkmsxdcb>");
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("trangThais: " + trangThais.toString());
		List<TblTtcgcndkmsxdcb> list = new ArrayList<TblTtcgcndkmsxdcb>();
		
		try {
			String queryString = "FROM TblTtcgcndkmsxdcb a WHERE a.created BETWEEN :from AND :to AND a.trangThai IN (:trangThais)";
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery (queryString);
			query.setDate("from", from);
			query.setDate("to", to);
			query.setParameterList("trangThais", trangThais);
			list = query.list();
		} catch (RuntimeException re) {
			log.error("getTtcgcndkmsxdcbWithTrangThais List<TblTtcgcndkmsxdcb> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	public List<TblTtpapbdtns> getTtpapbdtnsWithTrangThais(Date from, Date to, Collection<Byte> trangThais) {
		log.debug("Call getTtpapbdtnsWithTrangThais List<TblTtpapbdtns>");
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("trangThais: " + trangThais.toString());
		List<TblTtpapbdtns> list = new ArrayList<TblTtpapbdtns>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpapbdtns.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.between("created", from, to));
			criteria.add(Restrictions.in("trangThai", trangThais));
			criteria.addOrder(Order.asc("created"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtpapbdtnsWithTrangThais List<TblTtpapbdtns> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	public List<TblTtpdgmsts> getTtpdgmstsWithTrangThais(Date from, Date to, Collection<Byte> trangThais) {
		log.debug("Call getTtpdgmstsWithTrangThais List<TblTtpdgmsts>");
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("trangThais: " + trangThais.toString());
		List<TblTtpdgmsts> list = new ArrayList<TblTtpdgmsts>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpdgmsts.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.between("created", from, to));
			criteria.add(Restrictions.in("trangThai", trangThais));
			criteria.addOrder(Order.asc("created"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtpdgmstsWithTrangThais List<TblTtpdgmsts> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	private List<TblTtcgcndkmsxdcb> getTtcgcndkmsxdcbXuLy(Long userXuLyId, Byte trangThai, Date from, Date to, String query) {
		log.debug("Call getTtcgcndkmsxdcbTiepNhan List<TblTtcgcndkmsxdcb>");
		log.debug("userXuLyId: " + userXuLyId);
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + query);
		List<TblTtcgcndkmsxdcb> list = new ArrayList<TblTtcgcndkmsxdcb>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcgcndkmsxdcb.class).createAlias("tblCongDan","tblCongDan").createAlias("tblToChuc","tblToChuc");
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.between("modified", from, to));
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				criteria.add(Restrictions.eq("trangThai", trangThai));
			}
			criteria.add(Restrictions.eq("tblUsersByUsersXuLyId.usersId", userXuLyId));
			if ((query != null) && (!"".equals(query))) {
				log.debug("query is not null");
				criteria.add(Restrictions.or(Restrictions.like("tblCongDan.ten", "%" + query + "%"),Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%")));
			}
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtcgcndkmsxdcbTiepNhan List<TblTtcgcndkmsxdcb> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	private List<TblTtcgcndkmsxdcb> getTtcgcndkmsxdcbXuLy(Long userXuLyId, Byte trangThai, Date from, Date to, String query, String radioDate) {
		log.debug("Call getTtcgcndkmsxdcbTiepNhan List<TblTtcgcndkmsxdcb>");
		log.debug("userXuLyId: " + userXuLyId);
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + query);
		log.debug("radioDate: " + radioDate);
		List<TblTtcgcndkmsxdcb> list = new ArrayList<TblTtcgcndkmsxdcb>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcgcndkmsxdcb.class).createAlias("tblCongDan","tblCongDan").createAlias("tblToChuc","tblToChuc");
			criteria.add(Restrictions.eq("status", (byte)1));
//			criteria.add(Restrictions.between("modified", from, to));
			
			if ("2".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayThuLy", from, to));
				criteria.addOrder(Order.desc("ngayThuLy"));
			} else if ("3".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHenTra", from, to));
				criteria.addOrder(Order.desc("ngayHenTra"));
			} else if ("4".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHoanThanh", from, to));
				criteria.addOrder(Order.desc("ngayHoanThanh"));
			} else {
				criteria.add(Restrictions.between("modified", from, to));
				criteria.addOrder(Order.desc("modified"));
			}
			
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				criteria.add(Restrictions.eq("trangThai", trangThai));
			}
			criteria.add(Restrictions.eq("tblUsersByUsersXuLyId.usersId", userXuLyId));
			if ((query != null) && (!"".equals(query))) {
				log.debug("query is not null");
				criteria.add(Restrictions.or(Restrictions.like("tblCongDan.ten", "%" + query + "%"),Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%")));
			}
//			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtcgcndkmsxdcbTiepNhan List<TblTtcgcndkmsxdcb> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	public List<TblTtpapbdtns> getTtpapbdtnsTiepNhan(Byte trangThai, Date from, Date to, String query, String radioDate) {
		log.debug("Call getTtpapbdtnsTiepNhan List<TblTtpapbdtns>");
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query" + query);
		List<TblTtpapbdtns> list = new ArrayList<TblTtpapbdtns>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpapbdtns.class).createAlias("tblCongDan","tblCongDan").createAlias("tblToChuc","tblToChuc");
			criteria.add(Restrictions.eq("status", (byte)1));
//			criteria.add(Restrictions.between("modified", from, to));
			
			if ("2".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayThuLy", from, to));
				criteria.addOrder(Order.desc("ngayThuLy"));
			} else if ("3".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHenTra", from, to));
				criteria.addOrder(Order.desc("ngayHenTra"));
			} else if ("4".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHoanThanh", from, to));
				criteria.addOrder(Order.desc("ngayHoanThanh"));
			} else {
				criteria.add(Restrictions.between("modified", from, to));
				criteria.addOrder(Order.desc("modified"));
			}
			
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				criteria.add(Restrictions.eq("trangThai", trangThai));
			}
			if ((query != null) && (!"".equals(query))) {
				log.debug("query is not null");
//				criteria.add(Restrictions.or(Restrictions.like("tblCongDan.ten", "%" + query + "%"),Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%")));
				Disjunction disjunction = Restrictions.disjunction();
			    disjunction.add(Restrictions.like("tblCongDan.ten", "%" + query + "%"));
			    disjunction.add(Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%"));
			    disjunction.add(Restrictions.like("noiDung", "%" + query + "%"));
			    criteria.add(disjunction);
			}
//			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtpapbdtnsTiepNhan List<TblTtcmsdvsdns> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	private List<TblTtpapbdtns> getTtpapbdtnsXuLy(Long userXuLyId, Byte trangThai, Date from, Date to, String query, String radioDate) {
		log.debug("Call getTtpapbdtnsTiepNhan List<TblTtpapbdtns>");
		log.debug("userXuLyId: " + userXuLyId);
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + query);
		List<TblTtpapbdtns> list = new ArrayList<TblTtpapbdtns>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpapbdtns.class).createAlias("tblCongDan","tblCongDan").createAlias("tblToChuc","tblToChuc");
			criteria.add(Restrictions.eq("status", (byte)1));
			
			if ("2".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayThuLy", from, to));
				criteria.addOrder(Order.desc("ngayThuLy"));
			} else if ("3".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHenTra", from, to));
				criteria.addOrder(Order.desc("ngayHenTra"));
			} else if ("4".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHoanThanh", from, to));
				criteria.addOrder(Order.desc("ngayHoanThanh"));
			} else {
				criteria.add(Restrictions.between("modified", from, to));
				criteria.addOrder(Order.desc("modified"));
			}
			
//			criteria.add(Restrictions.between("modified", from, to));
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				criteria.add(Restrictions.eq("trangThai", trangThai));
			}
			criteria.add(Restrictions.eq("tblUsersByUsersXuLyId.usersId", userXuLyId));
			if ((query != null) && (!"".equals(query))) {
				log.debug("query is not null");
//				criteria.add(Restrictions.or(Restrictions.like("tblCongDan.ten", "%" + query + "%"),Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%")));
				Disjunction disjunction = Restrictions.disjunction();
			    disjunction.add(Restrictions.like("tblCongDan.ten", "%" + query + "%"));
			    disjunction.add(Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%"));
			    disjunction.add(Restrictions.like("noiDung", "%" + query + "%"));
			    criteria.add(disjunction);
			}
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtpapbdtnsTiepNhan List<TblTtcmsdvsdns> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	private List<TblTtpapbdtns> getTtpapbdtnsXuLy(Long userXuLyId, Byte trangThai, Date from, Date to, String query) {
		log.debug("Call getTtpapbdtnsTiepNhan List<TblTtpapbdtns>");
		log.debug("userXuLyId: " + userXuLyId);
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + query);
		List<TblTtpapbdtns> list = new ArrayList<TblTtpapbdtns>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpapbdtns.class).createAlias("tblCongDan","tblCongDan").createAlias("tblToChuc","tblToChuc");
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.between("modified", from, to));
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				criteria.add(Restrictions.eq("trangThai", trangThai));
			}
			criteria.add(Restrictions.eq("tblUsersByUsersXuLyId.usersId", userXuLyId));
			if ((query != null) && (!"".equals(query))) {
				log.debug("query is not null");
				criteria.add(Restrictions.or(Restrictions.like("tblCongDan.ten", "%" + query + "%"),Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%")));
			}
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtpapbdtnsTiepNhan List<TblTtcmsdvsdns> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	public List<TblTtpdgmsts> getTtpdgmstsTiepNhan(Byte trangThai, Date from, Date to, String query, String radioDate) {
		log.debug("Call getTtpdgmstsTiepNhan List<TblTtpdgmsts>");
		log.debug("from: " + from);
		log.debug("to: " + to);
		List<TblTtpdgmsts> list = new ArrayList<TblTtpdgmsts>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpdgmsts.class).createAlias("tblCongDan","tblCongDan").createAlias("tblToChuc","tblToChuc");
			criteria.add(Restrictions.eq("status", (byte)1));
//			criteria.add(Restrictions.between("modified", from, to));
			
			if ("2".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayThuLy", from, to));
				criteria.addOrder(Order.desc("ngayThuLy"));
			} else if ("3".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHenTra", from, to));
				criteria.addOrder(Order.desc("ngayHenTra"));
			} else if ("4".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHoanThanh", from, to));
				criteria.addOrder(Order.desc("ngayHoanThanh"));
			} else {
				criteria.add(Restrictions.between("modified", from, to));
				criteria.addOrder(Order.desc("modified"));
			}
			
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				criteria.add(Restrictions.eq("trangThai", trangThai));
			}
			if ((query != null) && (!"".equals(query))) {
				log.debug("query is not null");
//				criteria.add(Restrictions.or(Restrictions.like("tblCongDan.ten", "%" + query + "%"),Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%")));
				Disjunction disjunction = Restrictions.disjunction();
			    disjunction.add(Restrictions.like("tblCongDan.ten", "%" + query + "%"));
			    disjunction.add(Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%"));
			    disjunction.add(Restrictions.like("noiDung", "%" + query + "%"));
			    criteria.add(disjunction);
			}
//			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtpdgmstsTiepNhan List<TblTtpdgmsts> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	private List<TblTtpdgmsts> getTtpdgmstsXuLy(Long userXuLyId, Byte trangThai, Date from, Date to, String query) {
		log.debug("Call getTtpdgmstsTiepNhan List<TblTtpdgmsts>");
		log.debug("from: " + from);
		log.debug("to: " + to);
		List<TblTtpdgmsts> list = new ArrayList<TblTtpdgmsts>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpdgmsts.class).createAlias("tblCongDan","tblCongDan").createAlias("tblToChuc","tblToChuc");
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.between("modified", from, to));
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				criteria.add(Restrictions.eq("trangThai", trangThai));
			}
			criteria.add(Restrictions.eq("tblUsersByUsersXuLyId.usersId", userXuLyId));
			if ((query != null) && (!"".equals(query))) {
				log.debug("query is not null");
				criteria.add(Restrictions.or(Restrictions.like("tblCongDan.ten", "%" + query + "%"),Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%")));
			}
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtpdgmstsTiepNhan List<TblTtpdgmsts> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	private List<TblTtpdgmsts> getTtpdgmstsXuLy(Long userXuLyId, Byte trangThai, Date from, Date to, String query, String radioDate) {
		log.debug("Call getTtpdgmstsTiepNhan List<TblTtpdgmsts>");
		log.debug("from: " + from);
		log.debug("to: " + to);
		List<TblTtpdgmsts> list = new ArrayList<TblTtpdgmsts>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpdgmsts.class).createAlias("tblCongDan","tblCongDan").createAlias("tblToChuc","tblToChuc");
			criteria.add(Restrictions.eq("status", (byte)1));
			
			if ("2".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayThuLy", from, to));
				criteria.addOrder(Order.desc("ngayThuLy"));
			} else if ("3".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHenTra", from, to));
				criteria.addOrder(Order.desc("ngayHenTra"));
			} else if ("4".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHoanThanh", from, to));
				criteria.addOrder(Order.desc("ngayHoanThanh"));
			} else {
				criteria.add(Restrictions.between("modified", from, to));
				criteria.addOrder(Order.desc("modified"));
			}
//			criteria.add(Restrictions.between("modified", from, to));
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				criteria.add(Restrictions.eq("trangThai", trangThai));
			}
			
			criteria.add(Restrictions.eq("tblUsersByUsersXuLyId.usersId", userXuLyId));
			if ((query != null) && (!"".equals(query))) {
				log.debug("query is not null");
//				criteria.add(Restrictions.or(Restrictions.like("tblCongDan.ten", "%" + query + "%"),Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%")));
				Disjunction disjunction = Restrictions.disjunction();
			    disjunction.add(Restrictions.like("tblCongDan.ten", "%" + query + "%"));
			    disjunction.add(Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%"));
			    disjunction.add(Restrictions.like("tenDuAn", "%" + query + "%"));
			    criteria.add(disjunction);
			}
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtpdgmstsTiepNhan List<TblTtpdgmsts> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	public List<TblTtcmsdvsdns> getTtcmsdvsdnsTiepNhan(Byte trangThai, Date from, Date to, String query, String radioDate) {
		log.debug("Call getTtcmsdvsdnsTiepNhan List<TblTtcmsdvsdns>");
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + query);
		log.debug("radioDate: " + radioDate);
		List<TblTtcmsdvsdns> list = new ArrayList<TblTtcmsdvsdns>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcmsdvsdns.class).createAlias("tblCongDan","tblCongDan").createAlias("tblToChuc","tblToChuc");
			criteria.add(Restrictions.eq("status", (byte)1));
			
			if ("2".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayThuLy", from, to));
				criteria.addOrder(Order.desc("ngayThuLy"));
			} else if ("3".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHenTra", from, to));
				criteria.addOrder(Order.desc("ngayHenTra"));
			} else if ("4".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHoanThanh", from, to));
				criteria.addOrder(Order.desc("ngayHoanThanh"));
			} else {
				criteria.add(Restrictions.between("modified", from, to));
				criteria.addOrder(Order.desc("modified"));
			}
			
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				criteria.add(Restrictions.eq("trangThai", trangThai));
			}
			if ((query != null) && (!"".equals(query))) {
				log.debug("query is not null");
//				criteria.add(Restrictions.or(Restrictions.like("tblCongDan.ten", "%" + query + "%"),Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%")));
				Disjunction disjunction = Restrictions.disjunction();
			    disjunction.add(Restrictions.like("tblCongDan.ten", "%" + query + "%"));
			    disjunction.add(Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%"));
			    disjunction.add(Restrictions.like("noiDung", "%" + query + "%"));
			    criteria.add(disjunction);
			}
//			criteria.addOrder(Order.desc("created"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtcmsdvsdnsTiepNhan List<TblTtcmsdvsdns> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	private List<TblTtcmsdvsdns> getTtcmsdvsdnsXuLy(Long userXuLyId, Byte trangThai, Date from, Date to, String query) {
		log.debug("Call getTtcmsdvsdnsTiepNhan List<TblTtcmsdvsdns>");
		log.debug("from: " + from);
		log.debug("to: " + to);
		List<TblTtcmsdvsdns> list = new ArrayList<TblTtcmsdvsdns>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcmsdvsdns.class).createAlias("tblCongDan","tblCongDan").createAlias("tblToChuc","tblToChuc");
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.between("modified", from, to));
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				criteria.add(Restrictions.eq("trangThai", trangThai));
			}
			criteria.add(Restrictions.eq("tblUsersByUsersXuLyId.usersId", userXuLyId));
			if ((query != null) && (!"".equals(query))) {
				log.debug("query is not null");
				criteria.add(Restrictions.or(Restrictions.like("tblCongDan.ten", "%" + query + "%"),Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%")));
			}
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtcmsdvsdnsTiepNhan List<TblTtcmsdvsdns> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	private List<TblTtcmsdvsdns> getTtcmsdvsdnsXuLy(Long userXuLyId, Byte trangThai, Date from, Date to, String query, String radioDate) {
		log.debug("Call getTtcmsdvsdnsTiepNhan List<TblTtcmsdvsdns>");
		log.debug("from: " + from);
		log.debug("to: " + to);
		List<TblTtcmsdvsdns> list = new ArrayList<TblTtcmsdvsdns>();
		
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcmsdvsdns.class).createAlias("tblCongDan","tblCongDan").createAlias("tblToChuc","tblToChuc");
			criteria.add(Restrictions.eq("status", (byte)1));
//			criteria.add(Restrictions.between("modified", from, to));
			
			if ("2".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayThuLy", from, to));
				criteria.addOrder(Order.desc("ngayThuLy"));
			} else if ("3".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHenTra", from, to));
				criteria.addOrder(Order.desc("ngayHenTra"));
			} else if ("4".equals(radioDate)) {
				criteria.add(Restrictions.between("ngayHoanThanh", from, to));
				criteria.addOrder(Order.desc("ngayHoanThanh"));
			} else {
				criteria.add(Restrictions.between("modified", from, to));
				criteria.addOrder(Order.desc("modified"));
			}
			
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				criteria.add(Restrictions.eq("trangThai", trangThai));
			}
			criteria.add(Restrictions.eq("tblUsersByUsersXuLyId.usersId", userXuLyId));
			if ((query != null) && (!"".equals(query))) {
				log.debug("query is not null");
				criteria.add(Restrictions.or(Restrictions.like("tblCongDan.ten", "%" + query + "%"),Restrictions.like("tblToChuc.tenCoQuan", "%" + query + "%")));
			}
//			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTtcmsdvsdnsTiepNhan List<TblTtcmsdvsdns> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	public TblToChuc getToChuc(Long toChucId) {
		log.debug("Call get TblToChuc with: " + toChucId);
		TblToChuc object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblToChuc.class);
			criteria.add(Restrictions.eq("toChucId", toChucId));
			object = (TblToChuc)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblToChuc", e);
		}
		return object;
	}
	
	public TblTtcgcndkmsxdcbDinhKem getTtcgcndkmsxdcbDinhKem(Long documentId) {
		log.debug("Call get getTblTtcgcndkmsxdcbDinhKem with documentId: " + documentId);
		TblTtcgcndkmsxdcbDinhKem object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcgcndkmsxdcbDinhKem.class);
			criteria.add(Restrictions.eq("tblDocument.documentId", documentId));
			object = (TblTtcgcndkmsxdcbDinhKem)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get getTblTtcgcndkmsxdcbDinhKem", e);
		}
		return object;
	}
	
	public TblTtpapbdtnsDinhKem getTtpapbdtnsDinhKem(Long documentId) {
		log.debug("Call get TblTtpapbdtnsDinhKem with documentId: " + documentId);
		TblTtpapbdtnsDinhKem object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpapbdtnsDinhKem.class);
			criteria.add(Restrictions.eq("tblDocument.documentId", documentId));
			object = (TblTtpapbdtnsDinhKem)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtpapbdtnsDinhKem", e);
		}
		return object;
	}
	
	public TblTtcmsdvsdnsDinhKem getTtcmsdvsdnsDinhKem(Long documentId) {
		log.debug("Call get getTtcmsdvsdnsDinhKem with documentId: " + documentId);
		TblTtcmsdvsdnsDinhKem object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcmsdvsdnsDinhKem.class);
			criteria.add(Restrictions.eq("tblDocument.documentId", documentId));
			object = (TblTtcmsdvsdnsDinhKem)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get getTblTtcgcndkmsxdcbDinhKem", e);
		}
		return object;
	}
	public TblTtpdgmstsDinhKem getTtpdgmstsDinhKem(Long documentId) {
		log.debug("Call get getTtcmsdvsdnsDinhKem with documentId: " + documentId);
		TblTtpdgmstsDinhKem object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpdgmstsDinhKem.class);
			criteria.add(Restrictions.eq("tblDocument.documentId", documentId));
			object = (TblTtpdgmstsDinhKem)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get getTblTtcgcndkmsxdcbDinhKem", e);
		}
		return object;
	}
	
	public TblCongDan getCongDan(Long congDanId) {
		log.debug("Call get TblCongDan with: " + congDanId);
		TblCongDan object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblCongDan.class);
			criteria.add(Restrictions.eq("congDanId", congDanId));
			object = (TblCongDan)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblCongDan", e);
		}
		return object;
	}
	
	public TblTtcgcndkmsxdcb getTtcgcndkmsxdcb(Long ttcgcndkmsxdcbId) {
		log.debug("Call get TblTtcgcndkmsxdcb with: " + ttcgcndkmsxdcbId);
		TblTtcgcndkmsxdcb object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcgcndkmsxdcb.class);
			criteria.add(Restrictions.eq("ttcgcndkmsxdcbId", ttcgcndkmsxdcbId));
			object = (TblTtcgcndkmsxdcb)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtcgcndkmsxdcb with ttcgcndkmsxdcbId = " + ttcgcndkmsxdcbId, e);
		}
		return object;
	}
	
	public Long getMaxTtcgcndkmsxdcbId() {
		log.debug("Call getMaxTtcgcndkmsxdcbId");
		Long maxTtcgcndkmsxdcbId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Calendar calendar = Calendar.getInstance();
			calendar.set(calendar.get(Calendar.YEAR), 1, 1, 0, 0, 0);
			Date from = calendar.getTime();
			calendar.set(calendar.get(Calendar.YEAR), 31, 12, 23, 59, 59);
			Date to = calendar.getTime();
			Query query = session.createQuery("select count(*) from TblTtcgcndkmsxdcb where bienNhanTmc is not null and created between :from and :to");
			query.setDate("from", from);
			query.setDate("to", to);
			maxTtcgcndkmsxdcbId = (Long)query.uniqueResult();
		} catch (Exception e) {
			log.debug("fail getMaxTtcgcndkmsxdcbId", e);
		}
		return maxTtcgcndkmsxdcbId;
	}
	
	public TblTtcgcndkmsxdcb getTtcgcndkmsxdcb(String soBienNhan, String codeTraCuu) {
		log.debug("Call get TblTtcgcndkmsxdcb with: soBienNhan = " + soBienNhan + " and codeTraCuu = " + codeTraCuu);
		TblTtcgcndkmsxdcb object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcgcndkmsxdcb.class);
			criteria.add(Restrictions.eq("soBienNhan", soBienNhan));
			criteria.add(Restrictions.eq("codeTraCuu", codeTraCuu));
			criteria.addOrder(Order.desc("modified"));
			object = (TblTtcgcndkmsxdcb)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtcgcndkmsxdcb", e);
		}
		return object;
	}
	
	public TblTtcgcndkmsxdcb getTtcgcndkmsxdcb(String soBienNhan) {
		log.debug("Call get TblTtcgcndkmsxdcb with: soBienNhan = " + soBienNhan);
		TblTtcgcndkmsxdcb object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcgcndkmsxdcb.class);
			criteria.add(Restrictions.eq("soBienNhan", soBienNhan));
//			criteria.add(Restrictions.eq("codeTraCuu", codeTraCuu));
			criteria.addOrder(Order.desc("modified"));
			object = (TblTtcgcndkmsxdcb)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtcgcndkmsxdcb", e);
		}
		return object;
	}
	
	public TblTtcgcndkmsxdcbButPhe getTtcgcndkmsxdcbButPhe(Long id) {
		log.debug("Call get TblTtcgcndkmsxdcbButPhe with: " + id);
		TblTtcgcndkmsxdcbButPhe object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcgcndkmsxdcbButPhe.class);
			criteria.add(Restrictions.eq("ttcgcndkmsxdcbButPheId", id));
			object = (TblTtcgcndkmsxdcbButPhe)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtcgcndkmsxdcb", e);
		}
		return object;
	}
	
	public TblTtcmsdvsdns getTtcmsdvsdns(Long ttcmsdvsdnsId) {
		log.debug("Call get TblTtcmsdvsdns with: " + ttcmsdvsdnsId);
		TblTtcmsdvsdns object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcmsdvsdns.class);
			criteria.add(Restrictions.eq("ttcmsdvsdnsId", ttcmsdvsdnsId));
			object = (TblTtcmsdvsdns)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtcmsdvsdns", e);
		}
		return object;
	}
	
	public Long getMaxTtcmsdvsdnsId() {
		log.debug("Call getMaxTtcgcndkmsxdcbId");
		Long maxTtcmsdvsdnsId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Calendar calendar = Calendar.getInstance();
			calendar.set(calendar.get(Calendar.YEAR), 1, 1, 0, 0, 0);
			Date from = calendar.getTime();
			calendar.set(calendar.get(Calendar.YEAR), 31, 12, 23, 59, 59);
			Date to = calendar.getTime();
			Query query = session.createQuery("select count(*) from TblTtcmsdvsdns where bienNhanTmc is not null and created between :from and :to");
			query.setDate("from", from);
			query.setDate("to", to);
			maxTtcmsdvsdnsId = (Long)query.uniqueResult();
		} catch (Exception e) {
			log.debug("fail getMaxTtcgcndkmsxdcbId", e);
		}
		return maxTtcmsdvsdnsId;
	}
	
	public TblTtcmsdvsdns getTtcmsdvsdns(String soBienNhan, String codeTraCuu) {
		log.debug("Call get TblTtcmsdvsdns with: soBienNhan = " + soBienNhan + " and codeTraCuu = " + codeTraCuu);
		TblTtcmsdvsdns object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcmsdvsdns.class);
			criteria.add(Restrictions.eq("soBienNhan", soBienNhan));
			criteria.add(Restrictions.eq("codeTraCuu", codeTraCuu));
			criteria.addOrder(Order.desc("modified"));
			object = (TblTtcmsdvsdns)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtcgcndkmsxdcb", e);
		}
		return object;
	}
	
	public TblTtcmsdvsdns getTtcmsdvsdns(String soBienNhan) {
		log.debug("Call get TblTtcmsdvsdns with: soBienNhan = " + soBienNhan);
		TblTtcmsdvsdns object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcmsdvsdns.class);
			criteria.add(Restrictions.eq("soBienNhan", soBienNhan));
//			criteria.add(Restrictions.eq("codeTraCuu", codeTraCuu));
			criteria.addOrder(Order.desc("modified"));
			object = (TblTtcmsdvsdns)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtcgcndkmsxdcb", e);
		}
		return object;
	}
	
	public TblTtcmsdvsdnsButPhe getTtcmsdvsdnsButPhe(Long id) {
		log.debug("Call get TblTtcmsdvsdnsButPhe with: " + id);
		TblTtcmsdvsdnsButPhe object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtcmsdvsdnsButPhe.class);
			criteria.add(Restrictions.eq("ttcmsdvsdnsButPheId", id));
			object = (TblTtcmsdvsdnsButPhe)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtcmsdvsdnsButPhe", e);
		}
		return object;
	}
	
	public TblTtpdgmsts getTtpdgmsts(Long ttpdgmstsId) {
		log.debug("Call get TblTtpdgmsts with: " + ttpdgmstsId);
		TblTtpdgmsts object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpdgmsts.class);
			criteria.add(Restrictions.eq("ttpdgmstsId", ttpdgmstsId));
			object = (TblTtpdgmsts)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtpdgmsts", e);
		}
		return object;
	}
	
	public Long getMaxTtpdgmstsId() {
		log.debug("Call getMaxTtpdgmstsId");
		Long maxTtpdgmstsId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Calendar calendar = Calendar.getInstance();
			calendar.set(calendar.get(Calendar.YEAR), 1, 1, 0, 0, 0);
			Date from = calendar.getTime();
			calendar.set(calendar.get(Calendar.YEAR), 31, 12, 23, 59, 59);
			Date to = calendar.getTime();
			Query query = session.createQuery("select count(*) from TblTtpdgmsts where bienNhanTmc is not null and created between :from and :to");
			query.setDate("from", from);
			query.setDate("to", to);
			maxTtpdgmstsId = (Long)query.uniqueResult();
		} catch (Exception e) {
			log.debug("fail getMaxTtcgcndkmsxdcbId", e);
		}
		return maxTtpdgmstsId;
	}
	
	public TblTtpdgmsts getTtpdgmsts(String soBienNhan, String codeTraCuu) {
		log.debug("Call get TblTtpdgmsts with: soBienNhan = " + soBienNhan + " and codeTraCuu = " + codeTraCuu);
		TblTtpdgmsts object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpdgmsts.class);
			criteria.add(Restrictions.eq("soBienNhan", soBienNhan));
			criteria.add(Restrictions.eq("codeTraCuu", codeTraCuu));
			criteria.addOrder(Order.desc("modified"));
			object = (TblTtpdgmsts)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtcgcndkmsxdcb", e);
		}
		return object;
	}
	
	public TblTtpdgmsts getTtpdgmsts(String soBienNhan) {
		log.debug("Call get TblTtpdgmsts with: soBienNhan = " + soBienNhan);
		TblTtpdgmsts object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpdgmsts.class);
			criteria.add(Restrictions.eq("soBienNhan", soBienNhan));
//			criteria.add(Restrictions.eq("codeTraCuu", codeTraCuu));
			criteria.addOrder(Order.desc("modified"));
			object = (TblTtpdgmsts)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtcgcndkmsxdcb", e);
		}
		return object;
	}
	
	public TblTtpdgmstsButPhe getTtpdgmstsButPhe(Long id) {
		log.debug("Call get TblTtpdgmstsButPhe with: " + id);
		TblTtpdgmstsButPhe object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpdgmstsButPhe.class);
			criteria.add(Restrictions.eq("ttpdgmstsButPheId", id));
			object = (TblTtpdgmstsButPhe)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtpdgmstsButPhe", e);
		}
		return object;
	}
	
	public TblTtpapbdtns getTtpapbdtns(Long ttpapbdtnsId) {
		log.debug("Call get TblTtcgcndkmsxdcb with: " + ttpapbdtnsId);
		TblTtpapbdtns object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpapbdtns.class);
			criteria.add(Restrictions.eq("ttpapbdtnsId", ttpapbdtnsId));
			object = (TblTtpapbdtns)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtpapbdtns", e);
		}
		return object;
	}
	
	public Long getMaxTtpapbdtnsId() {
		log.debug("Call getMaxTtpapbdtnsId");
		Long maxTtpapbdtnsId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Calendar calendar = Calendar.getInstance();
			calendar.set(calendar.get(Calendar.YEAR), 1, 1, 0, 0, 0);
			Date from = calendar.getTime();
			calendar.set(calendar.get(Calendar.YEAR), 31, 12, 23, 59, 59);
			Date to = calendar.getTime();
			Query query = session.createQuery("select count(*) from TblTtpapbdtns where bienNhanTmc is not null and created between :from and :to");
			query.setDate("from", from);
			query.setDate("to", to);
			maxTtpapbdtnsId = (Long)query.uniqueResult();
		} catch (Exception e) {
			log.debug("fail getMaxTtcgcndkmsxdcbId", e);
		}
		return maxTtpapbdtnsId;
	}
	
	public TblTtpapbdtns getTtpapbdtns(String soBienNhan, String codeTraCuu) {
		log.debug("Call get TblTtpdgmsts with: soBienNhan = " + soBienNhan + " and codeTraCuu = " + codeTraCuu);
		TblTtpapbdtns object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpapbdtns.class);
			criteria.add(Restrictions.eq("soBienNhan", soBienNhan));
			criteria.add(Restrictions.eq("codeTraCuu", codeTraCuu));
			criteria.addOrder(Order.desc("modified"));
			object = (TblTtpapbdtns)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtcgcndkmsxdcb", e);
		}
		return object;
	}
	
	public TblTtpapbdtns getTtpapbdtns(String soBienNhan) {
		log.debug("Call get TblTtpdgmsts with: soBienNhan = " + soBienNhan);
		TblTtpapbdtns object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpapbdtns.class);
			criteria.add(Restrictions.eq("soBienNhan", soBienNhan));
//			criteria.add(Restrictions.eq("codeTraCuu", codeTraCuu));
			criteria.addOrder(Order.desc("modified"));
			object = (TblTtpapbdtns)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtcgcndkmsxdcb", e);
		}
		return object;
	}
	
	public TblTtpapbdtnsButPhe getTtpapbdtnsButPhe(Long id) {
		log.debug("Call get TblTtpapbdtnsButPhe with: " + id);
		TblTtpapbdtnsButPhe object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTtpapbdtnsButPhe.class);
			criteria.add(Restrictions.eq("ttpapbdtnsButPheId", id));
			object = (TblTtpapbdtnsButPhe)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblTtpapbdtnsButPhe", e);
		}
		return object;
	}
	
	public Long save(TblCongDan object) {
		log.debug("Call save TblCongDan");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblCongDan", e);
		}
		return returnId;
	}
	
	public Long save(TblDocument object) {
		log.debug("Call save TblDocument");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblDocument", e);
		}
		return returnId;
	}
	
	public TblDocument getTblDocument(Long documentId) {
		log.debug("Call get TblDocument with: " + documentId);
		TblDocument object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblDocument.class);
			criteria.add(Restrictions.eq("documentId", documentId));
			object = (TblDocument)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblDocument", e);
		}
		return object;
	}
	
	public Long save(TblToChuc object) {
		log.debug("Call save TblToChuc");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblToChuc", e);
		}
		return returnId;
	}
	
	public Long save(TblTtcgcndkmsxdcb object) {
		log.debug("Call save TblTtcgcndkmsxdcb");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtcgcndkmsxdcb", e);
		}
		return returnId;
	}
	
	public void delete(TblTtcgcndkmsxdcb object) {
		log.debug("Call delete TblTtcgcndkmsxdcb");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("delete TblTtcgcndkmsxdcbDinhKem where tblTtcgcndkmsxdcb.ttcgcndkmsxdcbId =:ttcgcndkmsxdcbId");
			query.setLong("ttcgcndkmsxdcbId", object.getTtcgcndkmsxdcbId());
			query.executeUpdate();
			query = session.createQuery("delete TblTtcgcndkmsxdcbButPhe where tblTtcgcndkmsxdcb.ttcgcndkmsxdcbId =:ttcgcndkmsxdcbId");
			query.setLong("ttcgcndkmsxdcbId", object.getTtcgcndkmsxdcbId());
			query.executeUpdate();
			query = session.createQuery("delete TblTtcgcndkmsxdcbChuyenhs where tblTtcgcndkmsxdcb.ttcgcndkmsxdcbId =:ttcgcndkmsxdcbId");
			query.setLong("ttcgcndkmsxdcbId", object.getTtcgcndkmsxdcbId());
			query.executeUpdate();
			query = session.createQuery("delete TblTtcgcndkmsxdcb where ttcgcndkmsxdcbId =:ttcgcndkmsxdcbId");
			query.setLong("ttcgcndkmsxdcbId", object.getTtcgcndkmsxdcbId());
			query.executeUpdate();
			session.flush();
		} catch (Exception e) {
			log.debug("fail delete TblTtcgcndkmsxdcb", e);
		}
	}
	
	public void deleteTblTtcgcndkmsxdcb(Long ttcgcndkmsxdcbId) {
		log.debug("Call delete TblTtcgcndkmsxdcb with ttcgcndkmsxdcbId: " + ttcgcndkmsxdcbId);
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("delete TblTtcgcndkmsxdcbDinhKem where tblTtcgcndkmsxdcb.ttcgcndkmsxdcbId =:ttcgcndkmsxdcbId");
			query.setLong("ttcgcndkmsxdcbId", ttcgcndkmsxdcbId);
			query.executeUpdate();
			query = session.createQuery("delete TblTtcgcndkmsxdcbButPhe where tblTtcgcndkmsxdcb.ttcgcndkmsxdcbId =:ttcgcndkmsxdcbId");
			query.setLong("ttcgcndkmsxdcbId", ttcgcndkmsxdcbId);
			query.executeUpdate();
			query = session.createQuery("delete TblTtcgcndkmsxdcbChuyenhs where tblTtcgcndkmsxdcb.ttcgcndkmsxdcbId =:ttcgcndkmsxdcbId");
			query.setLong("ttcgcndkmsxdcbId", ttcgcndkmsxdcbId);
			query.executeUpdate();
			query = session.createQuery("delete TblTtcgcndkmsxdcb where ttcgcndkmsxdcbId =:ttcgcndkmsxdcbId");
			query.setLong("ttcgcndkmsxdcbId", ttcgcndkmsxdcbId);
			query.executeUpdate();
			session.flush();
		} catch (Exception e) {
			log.debug("fail delete TblTtcgcndkmsxdcb", e);
		}
	}
	
	public void delete(TblTtcmsdvsdns object) {
		log.debug("Call delete TblTtcmsdvsdns");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("delete TblTtcmsdvsdnsDinhKem where tblTtcmsdvsdns.ttcmsdvsdnsId =:ttcmsdvsdnsId");
			query.setLong("ttcmsdvsdnsId", object.getTtcmsdvsdnsId());
			query.executeUpdate();
			query = session.createQuery("delete TblTtcmsdvsdnsButPhe where tblTtcmsdvsdns.ttcmsdvsdnsId =:ttcmsdvsdnsId");
			query.setLong("ttcmsdvsdnsId", object.getTtcmsdvsdnsId());
			query.executeUpdate();
			query = session.createQuery("delete TblTtcmsdvsdnsChuyenhs where tblTtcmsdvsdns.ttcmsdvsdnsId =:ttcmsdvsdnsId");
			query.setLong("ttcmsdvsdnsId", object.getTtcmsdvsdnsId());
			query.executeUpdate();
			query = session.createQuery("delete TblTtcmsdvsdns where ttcmsdvsdnsId =:ttcmsdvsdnsId");
			query.setLong("ttcmsdvsdnsId", object.getTtcmsdvsdnsId());
			query.executeUpdate();
			session.flush();
		} catch (Exception e) {
			log.debug("fail delete TblTtcgcndkmsxdcb", e);
		}
	}
	
	public void deleteTblTtcmsdvsdns(Long ttcmsdvsdnsId) {
		log.debug("Call delete TblTtcmsdvsdns with ttcmsdvsdnsId: " + ttcmsdvsdnsId);
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("delete TblTtcmsdvsdnsDinhKem where tblTtcmsdvsdns.ttcmsdvsdnsId =:ttcmsdvsdnsId");
			query.setLong("ttcmsdvsdnsId", ttcmsdvsdnsId);
			query.executeUpdate();
			query = session.createQuery("delete TblTtcmsdvsdnsButPhe where tblTtcmsdvsdns.ttcmsdvsdnsId =:ttcmsdvsdnsId");
			query.setLong("ttcmsdvsdnsId", ttcmsdvsdnsId);
			query.executeUpdate();
			query = session.createQuery("delete TblTtcmsdvsdnsChuyenhs where tblTtcmsdvsdns.ttcmsdvsdnsId =:ttcmsdvsdnsId");
			query.setLong("ttcmsdvsdnsId", ttcmsdvsdnsId);
			query.executeUpdate();
			query = session.createQuery("delete TblTtcmsdvsdns where ttcmsdvsdnsId =:ttcmsdvsdnsId");
			query.setLong("ttcmsdvsdnsId", ttcmsdvsdnsId);
			query.executeUpdate();
			session.flush();
		} catch (Exception e) {
			log.debug("fail delete TblTtcgcndkmsxdcb", e);
		}
	}
	
	public void delete(TblTtpapbdtns object) {
		log.debug("Call delete TblTtpapbdtns");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("delete TblTtpapbdtnsDinhKem where tblTtpapbdtns.ttpapbdtnsId =:ttpapbdtnsId");
			query.setLong("ttpapbdtnsId", object.getTtpapbdtnsId());
			query.executeUpdate();
			query = session.createQuery("delete TblTtpapbdtnsButPhe where tblTtpapbdtns.ttpapbdtnsId =:ttpapbdtnsId");
			query.setLong("ttpapbdtnsId", object.getTtpapbdtnsId());
			query.executeUpdate();
			query = session.createQuery("delete TblTtpapbdtnsChuyenhs where tblTtpapbdtns.ttpapbdtnsId =:ttpapbdtnsId");
			query.setLong("ttpapbdtnsId", object.getTtpapbdtnsId());
			query.executeUpdate();
			query = session.createQuery("delete TblTtpapbdtns where ttpapbdtnsId =:ttpapbdtnsId");
			query.setLong("ttpapbdtnsId", object.getTtpapbdtnsId());
			query.executeUpdate();
			session.flush();
		} catch (Exception e) {
			log.debug("fail delete TblTtcgcndkmsxdcb", e);
		}
	}
	
	public void deleteTblTtpapbdtns(Long ttpapbdtnsId) {
		log.debug("Call delete TblTtpapbdtns with ttpapbdtnsId: " + ttpapbdtnsId);
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("delete TblTtpapbdtnsDinhKem where tblTtpapbdtns.ttpapbdtnsId =:ttpapbdtnsId");
			query.setLong("ttpapbdtnsId", ttpapbdtnsId);
			query.executeUpdate();
			query = session.createQuery("delete TblTtpapbdtnsButPhe where tblTtpapbdtns.ttpapbdtnsId =:ttpapbdtnsId");
			query.setLong("ttpapbdtnsId", ttpapbdtnsId);
			query.executeUpdate();
			query = session.createQuery("delete TblTtpapbdtnsChuyenhs where tblTtpapbdtns.ttpapbdtnsId =:ttpapbdtnsId");
			query.setLong("ttpapbdtnsId", ttpapbdtnsId);
			query.executeUpdate();
			query = session.createQuery("delete TblTtpapbdtns where ttpapbdtnsId =:ttpapbdtnsId");
			query.setLong("ttpapbdtnsId", ttpapbdtnsId);
			query.executeUpdate();
			session.flush();
		} catch (Exception e) {
			log.debug("fail delete TblTtcgcndkmsxdcb", e);
		}
	}
	
	public void delete(TblTtpdgmsts object) {
		log.debug("Call delete TblTtpdgmsts");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("delete TblTtpdgmstsDinhKem where tblTtpdgmsts.ttpdgmstsId =:ttpdgmstsId");
			query.setLong("ttpdgmstsId", object.getTtpdgmstsId());
			query.executeUpdate();
			query = session.createQuery("delete TblTtpdgmstsButPhe where tblTtpdgmsts.ttpdgmstsId =:ttpdgmstsId");
			query.setLong("ttpdgmstsId", object.getTtpdgmstsId());
			query.executeUpdate();
			query = session.createQuery("delete TblTtpdgmstsChuyenhs where tblTtpdgmsts.ttpdgmstsId =:ttpdgmstsId");
			query.setLong("ttpdgmstsId", object.getTtpdgmstsId());
			query.executeUpdate();
			query = session.createQuery("delete TblTtpdgmsts where ttpdgmstsId =:ttpdgmstsId");
			query.setLong("ttpdgmstsId", object.getTtpdgmstsId());
			query.executeUpdate();
			session.flush();
		} catch (Exception e) {
			log.debug("fail delete TblTtcgcndkmsxdcb", e);
		}
	}
	
	public void deleteTblTtpdgmsts(Long ttpdgmstsId) {
		log.debug("Call delete TblTtpdgmsts with ttpdgmstsId: " + ttpdgmstsId);
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("delete TblTtpdgmstsDinhKem where tblTtpdgmsts.ttpdgmstsId =:ttpdgmstsId");
			query.setLong("ttpdgmstsId", ttpdgmstsId);
			query.executeUpdate();
			query = session.createQuery("delete TblTtpdgmstsButPhe where tblTtpdgmsts.ttpdgmstsId =:ttpdgmstsId");
			query.setLong("ttpdgmstsId", ttpdgmstsId);
			query.executeUpdate();
			query = session.createQuery("delete TblTtpdgmstsChuyenhs where tblTtpdgmsts.ttpdgmstsId =:ttpdgmstsId");
			query.setLong("ttpdgmstsId", ttpdgmstsId);
			query.executeUpdate();
			query = session.createQuery("delete TblTtpdgmsts where ttpdgmstsId =:ttpdgmstsId");
			query.setLong("ttpdgmstsId", ttpdgmstsId);
			query.executeUpdate();
			session.flush();
		} catch (Exception e) {
			log.debug("fail delete TblTtcgcndkmsxdcb", e);
		}
	}
	
	public void update(TblTtcgcndkmsxdcb object) {
		log.debug("Call update TblTtcgcndkmsxdcb");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblTtcgcndkmsxdcb", e);
		}
	}
	
	public void update(TblCongDan object) {
		log.debug("Call update TblCongDan");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblCongDan", e);
		}
	}
	public void update(TblToChuc object) {
		log.debug("Call update TblToChuc");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblToChuc", e);
		}
	}	
	
	public void delete(TblTtcgcndkmsxdcbDinhKem object) {
		log.debug("Call delete TblTtcgcndkmsxdcbDinhKem");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.delete(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail delete TblTtcgcndkmsxdcbDinhKem", e);
		}
	}
	
	public void delete(TblTtcmsdvsdnsDinhKem object) {
		log.debug("Call delete TblTtcmsdvsdnsDinhKem");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.delete(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail delete TblTtcmsdvsdnsDinhKem", e);
		}
	}
	
	public void delete(TblTtpapbdtnsDinhKem object) {
		log.debug("Call delete TblTtpapbdtnsDinhKem");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.delete(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail delete TblTtpapbdtnsDinhKem", e);
		}
	}
	public void delete(TblTtpdgmstsDinhKem object) {
		log.debug("Call delete TblTtpdgmstsDinhKem");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.delete(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail delete TblTtpdgmstsDinhKem", e);
		}
	}
	public void delete(TblDocument object) {
		log.debug("Call update TblTtcgcndkmsxdcb");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.delete(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblTtcgcndkmsxdcb", e);
		}
	}
	
	public void update(TblDocument object) {
		log.debug("Call update TblDocument");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblDocument", e);
		}
	}
	
	public TblDocument getDocument(Long documentId) {
		log.debug("Call get TblDocument with: " + documentId);
		TblDocument object = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblDocument.class);
			criteria.add(Restrictions.eq("documentId", documentId));
			object = (TblDocument)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblDocument", e);
		}
		return object;
	}
	
	public void update(TblTtcgcndkmsxdcbDinhKem object) {
		log.debug("Call update TblTtcgcndkmsxdcbDinhKem");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblTtcgcndkmsxdcbDinhKem", e);
		}
	}
	
	
	public void update(TblTtpdgmsts object) {
		log.debug("Call update TblTtpdgmsts");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblTtpdgmsts", e);
		}
	}
	
	public void update(TblTtpapbdtns object) {
		log.debug("Call update TblTtpapbdtns");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblTtpapbdtns", e);
		}
	}
	
	public void update(TblTtcmsdvsdns object) {
		log.debug("Call update TblTtcmsdvsdns");
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblTtcmsdvsdns", e);
		}
	}
	
	public Long save(TblTtcgcndkmsxdcbButPhe object) {
		log.debug("Call save TblTtcgcndkmsxdcbButPhe");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtcgcndkmsxdcbButPhe", e);
		}
		return returnId;
	}
	
	public Long save(TblTtcgcndkmsxdcbChuyenhs object) {
		log.debug("Call save TblTtcgcndkmsxdcbChuyenhs");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtcgcndkmsxdcbChuyenhs", e);
		}
		return returnId;
	}
	
	public Long save(TblTtcgcndkmsxdcbDinhKem object) {
		log.debug("Call save TblTtcgcndkmsxdcbChuyenhs");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtcgcndkmsxdcbChuyenhs", e);
		}
		return returnId;
	}
	
	public Long save(TblTtcmsdvsdns object) {
		log.debug("Call save TblTtcgcndkmsxdcbChuyenhs");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtcgcndkmsxdcbChuyenhs", e);
		}
		return returnId;
	}
	
	public Long save(TblTtcmsdvsdnsButPhe object) {
		log.debug("Call save TblTtcgcndkmsxdcbChuyenhs");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtcmsdvsdnsButPhe", e);
		}
		return returnId;
	}
	public Long save(TblTtcmsdvsdnsChuyenhs object) {
		log.debug("Call save TblTtcmsdvsdnsChuyenhs");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtcmsdvsdnsChuyenhs", e);
		}
		return returnId;
	}
	public Long save(TblTtcmsdvsdnsDinhKem object) {
		log.debug("Call save TblTtcgcndkmsxdcbChuyenhs");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtcmsdvsdnsDinhKem", e);
		}
		return returnId;
	}
	
	public Long save(TblTtpapbdtns object) {
		log.debug("Call save TblTtcgcndkmsxdcbChuyenhs");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtcmsdvsdnsDinhKem", e);
		}
		return returnId;
	}
	
	public Long save(TblTtpapbdtnsButPhe object) {
		log.debug("Call save TblTtcgcndkmsxdcbChuyenhs");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtcmsdvsdnsDinhKem", e);
		}
		return returnId;
	}
	
	public Long save(TblTtpapbdtnsChuyenhs object) {
		log.debug("Call save TblTtcgcndkmsxdcbChuyenhs");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtcmsdvsdnsDinhKem", e);
		}
		return returnId;
	}
	
	public Long save(TblTtpapbdtnsDinhKem object) {
		log.debug("Call save TblTtcgcndkmsxdcbChuyenhs");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtcmsdvsdnsDinhKem", e);
		}
		return returnId;
	}
	
	public Long save(TblTtpdgmsts object) {
		log.debug("Call save TblTtpdgmsts");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtpdgmsts", e);
		}
		return returnId;
	}
	
	public Long save(TblTtpdgmstsButPhe object) {
		log.debug("Call save TblTtpdgmsts");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtpdgmsts", e);
		}
		return returnId;
	}
	
	public Long save(TblTtpdgmstsChuyenhs object) {
		log.debug("Call save TblTtpdgmsts");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtpdgmsts", e);
		}
		return returnId;
	}
	
	public Long save(TblTtpdgmstsDinhKem object) {
		log.debug("Call save TblTtpdgmsts");
		Long returnId = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTtpdgmsts", e);
		}
		return returnId;
	}

	public Long countHoSoDungHen(Date dFrom, Date dTo, String code) {
		log.debug("Call countHoSoDungHen");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long count = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			String sFrom = dateFormat.format(dFrom);
			String sTo = dateFormat.format(dTo);
			if ("TTCGCNDKMSXDCB".equals(code)) {
//				String sqlQuery = "SELECT COUNT(*) FROM TBL_TTCGCNDKMSXDCB P WHERE P.NGAY_HOAN_THANH <= DATE_ADD(P.NGAY_THU_LY, INTERVAL " + StringUtils.HANXULY.TTCGCNDKMSXDCB.getValue() + " DAY) AND (P.NGAY_THU_LY BETWEEN '" + sFrom + "' AND '" + sTo + "') AND P.TRANG_THAI = 3";
//				log.debug(sqlQuery);
//				SQLQuery query = session.createSQLQuery(sqlQuery);
//				count = Long.parseLong(query.list().get(0).toString());
				String queryString = "SELECT COUNT(*) FROM TblTtcgcndkmsxdcb a WHERE a.created BETWEEN :from AND :to AND a.trangThai = 3 and a.ngayHenTra >= a.ngayHoanThanh";
				Query query = session.createQuery (queryString);
				query.setDate("from", dFrom);
				query.setDate("to", dTo);
				count = ((Long)query.uniqueResult()).longValue();
			} else if ("TTCMSDVSDNS".equals(code)) {
//				String sqlQuery = "SELECT COUNT(*) FROM TBL_TTCMSDVSDNS P WHERE P.NGAY_HOAN_THANH <= DATE_ADD(P.NGAY_THU_LY, INTERVAL " + StringUtils.HANXULY.TTCMSDVSDNS.getValue() + " DAY) AND (P.NGAY_THU_LY BETWEEN '" + sFrom + "' AND '" + sTo + "') AND P.TRANG_THAI = 3";
//				log.debug(sqlQuery);
//				SQLQuery query = session.createSQLQuery(sqlQuery);
//				count = Long.parseLong(query.list().get(0).toString());				
				String queryString = "SELECT COUNT(*) FROM TblTtcmsdvsdns a WHERE a.created BETWEEN :from AND :to AND a.trangThai = 3 and a.ngayHenTra >= a.ngayHoanThanh";
				Query query = session.createQuery (queryString);
				query.setDate("from", dFrom);
				query.setDate("to", dTo);
				count = ((Long)query.uniqueResult()).longValue();
			} else if ("TTPAPBDTNS".equals(code)) {
//				String sqlQuery = "SELECT COUNT(*) FROM TBL_TTPAPBDTNS P WHERE P.NGAY_HOAN_THANH <= DATE_ADD(P.NGAY_THU_LY, INTERVAL " + StringUtils.HANXULY.TTPAPBDTNS.getValue() + " DAY) AND (P.NGAY_THU_LY BETWEEN '" + sFrom + "' AND '" + sTo + "') AND P.TRANG_THAI = 3";
//				log.debug(sqlQuery);
//				SQLQuery query = session.createSQLQuery(sqlQuery);
//				count = Long.parseLong(query.list().get(0).toString());				
				String queryString = "SELECT COUNT(*) FROM TblTtpapbdtns a WHERE a.created BETWEEN :from AND :to AND a.trangThai = 3 and a.ngayHenTra >= a.ngayHoanThanh";
				Query query = session.createQuery (queryString);
				query.setDate("from", dFrom);
				query.setDate("to", dTo);
				count = ((Long)query.uniqueResult()).longValue();
			} else if ("TTPDGMSTS".equals(code)) {
//				String sqlQuery = "SELECT COUNT(*) FROM TBL_TTPDGMSTS P WHERE P.NGAY_HOAN_THANH <= DATE_ADD(P.NGAY_THU_LY, INTERVAL " + StringUtils.HANXULY.TTPDGMSTS.getValue() + " DAY) AND (P.NGAY_THU_LY BETWEEN '" + sFrom + "' AND '" + sTo + "') AND P.TRANG_THAI = 3";
//				log.debug(sqlQuery);
//				SQLQuery query = session.createSQLQuery(sqlQuery);
//				count = Long.parseLong(query.list().get(0).toString());
				String queryString = "SELECT COUNT(*) FROM TblTtpdgmsts a WHERE a.created BETWEEN :from AND :to AND a.trangThai = 3 and a.ngayHenTra >= a.ngayHoanThanh";
				Query query = session.createQuery (queryString);
				query.setDate("from", dFrom);
				query.setDate("to", dTo);
				count = ((Long)query.uniqueResult()).longValue();
			}
		} catch (Exception e) {
			log.error("fail countHoSoDungHen");
			e.printStackTrace();
		}
		return count;
	}
	
	public Long countHoSoTreHen(Date from, Date to, String code) {
		log.debug("Call countHoSoTreHen");
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("code: " + code);
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long count = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
//			String sFrom = dateFormat.format(dFrom);
//			String sTo = dateFormat.format(dTo);
			if ("TTCGCNDKMSXDCB".equals(code)) {
//				String sqlQuery = "SELECT COUNT(*) FROM TBL_TTCGCNDKMSXDCB P WHERE P.NGAY_HOAN_THANH > DATE_ADD(P.NGAY_THU_LY, INTERVAL " + StringUtils.HANXULY.TTCGCNDKMSXDCB.getValue() + " DAY) AND (P.NGAY_THU_LY BETWEEN '" + sFrom + "' AND '" + sTo + "') AND P.TRANG_THAI = 3";
//				log.debug(sqlQuery);
//				SQLQuery query = session.createSQLQuery(sqlQuery);
//				count = Long.parseLong(query.list().get(0).toString());
				String queryString = "SELECT COUNT(*) FROM TblTtcgcndkmsxdcb a WHERE a.created BETWEEN :from AND :to AND a.trangThai = 3 and a.ngayHenTra < a.ngayHoanThanh";
				Query query = session.createQuery (queryString);
				query.setDate("from", from);
				query.setDate("to", to);
				count = ((Long)query.uniqueResult()).longValue();
			} else if ("TTCMSDVSDNS".equals(code)) {
//				String sqlQuery = "SELECT COUNT(*) FROM TBL_TTCMSDVSDNS P WHERE P.NGAY_HOAN_THANH > DATE_ADD(P.NGAY_THU_LY, INTERVAL " + StringUtils.HANXULY.TTCMSDVSDNS.getValue() + " DAY) AND (P.NGAY_THU_LY BETWEEN '" + sFrom + "' AND '" + sTo + "') AND P.TRANG_THAI = 3";
//				log.debug(sqlQuery);
//				SQLQuery query = session.createSQLQuery(sqlQuery);
//				count = Long.parseLong(query.list().get(0).toString());
				String queryString = "SELECT COUNT(*) FROM TblTtcmsdvsdns a WHERE a.created BETWEEN :from AND :to AND a.trangThai = 3 and a.ngayHenTra < a.ngayHoanThanh";
				Query query = session.createQuery (queryString);
				query.setDate("from", from);
				query.setDate("to", to);
				count = ((Long)query.uniqueResult()).longValue();
			} else if ("TTPAPBDTNS".equals(code)) {
//				String sqlQuery = "SELECT COUNT(*) FROM TBL_TTPAPBDTNS P WHERE P.NGAY_HOAN_THANH > DATE_ADD(P.NGAY_THU_LY, INTERVAL " + StringUtils.HANXULY.TTPAPBDTNS.getValue() + " DAY) AND (P.NGAY_THU_LY BETWEEN '" + sFrom + "' AND '" + sTo + "') AND P.TRANG_THAI = 3";
//				log.debug(sqlQuery);
//				SQLQuery query = session.createSQLQuery(sqlQuery);
//				count = Long.parseLong(query.list().get(0).toString());				
				String queryString = "SELECT COUNT(*) FROM TblTtpapbdtns a WHERE a.created BETWEEN :from AND :to AND a.trangThai = 3 and a.ngayHenTra < a.ngayHoanThanh";
				Query query = session.createQuery (queryString);
				query.setDate("from", from);
				query.setDate("to", to);
				count = ((Long)query.uniqueResult()).longValue();
			} else if ("TTPDGMSTS".equals(code)) {
//				String sqlQuery = "SELECT COUNT(*) FROM TBL_TTPDGMSTS P WHERE P.NGAY_HOAN_THANH > DATE_ADD(P.NGAY_THU_LY, INTERVAL " + StringUtils.HANXULY.TTPDGMSTS.getValue() + " DAY) AND (P.NGAY_THU_LY BETWEEN '" + sFrom + "' AND '" + sTo + "') AND P.TRANG_THAI = 3";
//				log.debug(sqlQuery);
//				SQLQuery query = session.createSQLQuery(sqlQuery);
//				count = Long.parseLong(query.list().get(0).toString());
				String queryString = "SELECT COUNT(*) FROM TblTtpdgmsts a WHERE a.created BETWEEN :from AND :to AND a.trangThai = 3 and a.ngayHenTra < a.ngayHoanThanh";
				Query query = session.createQuery (queryString);
				query.setDate("from", from);
				query.setDate("to", to);
				count = ((Long)query.uniqueResult()).longValue();
			}
		} catch (Exception e) {
			log.error("fail countHoSoTreHen");
			e.printStackTrace();
		}
		return count;
	}
	
	public Long countHoSo(Date from, Date to, String code, Byte trangThai) {
		log.debug("Call countHoSo");
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("code: " + code);
		log.debug("trangThai: " + trangThai);
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long count = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
//			String sFrom = dateFormat.format(dFrom);
//			String sTo = dateFormat.format(dTo);
			if ("TTCGCNDKMSXDCB".equals(code)) {
//				String sqlQuery = "SELECT COUNT(*) FROM TBL_TTCGCNDKMSXDCB P WHERE P.CREATED BETWEEN '" + sFrom + "' AND '" + sTo + "'";
//				if ((trangThai != null) && (trangThai.longValue()>0)) {
//					sqlQuery = sqlQuery + " AND P.TRANG_THAI = " + trangThai.toString();
//				}
//				log.debug(sqlQuery);
//				SQLQuery query = session.createSQLQuery(sqlQuery);
//				count = Long.parseLong(query.list().get(0).toString());
				String queryString = "SELECT COUNT(*) FROM TblTtcgcndkmsxdcb a WHERE a.created BETWEEN :from AND :to AND a.trangThai = :trangThai and a.status = 1";
				Query query = session.createQuery (queryString);
				query.setDate("from", from);
				query.setDate("to", to);
				query.setByte("trangThai", trangThai);
				count = ((Long)query.uniqueResult()).longValue();
			} else if ("TTCMSDVSDNS".equals(code)) {
//				String sqlQuery = "SELECT COUNT(*) FROM TBL_TTCMSDVSDNS P WHERE P.CREATED BETWEEN '" + sFrom + "' AND '" + sTo + "'";
//				if ((trangThai != null) && (trangThai.longValue()>0)) {
//					sqlQuery = sqlQuery + " AND P.TRANG_THAI = " + trangThai.toString();
//				}
//				log.debug(sqlQuery);
//				SQLQuery query = session.createSQLQuery(sqlQuery);
//				count = Long.parseLong(query.list().get(0).toString());
				String queryString = "SELECT COUNT(*) FROM TblTtcmsdvsdns a WHERE a.created BETWEEN :from AND :to AND a.trangThai = :trangThai and a.status = 1";
				Query query = session.createQuery (queryString);
				query.setDate("from", from);
				query.setDate("to", to);
				query.setByte("trangThai", trangThai);
				count = ((Long)query.uniqueResult()).longValue();
			} else if ("TTPAPBDTNS".equals(code)) {
//				String sqlQuery = "SELECT COUNT(*) FROM TBL_TTPAPBDTNS P WHERE P.CREATED BETWEEN '" + sFrom + "' AND '" + sTo + "'";
//				if ((trangThai != null) && (trangThai.longValue()>0)) {
//					sqlQuery = sqlQuery + " AND P.TRANG_THAI = " + trangThai.toString();
//				}
//				log.debug(sqlQuery);
//				SQLQuery query = session.createSQLQuery(sqlQuery);
//				count = Long.parseLong(query.list().get(0).toString());
				String queryString = "SELECT COUNT(*) FROM TblTtpapbdtns a WHERE a.created BETWEEN :from AND :to AND a.trangThai = :trangThai and a.status = 1";
				Query query = session.createQuery (queryString);
				query.setDate("from", from);
				query.setDate("to", to);
				query.setByte("trangThai", trangThai);
				count = ((Long)query.uniqueResult()).longValue();
			} else if ("TTPDGMSTS".equals(code)) {
//				String sqlQuery = "SELECT COUNT(*) FROM TBL_TTPDGMSTS P WHERE P.CREATED BETWEEN '" + sFrom + "' AND '" + sTo + "'";
//				if ((trangThai != null) && (trangThai.longValue()>0)) {
//					sqlQuery = sqlQuery + " AND P.TRANG_THAI = " + trangThai.toString();
//				}
//				log.debug(sqlQuery);
//				SQLQuery query = session.createSQLQuery(sqlQuery);
//				count = Long.parseLong(query.list().get(0).toString());
				String queryString = "SELECT COUNT(*) FROM TblTtpdgmsts a WHERE a.created BETWEEN :from AND :to AND a.trangThai = :trangThai and a.status = 1";
				Query query = session.createQuery (queryString);
				query.setDate("from", from);
				query.setDate("to", to);
				query.setByte("trangThai", trangThai);
				count = ((Long)query.uniqueResult()).longValue();
			}
		} catch (Exception e) {
			log.error("fail countHoSo");
			e.printStackTrace();
		}
		return count;
	}
	
	public Long countHoSo(Date from, Date to, String code, Collection<Byte> trangThais) {
		log.debug("Call countHoSo");
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("TrangThais: " + trangThais.toString());
		Long count = null;
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			if ("TTCGCNDKMSXDCB".equals(code)) {
				String queryString = "SELECT COUNT(*) FROM TblTtcgcndkmsxdcb a WHERE a.created BETWEEN :from AND :to AND a.trangThai IN (:trangThais) and a.status = 1";
				Query query = session.createQuery (queryString);
				query.setDate("from", from);
				query.setDate("to", to);
				query.setParameterList("trangThais", trangThais);
				count = ((Long)query.uniqueResult()).longValue();
			} else if ("TTCMSDVSDNS".equals(code)) {				
				String queryString = "SELECT COUNT(*) FROM TblTtcmsdvsdns a WHERE a.created BETWEEN :from AND :to AND a.trangThai IN (:trangThais) and a.status = 1";
				Query query = session.createQuery (queryString);
				query.setDate("from", from);
				query.setDate("to", to);
				query.setParameterList("trangThais", trangThais);
				count = ((Long)query.uniqueResult()).longValue();
			} else if ("TTPAPBDTNS".equals(code)) {
				String queryString = "SELECT COUNT(*) FROM TblTtpapbdtns a WHERE a.created BETWEEN :from AND :to AND a.trangThai IN (:trangThais) and a.status = 1";
				Query query = session.createQuery (queryString);
				query.setDate("from", from);
				query.setDate("to", to);
				query.setParameterList("trangThais", trangThais);
				count = ((Long)query.uniqueResult()).longValue();
			} else if ("TTPDGMSTS".equals(code)) {
				String queryString = "SELECT COUNT(*) FROM TblTtpdgmsts a WHERE a.created BETWEEN :from AND :to AND a.trangThai IN (:trangThais) and a.status = 1";
				Query query = session.createQuery (queryString);
				query.setDate("from", from);
				query.setDate("to", to);
				query.setParameterList("trangThais", trangThais);
				count = ((Long)query.uniqueResult()).longValue();
			}
		} catch (Exception e) {
			log.error("fail countHoSo");
			e.printStackTrace();
		}
		log.debug("count: " + count);
		return count;
	}
	
	public List<DichVuCongBean> getTheoDoi(Long userId, String loaidvc, Byte trangThai, Date from, Date to, String query, String radioDate) {
		log.debug("Call getXuLy List<DichVuCongBean>");
		List<DichVuCongBean> list = new ArrayList<DichVuCongBean>();
		log.debug("userId: " + userId);
		log.debug("loaidvc: " + loaidvc);
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + query);
		log.debug("radioDate: " + radioDate);
		try {
			if ((loaidvc == null) || ("TTCGCNDKMSXDCB".equals(loaidvc))) {
				List<TblTtcgcndkmsxdcb> listTtcgcndkmsxdcb = getTtcgcndkmsxdcbTheoDoi(userId, trangThai, from, to, query, radioDate);
				for (TblTtcgcndkmsxdcb object: listTtcgcndkmsxdcb) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTCGCNDKMSXDCB");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtcgcndkmsxdcbId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getTenDuAn());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTCMSDVSDNS".equals(loaidvc))) {
				List<TblTtcmsdvsdns> listTtcmsdvsdns = getTtcmsdvsdnsTheoDoi(userId, trangThai, from, to, query, radioDate);
				for (TblTtcmsdvsdns object: listTtcmsdvsdns) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTCMSDVSDNS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtcmsdvsdnsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getNoiDung());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTPAPBDTNS".equals(loaidvc))) {
				List<TblTtpapbdtns> listTtpapbdtns = getTtpapbdtnsTheoDoi(userId, trangThai, from, to, query, radioDate);
				for (TblTtpapbdtns object: listTtpapbdtns) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTPAPBDTNS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtpapbdtnsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getNoiDung());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
			
			if ((loaidvc == null) || ("TTPDGMSTS".equals(loaidvc))) {
				List<TblTtpdgmsts> listTtpdgmsts = getTtpdgmstsTheoDoi(userId, trangThai, from, to, query, radioDate);
				for (TblTtpdgmsts object: listTtpdgmsts) {
					DichVuCongBean dvcBean = new DichVuCongBean();
					dvcBean.setCode("TTPDGMSTS");
					dvcBean.setNgayGoi(object.getModified());
					dvcBean.setId(object.getTtpdgmstsId());
					dvcBean.setTenNguoiGoi(object.getTblCongDan().getTen());
					dvcBean.setTenToChuc(object.getTblToChuc().getTenCoQuan());
					dvcBean.setTrangThai(object.getTrangThai());
					dvcBean.setLanSua(object.getLanSua());
					dvcBean.setNoiDung(object.getNoiDung());
					
					dvcBean.setNgayThuLy(object.getNgayThuLy());
					dvcBean.setNgayXuLy(object.getNgayXuLy());
					dvcBean.setNgayHoanThanh(object.getNgayHoanThanh());
					dvcBean.setNgayHenTra(object.getNgayHenTra());
					list.add(dvcBean);
				}
			}
		} catch (RuntimeException re) {
			list = new ArrayList<DichVuCongBean>();
			log.error("getXuLy List<DichVuCongBean> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	private List<TblTtcgcndkmsxdcb> getTtcgcndkmsxdcbTheoDoi(Long usersId, Byte trangThai, Date from, Date to, String sQuery, String radioDate) {
		log.debug("Call getTtcgcndkmsxdcbTiepNhan List<TblTtcgcndkmsxdcb>");
		log.debug("usersId: " + usersId);
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + sQuery);
		log.debug("radioDate: " + radioDate);
		List<TblTtcgcndkmsxdcb> list = new ArrayList<TblTtcgcndkmsxdcb>();
		
		try {
			String querySelectString = "SELECT a.tblTtcgcndkmsxdcb FROM TblTtcgcndkmsxdcbChuyenhs a ";
			String queryWhereString = "WHERE a.tblUsersByUsersChuyenId.usersId = :usersId ";
			String queryOrderString = "";
			String queryGroupByString = "GROUP BY a.tblTtcgcndkmsxdcb.ttcgcndkmsxdcbId ";
			if ("2".equals(radioDate)) {
				queryWhereString = queryWhereString + "AND a.tblTtcgcndkmsxdcb.ngayThuLy between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtcgcndkmsxdcb.ngayThuLy ";
			} else if ("3".equals(radioDate)) {
				queryWhereString = queryWhereString + "AND a.tblTtcgcndkmsxdcb.ngayHenTra between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtcgcndkmsxdcb.ngayHenTra ";
			} else if ("4".equals(radioDate)) {
				queryWhereString = queryWhereString + "AND a.tblTtcgcndkmsxdcb.ngayHoanThanh between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtcgcndkmsxdcb.ngayHoanThanh ";
			} else {
				queryWhereString = queryWhereString + "AND a.tblTtcgcndkmsxdcb.modified between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtcgcndkmsxdcb.modified ";
			}
			
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				queryWhereString = queryWhereString + "AND a.tblTtcgcndkmsxdcb.trangThai = :trangThai ";
			}
			
			if ((sQuery != null) && (!"".equals(sQuery))) {
				queryWhereString = queryWhereString + "AND ((a.tblTtcgcndkmsxdcb.tblCongDan.ten like :sQuery) or (a.tblTtcgcndkmsxdcb.tblToChuc.tenCoQuan like :sQuery) or (a.tblTtcgcndkmsxdcb.tenDuAn like :sQuery)) ";
			}
			
			String queryString = querySelectString + queryWhereString + queryGroupByString + queryOrderString;;
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			log.debug("queryString: " + queryString);
			Query query = session.createQuery(queryString);
			query.setLong("usersId", usersId);
			query.setDate("from", from);
			query.setDate("to", to);
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				query.setByte("trangThai", trangThai);
			}
			if ((sQuery != null) && (!"".equals(sQuery))) {
				query.setString("sQuery", "%" + sQuery + "%");
			}
			list = query.list();
		} catch (RuntimeException re) {
			log.error("getTtcgcndkmsxdcbTiepNhan List<TblTtcgcndkmsxdcb> failed", re);
		}
		
		log.debug("list.size(): " + list.size());

		return list;
	}
	
	private List<TblTtcmsdvsdns> getTtcmsdvsdnsTheoDoi(Long usersId, Byte trangThai, Date from, Date to, String sQuery, String radioDate) {
		log.debug("Call getTtcmsdvsdnsTiepNhan List<TblTtcmsdvsdns>");
		log.debug("usersId: " + usersId);
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + sQuery);
		log.debug("radioDate: " + radioDate);
		List<TblTtcmsdvsdns> list = new ArrayList<TblTtcmsdvsdns>();
		try {
			String querySelectString = "SELECT a.tblTtcmsdvsdns FROM TblTtcmsdvsdnsChuyenhs a ";
			String queryWhereString = "WHERE a.tblUsersByUsersChuyenId.usersId = :usersId ";
			String queryOrderString = "";
			String queryGroupByString = "GROUP BY a.tblTtcmsdvsdns.ttcmsdvsdnsId ";
			if ("2".equals(radioDate)) {
				queryWhereString = queryWhereString + "AND a.tblTtcmsdvsdns.ngayThuLy between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtcmsdvsdns.ngayThuLy ";
			} else if ("3".equals(radioDate)) {
				queryWhereString = queryWhereString + "AND a.tblTtcmsdvsdns.ngayHenTra between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtcmsdvsdns.ngayHenTra ";
			} else if ("4".equals(radioDate)) {
				queryWhereString = queryWhereString + "AND a.tblTtcmsdvsdns.ngayHoanThanh between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtcmsdvsdns.ngayHoanThanh ";
			} else {
				queryWhereString = queryWhereString + "AND a.tblTtcmsdvsdns.modified between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtcmsdvsdns.modified ";
			}
			
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				queryWhereString = queryWhereString + "AND a.tblTtcmsdvsdns.trangThai = :trangThai ";
			}
			
			if ((sQuery != null) && (!"".equals(sQuery))) {
				queryWhereString = queryWhereString + "AND ((a.tblTtcmsdvsdns.tblCongDan.ten like :sQuery) or (a.tblTtcmsdvsdns.tblToChuc.tenCoQuan like :sQuery) or (a.tblTtcmsdvsdns.noiDung like :sQuery)) ";
			}
			
			String queryString = querySelectString + queryWhereString + queryGroupByString + queryOrderString;
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			log.debug("queryString: " + queryString);
			Query query = session.createQuery(queryString);
			query.setLong("usersId", usersId);
			query.setDate("from", from);
			query.setDate("to", to);
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				query.setByte("trangThai", trangThai);
			}
			if ((sQuery != null) && (!"".equals(sQuery))) {
				query.setString("sQuery", "%" + sQuery + "%");
			}
			list = query.list();
		} catch (RuntimeException re) {
			log.error("getTtcmsdvsdnsTiepNhan List<TblTtcmsdvsdns> failed", re);
		}
		
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	private List<TblTtpapbdtns> getTtpapbdtnsTheoDoi(Long usersId, Byte trangThai, Date from, Date to, String sQuery, String radioDate) {
		log.debug("Call getTtpapbdtnsTiepNhan List<TblTtpapbdtns>");
		log.debug("usersId: " + usersId);
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + sQuery);
		log.debug("radioDate: " + radioDate);
		List<TblTtpapbdtns> list = new ArrayList<TblTtpapbdtns>();
		try {
			String querySelectString = "SELECT a.tblTtpapbdtns FROM TblTtpapbdtnsChuyenhs a ";
			String queryWhereString = "WHERE a.tblUsersByUsersChuyenId.usersId = :usersId ";
			String queryOrderString = "";
			String queryGroupByString = "GROUP BY a.tblTtpapbdtns.ttpapbdtnsId ";
			if ("2".equals(radioDate)) {
				queryWhereString = queryWhereString + "AND a.tblTtpapbdtns.ngayThuLy between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtpapbdtns.ngayThuLy ";
			} else if ("3".equals(radioDate)) {
				queryWhereString = queryWhereString + "AND a.tblTtpapbdtns.ngayHenTra between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtpapbdtns.ngayHenTra ";
			} else if ("4".equals(radioDate)) {
				queryWhereString = queryWhereString + "AND a.tblTtpapbdtns.ngayHoanThanh between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtpapbdtns.ngayHoanThanh ";
			} else {
				queryWhereString = queryWhereString + "AND a.tblTtpapbdtns.modified between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtpapbdtns.modified ";
			}
			
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				queryWhereString = queryWhereString + "AND a.tblTtpapbdtns.trangThai = :trangThai ";
			}
			
			if ((sQuery != null) && (!"".equals(sQuery))) {
				queryWhereString = queryWhereString + "AND ((a.tblTtpapbdtns.tblCongDan.ten like :sQuery) or (a.tblTtpapbdtns.tblToChuc.tenCoQuan like :sQuery) or (a.tblTtpapbdtns.noiDung like :sQuery)) ";
			}
			
			String queryString = querySelectString + queryWhereString + queryGroupByString + queryOrderString;
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			log.debug("queryString: " + queryString);
			Query query = session.createQuery(queryString);
			query.setLong("usersId", usersId);
			query.setDate("from", from);
			query.setDate("to", to);
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				query.setByte("trangThai", trangThai);
			}
			if ((sQuery != null) && (!"".equals(sQuery))) {
				query.setString("sQuery", "%" + sQuery + "%");
			}
			list = query.list();
		} catch (RuntimeException re) {
			log.error("getTtpapbdtnsTiepNhan List<TblTtpapbdtns> failed", re);
		}
		
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	private List<TblTtpdgmsts> getTtpdgmstsTheoDoi(Long usersId, Byte trangThai, Date from, Date to, String sQuery, String radioDate) {
		log.debug("Call getTtpdgmstsTiepNhan List<TblTtpdgmsts>");
		log.debug("usersId: " + usersId);
		log.debug("trangThai: " + trangThai);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("query: " + sQuery);
		log.debug("radioDate: " + radioDate);
		List<TblTtpdgmsts> list = new ArrayList<TblTtpdgmsts>();
		try {
			String querySelectString = "SELECT a.tblTtpdgmsts FROM TblTtpdgmstsChuyenhs a ";
			String queryWhereString = "WHERE a.tblUsersByUsersChuyenId.usersId = :usersId ";
			String queryOrderString = "";
			String queryGroupByString = "GROUP BY a.tblTtpdgmsts.ttpdgmstsId ";
			if ("2".equals(radioDate)) {
				queryWhereString = queryWhereString + "AND a.tblTtpdgmsts.ngayThuLy between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtpdgmsts.ngayThuLy ";
			} else if ("3".equals(radioDate)) {
				queryWhereString = queryWhereString + "AND a.tblTtpdgmsts.ngayHenTra between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtpdgmsts.ngayHenTra ";
			} else if ("4".equals(radioDate)) {
				queryWhereString = queryWhereString + "AND a.tblTtpdgmsts.ngayHoanThanh between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtpdgmsts.ngayHoanThanh ";
			} else {
				queryWhereString = queryWhereString + "AND a.tblTtpdgmsts.modified between :from and :to ";
				queryOrderString = "ORDER BY a.tblTtpdgmsts.modified ";
			}
			
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				queryWhereString = queryWhereString + "AND a.tblTtpdgmsts.trangThai = :trangThai ";
			}
			
			if ((sQuery != null) && (!"".equals(sQuery))) {
				queryWhereString = queryWhereString + "AND ((a.tblTtpdgmsts.tblCongDan.ten like :sQuery) or (a.tblTtpdgmsts.tblToChuc.tenCoQuan like :sQuery) or (a.tblTtpdgmsts.noiDung like :sQuery)) ";
			}
			
			String queryString = querySelectString + queryWhereString + queryGroupByString + queryOrderString;
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			log.debug("queryString: " + queryString);
			Query query = session.createQuery(queryString);
			query.setLong("usersId", usersId);
			query.setDate("from", from);
			query.setDate("to", to);
			if ((trangThai != null) && (trangThai.byteValue() > 0)) {
				query.setByte("trangThai", trangThai);
			}
			if ((sQuery != null) && (!"".equals(sQuery))) {
				query.setString("sQuery", "%" + sQuery + "%");
			}
			list = query.list();
		} catch (RuntimeException re) {
			log.error("getTtpdgmstsTiepNhan List<TblTtpdgmsts> failed", re);
		}
		
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	public static void main(String[] args) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date from = format.parse("01/01/2012 00:00:01");;
		Date to = format.parse("31/12/2012 23:59:59");;
		DichVuCongDao dao = new DichVuCongDao();
/*		
		List<TblTtcgcndkmsxdcb> list = dao.getTtcgcndkmsxdcbTheoDoi((long)1, (byte)3, from, to, "ABC", "2");
		log.debug("size: " + list.size());		
		for (TblTtcgcndkmsxdcb ttcgcndkmsxdcb : list) {
			log.debug("TtcgcndkmsxdcbId: " + ttcgcndkmsxdcb.getTtcgcndkmsxdcbId());
			log.debug("NgayThuLy: " + ttcgcndkmsxdcb.getNgayThuLy());
			log.debug("NgayHenTra: " + ttcgcndkmsxdcb.getNgayHenTra());
			log.debug("NgayHoanThanh: " + ttcgcndkmsxdcb.getNgayHoanThanh());
			log.debug("Modified: " + ttcgcndkmsxdcb.getModified());
			log.debug("TrangThai: " + ttcgcndkmsxdcb.getTrangThai());			
			log.debug("TenDuAn: " + ttcgcndkmsxdcb.getTenDuAn());
			log.debug("Ten Cong Dan: " + ttcgcndkmsxdcb.getTblCongDan().getTen());
			log.debug("TenCoQuan: " + ttcgcndkmsxdcb.getTblToChuc().getTenCoQuan());
		}
*/
/*
		List<TblTtcmsdvsdns> list = dao.getTtcmsdvsdnsTheoDoi((long)1, (byte)3, from, to, "chuc", "2");
		log.debug("size: " + list.size());		
		for (TblTtcmsdvsdns ttcmsdvsdns : list) {
			log.debug("TtcmsdvsdnsId: " + ttcmsdvsdns.getTtcmsdvsdnsId());
			log.debug("NgayThuLy: " + ttcmsdvsdns.getNgayThuLy());
			log.debug("NgayHenTra: " + ttcmsdvsdns.getNgayHenTra());
			log.debug("NgayHoanThanh: " + ttcmsdvsdns.getNgayHoanThanh());
			log.debug("Modified: " + ttcmsdvsdns.getModified());
			log.debug("TrangThai: " + ttcmsdvsdns.getTrangThai());			
			log.debug("NoiDung: " + ttcmsdvsdns.getNoiDung());
			log.debug("Ten Cong Dan: " + ttcmsdvsdns.getTblCongDan().getTen());
			log.debug("TenCoQuan: " + ttcmsdvsdns.getTblToChuc().getTenCoQuan());
		}
*/
/*		
		List<TblTtpapbdtns> list = dao.getTtpapbdtnsTheoDoi((long)1, null, from, to, null, "2");
		log.debug("size: " + list.size());		
		for (TblTtpapbdtns ttpapbdtns : list) {
			log.debug("TtcmsdvsdnsId: " + ttpapbdtns.getTtpapbdtnsId());
			log.debug("NgayThuLy: " + ttpapbdtns.getNgayThuLy());
			log.debug("NgayHenTra: " + ttpapbdtns.getNgayHenTra());
			log.debug("NgayHoanThanh: " + ttpapbdtns.getNgayHoanThanh());
			log.debug("Modified: " + ttpapbdtns.getModified());
			log.debug("TrangThai: " + ttpapbdtns.getTrangThai());			
			log.debug("NoiDung: " + ttpapbdtns.getNoiDung());
			log.debug("Ten Cong Dan: " + ttpapbdtns.getTblCongDan().getTen());
			log.debug("TenCoQuan: " + ttpapbdtns.getTblToChuc().getTenCoQuan());
		}
*/		
/*		
		List<TblTtpdgmsts> list = dao.getTtpdgmstsTheoDoi((long)1, null, from, to, null, "2");
		log.debug("size: " + list.size());		
		for (TblTtpdgmsts ttpdgmsts : list) {
			log.debug("TtcmsdvsdnsId: " + ttpdgmsts.getTtpdgmstsId());
			log.debug("NgayThuLy: " + ttpdgmsts.getNgayThuLy());
			log.debug("NgayHenTra: " + ttpdgmsts.getNgayHenTra());
			log.debug("NgayHoanThanh: " + ttpdgmsts.getNgayHoanThanh());
			log.debug("Modified: " + ttpdgmsts.getModified());
			log.debug("TrangThai: " + ttpdgmsts.getTrangThai());			
			log.debug("NoiDung: " + ttpdgmsts.getNoiDung());
			log.debug("Ten Cong Dan: " + ttpdgmsts.getTblCongDan().getTen());
			log.debug("TenCoQuan: " + ttpdgmsts.getTblToChuc().getTenCoQuan());
		}
*/		
		List<DichVuCongBean> list = dao.getTheoDoi((long)1, null, null, from, to, null, "2");
		Collections.sort(list,new DichVuCongComparator());
		log.debug("Total size: " + list.size());
		for (DichVuCongBean dvc : list) {
			log.debug("============================================================");
			log.debug("Code: " + dvc.getCode());
			log.debug("id: " + dvc.getId());
			log.debug("TenNguoiGoi: " + dvc.getTenNguoiGoi());
			log.debug("TenToChuc: " + dvc.getTenToChuc());
			log.debug("TrangThai: " + dvc.getTrangThai());
			log.debug("NoiDung: " + dvc.getNoiDung());
			
			log.debug("NgayThuLy: " + dvc.getNgayThuLy());
			log.debug("NgayHenTra: " + dvc.getNgayHenTra());
			log.debug("NgayHoanThanh: " + dvc.getNgayHoanThanh());
		}
	}
}
