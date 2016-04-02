package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblLdCap;

public class LdCapDao {
	private static Logger log = Logger.getLogger(LdCapDao.class);
	
	public List<TblLdCap> get() {
		log.debug("Call get List<TblLdCap>");
		List<TblLdCap> list = new ArrayList<TblLdCap>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLdCap.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblLdCap> failed", re);
		}
		return list;
	}
	
	public Short save(TblLdCap object) {
		log.debug("Call save TblLdCap");
		Short returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Short)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblLdCap", e);
		}
		return returnId;
	}
	
	public TblLdCap get(Short ldCapId) {
		log.debug("Call get TblLdCap with: " + ldCapId);
		TblLdCap object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLdCap.class);
			criteria.add(Restrictions.eq("ldCapId", ldCapId));
			object = (TblLdCap)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblLdCap", e);
		}
		return object;
	}
	
	public void update(TblLdCap object) throws Exception {
		log.debug("Call update TblLdCap");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblLdCap", e);
			throw e;
		}
	}

	public String updateBatch(String arrLdCapId) {
		String sReturn = "";
		String[] ldCapIds = arrLdCapId.split(",");
		log.debug("ldCapIds.length: " + ldCapIds.length);
		for (int i = 0; i<ldCapIds.length; i++) {
			Short ldCapId = null;
			try {
				ldCapId = Short.parseShort(ldCapIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "ldCapId = " + ldCapIds[i] + " là không hợp lệ";
				ldCapId = null;
			}
			if (ldCapId != null) {
				TblLdCap ldCap = get(ldCapId);
				if (ldCap == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "ldCapId là " + ldCapIds[i] + " không tồn tại";
				} else {
					ldCap.setStatus((byte)3);
					Date current = new Date();
					ldCap.setModified(current);
					try {
						update(ldCap);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa ldCapId: " + ldCapIds[i];
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
