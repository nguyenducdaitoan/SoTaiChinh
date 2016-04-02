package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblDvcGopy;

public class DvcGopyDao {
	private static Logger log = Logger.getLogger(DvcGopyDao.class);
	
	public List<TblDvcGopy> get(int rowOfPage, int page) {
		log.debug("Call get List<TblDvcGopy>");
		List<TblDvcGopy> list = new ArrayList<TblDvcGopy>();
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
			Criteria criteria = session.createCriteria(TblDvcGopy.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblDvcGopy> failed", re);
		}
		log.debug("List lien he" + list.size());
		return list;
	}
	
	public Long countAll() throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblDvcGopy t where t.status = 1");
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	
	public Long save(TblDvcGopy object) {
		log.debug("Call save TblDvcGopy");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblDvcGopy", e);
		}
		return returnId;
	}
	
	public TblDvcGopy get(Long dvcGopyId) {
		log.debug("Call get TblDvcGopy with: " + dvcGopyId);
		TblDvcGopy object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblDvcGopy.class);
			criteria.add(Restrictions.eq("dvcGopyId", dvcGopyId));
			object = (TblDvcGopy)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return object;
	}
	
	public void update(TblDvcGopy object) throws Exception {
		log.debug("Call update TblDvcGopy");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblDvcGopy", e);
			throw e;
		}
	}

	public String updateBatch(String arrlienHeId) {
		String sReturn = "";
		String[] lienHeIds = arrlienHeId.split(",");
		log.debug("lienHeIds.length: " + lienHeIds.length);
		for (int i = 0; i<lienHeIds.length; i++) {
			Long lienHeId = null;
			try {
				lienHeId = Long.parseLong(lienHeIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "lienHeId = " + lienHeIds[i] + " là không hợp lệ";
				lienHeId = null;
			}
			if (lienHeId != null) {
				TblDvcGopy lienThieu = get(lienHeId);
				if (lienThieu == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "lienHeId là " + lienHeIds[i] + " không tồn tại";
				} else {
					lienThieu.setStatus((byte)3);
					Date current = new Date();
					lienThieu.setModified(current);
					try {
						update(lienThieu);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa lienHeId: " + lienHeIds[i];
					}
				}				
			}
		}
		return sReturn;
	}
}
