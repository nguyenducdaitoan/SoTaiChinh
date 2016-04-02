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
import org.hibernate.exception.GenericJDBCException;

import vn.softech.hibernate.TblBmdt;
import vn.softech.hibernate.TblTinTuc;

public class BmdtDao {
	private static Logger log = Logger.getLogger(BmdtDao.class);
	
	public List<TblBmdt> get() {
		log.debug("Call get List<TblBmdt>");
		List<TblBmdt> list = new ArrayList<TblBmdt>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdt.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblBmdt> failed", e);
		}
		return list;
	}
	
	/**
	 * Get danh sách thủ tục
	 * @param rowOfPage Số bản ghi thủ tuc trong 1 trang
	 * @param page Trang thủ tục cần get
	 * @return
	 */
	public List<TblBmdt> getByPage(int rowOfPage, int page) {
		log.debug("Call get List<TblBmdt>");
		List<TblBmdt> list = new ArrayList<TblBmdt>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countAll();
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch (GenericJDBCException e) {
			throw e;
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdt.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblBmdt> failed", e);
		}
		return list;
	}
	
	public List<TblBmdt> getSearch(String sQuery, int rowOfPage, int page) {
		log.debug("Call get List<TblBmdt>");
		List<TblBmdt> list = new ArrayList<TblBmdt>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countSearch(sQuery);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch (GenericJDBCException e) {
			throw e;
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdt.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			if ((sQuery != null) && (!"".equals(sQuery))) {
				log.debug("query is not null");
				criteria.add(Restrictions.like("description", "%" + sQuery + "%"));
			}
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblBmdt> failed", e);
		}
		return list;
	}
	
	public List<TblBmdt> getByBmdtPublic(int rowOfPage, int page,  Long chuyenMucId) {
		log.debug("Call get List<TblBmdt>");
		List<TblBmdt> list = new ArrayList<TblBmdt>();
		if (chuyenMucId <= 0) return list;
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
			Criteria criteria = session.createCriteria(TblBmdt.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("active", true));
			criteria.add(Restrictions.eq("tblBmdtDm.bmdtDmId", chuyenMucId));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblBmdt> failed", e);
		}
		return list;
	}
	public List<TblBmdt> getByPagePublic(int rowOfPage, int page) {
		log.debug("Call get List<TblBmdt>");
		List<TblBmdt> list = new ArrayList<TblBmdt>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countAll();
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch (GenericJDBCException e) {
			throw e;
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdt.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("active", true));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblBmdt> failed", e);
		}
		return list;
	}
	public List<TblBmdt> getByBmdtPublic( Long chuyenMucId) {
		log.debug("Call get List<TblBmdt>");
		List<TblBmdt> list = new ArrayList<TblBmdt>();
		if (chuyenMucId <= 0) return list;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdt.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("tblBmdtDm.bmdtDmId", chuyenMucId));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblBmdt> failed", e);
		}
		return list;
	}
	
	public List<TblBmdt> getByBmdtPublicByNum(int numberRecord) {
		log.debug("Call get List<TblBmdt>");
		List<TblBmdt> list = new ArrayList<TblBmdt>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdt.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(numberRecord);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblBmdt> failed", e);
		}
		return list;
	}
	/**
	 * Get danh sách thủ tuc ứng với chuyên mục
	 * @param rowOfPage Số bản ghi thủ tuc trong 1 trang
	 * @param page Trang thủ tuc cần get
	 * @return
	 */
	public List<TblBmdt> getByPage(int rowOfPage, int page, Long bmdtDmId) {
		log.debug("Call get List<TblBmdt>");
		List<TblBmdt> list = new ArrayList<TblBmdt>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countCm(bmdtDmId);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdt.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			log.debug("chuyen muc Dao:" + bmdtDmId);
			criteria.add(Restrictions.eq("tblBmdtDm.bmdtDmId", bmdtDmId));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblBmdt> failed", e);
		}
		return list;
	}
	
	public Long save(TblBmdt object) {
		log.debug("Call save TblVote");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblBmdt", e);
		}
		return returnId;
	}
	
	public TblBmdt get(Long bmdtId) {
		log.debug("Call get TblBmdt with: " + bmdtId);
		TblBmdt object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdt.class);
			criteria.add(Restrictions.eq("bmdtId", bmdtId));
			object = (TblBmdt)criteria.list().get(0);
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail get TblBmdt", e);
		}
		return object;
	}
	public TblBmdt getPublic(Long bmdtId) {
		log.debug("Call get TblBmdt with: " + bmdtId);
		TblBmdt object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdt.class);
			criteria.add(Restrictions.eq("bmdtId", bmdtId));
			criteria.add(Restrictions.eq("status", (byte)1));
			object = (TblBmdt)criteria.list().get(0);
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail get TblBmdt", e);
		}
		return object;
	}
	public void update(TblBmdt object) throws Exception {
		log.debug("Call update TblBmdt");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail update TblBmdt", e);
			throw e;
		}
	}

	public Long countAll() {
		// TODO Auto-generated method stub
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblBmdt t where t.status = 1");
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	
	public Long countSearch(String sQuery) {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(TblBmdt.class);
		criteria.add(Restrictions.eq("status", (byte)1));
		if ((sQuery != null) && (!"".equals(sQuery))) {
			log.debug("query is not null");
			criteria.add(Restrictions.like("description", "%" + sQuery + "%"));
		}
		count = (Long)criteria.uniqueResult();
		return count;
	}
	
	public Long countCm(Long bmdtDmId) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblBmdt t where t.tblBmdtDm.bmdtDmId = :bmdtDmId and t.status = 1");
		query.setLong("bmdtDmId", bmdtDmId);
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	
	public Long countCmActive(Long bmdtDmId) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblBmdt t where t.tblBmdtDm.bmdtDmId = :bmdtDmId and t.status = 1 and t.active = :active");
		query.setBoolean("active", true);
		query.setLong("bmdtDmId", bmdtDmId);
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	
	public String updateApprovedBatch(String arrbmdtId) {
		String sReturn = "";
		
		String[] bmdtIds = arrbmdtId.split(",");
		log.debug("List Thu Tuc Dao: "+arrbmdtId);
		log.debug("bmdtIds.length: " + bmdtIds.length);
		for (int i = 0; i<bmdtIds.length; i++) {
			Long bmdtId = null;
			try {
				bmdtId = Long.parseLong(bmdtIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn += "\n";
				}
				sReturn += "bmdtId = " + bmdtIds[i] + " là không hợp lệ";
				bmdtId = null;
			}
			if (bmdtId != null) {
				TblBmdt object = get(bmdtId);
				if (object == null) {
					if (!"".equals(sReturn)) {
						sReturn += "\n";
					}
					sReturn += "bmdtId là " + bmdtIds[i] + " không tồn tại";
				} else {
					object.setStatus((byte)3);
					Date current = new Date();
					object.setModified(current);
					try {
						update(object);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn += "\n";
						}
						sReturn += "Lỗi phát sinh trong quá trình phê duyệt thủ tục bmdtId: " + bmdtIds[i];
					}
				}				
			}
		}
		return sReturn;
	}
	public List<TblBmdt> getByPageApproved(int rowOfPage, int page,
			String parameter) {

		log.debug("Call get List<TblBmdt>");
		log.debug("Trang thai Dao Function: "+ parameter);
		List<TblBmdt> list = new ArrayList<TblBmdt>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countAll();
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch (GenericJDBCException e) {
			throw e;
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblBmdt.class);
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
		} catch (Exception e) {
			log.error("get List<TblBmdt> failed", e);
		}
		return list;
	}
	public String updateBatch(String arrBmdtId) {
		String sReturn = "";
		String[] bmdtIds = arrBmdtId.split(",");
		log.debug("bmdtIds.length: " + bmdtIds.length);
		for (int i = 0; i<bmdtIds.length; i++) {
			Long bmdtId = null;
			try {
				bmdtId = Long.parseLong(bmdtIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "bmdtId = " + bmdtIds[i] + " là không hợp lệ";
				bmdtId = null;
			}
			if (bmdtId != null) {
				TblBmdt bmdt = get(bmdtId);
				if (bmdt == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "bmdtId là " + bmdtIds[i] + " không tồn tại";
				} else {
					bmdt.setStatus((byte)3);
					Date current = new Date();
					bmdt.setModified(current);
					try {
						update(bmdt);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa bmdtId: " + bmdtIds[i];
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
