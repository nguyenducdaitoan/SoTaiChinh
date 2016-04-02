package vn.softech.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblDvcGopy;
import vn.softech.hibernate.TblTracking;

public class TrackingDao {
	private static Logger log = Logger.getLogger(TrackingDao.class);
	
	public Long save(TblTracking object) {
		log.debug("Call save TblTracking");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblTracking", e);
		}
		return returnId;
	}

	public List<TblTracking> get(boolean login, boolean urlAdmin, String ipAddress, int rowOfPage, int page) {
		log.debug("Call get List<TblTracking>");
		List<TblTracking> list = new ArrayList<TblTracking>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		
		long totalPage = 0;
		try {
			long totalRecord = countAll(login, urlAdmin, ipAddress);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTracking.class);
			if ((ipAddress != null) && (!"".equals(ipAddress))) {
				criteria.add(Restrictions.eq("ipAddress", ipAddress));
			}
			if (login) {
				criteria.add(Restrictions.like("url", "%/login.do%"));
			}
			if (urlAdmin) {
				criteria.add(Restrictions.like("url", "%/admin/%"));
			}
			criteria.addOrder(Order.desc("accessDate"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblTracking> failed", re);
		}
		log.debug("list.size(): " + list.size());
		return list;
	}
	
	public Long countAll(boolean login, boolean urlAdmin, String ipAddress) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		String hsqlQuery = "select count(*) from TblTracking t";
		String hsqlQueryWhere = "";
		if ((ipAddress != null) && (!"".equals(ipAddress))) {
			hsqlQueryWhere = hsqlQueryWhere + " ipAddress = '" + ipAddress + "'";
		}		
		if (login) {
			if ((hsqlQueryWhere != null) && (!"".equals(hsqlQueryWhere))) {
				hsqlQueryWhere = hsqlQueryWhere + " and url like '%/login.do%'";
			} else {
				hsqlQueryWhere = hsqlQueryWhere + " url like '%/login.do%'";
			}
		}
		if (urlAdmin) {
			if ((hsqlQueryWhere != null) && (!"".equals(hsqlQueryWhere))) {
				hsqlQueryWhere = hsqlQueryWhere + " and url like '%/admin/%'";
			} else {
				hsqlQueryWhere = hsqlQueryWhere + " url like '%/admin/%'";
			}
		}
		
		if ((hsqlQueryWhere != null) && (!"".equals(hsqlQueryWhere))) {
			hsqlQuery = hsqlQuery + " where" + hsqlQueryWhere;
		}
		log.debug("hsqlQuery: " + hsqlQuery);
		Query query = session.createQuery(hsqlQuery);
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
}
