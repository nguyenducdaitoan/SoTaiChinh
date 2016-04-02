package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblPhongBan;
import vn.softech.hibernate.TblUsers;

public class UsersDao {
	private static Logger log = Logger.getLogger(UsersDao.class);
	
	/**
	 * Get danh sách người dùng trong hệ thống
	 * @return List&lt;TblUsers&gt; 
	 * @author vulh 
	 * @version 1.0 (2012-11-01) 
	 * @author vinhlv
	 * @version 1.1 (2012-11-03)
	 */
	public List<TblUsers> get() {
		log.debug("Call get List<TblUsers>");
		List<TblUsers> list = new ArrayList<TblUsers>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUsers.class);
//			criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte)1));
			list = criteria.list();
			//session.close();
		} catch (RuntimeException re) {
			log.error("get List<TblUsers> failed", re);
		}
		return list;
	}
	
	public List<TblUsers> getByPhongBanId(Long phongBanId) {
		log.debug("Call getByPhongBanId List<TblUsers>");
		List<TblUsers> list = new ArrayList<TblUsers>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUsers.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("tblPhongBan.phongBanId", phongBanId));
			list = criteria.list();
			//session.close();
		} catch (RuntimeException e) {
			log.error("getByPhongBanId List<TblUsers> failed", e);
		}
		return list;
	}
	
	public List<TblPhongBan> getPhongBan() {
		log.debug("Call getPhongBan List<TblPhongBan>");
		List<TblPhongBan> list = new ArrayList<TblPhongBan>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblPhongBan.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			list = criteria.list();
			//session.close();
		} catch (RuntimeException re) {
			log.error("get List<TblUsers> failed", re);
		}
		return list;
	}
	
	public Long save(TblUsers object) {
		log.debug("Call save TblUsers");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
			//session.close();
		} catch (Exception e) {
			log.debug("fail save TblUsers", e);
			throw e;
		}
		return returnId;
	}
	
	public TblUsers get(Long usersId) {
		log.debug("Call get TblUsers with: " + usersId);
		TblUsers object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUsers.class);
			criteria.add(Restrictions.eq("usersId", usersId));
			object = (TblUsers)criteria.list().get(0);
			//session.close();
		} catch (Exception e) {
			log.debug("fail get TblUsers", e);
		}
		return object;
	}
	
	public TblPhongBan getPhongBan(Long phongBanId) {
		log.debug("Call getPhongBan TblPhongBan with: " + phongBanId);
		TblPhongBan object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblPhongBan.class);
			criteria.add(Restrictions.eq("phongBanId", phongBanId));
			object = (TblPhongBan)criteria.list().get(0);
			//session.close();
		} catch (Exception e) {
			log.debug("fail getPhongBan TblPhongBan", e);
		}
		return object;
	}
	
	public void update(TblUsers object) throws Exception {
		log.debug("Call update TblUsers");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
			//session.close();
		} catch (Exception e) {
			log.debug("fail update TblUsers", e);
			throw e;
		}
	}

	public String updateBatch(String arrUsersId) {
		String sReturn = "";
		String[] usersIds = arrUsersId.split(",");
		log.debug("usersIds.length: " + usersIds.length);
		for (int i = 0; i<usersIds.length; i++) {
			Long usersId = null;
			try {
				usersId = Long.parseLong(usersIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "usersId = " + usersIds[i] + " là không hợp lệ";
				usersId = null;
			}
			if (usersId != null) {
				TblUsers users = get(usersId);
				if (users == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "usersId là " + usersIds[i] + " không tồn tại";
				} else {
					users.setStatus((byte)3);
					Date current = new Date();
					users.setModified(current);
					try {
						update(users);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa usersId: " + usersIds[i];
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
