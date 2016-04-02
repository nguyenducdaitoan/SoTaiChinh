package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblChuyenMuc;
import vn.softech.hibernate.TblTinTuc;

public class ChuyenMucDao {
	private static Logger log = Logger.getLogger(ChuyenMucDao.class);
	
	public List<TblChuyenMuc> get() {
		log.debug("Call get List<TblChuyenMuc>");
		List<TblChuyenMuc> list = new ArrayList<TblChuyenMuc>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblChuyenMuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.asc("priority"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblChuyenMuc> failed", re);
		}
		return list;
	}
	public List<TblChuyenMuc> menuChuyenMuc() {
		log.debug("Call get List<TblChuyenMuc>");
		List<TblChuyenMuc> list = new ArrayList<TblChuyenMuc>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblChuyenMuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.asc("priority"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblChuyenMuc> failed", re);
		}
		return list;
	}	
	public Short save(TblChuyenMuc object) {
		log.debug("Call save TblChuyenMuc");
		Short returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Short)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblChuyenMuc", e);
		}
		return returnId;
	}
	
	public TblChuyenMuc get(Short chuyenMucId) {
		log.debug("Call get TblChuyenMuc with: " + chuyenMucId);
		TblChuyenMuc object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblChuyenMuc.class);
			criteria.add(Restrictions.eq("chuyenMucId", chuyenMucId));
			object = (TblChuyenMuc)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblChuyenMuc", e);
		}
		return object;
	}
	
	public void update(TblChuyenMuc object) throws Exception {
		log.debug("Call update TblChuyenMuc");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblChuyenMuc", e);
			throw e;
		}
	}

	public String updateBatch(String arrChuyenMuc) {
		String sReturn = "";
		String[] chuyenMucIds = arrChuyenMuc.split(",");
		log.debug("chuyenMucIds.length: " + chuyenMucIds.length);
		for (int i = 0; i<chuyenMucIds.length; i++) {
			Short chuyenMucId = null;
			try {
				chuyenMucId = Short.parseShort(chuyenMucIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "chuyenMucId = " + chuyenMucIds[i] + " là không hợp lệ";
				chuyenMucId = null;
			}
			if (chuyenMucId != null) {
				TblChuyenMuc chuyenMuc = get(chuyenMucId);
				if (chuyenMuc == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "chuyenMucId là " + chuyenMucIds[i] + " không tồn tại";
				} else {
					chuyenMuc.setStatus((byte)3);
					Date current = new Date();
					chuyenMuc.setModified(current);
					try {
						update(chuyenMuc);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn += "Lỗi phát sinh trong quá trình xóa tinTucId: " + chuyenMucIds[i];
					}
				}				
			}
		}	
		return sReturn;
	}
	
}
