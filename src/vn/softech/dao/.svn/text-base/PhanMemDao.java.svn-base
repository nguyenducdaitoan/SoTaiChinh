package vn.softech.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.GenericJDBCException;

import vn.softech.hibernate.TblPhanmem;
import vn.softech.hibernate.TblPhanmem;

public class PhanMemDao {
	private static Logger log = Logger.getLogger(PhanMemDao.class);
	
	public List<TblPhanmem> get() {
		log.debug("Call get List<TblPhanmem>");
		List<TblPhanmem> list = new ArrayList<TblPhanmem>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblPhanmem.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("priority"));
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblPhanmem> failed", e);
		}
		return list;
	}
	
	public Long save(TblPhanmem object) {
		log.debug("Call save TblPhanmem");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail save TblPhanmem", e);
		}
		return returnId;
	}
	
	public TblPhanmem get(Long phanmemId) {
		log.debug("Call get TblPhanmem with: " + phanmemId);
		TblPhanmem object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblPhanmem.class);
			criteria.add(Restrictions.eq("phanmemId", phanmemId));
			object = (TblPhanmem)criteria.list().get(0);
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail get TblPhanmem", e);
		}
		return object;
	}
	
	public void update(TblPhanmem object) throws Exception {
		log.debug("Call update TblPhanmem");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail update TblPhanmem", e);
			throw e;
		}
	}

	public Long countAll() {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblPhanmem t where t.status = 1");
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}

	public Long countSearch(String sQuery) {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(TblPhanmem.class);
		criteria.add(Restrictions.eq("status", (byte)1));
		if ((sQuery != null) && (!"".equals(sQuery))) {
			log.debug("query is not null");			
			criteria.add(Restrictions.like("title", "%" + sQuery + "%"));			
		}
		count = (Long)criteria.uniqueResult();
		return count;
	}
	
	public List<TblPhanmem> getByPage(int rowOfPage, int page) {
		log.debug("Call get List<TblPhanmem>");
		List<TblPhanmem> list = new ArrayList<TblPhanmem>();
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
			Criteria criteria = session.createCriteria(TblPhanmem.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("priority"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblPhanmem> failed", e);
		}
		return list;
	}
	
	public List<TblPhanmem> getSearch(String sQuery, int rowOfPage, int page) {
		log.debug("Call getSearch List<TblPhanmem>");
		List<TblPhanmem> list = new ArrayList<TblPhanmem>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countSearch(sQuery);
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
			Criteria criteria = session.createCriteria(TblPhanmem.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			if ((sQuery != null) && (!"".equals(sQuery))) {
				log.debug("query is not null");			
				criteria.add(Restrictions.like("title", "%" + sQuery + "%"));			
			}
			criteria.addOrder(Order.desc("priority"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("getSearch List<TblPhanmem> failed", e);
		}
		return list;
	}
	
	public List<TblPhanmem> getTop(int numRecord) {
		log.debug("Call get List<TblPhanmem>");
		List<TblPhanmem> list = new ArrayList<TblPhanmem>();
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblPhanmem.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("priority"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(numRecord);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblPhanmem> failed", e);
		}
		return list;
	}
}
