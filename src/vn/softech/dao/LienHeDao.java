package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblLienHe;

public class LienHeDao {
	private static Logger log = Logger.getLogger(LienHeDao.class);
	
	public List<TblLienHe> get() {
		log.debug("Call get List<TblLienHe>");
		List<TblLienHe> list = new ArrayList<TblLienHe>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLienHe.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblLienHe> failed", re);
		}
		log.debug("List lien he" + list.size());
		return list;
	}
	
	public Long save(TblLienHe object) {
		log.debug("Call save TblLienHe");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblLienHe", e);
		}
		return returnId;
	}
	
	public TblLienHe get(Long lienHeId) {
		log.debug("Call get TblLienHe with: " + lienHeId);
		TblLienHe object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLienHe.class);
			criteria.add(Restrictions.eq("lienHeId", lienHeId));
			object = (TblLienHe)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return object;
	}
	
	public void update(TblLienHe object) throws Exception {
		log.debug("Call update TblLienHe");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblLienHe", e);
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
				TblLienHe lienThieu = get(lienHeId);
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
