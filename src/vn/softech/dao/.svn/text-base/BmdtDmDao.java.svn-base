package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblBmdtDm;

public class BmdtDmDao {
	private static Logger log = Logger.getLogger(BmdtDmDao.class);
	
	public List<TblBmdtDm> get() {
		log.debug("Call get List<TblBmdtDm>");
		List<TblBmdtDm> list = new ArrayList<TblBmdtDm>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdtDm.class);
//			criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte)1));
//			criteria.addOrder(Order.desc("active"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblBmdtDm> failed", re);
		}
		return list;
	}
	
	public List<TblBmdtDm> getMenuHeader() {
		log.debug("Call get List<TblBmdtDm>");
		List<TblBmdtDm> list = new ArrayList<TblBmdtDm>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdtDm.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("created"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblBmdtDm> failed", re);
		}
		return list;
	}
	
	public Long save(TblBmdtDm object) {
		log.debug("Call save TblVote");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblBmdtDm", e);
		}
		return returnId;
	}
	
	public TblBmdtDm get(Long bmdtDmId) {
		log.debug("Call get TblBmdtDm with: " + bmdtDmId);
		TblBmdtDm object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdtDm.class);
			criteria.add(Restrictions.eq("bmdtDmId", bmdtDmId));
			object = (TblBmdtDm)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return object;
	}
	
	public TblBmdtDm getPublic(Long bmdtDmId) {
		log.debug("Call get TblBmdtDm with: " + bmdtDmId);
		TblBmdtDm object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdtDm.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("bmdtDmId", bmdtDmId));
			object = (TblBmdtDm)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return object;
	}
	
	public void update(TblBmdtDm object) throws Exception {
		log.debug("Call update TblBmdtDm");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblBmdtDm", e);
			throw e;
		}
	}

	public String updateBatch(String arrBmdtDmId) {
		String sReturn = "";
		String[] bmdtDmIds = arrBmdtDmId.split(",");
		log.debug("bmdtDmIds.length: " + bmdtDmIds.length);
		for (int i = 0; i<bmdtDmIds.length; i++) {
			Long bmdtDmId = null;
			try {
				bmdtDmId = Long.parseLong(bmdtDmIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "bmdtDmId = " + bmdtDmIds[i] + " là không hợp lệ";
				bmdtDmId = null;
			}
			if (bmdtDmId != null) {
				TblBmdtDm bmdtDm = get(bmdtDmId);
				if (bmdtDm == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "bmdtDmId là " + bmdtDmIds[i] + " không tồn tại";
				} else {
					bmdtDm.setStatus((byte)3);
					Date current = new Date();
					bmdtDm.setModified(current);
					try {
						update(bmdtDm);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa bmdtDmId: " + bmdtDmIds[i];
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



	
	
}
