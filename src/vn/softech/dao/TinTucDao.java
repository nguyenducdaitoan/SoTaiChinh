package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.GenericJDBCException;

import vn.softech.hibernate.TblChuyenMuc;
import vn.softech.hibernate.TblGioiThieu;
import vn.softech.hibernate.TblTinTuc;

public class TinTucDao {
	private static Logger log = Logger.getLogger(TinTucDao.class);
	
	public List<TblTinTuc> get() {
		log.debug("Call get List<TblTinTuc>");
		List<TblTinTuc> list = new ArrayList<TblTinTuc>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTinTuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblTinTuc> failed", e);
		}
		return list;
	}
	
	/**
	 * Get danh sách tin tức
	 * @param rowOfPage Số bản ghi tin tức trong 1 trang
	 * @param page Trang tin tức cần get
	 * @return
	 */
	public List<TblTinTuc> getTopView(int rowOfPage, int page) {
		log.debug("Call get List<TblTinTuc>");
		List<TblTinTuc> list = new ArrayList<TblTinTuc>();
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
			Criteria criteria = session.createCriteria(TblTinTuc.class);
			criteria.add(Restrictions.eq("approved", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblTinTuc> failed", e);
		}
		return list;
	}
		
	public List<TblTinTuc> getSearch(String sQuery, int rowOfPage, int page) {
		log.debug("Call getSearch List<TblTinTuc>");
		List<TblTinTuc> list = new ArrayList<TblTinTuc>();
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
			Criteria criteria = session.createCriteria(TblTinTuc.class);
			criteria.add(Restrictions.eq("approved", (byte)1));
			if ((sQuery != null) && (!"".equals(sQuery))) {
				log.debug("query is not null");
				Disjunction disjunction = Restrictions.disjunction();
				disjunction.add(Restrictions.like("title", "%" + sQuery + "%"));
				disjunction.add(Restrictions.like("summary", "%" + sQuery + "%"));
				disjunction.add(Restrictions.like("content", "%" + sQuery + "%"));
				criteria.add(disjunction);
			}
			criteria.addOrder(Order.desc("modified"));			
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("getSearch List<TblTinTuc> failed", e);
		}
		return list;
	}
	
	/**
	 * Get danh sách tin tức
	 * @param rowOfPage Số bản ghi tin tức trong 1 trang
	 * @param page Trang tin tức cần get
	 * @return
	 */
	public List<TblTinTuc> getByPage(int rowOfPage, int page) {
		log.debug("Call get List<TblTinTuc>");
		List<TblTinTuc> list = new ArrayList<TblTinTuc>();
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
			Criteria criteria = session.createCriteria(TblTinTuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblTinTuc> failed", e);
		}
		return list;
	}
	
	public List<TblTinTuc> getByPage(int rowOfPage, int page, int approved) {
		log.debug("Call get List<TblTinTuc>");
		List<TblTinTuc> list = new ArrayList<TblTinTuc>();
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
			Criteria criteria = session.createCriteria(TblTinTuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			if(approved != -1){
				criteria.add(Restrictions.eq("approved", (byte)approved));
			}
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblTinTuc> failed", e);
		}
		return list;
	}
	
	public List<TblTinTuc> getByPage(int rowOfPage, int page, Short chuyenMucId, Byte approved, Date from, Date to, String search) {
		log.debug("Call getByPage List<TblTinTuc>");
		List<TblTinTuc> list = new ArrayList<TblTinTuc>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countByPage(chuyenMucId, approved, from, to, search);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTinTuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			if (chuyenMucId != null) {
				criteria.add(Restrictions.eq("tblChuyenMuc.chuyenMucId", chuyenMucId));
			}
			if (approved != null) {
				criteria.add(Restrictions.eq("approved", approved));
			}
			if (from != null) {
				if (to != null) {
					criteria.add(Restrictions.between("modified", from, to));
				} else {
					criteria.add(Restrictions.ge("modified", from));
				}
			} else {
				if (to != null) {
					criteria.add(Restrictions.le("modified", to));
				}
			}
			if (search != null) {
				Disjunction disjunction = Restrictions.disjunction();
				disjunction.add(Restrictions.like("title", "%" + search + "%"));
				disjunction.add(Restrictions.like("summary", "%" + search + "%"));
				disjunction.add(Restrictions.like("content", "%" + search + "%"));
				criteria.add(disjunction);
			}
			
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblTinTuc> failed", e);
		}
		return list;
	}
	
	public List<TblTinTuc> getTopRecentPostAllChuyenMuc() {
		log.debug("Call getTopAllChuyenMuc List<TblTinTuc>");
		List<TblTinTuc> listTinTuc = new ArrayList<TblTinTuc>();
		List<TblChuyenMuc> listChuyenMuc = new ArrayList<TblChuyenMuc>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblChuyenMuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));			
			listChuyenMuc = criteria.list();
			if ((listChuyenMuc != null) && (listChuyenMuc.size()>0)) {
				for (TblChuyenMuc chuyenMuc: listChuyenMuc) {
					criteria = session.createCriteria(TblTinTuc.class);
					criteria.add(Restrictions.eq("status", (byte)1));
					criteria.add(Restrictions.eq("approved", (byte)1));
					criteria.add(Restrictions.eq("tblChuyenMuc.chuyenMucId", chuyenMuc.getChuyenMucId()));
					criteria.addOrder(Order.desc("modified"));
					//criteria.setFirstResult(0);
					//criteria.setMaxResults(numberRecord);
					List<TblTinTuc> list = new ArrayList<TblTinTuc>();
					list = criteria.list();
					if ((list != null) && (list.size()>0)) {
						for (TblTinTuc tinTuc: list) {
							listTinTuc.add(tinTuc);
						}
					}
				}
			}
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("getTopAllChuyenMuc List<TblTinTuc> failed", e);
		}
		return listTinTuc;
	}	
	public List<TblTinTuc> getTopRecentPostAllChuyenMuc(int numberRecord) {
		log.debug("Call getTopAllChuyenMuc List<TblTinTuc>");
		List<TblTinTuc> listTinTuc = new ArrayList<TblTinTuc>();
		List<TblChuyenMuc> listChuyenMuc = new ArrayList<TblChuyenMuc>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblChuyenMuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.asc("priority"));
			criteria.addOrder(Order.desc("modified"));			
			listChuyenMuc = criteria.list();
			if ((listChuyenMuc != null) && (listChuyenMuc.size()>0)) {
				for (TblChuyenMuc chuyenMuc: listChuyenMuc) {
					criteria = session.createCriteria(TblTinTuc.class);
					criteria.add(Restrictions.eq("status", (byte)1));
					criteria.add(Restrictions.eq("approved", (byte)1));
					criteria.add(Restrictions.eq("tblChuyenMuc.chuyenMucId", chuyenMuc.getChuyenMucId()));
					criteria.addOrder(Order.desc("modified"));
					criteria.setFirstResult(0);
					criteria.setMaxResults(numberRecord);
					List<TblTinTuc> list = new ArrayList<TblTinTuc>();
					list = criteria.list();
					if ((list != null) && (list.size()>0)) {
						for (TblTinTuc tinTuc: list) {
							listTinTuc.add(tinTuc);
						}
					}
				}
			}
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("getTopAllChuyenMuc List<TblTinTuc> failed", e);
		}
		return listTinTuc;
	}
	
	public List<TblTinTuc> getTopRecentPost(int numberRecord) {
		log.debug("Call getTopAllChuyenMuc List<TblTinTuc>");
		List<TblTinTuc> listTinTuc = new ArrayList<TblTinTuc>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTinTuc.class);			
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("approved", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(numberRecord);
			listTinTuc = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("getTopAllChuyenMuc List<TblTinTuc> failed", e);
		}
		return listTinTuc;
	}
	
	/**
	 * Get danh sách tin tức ứng với chuyên mục
	 * @param rowOfPage Số bản ghi tin tức trong 1 trang
	 * @param page Trang tin tức cần get
	 * @return
	 */
	public List<TblTinTuc> getByPage(int rowOfPage, int page, Short chuyenMucId) {
		log.debug("Call get List<TblTinTuc>");
		List<TblTinTuc> list = new ArrayList<TblTinTuc>();
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
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTinTuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("tblChuyenMuc.chuyenMucId", chuyenMucId));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblTinTuc> failed", e);
		}
		return list;
	}
	public List<TblTinTuc> getByPageCm(int rowOfPage, int page, Short chuyenMucId, int approved) {
		log.debug("Call get List<TblTinTuc>");
		List<TblTinTuc> list = new ArrayList<TblTinTuc>();
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
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTinTuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("tblChuyenMuc.chuyenMucId", chuyenMucId));
			criteria.addOrder(Order.desc("modified"));
			if(approved != -1){
				criteria.add(Restrictions.eq("approved", (byte)approved));
			}
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblTinTuc> failed", e);
		}
		return list;
	}
	public List<TblTinTuc> getByTinTucByChuyenMucId(int rowOfPage, int page, Short chuyenMucId) {
		log.debug("Call get List<TblTinTuc>");
		List<TblTinTuc> list = new ArrayList<TblTinTuc>();
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
			Criteria criteria = session.createCriteria(TblTinTuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("approved", (byte)1));
			criteria.add(Restrictions.eq("tblChuyenMuc.chuyenMucId", chuyenMucId));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblTinTuc> failed", e);
		}
		return list;
	}
	public Long save(TblTinTuc object) {
		log.debug("Call save TblTinTuc");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail save TblTinTuc", e);
		}
		return returnId;
	}
	
	public TblTinTuc get(Long tinTucId) {
		log.debug("Call get TblTinTuc with: " + tinTucId);
		TblTinTuc object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTinTuc.class);
			criteria.add(Restrictions.eq("tinTucId", tinTucId));
			object = (TblTinTuc)criteria.list().get(0);
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail get TblTinTuc", e);
		}
		return object;
	}
	
	public void update(TblTinTuc object) throws Exception {
		log.debug("Call update TblTinTuc");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail update TblTinTuc", e);
			throw e;
		}
	}

	public Long countAll() throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblTinTuc t where t.status = 1");
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	public Long countAllApproved(int approved) throws Exception {
		Long count = (long)0;
		String strSql = "select count(*) from TblTinTuc t where t.status = 1";
		if(approved != -1){
			strSql += " AND t.approved = "+ approved;
		}
			
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery(strSql);
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	public Long countSearch(String sQuery) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(TblTinTuc.class);
		criteria.add(Restrictions.eq("approved", (byte)1));
		if ((sQuery != null) && (!"".equals(sQuery))) {
			log.debug("query is not null");
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.like("title", "%" + sQuery + "%"));
			disjunction.add(Restrictions.like("summary", "%" + sQuery + "%"));
			disjunction.add(Restrictions.like("content", "%" + sQuery + "%"));
			criteria.add(disjunction);
		}
		count = ((Long)criteria.uniqueResult()).longValue();
		return count;
	}
	
	public Long countCm(Short chuyenMucId) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblTinTuc t where t.tblChuyenMuc.chuyenMucId = :chuyenMucId");
		query.setShort("chuyenMucId", chuyenMucId);
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	public Long countCmApproved(Short chuyenMucId, int approved) throws Exception {
		Long count = (long)0;
		String strSql = "select count(*) from TblTinTuc t where t.tblChuyenMuc.chuyenMucId = :chuyenMucId";
		if(approved != -1){
			strSql += " AND t.approved = "+ approved;
		}
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery(strSql);
		query.setShort("chuyenMucId", chuyenMucId);
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	public String updateBatch(String arrTinTucId) {
		String sReturn = "";
		String[] tinTucIds = arrTinTucId.split(",");
		log.debug("tinTucIds.length: " + tinTucIds.length);
		for (int i = 0; i<tinTucIds.length; i++) {
			Long tinTucId = null;
			try {
				tinTucId = Long.parseLong(tinTucIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "tinTucId = " + tinTucIds[i] + " là không hợp lệ";
				tinTucId = null;
			}
			if (tinTucId != null) {
				TblTinTuc tinTuc = get(tinTucId);
				if (tinTuc == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "Tin tuc là " + tinTucIds[i] + " không tồn tại";
				} else {
					tinTuc.setStatus((byte)3);
					Date current = new Date();
					tinTuc.setModified(current);
					try {
						update(tinTuc);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn += "Lỗi phát sinh trong quá trình xóa tinTucId: " + tinTucIds[i];
					}
				}				
			}
		}
	
		return sReturn;
	}

	public String updateApprovedBatch(String arrTinTuc) {
		String sReturn = "";
		String[] tinTucIds = arrTinTuc.split(",");
		log.debug("tinTucIds.length: " + tinTucIds.length);
		for (int i = 0; i<tinTucIds.length; i++) {
			Long tinTucId = null;
			try {
				tinTucId = Long.parseLong(tinTucIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "tinTucId = " + tinTucIds[i] + " là không hợp lệ";
				tinTucId = null;
			}
			if (tinTucId != null) {
				TblTinTuc tinTuc = get(tinTucId);
				if (tinTuc == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "Tintucid là " + tinTucIds[i] + " không tồn tại";
				} else {
					//tinTuc.setStatus((byte)3);
					tinTuc.setApproved((byte)1);
					Date current = new Date();
					tinTuc.setModified(current);
					try {
						update(tinTuc);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn += "Lỗi phát sinh trong quá trình xóa tinTucId: " + tinTucIds[i];
					}
				}				
			}
		}
	
		return sReturn;
	}
	
	public String updateUnApprovedBatch(String arrTinTuc) {
		String sReturn = "";
		String[] tinTucIds = arrTinTuc.split(",");
		log.debug("tinTucIds.length: " + tinTucIds.length);
		for (int i = 0; i<tinTucIds.length; i++) {
			Long tinTucId = null;
			try {
				tinTucId = Long.parseLong(tinTucIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "tinTucId = " + tinTucIds[i] + " lÃ  khÃ´ng há»£p lá»‡";
				tinTucId = null;
			}
			if (tinTucId != null) {
				TblTinTuc tinTuc = get(tinTucId);
				if (tinTuc == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "Tintucid lÃ  " + tinTucIds[i] + " khÃ´ng tá»“n táº¡i";
				} else {
					//tinTuc.setStatus((byte)3);
					tinTuc.setApproved((byte)0);
					Date current = new Date();
					tinTuc.setModified(current);
					try {
						update(tinTuc);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn += "Lá»—i phÃ¡t sinh trong quÃ¡ trÃ¬nh xÃ³a tinTucId: " + tinTucIds[i];
					}
				}				
			}
		}
	
		return sReturn;
	}
	
	public boolean existUrlSource(String sUrl) {
		log.debug("Call existUrlSource");
		boolean bReturn = false;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblTinTuc.class);
			criteria.add(Restrictions.eq("isTinbenngoai", Boolean.TRUE));
			criteria.add(Restrictions.eq("urlSource", sUrl));
			if (criteria.list().size() > 0) {
				bReturn = true;
			}
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("existUrlSource failed", e);
		}
		return bReturn;
	}
	
	public int countByPage(Short chuyenMucId, Byte approved, Date from, Date to, String search) {
		int count = 0;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			String sSQLQuery = "select count(*) from TblTinTuc where status = 1";
			if (chuyenMucId != null) {
				sSQLQuery += " and tblChuyenMuc.chuyenMucId = :chuyenMucId";
			}
			if (approved != null) {
				sSQLQuery += " and approved = :approved";
			}
			if (from != null) {
				if (to != null) {
					sSQLQuery += " and modified between :from  and :to";
				} else {
					sSQLQuery += " and modified >= :from";
				}
			} else {
				if (to != null) {
					sSQLQuery += " and modified <= :to";
				}
			}
			if (search != null) {
				sSQLQuery += " and ((title like :search) or (summary like :search) or (content like :search))";				
			}
			sSQLQuery += " order by modified";
			log.debug("sSQLQuery: " + sSQLQuery);
			
			Query query =  session.createQuery(sSQLQuery);			
			
			if (chuyenMucId != null) {
				query.setShort("chuyenMucId", chuyenMucId);
			}
			if (approved != null) {
				query.setByte("approved", approved);
			}
			if (from != null) {
				if (to != null) {
					query.setDate("from", from);
					query.setDate("to", to);
				} else {
					query.setDate("from", from);
				}
			} else {
				if (to != null) {
					query.setDate("to", to);
				}
			}
			if (search != null) {
				query.setString("search", "%" + search + "%");				
			}
			count = ((Long)query.uniqueResult()).intValue();
			
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("existUrlSource failed", e);
		}
		return count;
	}
}
