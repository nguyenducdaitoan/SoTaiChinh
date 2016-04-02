package vn.softech.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblVote;
import vn.softech.hibernate.TblVoteItem;
import vn.softech.hibernate.TblVoteResult;

public class VoteDao {
	private static Logger log = Logger.getLogger(VoteDao.class);
	
	public List<TblVote> getVotes() {
		List<TblVote> listVote = new ArrayList<TblVote>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVote.class);
			criteria.setCacheMode(CacheMode.GET);
			criteria.add(Restrictions.eq("status", (long)1));
			criteria.addOrder(Order.desc("active"));
			criteria.addOrder(Order.desc("modified"));
			listVote = criteria.list();
		} catch (RuntimeException re) {
			log.error("find TblVote failed", re);
		}
		return listVote;
	}
	
	public Long save(TblVote vote) {
		log.debug("Call save TblVote");
		Long voteId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			voteId = (Long)session.save(vote);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save vote", e);
		}
		return voteId;
	}
	
	public Long save(TblVoteItem voteItem) {
		log.debug("Call save TblVoteItem");
		Long voteItemId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			voteItemId = (Long)session.save(voteItem);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save vote", e);
		}
		return voteItemId;
	}
	
	public Long save(TblVoteResult voteResult) {
		log.debug("Call save voteResult");
		Long voteResultId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			voteResultId = (Long)session.save(voteResult);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save vote", e);
		}
		return voteResultId;
	}
	
	public TblVote getVote(Long voteId) {
		log.debug("Call get TblVote with: " + voteId);
		TblVote vote = null;
/*		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVote.class);
			criteria.add(Restrictions.eq("voteId", voteId));
			vote = (TblVote)criteria.list().get(0);			
		} catch (Exception e) {
			log.debug("fail get vote", e);
		}
*/		
		try {
			String queryString = "from TblVote where voteId = :voteId";
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Query queryObject = session.createQuery(queryString);
			queryObject.setLong("voteId", voteId);
			vote = (TblVote)queryObject.list().get(0);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
		}
		return vote;
	}
	
	
	public TblVote getVoteLastActive() {
		log.debug("Call getVoteLastActive");
		TblVote vote = null;		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVote.class);
			criteria.add(Restrictions.eq("active", true));
			criteria.addOrder(Order.desc("modified"));
			vote = (TblVote)criteria.list().get(0);			
		} catch (Exception e) {
			log.debug("fail get vote", e);
		}
		return vote;
	}
	public TblVoteItem getVoteItem(Long voteItemId) {
		log.debug("Call get TblVoteItem with: " + voteItemId);
		TblVoteItem voteItem = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVoteItem.class);
			criteria.add(Restrictions.eq("voteItemId", voteItemId));
			voteItem = (TblVoteItem)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return voteItem;
	}	
	
	public List<TblVoteItem> getVoteItems(Long voteId) {
		log.debug("Call get getVoteItems with: " + voteId);
		List<TblVoteItem> voteItems = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVoteItem.class);
			criteria.setCacheMode(CacheMode.GET);
			criteria.add(Restrictions.eq("tblVote.voteId", voteId));
			criteria.add(Restrictions.eq("status", (long)1));
			voteItems = criteria.list();
		} catch (Exception e) {
			log.debug("fail get VoteItems", e);
		}
		return voteItems;
	}
	
	public void updateVote(TblVote vote) throws Exception {
		log.debug("Call update TblVote");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(vote);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update vote", e);
			throw e;
		}
	}
	
	public void updateVoteItem(TblVoteItem vote) throws Exception {
		log.debug("Call update TblVoteItem");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(vote);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update vote", e);
			throw e;
		}
	}
	
	public Long countVoteResult(Long voteId) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblVoteResult r where r.tblVoteItem.tblVote.voteId = :voteId");
		query.setLong("voteId", voteId);
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
}
