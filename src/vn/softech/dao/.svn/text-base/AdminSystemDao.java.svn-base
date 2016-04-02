package vn.softech.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.GenericJDBCException;

import vn.softech.hibernate.TblUrls;
import vn.softech.hibernate.TblUsers;
import vn.softech.hibernate.TblUsersGroups;
import vn.softech.util.UrlsComparator;

public class AdminSystemDao {
	private static Logger log = Logger.getLogger(AdminSystemDao.class);
	public List<TblUsers> get() {
		log.debug("Call get List<TblUsers>");
		List<TblUsers> list = new ArrayList<TblUsers>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUsers.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblUsers> failed", e);
		}
		return list;
	}
	
	public List<TblUrls> getUrlsParent() {
		log.debug("Call getUrlsParent List<TblUrls>");
		List<TblUrls> list = new ArrayList<TblUrls>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUrls.class);
			criteria.add(Restrictions.isNull("parentId"));
			criteria.addOrder(Order.asc("priority"));
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblUsers> failed", e);
		}
		return list;
	}
	
	public List<TblUrls> getUrlsChild(Long parentId) {
		log.debug("Call getUrlsChild List<TblUrls>");
		List<TblUrls> list = new ArrayList<TblUrls>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUrls.class);
			criteria.add(Restrictions.eq("parentId", parentId));
			criteria.addOrder(Order.asc("priority"));
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblUsers> failed", e);
		}
		return list;
	}
	
	public TblUsers getUsers(Long usersId) {
		log.debug("Call get TblUsers with: " + usersId);
		TblUsers object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUsers.class);
			criteria.add(Restrictions.eq("usersId", usersId));
			object = (TblUsers)criteria.list().get(0);

		} catch (Exception e) {
			log.debug("fail get TblUsers", e);
		}
		return object;
	}
	
	public TblUrls getUrls(Long urlsId) {
		log.debug("Call get TblUrls with: " + urlsId);
		TblUrls object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUrls.class);
			criteria.add(Restrictions.eq("urlsId", urlsId));
			object = (TblUrls)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblUsers", e);
		}
		return object;
	}
	
	public boolean existUsers(String username) {
		log.debug("Call existUsers with: username = " + username);
		boolean exist = false;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUsers.class);
			criteria.add(Restrictions.eq("username", username));
			criteria.add(Restrictions.eq("active", true));
			criteria.add(Restrictions.eq("status", (byte)1));
			if (criteria.list().size()>0) exist = true;
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail get TblUsers", e);
		}
		return exist;
	}
	
	public TblUsers login(String username, String password) {
		log.debug("Call login with: username: " + username + " and password: " + password);
		TblUsers object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUsers.class);
			criteria.add(Restrictions.eq("username", username));
			criteria.add(Restrictions.eq("password", password));
			criteria.add(Restrictions.eq("active", true));
			criteria.add(Restrictions.eq("status", (byte)1));
			object = (TblUsers)criteria.list().get(0);
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail get TblUsers", e);
		}
		return object;
	}
	
	public List<TblUsersGroups> getUsersGroups(Long usersId) {
		log.debug("Call getUsersGroups List<TblUsersGroups> with usersId: " + usersId);
		List<TblUsersGroups> list = new ArrayList<TblUsersGroups>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUsersGroups.class).createAlias("tblGroups", "tblGroups");
			criteria.add(Restrictions.eq("id.usersId", usersId));
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.asc("tblGroups.priority"));
			criteria.addOrder(Order.asc("tblGroups.groupsId"));
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail getUsersGroups List<TblUsersGroups>", e);
		}
		return list;
	}
	
	public TblUsersGroups getUsersGroups(Long usersId, Long groupsId) {
		log.debug("Call getUsersGroups List<TblUsersGroups> with usersId: " + usersId);
		TblUsersGroups object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUsersGroups.class);
			criteria.add(Restrictions.eq("id.usersId", usersId));
			criteria.add(Restrictions.eq("id.groupsId", groupsId));
			criteria.add(Restrictions.eq("status", (byte)1));
			object = (TblUsersGroups)criteria.list().get(0);
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail getUsersGroups List<TblUsersGroups>", e);
		}
		return object;
	}
	
	public List<TblUsersGroups> getGroupsUsers(Long groupsId) {
		log.debug("Call getGroupsUsers List<TblUsersGroups> with groupsId: " + groupsId);
		List<TblUsersGroups> list = new ArrayList<TblUsersGroups>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUsersGroups.class).createAlias("tblUsers", "tblUsers");
			criteria.add(Restrictions.eq("id.groupsId", groupsId));
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.asc("tblUsers.usersId"));
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail getGroupsUsers", e);
		}
		return list;
	}
	
	public List<TblUrls> getUrlsParentByGroupsId(Collection groupsIds) {
		List<TblUrls> list = new ArrayList<TblUrls>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			String queryString = "SELECT a.tblUrls FROM TblUrlsGroups a WHERE a.tblGroups.groupsId IN (:groupsIds) AND a.tblUrls.parentId is NULL AND a.status = 1 AND a.tblUrls.active = 1 GROUP BY a.tblUrls.urlsId ORDER BY a.tblUrls.priority";
			Query query = session.createQuery (queryString);
			query.setParameterList("groupsIds", groupsIds);
			list = query.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail get TblUsers", e);
		}
		return list;
	}
	
	public List<TblUrls> getUrlsChildByGroupsId(Long parentId, Long groupsId) {
		List<TblUrls> list = new ArrayList<TblUrls>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			String queryString = "SELECT a.tblUrls FROM TblUrlsGroups a WHERE a.tblGroups.groupsId =:groupsId AND a.tblUrls.parentId =:parentId AND a.status = 1 AND a.tblUrls.active = 1 GROUP BY a.tblUrls.urlsId ORDER BY a.tblUrls.priority, a.tblUrls.urlsId";
			Query query = session.createQuery (queryString);
			query.setLong("parentId", parentId);
			query.setLong("groupsId", groupsId);
			List<TblUrls> listParent = query.list();
			if ((listParent != null) && (listParent.size()>0)) {
				for (TblUrls url: listParent) {
					list.add(url);
					List<TblUrls> listChild = getUrlsChildByGroupsId(url.getUrlsId(), groupsId);
					if ((listChild != null) && (listChild.size()>0)) {
						list.addAll(listChild);
					}
				}
			}
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail get TblUsers", e);
		}
		return list;
	}
	
	public List<TblUrls> getUrlsByUsersId(Long usersId) {
		List<TblUrls> listUrls = new ArrayList<TblUrls>();		
		List<TblUsersGroups> listGroups = getUsersGroups(usersId);
		List<Long> groupsIds =  new ArrayList<Long>();
		if ((listGroups != null) && (listGroups.size() > 0)) {
			for (TblUsersGroups userGroup : listGroups) {
				groupsIds.add(userGroup.getTblGroups().getGroupsId());
			}
			List<TblUrls> listParentUrls = getUrlsParentByGroupsId(groupsIds);
			for (TblUrls url: listParentUrls) {
				listUrls.add(url);
				log.debug("name url: " + url.getName());
				for (Long groupsId: groupsIds) {
					listUrls.addAll(getUrlsChildByGroupsId(url.getUrlsId(),groupsId));
				}
			}
		}
		
		List<TblUrls> listUrlsNotDuplicate = new ArrayList<TblUrls>();
		if ((listUrls != null) && (listUrls.size() > 0)) {
			Iterator iterator = listUrls.iterator();
	        while (iterator.hasNext()) {
	        	TblUrls o = (TblUrls)iterator.next();
	            if(!listUrlsNotDuplicate.contains(o)) listUrlsNotDuplicate.add(o);
	        }
		}
		Collections.sort(listUrlsNotDuplicate,new UrlsComparator());
		return listUrlsNotDuplicate;
//		return listUrls;
	}
	
	public void save(TblUsersGroups object) {
		log.debug("Call save TblUsersGroups");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblUsersGroups", e);
		}
	}
	
	public void update(TblUsersGroups object) throws Exception {
		log.debug("Call update TblUsersGroups");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblUsersGroups", e);
			throw e;
		}
	}
	
	public void update(TblUrls object) throws Exception {
		log.debug("Call update TblUrls");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblUrls", e);
			throw e;
		}
	}
	
	public void delete(TblUsersGroups object) throws Exception {
		log.debug("Call update TblUsersGroups");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.delete(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblUsersGroups", e);
			throw e;
		}
	}
/*	
	public static void main(String[] args) {
		AdminSystemDao dao = new AdminSystemDao();
		List<TblUrls> list = dao.getUrlsByUsersId((long)1);
		for (TblUrls url: list) {
			System.out.println("[" + url.getUrlsId() + "] => " + url.getName() + ((url.getParentId() == null)?"":" child of [" + url.getParentId() + "]"));
		}
	}
*/

	public TblUrls getUrlsAfter(Long parentId, Byte priority) {
		log.debug("Call get getUrlsAfter");
		log.debug("parentId = " + parentId);
		log.debug("priority = " + priority);
		TblUrls object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblUrls.class);
			criteria.add(Restrictions.eq("parentId", parentId));
			criteria.add(Restrictions.gt("priority", priority));
			criteria.addOrder(Order.asc("priority"));
			object = (TblUrls)criteria.list().get(0);

		} catch (Exception e) {
			log.debug("fail get getUrlsAfter", e);
		}
		return object;
	}	
}
