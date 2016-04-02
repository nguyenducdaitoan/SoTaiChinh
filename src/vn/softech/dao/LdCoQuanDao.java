package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblLdCoQuan;

public class LdCoQuanDao {
	private static Logger log = Logger.getLogger(LdCoQuanDao.class);
	
	public List<TblLdCoQuan> get() {
		log.debug("Call get List<TblLdCoQuan>");
		List<TblLdCoQuan> list = new ArrayList<TblLdCoQuan>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLdCoQuan.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblLdCoQuan> failed", re);
		}
		return list;
	}
	
	public List<TblLdCoQuan> getByType(Byte type) {
		log.debug("Call get List<TblLdCoQuan>");
		List<TblLdCoQuan> list = new ArrayList<TblLdCoQuan>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLdCoQuan.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			if ((type != null) && (type.byteValue() > 0)) {
				criteria.add(Restrictions.eq("type", type));
				criteria.addOrder(Order.asc("name"));
			} else {
				criteria.add(Restrictions.isNull("type"));
				criteria.addOrder(Order.asc("name"));
			}
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblLdCoQuan> failed", re);
		}
		return list;
	}
	
	public Short save(TblLdCoQuan object) {
		log.debug("Call save TblLdCoQuan");
		Short returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Short)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblLdCoQuan", e);
		}
		return returnId;
	}
	
	public TblLdCoQuan get(Short ldCoQuanId) {
		log.debug("Call get TblLdCoQuan with: " + ldCoQuanId);
		TblLdCoQuan object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLdCoQuan.class);
			criteria.add(Restrictions.eq("ldCoQuanId", ldCoQuanId));
			object = (TblLdCoQuan)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblLdCoQuan", e);
		}
		return object;
	}
	
	public void update(TblLdCoQuan object) throws Exception {
		log.debug("Call update TblLdCoQuan");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblLdCoQuan", e);
			throw e;
		}
	}

	public String updateBatch(String arrLdCoQuanId) {
		String sReturn = "";
		String[] ldCoQuanIds = arrLdCoQuanId.split(",");
		log.debug("ldCoQuanIds.length: " + ldCoQuanIds.length);
		for (int i = 0; i<ldCoQuanIds.length; i++) {
			Short ldCoQuanId = null;
			try {
				ldCoQuanId = Short.parseShort(ldCoQuanIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "ldCoQuanId = " + ldCoQuanIds[i] + " là không hợp lệ";
				ldCoQuanId = null;
			}
			if (ldCoQuanId != null) {
				TblLdCoQuan ldCoQuan = get(ldCoQuanId);
				if (ldCoQuan == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "ldCoQuanId là " + ldCoQuanIds[i] + " không tồn tại";
				} else {
					ldCoQuan.setStatus((byte)3);
					Date current = new Date();
					ldCoQuan.setModified(current);
					try {
						update(ldCoQuan);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa ldCoQuanId: " + ldCoQuanIds[i];
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
