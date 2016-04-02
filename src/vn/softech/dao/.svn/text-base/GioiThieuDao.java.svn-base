package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblGioiThieu;

public class GioiThieuDao {
	private static Logger log = Logger.getLogger(GioiThieuDao.class);
	
	public List<TblGioiThieu> get() {
		log.debug("Call get List<TblGioiThieu>");
		List<TblGioiThieu> list = new ArrayList<TblGioiThieu>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGioiThieu.class);
//			criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("active"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
			//session.close();
		} catch (RuntimeException re) {
			log.error("get List<TblGioiThieu> failed", re);
		}
		return list;
	}
	public List<TblGioiThieu> menuGioiThieu() {
		log.debug("Call get List<TblGioiThieu>");
		List<TblGioiThieu> list = new ArrayList<TblGioiThieu>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGioiThieu.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("active", true));
			criteria.addOrder(Order.asc("priority"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
			//session.close();
		} catch (RuntimeException re) {
			log.error("get List<TblGioiThieu> failed", re);
		}
		return list;
	}
	public Long save(TblGioiThieu object) {
		log.debug("Call save TblVote");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
			//session.close();
		} catch (Exception e) {
			log.debug("fail save TblGioiThieu", e);
		}
		return returnId;
	}
	
	public TblGioiThieu get(Long gioiThieuId) {
		log.debug("Call get TblGioiThieu with: " + gioiThieuId);
		TblGioiThieu object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGioiThieu.class);
			criteria.add(Restrictions.eq("gioiThieuId", gioiThieuId));
			object = (TblGioiThieu)criteria.list().get(0);
			//session.close();
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return object;
	}
	
	public void update(TblGioiThieu object) throws Exception {
		log.debug("Call update TblGioiThieu");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
			//session.close();
		} catch (Exception e) {
			log.debug("fail update TblGioiThieu", e);
			throw e;
		}
	}

	public String updateBatch(String arrGioiThieuId) {
		String sReturn = "";
		String[] gioiThieuIds = arrGioiThieuId.split(",");
		log.debug("gioiThieuIds.length: " + gioiThieuIds.length);
		for (int i = 0; i<gioiThieuIds.length; i++) {
			Long gioiThieuId = null;
			try {
				gioiThieuId = Long.parseLong(gioiThieuIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "gioiThieuId = " + gioiThieuIds[i] + " là không hợp lệ";
				gioiThieuId = null;
			}
			if (gioiThieuId != null) {
				TblGioiThieu gioiThieu = get(gioiThieuId);
				if (gioiThieu == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "gioiThieuId là " + gioiThieuIds[i] + " không tồn tại";
				} else {
					gioiThieu.setStatus((byte)3);
					Date current = new Date();
					gioiThieu.setModified(current);
					try {
						update(gioiThieu);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa gioiThieuId: " + gioiThieuIds[i];
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
