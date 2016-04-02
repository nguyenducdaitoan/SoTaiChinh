package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblLdLinhVuc;

public class LdLinhVucDao {
	private static Logger log = Logger.getLogger(LdLinhVucDao.class);
	
	public List<TblLdLinhVuc> get() {
		log.debug("Call get List<TblLdLinhVuc>");
		List<TblLdLinhVuc> list = new ArrayList<TblLdLinhVuc>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLdLinhVuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblLdLinhVuc> failed", re);
		}
		return list;
	}
	
	public List<TblLdLinhVuc> getByType(Byte type) {
		log.debug("Call get List<TblLdLinhVuc>");
		List<TblLdLinhVuc> list = new ArrayList<TblLdLinhVuc>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLdLinhVuc.class);
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
			log.error("get List<TblLdLinhVuc> failed", re);
		}
		return list;
	}
	
	public Short save(TblLdLinhVuc object) {
		log.debug("Call save TblLdLinhVuc");
		Short returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Short)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblLdLinhVuc", e);
		}
		return returnId;
	}
	
	public TblLdLinhVuc get(Short ldLinhVucId) {
		log.debug("Call get TblLdLinhVuc with: " + ldLinhVucId);
		TblLdLinhVuc object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLdLinhVuc.class);
			criteria.add(Restrictions.eq("ldLinhVucId", ldLinhVucId));
			object = (TblLdLinhVuc)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblLdLinhVuc", e);
		}
		return object;
	}
	
	public void update(TblLdLinhVuc object) throws Exception {
		log.debug("Call update TblLdLinhVuc");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblLdLinhVuc", e);
			throw e;
		}
	}

	public String updateBatch(String arrLdLinhVucId) {
		String sReturn = "";
		String[] ldLinhVucIds = arrLdLinhVucId.split(",");
		log.debug("ldLinhVucIds.length: " + ldLinhVucIds.length);
		for (int i = 0; i<ldLinhVucIds.length; i++) {
			Short ldLinhVucId = null;
			try {
				ldLinhVucId = Short.parseShort(ldLinhVucIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "ldLinhVucId = " + ldLinhVucIds[i] + " là không hợp lệ";
				ldLinhVucId = null;
			}
			if (ldLinhVucId != null) {
				TblLdLinhVuc ldLinhVuc = get(ldLinhVucId);
				if (ldLinhVuc == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "ldLinhVucId là " + ldLinhVucIds[i] + " không tồn tại";
				} else {
					ldLinhVuc.setStatus((byte)3);
					Date current = new Date();
					ldLinhVuc.setModified(current);
					try {
						update(ldLinhVuc);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa ldLinhVucId: " + ldLinhVucIds[i];
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
