package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblTthcDm;
import vn.softech.hibernate.TblTthcDm;

public class TthcDmDao {
	private static Logger log = Logger.getLogger(TthcDmDao.class);
	
	public List<TblTthcDm> get() {
		log.debug("Call get List<TblTthcDm>");
		List<TblTthcDm> list = new ArrayList<TblTthcDm>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthcDm.class);
//			criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte)1));
//			criteria.addOrder(Order.desc("active"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblTthcDm> failed", re);
		}
		return list;
	}
	
	public Long save(TblTthcDm object) {
		log.debug("Call save TblVote");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblTthcDm", e);
		}
		return returnId;
	}
	
	public TblTthcDm get(Long tthcDmId) {
		log.debug("Call get TblTthcDm with: " + tthcDmId);
		TblTthcDm object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthcDm.class);
			criteria.add(Restrictions.eq("tthcDmId", tthcDmId));
			object = (TblTthcDm)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return object;
	}
	
	public void update(TblTthcDm object) throws Exception {
		log.debug("Call update TblTthcDm");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblTthcDm", e);
			throw e;
		}
	}

	public String updateBatch(String arrtthcDmId) {
		String sReturn = "";
		String[] tthcDmIds = arrtthcDmId.split(",");
		log.debug("tthcDmIds.length: " + tthcDmIds.length);
		for (int i = 0; i<tthcDmIds.length; i++) {
			Long tthcDmId = null;
			try {
				tthcDmId = Long.parseLong(tthcDmIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn += "\n";
				}
				sReturn += "tthcDmId = " + tthcDmIds[i] + " là không hợp lệ";
				tthcDmId = null;
			}
			if (tthcDmId != null) {
				TblTthcDm object = get(tthcDmId);
				if (object == null) {
					if (!"".equals(sReturn)) {
						sReturn += "\n";
					}
					sReturn += "tthcDmId là " + tthcDmIds[i] + " không tồn tại";
				} else {
					object.setStatus((byte)3);
					Date current = new Date();
					object.setModified(current);
					try {
						update(object);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn += "\n";
						}
						sReturn += "Lỗi phát sinh trong quá trình xóa tthcDmId: " + tthcDmIds[i];
					}
				}				
			}
		}
		return sReturn;
	}
}
