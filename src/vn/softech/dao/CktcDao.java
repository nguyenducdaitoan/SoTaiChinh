package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblCktc;
import vn.softech.hibernate.TblCktcCm;

public class CktcDao {
	private static Logger log = Logger.getLogger(CktcDao.class);
	
	public List<TblCktcCm> getCktcCm() {
		log.debug("Call get List<TblCktcCm>");
		List<TblCktcCm> list = new ArrayList<TblCktcCm>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblCktcCm.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("hienThi"));
			criteria.addOrder(Order.asc("priority"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGioiThieu> failed", re);
		}
		return list;
	}
	public List<TblCktc> getCktcByCHuyenMuc(int rowOfPage, int page, Long cktcCmId) {
		List<TblCktc> list = new ArrayList<TblCktc>();
		log.debug("Call get List<TblTthc>");
		if(cktcCmId == null){
			return list;
		}
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countCm(cktcCmId);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		log.debug("totalPage: " + totalPage);
		if (page > totalPage) page = 1;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblCktc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("tblCktcCm.cktcCmId", cktcCmId));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblCktc> failed", re);
		}
		return list;
	}

	public List<TblCktc> getCktcPage(int rowOfPage, int page) {
		List<TblCktc> list = new ArrayList<TblCktc>();
		log.debug("Call get List<TblTthc>");

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
		log.debug("totalPage: " + totalPage);
		if (page > totalPage) page = 1;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblCktc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblCktc> failed", re);
		}
		return list;
	}
	public Long countAll() throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblCktc t where t.status = 1");
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}	
	public Long countCm(Long cktcCmId) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblCktc t where t.tblCktcCm.cktcCmId = :cktcCmId and t.status = 1");
		query.setLong("cktcCmId", cktcCmId);
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	public List<TblCktcCm> getCktcCmHienThi() {
		log.debug("Call get List<TblCktcCm>");
		List<TblCktcCm> list = new ArrayList<TblCktcCm>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblCktcCm.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("hienThi", true));
//			criteria.addOrder(Order.desc("hienThi"));
			criteria.addOrder(Order.asc("priority"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGioiThieu> failed", re);
		}
		return list;
	}
	
	public List<TblCktc> getCktc() {
		log.debug("Call get List<TblCktc>");
		List<TblCktc> list = new ArrayList<TblCktc>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblCktc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("ngayPd"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGioiThieu> failed", re);
		}
		return list;
	}
	
	public List<TblCktc> getCktcActive() {
		log.debug("Call get List<TblCktc>");
		List<TblCktc> list = new ArrayList<TblCktc>();
		List<TblCktcCm> listCktcCm = getCktcCmActive();
		for (TblCktcCm cktcCm: listCktcCm) {
			if ((cktcCm != null) && (cktcCm.getCktcCmId() > 0)) {
				List<TblCktc> listsub = getCktcByCktcCmId(cktcCm.getCktcCmId());
				if ((listsub != null) && (listsub.size() > 0)) {
					list.addAll(listsub);
				}
			}
		}
/*		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblCktc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("ngayPd"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGioiThieu> failed", re);
		}
*/		
		return list;
	}
	
	public List<TblCktc> getCktcByCktcCmId(Long cktcCmId) {
		log.debug("Call get List<TblCktc>");
		List<TblCktc> list = new ArrayList<TblCktc>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblCktc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("tblCktcCm.cktcCmId", cktcCmId));
			criteria.addOrder(Order.desc("ngayPd"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGioiThieu> failed", re);
		}
		return list;
	}
	
	public List<TblCktcCm> getCktcCmActive() {
		log.debug("Call get List<TblCktcCm>");
		List<TblCktcCm> list = new ArrayList<TblCktcCm>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblCktcCm.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("hienThi", true));
			criteria.addOrder(Order.asc("priority"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGioiThieu> failed", re);
		}
		return list;
	}
	
	public Long save(TblCktcCm object) {
		log.debug("Call save TblCktcCm");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblCktcCm", e);
		}
		return returnId;
	}
	
	public Long save(TblCktc object) {
		log.debug("Call save TblCktc");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblCktc", e);
		}
		return returnId;
	}
	
	public TblCktcCm getCktcCm(Long cktcCmId) {
		log.debug("Call getCktcCm TblCktcCm with: " + cktcCmId);
		TblCktcCm object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblCktcCm.class);
			criteria.add(Restrictions.eq("cktcCmId", cktcCmId));
			criteria.add(Restrictions.eq("status", (byte)1));
			object = (TblCktcCm)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblCktcCm", e);
		}
		return object;
	}
	
	public TblCktc getCktc(Long cktcId) {
		log.debug("Call getCktc TblCktc with: " + cktcId);
		TblCktc object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblCktc.class);
			criteria.add(Restrictions.eq("cktcId", cktcId));
			criteria.add(Restrictions.eq("status", (byte)1));
			object = (TblCktc)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblCktcCm", e);
		}
		return object;
	}
	
	public void update(TblCktc object) throws Exception {
		log.debug("Call update TblCktc");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblCktc", e);
			throw e;
		}
	}
	
	public void update(TblCktcCm object) throws Exception {
		log.debug("Call update TblCktcCm");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblCktcCm", e);
			throw e;
		}
	}
}
