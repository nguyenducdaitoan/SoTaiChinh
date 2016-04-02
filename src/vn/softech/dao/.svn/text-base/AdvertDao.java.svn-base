package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.GenericJDBCException;

import vn.softech.hibernate.TblAdvert;

public class AdvertDao {
	private static Logger log = Logger.getLogger(AdvertDao.class);
	
	public List<TblAdvert> get() {
		log.debug("Call get List<TblAdvert>");
		List<TblAdvert> list = new ArrayList<TblAdvert>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblAdvert.class);
//			criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte)1));
		//	criteria.addOrder(Order.desc("active"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblAdvert> failed", e);
		}
		return list;
	}
	
	public Long save(TblAdvert object) {
		log.debug("Call save TblVote");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail save TblAdvert", e);
		}
		return returnId;
	}
	
	public TblAdvert get(Long advertId) {
		log.debug("Call get TblAdvert with: " + advertId);
		TblAdvert object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblAdvert.class);
			criteria.add(Restrictions.eq("advertId", advertId));
			object = (TblAdvert)criteria.list().get(0);
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return object;
	}
	
	public void update(TblAdvert object) throws Exception {
		log.debug("Call update TblAdvert");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail update TblAdvert", e);
			throw e;
		}
	}

	public String updateBatch(String arradvertId) {
		String sReturn = "";
		String[] advertIds = arradvertId.split(",");
		log.debug("advertIds.length: " + advertIds.length);
		for (int i = 0; i<advertIds.length; i++) {
			Long advertId = null;
			try {
				advertId = Long.parseLong(advertIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "advertId = " + advertIds[i] + " là không hợp lệ";
				advertId = null;
			}
			if (advertId != null) {
				TblAdvert advert = get(advertId);
				if (advert == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "advertId là " + advertIds[i] + " không tồn tại";
				} else {
					advert.setStatus((byte)3);
					Date current = new Date();
					advert.setModified(current);
					try {
						update(advert);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa advertId: " + advertIds[i];
					}
				}				
			}
		}
/*		
		try {
			sReturn = new String(sReturn.getBytes("iso-8859-1"),"UTF-8");
		} catch (Exception e) {
			log.error(e.toString());
			e.printStackTrace();
		}
*/		
		return sReturn;
	}

	public Long countAll() {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblAdvert t where t.status = 1");
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}

	public List<TblAdvert> getByPage(int rowOfPage, int page) {
		log.debug("Call get List<TblAdvert>");
		List<TblAdvert> list = new ArrayList<TblAdvert>();
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
			Criteria criteria = session.createCriteria(TblAdvert.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblAdvert> failed", e);
		}
		return list;
	}
	
	public List<TblAdvert> getTopAdvert(int numRecord) {
		log.debug("Call get List<TblAdvert>");
		List<TblAdvert> list = new ArrayList<TblAdvert>();
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblAdvert.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(numRecord);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblAdvert> failed", e);
		}
		return list;
	}
}
