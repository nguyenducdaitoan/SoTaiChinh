package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblChuyenMuc;
import vn.softech.hibernate.TblHinhAnh;
import vn.softech.hibernate.TblThongBao;
import vn.softech.hibernate.TblTinTuc;

public class HinhAnhDao {
	private static Logger log = Logger.getLogger(HinhAnhDao.class);
	
	public List<TblHinhAnh> get() {
		log.debug("Call get List<TblHinhAnh>");
		List<TblHinhAnh> list = new ArrayList<TblHinhAnh>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblHinhAnh.class);
//			criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte)1));
//			criteria.addOrder(Order.desc("active"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblHinhAnh> failed", re);
		}
		return list;
	}
	
	public Integer save(TblHinhAnh object) {
		log.debug("Call save TblHinhAnh");
		Integer returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Integer)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblHinhAnh", e);
		}
		return returnId;
	}
	
	public TblHinhAnh get(Integer hinhAnhId) {
		log.debug("Call get TblHinhAnh with: " + hinhAnhId);
		TblHinhAnh object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblHinhAnh.class);
			criteria.add(Restrictions.eq("hinhAnhId", hinhAnhId));
			object = (TblHinhAnh)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblHinhAnh", e);
		}
		return object;
	}
	
	public void update(TblHinhAnh object) throws Exception {
		log.debug("Call update TblHinhAnh");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblHinhAnh", e);
			throw e;
		}
	}

	public String updateBatch(String arrHinhAnh) {
		String sReturn = "";
		String[] hinhAnhIds = arrHinhAnh.split(",");
		log.debug("hinhAnhIds.length: " + hinhAnhIds.length);
		for (int i = 0; i<hinhAnhIds.length; i++) {
			Integer hinhAnhId = null;
			try {
				hinhAnhId = Integer.parseInt(hinhAnhIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "hinhAnhId = " + hinhAnhIds[i] + " là không hợp lệ";
				hinhAnhId = null;
			}
			if (hinhAnhId != null) {
				TblHinhAnh hinhAnh = get(hinhAnhId);
				if (hinhAnh == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "hinhAnhId là " + hinhAnhIds[i] + " không tồn tại";
				} else {
					hinhAnh.setStatus((byte)3);
					Date current = new Date();
					hinhAnh.setModified(current);
					try {
						update(hinhAnh);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn += "Lỗi phát sinh trong quá trình xóa tinTucId: " + hinhAnhIds[i];
					}
				}				
			}
		}	
		return sReturn;
	}

	public Long countAll() throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblHinhAnh t where t.status = 1");
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	
	public Long countSearch(String sQuery) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(TblHinhAnh.class);
		criteria.add(Restrictions.eq("approved", (byte)1));
		if ((sQuery != null) && (!"".equals(sQuery))) {
			log.debug("query is not null");
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.like("title", "%" + sQuery + "%"));
			criteria.add(disjunction);
		}
		count = ((Long)criteria.uniqueResult()).longValue();
		return count;
	}

	public List<TblHinhAnh> getByPage(int rowOfPage, int page) {
		log.debug("Call get List<TblHinhAnh>");
		List<TblHinhAnh> list = new ArrayList<TblHinhAnh>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countAll();
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblHinhAnh.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblHinhAnh> failed", re);
		}
		return list;
	}
	//getListHinhAnhFooter
	public List<TblHinhAnh> getListHinhAnhFooter(int rowOfPage, int page) {
		log.debug("Call get List<TblHinhAnh>");
		List<TblHinhAnh> list = new ArrayList<TblHinhAnh>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countAll();
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblHinhAnh.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblHinhAnh> failed", re);
		}
		return list;
	}
	
}
