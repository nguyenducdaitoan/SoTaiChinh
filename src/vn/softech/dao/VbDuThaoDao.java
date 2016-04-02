package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblVbDuthao;
import vn.softech.hibernate.TblVbDuthaoGopy;

public class VbDuThaoDao {
	private static Logger log = Logger.getLogger(VbDuThaoDao.class);
	
	public List<TblVbDuthao> get() {
		log.debug("Call get List<TblVbDuthao>");
		List<TblVbDuthao> list = new ArrayList<TblVbDuthao>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbDuthao.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("ngayApproved"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblVbDuthao> failed", re);
		}
		return list;
	}
	
	public List<TblVbDuthao> getApproved() {
		log.debug("Call get List<TblVbDuthao>");
		List<TblVbDuthao> list = new ArrayList<TblVbDuthao>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbDuthao.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("approved", true));
			criteria.addOrder(Order.desc("ngayApproved"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblVbDuthao> failed", re);
		}
		return list;
	}
	
	public List<TblVbDuthaoGopy> getListVbDuThaoGopy(Long vbDuThaoId) {
		log.debug("Call get List<TblVbDuthao>");
		List<TblVbDuthaoGopy> list = new ArrayList<TblVbDuthaoGopy>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbDuthaoGopy.class);
			criteria.add(Restrictions.eq("tblVbDuthao.vbDuthaoId", vbDuThaoId));
			criteria.addOrder(Order.desc("ngayGoi"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblVbDuthao> failed", re);
		}
		return list;
	}
	
	public Long save(TblVbDuthao object) {
		log.debug("Call save TblVote");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblVbDuthao", e);
		}
		return returnId;
	}
	
	public Long save(TblVbDuthaoGopy object) {
		log.debug("Call save TblVbDuthaoGopy");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblVbDuthaoGopy", e);
		}
		return returnId;
	}
	
	public TblVbDuthaoGopy getVbDuThaoGopy(Long vbDuthaoGopyId) {
		log.debug("Call getVbDuThaoGopy TblVbDuthaoGopy with vbDuthaoGopyId: " + vbDuthaoGopyId);
		TblVbDuthaoGopy object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbDuthaoGopy.class);
			criteria.add(Restrictions.eq("vbDuthaoGopyId", vbDuthaoGopyId));
			object = (TblVbDuthaoGopy)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return object;
	}
	
	public TblVbDuthao get(Long vbDuthaoId) {
		log.debug("Call get TblVbDuthao with: " + vbDuthaoId);
		TblVbDuthao object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbDuthao.class);
			criteria.add(Restrictions.eq("vbDuthaoId", vbDuthaoId));
			object = (TblVbDuthao)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return object;
	}
	
	public void update(TblVbDuthao object) throws Exception {
		log.debug("Call update TblVbDuthao");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblVbDuthao", e);
			throw e;
		}
	}
}
