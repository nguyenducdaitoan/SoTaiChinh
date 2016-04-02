package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblGroups;

public class GroupsDao {
	private static Logger log = Logger.getLogger(GroupsDao.class);
	
	public List<TblGroups> get() {
		log.debug("Call get List<TblGroups>");
		List<TblGroups> list = new ArrayList<TblGroups>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGroups.class);
//			criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.asc("name"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGroups> failed", re);
		}
		return list;
	}
	
	public Long save(TblGroups object) {
		log.debug("Call save TblGroups");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblGroups", e);
		}
		return returnId;
	}
	
	public TblGroups get(Long groupsId) {
		log.debug("Call get TblGroups with: " + groupsId);
		TblGroups object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGroups.class);
			criteria.add(Restrictions.eq("groupsId", groupsId));
			object = (TblGroups)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblGroups", e);
		}
		return object;
	}
	
	public void update(TblGroups object) throws Exception {
		log.debug("Call update TblGroups");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblGroups", e);
			throw e;
		}
	}

	public String updateBatch(String arrGroupsId) {
		String sReturn = "";
		String[] groupsIds = arrGroupsId.split(",");
		log.debug("groupsIds.length: " + groupsIds.length);
		for (int i = 0; i<groupsIds.length; i++) {
			Long groupsId = null;
			try {
				groupsId = Long.parseLong(groupsIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "groupsId = " + groupsIds[i] + " là không hợp lệ";
				groupsId = null;
			}
			if (groupsId != null) {
				TblGroups groups = get(groupsId);
				if (groups == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "groupsId là " + groupsIds[i] + " không tồn tại";
				} else {
					groups.setStatus((byte)3);
					Date current = new Date();
					groups.setModified(current);
					try {
						update(groups);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa groupsId: " + groupsIds[i];
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
