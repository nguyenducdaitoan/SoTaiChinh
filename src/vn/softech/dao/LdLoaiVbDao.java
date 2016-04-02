package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblLdLoaiVb;

public class LdLoaiVbDao {
	private static Logger log = Logger.getLogger(LdLoaiVbDao.class);
	
	public List<TblLdLoaiVb> get() {
		log.debug("Call get List<TblLdLoaiVb>");
		List<TblLdLoaiVb> list = new ArrayList<TblLdLoaiVb>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLdLoaiVb.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblLdLoaiVb> failed", re);
		}
		return list;
	}
	
	public List<TblLdLoaiVb> getByType(Byte type) {
		log.debug("Call get List<TblLdLoaiVb>");
		List<TblLdLoaiVb> list = new ArrayList<TblLdLoaiVb>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLdLoaiVb.class);
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
			log.error("get List<TblLdLoaiVb> failed", re);
		}
		return list;
	}
	
	public Short save(TblLdLoaiVb object) {
		log.debug("Call save TblLdLoaiVb");
		Short returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Short)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblLdLoaiVb", e);
		}
		return returnId;
	}
	
	public TblLdLoaiVb get(Short ldLoaiVbId) {
		log.debug("Call get TblLdLoaiVb with: " + ldLoaiVbId);
		TblLdLoaiVb object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLdLoaiVb.class);
			criteria.add(Restrictions.eq("ldLoaiVbId", ldLoaiVbId));
			object = (TblLdLoaiVb)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblLdLoaiVb", e);
		}
		return object;
	}
	
	public void update(TblLdLoaiVb object) throws Exception {
		log.debug("Call update TblLdLoaiVb");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblLdLoaiVb", e);
			throw e;
		}
	}

	public String updateBatch(String arrLdLoaiVbId) {
		String sReturn = "";
		String[] ldLoaiVbIds = arrLdLoaiVbId.split(",");
		log.debug("ldLoaiVbIds.length: " + ldLoaiVbIds.length);
		for (int i = 0; i<ldLoaiVbIds.length; i++) {
			Short ldLoaiVbId = null;
			try {
				ldLoaiVbId = Short.parseShort(ldLoaiVbIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "ldLoaiVbId = " + ldLoaiVbIds[i] + " là không hợp lệ";
				ldLoaiVbId = null;
			}
			if (ldLoaiVbId != null) {
				TblLdLoaiVb ldLoaiVb = get(ldLoaiVbId);
				if (ldLoaiVb == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "ldLoaiVbId là " + ldLoaiVbIds[i] + " không tồn tại";
				} else {
					ldLoaiVb.setStatus((byte)3);
					Date current = new Date();
					ldLoaiVb.setModified(current);
					try {
						update(ldLoaiVb);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa ldLoaiVbId: " + ldLoaiVbIds[i];
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
