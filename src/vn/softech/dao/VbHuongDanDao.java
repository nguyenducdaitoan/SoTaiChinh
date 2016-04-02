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
import org.hibernate.exception.GenericJDBCException;

import vn.softech.hibernate.TblTinTuc;
import vn.softech.hibernate.TblTthc;
import vn.softech.hibernate.TblVbHuongDan;

public class VbHuongDanDao {
	private static Logger log = Logger.getLogger(VbHuongDanDao.class);
	
	public List<TblVbHuongDan> get() {
		log.debug("Call get List<TblVbHuongDan>");
		List<TblVbHuongDan> list = new ArrayList<TblVbHuongDan>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbHuongDan.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblVbHuongDan> failed", e);
		}
		return list;
	}
	/**
	 * get tất cả status
	 * @return
	 */
	public List<TblVbHuongDan> getall() {
		log.debug("Call get List<TblVbHuongDan>");
		List<TblVbHuongDan> list = new ArrayList<TblVbHuongDan>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbHuongDan.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblVbHuongDan> failed", e);
		}
		return list;
	}
	
	public List<TblVbHuongDan> getSearch(String sQuery, int rowOfPage, int page) {
		log.debug("Call getSearch List<TblTthc>");
		List<TblVbHuongDan> list = new ArrayList<TblVbHuongDan>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countSearch(sQuery);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbHuongDan.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			if ((sQuery != null) && (!"".equals(sQuery))) {
				log.debug("query is not null");
				Disjunction disjunction = Restrictions.disjunction();
				disjunction.add(Restrictions.like("title", "%" + sQuery + "%"));
				disjunction.add(Restrictions.like("summary", "%" + sQuery + "%"));
				disjunction.add(Restrictions.like("content", "%" + sQuery + "%"));
				criteria.add(disjunction);
			}
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getSearch List<TblTthc> failed", re);
		}
		return list;
	}
	
	public Long save(TblVbHuongDan object) {
		log.debug("Call save TblVbHuongDan");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail save TblVbHuongDan", e);
		}
		return returnId;
	}
	
	public TblVbHuongDan get(Long vbHuongDanId) {
		log.debug("Call get TblVbHuongDan with: " + vbHuongDanId);
		TblVbHuongDan object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbHuongDan.class);
			criteria.add(Restrictions.eq("vbHuongDanId", vbHuongDanId));
			object = (TblVbHuongDan)criteria.list().get(0);
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail get TblVbHuongDan", e);
		}
		return object;
	}
	
	public void update(TblVbHuongDan object) throws Exception {
		log.debug("Call update TblVbHuongDan");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail update TblVbHuongDan", e);
			throw e;
		}
	}
	
	public String updateBatch(String arrvbHuongDanId) {
		String sReturn = "";
		String[] vbHuongDanIds = arrvbHuongDanId.split(",");
		log.debug("vbHuongDanIds.length: " + vbHuongDanIds.length);
		for (int i = 0; i<vbHuongDanIds.length; i++) {
			Long vbHuongDanId = null;
			try {
				vbHuongDanId = Long.parseLong(vbHuongDanIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "vbHuongDanId = " + vbHuongDanIds[i] + " là không hợp lệ";
				vbHuongDanId = null;
			}
			if (vbHuongDanId != null) {
				TblVbHuongDan vbHuongDan = get(vbHuongDanId);
				if (vbHuongDan == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "Van Ban Id=" + vbHuongDanIds[i] + ": không tồn tại";
				} else {
					vbHuongDan.setStatus((byte)3);
					Date current = new Date();
					vbHuongDan.setModified(current);
					try {
						update(vbHuongDan);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn += "Lỗi phát sinh trong quá trình xóa vbHuongDanId: " + vbHuongDanIds[i];
					}
				}				
			}
		}
	
		return sReturn;
	}

	public Long countAll() {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblVbHuongDan t where t.status = 1");
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	
	public Long countSearch(String sQuery) {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(TblVbHuongDan.class);
		criteria.add(Restrictions.eq("status", (byte)1));
		if ((sQuery != null) && (!"".equals(sQuery))) {
			log.debug("query is not null");
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.like("title", "%" + sQuery + "%"));
			disjunction.add(Restrictions.like("summary", "%" + sQuery + "%"));
			disjunction.add(Restrictions.like("content", "%" + sQuery + "%"));
			criteria.add(disjunction);
		}
		count = (Long)criteria.uniqueResult();
		return count;
	}
	

	public List<TblVbHuongDan> getByPage(int rowOfPage, int page) {
		log.debug("Call get List<TblVbHuongDan>");
		List<TblVbHuongDan> list = new ArrayList<TblVbHuongDan>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countAll();
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch (GenericJDBCException e) {
			throw e;
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbHuongDan.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblVbHuongDan> failed", e);
		}
		return list;
	}
	
	public List<TblVbHuongDan> getTop(int numRecord) {
		log.debug("Call get List<TblVbHuongDan>");
		List<TblVbHuongDan> list = new ArrayList<TblVbHuongDan>();
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbHuongDan.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(numRecord);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblVbHuongDan> failed", e);
		}
		return list;
	}
}
