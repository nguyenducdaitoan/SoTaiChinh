package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblTinTuc;
import vn.softech.hibernate.TblTthc;
//import vn.org.danang.taichinh.util.MailServiceUtil;


public class TthcDao {
	private static Logger log = Logger.getLogger(TthcDao.class);
	
	public List<TblTthc> get() {
		log.debug("Call get List<TblTthc>");
		List<TblTthc> list = new ArrayList<TblTthc>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthc.class);
//			criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte)1));
//			criteria.addOrder(Order.desc("active"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblTthc> failed", re);
		}
		return list;
	}
	
	public List<TblTthc> getSearch(String sQuery, int rowOfPage, int page) {
		log.debug("Call getSearch List<TblTthc>");
		List<TblTthc> list = new ArrayList<TblTthc>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countSearch(sQuery);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			if ((sQuery != null) && (!"".equals(sQuery))) {
				log.debug("query is not null");
				Disjunction disjunction = Restrictions.disjunction();
				disjunction.add(Restrictions.like("title", "%" + sQuery + "%"));
				disjunction.add(Restrictions.like("content", "%" + sQuery + "%"));
				criteria.add(disjunction);
			}
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("getSearch List<TblTthc> failed", re);
		}
		return list;
	}
	
	/**
	 * Get danh sách thủ tục
	 * @param rowOfPage Số bản ghi thủ tuc trong 1 trang
	 * @param page Trang thủ tục cần get
	 * @return
	 */
	public List<TblTthc> getByPage(int rowOfPage, int page) {
		log.debug("Call get List<TblTthc>");
		List<TblTthc> list = new ArrayList<TblTthc>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countAll();
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthc.class);
			//criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblTthc> failed", re);
		}
		return list;
	}
	
	/**
	 * Get danh sách thủ tuc ứng với chuyên mục
	 * @param rowOfPage Số bản ghi thủ tuc trong 1 trang
	 * @param page Trang thủ tuc cần get
	 * @return
	 */
	public List<TblTthc> getByPage(int rowOfPage, int page, Long tthcDmId) {
		log.debug("Call get List<TblTthc>");
		List<TblTthc> list = new ArrayList<TblTthc>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countCm(tthcDmId);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			log.debug("chuyen muc Dao:" + tthcDmId);
			criteria.add(Restrictions.eq("tblTthcDm.tthcDmId", tthcDmId));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblTthc> failed", re);
		}
		return list;
	}
	public List<TblTthc> getByThuTucByChuyenMucId(Long chuyenMucId) {
		List<TblTthc> list = new ArrayList<TblTthc>();
		log.debug("Call get List<TblTthc>");
		if(chuyenMucId == null){
			return list;
		}
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("tblTthcDm.tthcDmId", chuyenMucId));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblTthc> failed", re);
		}
		return list;
	}
	
	public List<TblTthc> getByThuTucByChuyenMucId(int rowOfPage, int page, Long chuyenMucId) {
		List<TblTthc> list = new ArrayList<TblTthc>();
		log.debug("Call get List<TblTthc>");
		if(chuyenMucId == null){
			return list;
		}
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countCm(chuyenMucId);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		log.debug("totalPage: " + totalPage);
		if (page > totalPage) page = 1;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("tblTthcDm.tthcDmId", chuyenMucId));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblTthc> failed", re);
		}
		return list;
	}
	
	public List<TblTthc> getTthcActiveByChuyenMucId(int rowOfPage, int page, Long chuyenMucId) {
		List<TblTthc> list = new ArrayList<TblTthc>();
		log.debug("Call get List<TblTthc>");
		if(chuyenMucId == null){
			return list;
		}
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countCmActive(chuyenMucId);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		log.debug("totalPage: " + totalPage);
		if (page > totalPage) page = 1;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
//			criteria.add(Restrictions.eq("active", (byte)1));
			criteria.add(Restrictions.eq("active", true));
			criteria.add(Restrictions.eq("tblTthcDm.tthcDmId", chuyenMucId));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblTthc> failed", re);
		}
		return list;
	}
	
	public List<TblTthc> getTopTthcAllChuyenMuc(int numberRecord) {
		List<TblTthc> list = new ArrayList<TblTthc>();
		log.debug("Call get List<TblTthc>");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(numberRecord);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblTthc> failed", re);
		}
		return list;
	}
	
	public Long save(TblTthc object) {
		log.debug("Call save TblVote");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblTthc", e);
		}
		return returnId;
	}
	
	public TblTthc get(Long tthcId) {
		log.debug("Call get TblTthc with: " + tthcId);
		TblTthc object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthc.class);
			criteria.add(Restrictions.eq("tthcId", tthcId));
			object = (TblTthc)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return object;
	}
	
	public void update(TblTthc object) throws Exception {
		log.debug("Call update TblTthc");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblTthc", e);
			throw e;
		}
	}

	public String updateBatch(String arrtthcId) {
		String sReturn = "";
		//MailServiceUtil mail = new MailServiceUtil();
		//mail.message("vulh@softech.vn", "TthcDao updateBatch", "arrtthcId: " + arrtthcId); 
		String[] tthcIds = arrtthcId.split(",");
		log.debug("List Thu Tuc Dao: "+arrtthcId);
		log.debug("tthcIds.length: " + tthcIds.length);
		for (int i = 0; i<tthcIds.length; i++) {
			Long tthcId = null;
			try {
				tthcId = Long.parseLong(tthcIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn += "\n";
				}
				sReturn += "tthcId = " + tthcIds[i] + " là không hợp lệ";
				tthcId = null;
			}
			if (tthcId != null) {
				TblTthc object = get(tthcId);
				if (object == null) {
					if (!"".equals(sReturn)) {
						sReturn += "\n";
					}
					sReturn += "tthcId là " + tthcIds[i] + " không tồn tại";
				} else {
					object.setStatus((byte)3);
					Date current = new Date();
					object.setModified(current);
					try {
						log.debug("updateBatch >>> update tthc status = 3");
						update(object);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn += "\n";
						}
						sReturn += "Lỗi phát sinh trong quá trình xóa tthcId: " + tthcIds[i];
					}
				}				
			}
		}
		return sReturn;
	}

	public Long countAll() {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(TblTthc.class);
		criteria.add(Restrictions.eq("status", (byte)1));
		if ((criteria.list() != null) && (criteria.list().size() > 0)) {
			count = (long)criteria.list().size();
		}
		return count;
	}
	
	public Long countSearch(String sQuery) {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(TblTthc.class);
		criteria.add(Restrictions.eq("status", (byte)1));
		if ((sQuery != null) && (!"".equals(sQuery))) {
			log.debug("query is not null");
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.like("title", "%" + sQuery + "%"));
			disjunction.add(Restrictions.like("content", "%" + sQuery + "%"));
			criteria.add(disjunction);
		}
		count = (Long)criteria.uniqueResult();
		return count;
	}
	
	public Long countCm(Long tthcDmId) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblTthc t where t.tblTthcDm.tthcDmId = :tthcDmId and t.active = true and t.status = 1");
		query.setLong("tthcDmId", tthcDmId);
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	
	public Long countCmActive(Long tthcDmId) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblTthc t where t.tblTthcDm.tthcDmId = :tthcDmId and t.active = true and t.status = 1");
		query.setLong("tthcDmId", tthcDmId);
		count = ((Long)query.uniqueResult()).longValue();
		log.debug("countCmActive count = " + count);
		return count;
	}
	
	public String updateApprovedBatch(String arrtthcId) {
		String sReturn = "";
		
		String[] tthcIds = arrtthcId.split(",");
		log.debug("List Thu Tuc Dao: "+arrtthcId);
		log.debug("tthcIds.length: " + tthcIds.length);
		for (int i = 0; i<tthcIds.length; i++) {
			Long tthcId = null;
			try {
				tthcId = Long.parseLong(tthcIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn += "\n";
				}
				sReturn += "tthcId = " + tthcIds[i] + " là không hợp lệ";
				tthcId = null;
			}
			if (tthcId != null) {
				TblTthc object = get(tthcId);
				if (object == null) {
					if (!"".equals(sReturn)) {
						sReturn += "\n";
					}
					sReturn += "tthcId là " + tthcIds[i] + " không tồn tại";
				} else {
					//object.setStatus((byte)3);
					object.setActive(true);
					Date current = new Date();
					object.setModified(current);
					try {
						update(object);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn += "\n";
						}
						sReturn += "Lỗi phát sinh trong quá trình phê duyệt thủ tục tthcId: " + tthcIds[i];
					}
				}				
			}
		}
		return sReturn;
	}
	public String updateUnApprovedBatch(String arrtthcId) {
		String sReturn = "";
		
		String[] tthcIds = arrtthcId.split(",");
		log.debug("List Thu Tuc Dao: "+arrtthcId);
		log.debug("tthcIds.length: " + tthcIds.length);
		for (int i = 0; i<tthcIds.length; i++) {
			Long tthcId = null;
			try {
				tthcId = Long.parseLong(tthcIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn += "\n";
				}
				sReturn += "tthcId = " + tthcIds[i] + " là không hợp lệ";
				tthcId = null;
			}
			if (tthcId != null) {
				TblTthc object = get(tthcId);
				if (object == null) {
					if (!"".equals(sReturn)) {
						sReturn += "\n";
					}
					sReturn += "tthcId là " + tthcIds[i] + " không tồn tại";
				} else {
					//object.setStatus((byte)3);
					object.setActive(false);
					Date current = new Date();
					object.setModified(current);
					try {
						update(object);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn += "\n";
						}
						sReturn += "Lỗi phát sinh trong quá trình hủy phê duyệt thủ tục tthcId: " + tthcIds[i];
					}
				}				
			}
		}
		return sReturn;
	}
	public List<TblTthc> getByPageApproved(int rowOfPage, int page,
			String parameter) {

		log.debug("Call get List<TblTthc>");
		log.debug("Trang thai Dao Function: "+ parameter);
		List<TblTthc> list = new ArrayList<TblTthc>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countAll();
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			if(parameter == "true"){
				criteria.add(Restrictions.eq("active", (byte)1));
				log.debug("Trang thai Dao: True "+ parameter );
			} else if(parameter == "false"){
				log.debug("Trang thai Dao: False "+ parameter );
				criteria.add(Restrictions.eq("active", (byte)0));
			}
			else{
				log.debug("No search with Approved");
			}
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblTthc> failed", re);
		}
		return list;
	}
	public List<TblTthc> getByPageApproved(int rowOfPage, int page) {

		log.debug("Call get List<TblTthc>");
		List<TblTthc> list = new ArrayList<TblTthc>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countAll();
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTthc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblTthc> failed", re);
		}
		return list;
	}	
}
