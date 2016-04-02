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

import vn.softech.hibernate.TblThongBao;
import vn.softech.hibernate.TblTinTuc;
import vn.softech.hibernate.TblUsers;

public class ThongBaoDao {
	private static Logger log = Logger.getLogger(ThongBaoDao.class);
	
	public List<TblThongBao> get() {
		log.debug("Call get List<TblThongBao>");
		List<TblThongBao> list = new ArrayList<TblThongBao>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblThongBao.class);
//			criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte)1));
			list = criteria.list();
			//session.close();
		} catch (RuntimeException re) {
			log.error("get List<TblUsers> failed", re);
		}
		return list;
	}
	
	public List<TblThongBao> get(String querySearch) {
		log.debug("Call get List<TblThongBao>");
		List<TblThongBao> list = new ArrayList<TblThongBao>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblThongBao.class);
			if ((querySearch != null) && (!"".equals(querySearch))) {
				log.debug("query is not null");
				Disjunction disjunction = Restrictions.disjunction();
				disjunction.add(Restrictions.like("title", "%" + querySearch + "%"));
				disjunction.add(Restrictions.like("content", "%" + querySearch + "%"));
				criteria.add(disjunction);
			}
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("active"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblThongBao> failed", re);
		}
		return list;
	}
	
	/**
	 * get public thong bao
	 * @param numberRecord
	 * @return
	 */
	public List<TblThongBao> getTopThongBao(int numberRecord) {
		log.debug("Call getTopThongBao List<TblThongBao>");
		List<TblThongBao> listThongBao = new ArrayList<TblThongBao>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblThongBao.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("active", true));
			criteria.addOrder(Order.desc("modified"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(numberRecord);
			listThongBao = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTopThongBao List<TblThongBao> failed", re);
		}
		return listThongBao;
	}
	
	public List<TblThongBao> getThongBaoPublic(int numberRecord) {
		log.debug("Call getTopThongBao List<TblThongBao>");
		List<TblThongBao> listThongBao = new ArrayList<TblThongBao>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblThongBao.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("active", true));
			Date current = new Date();
			criteria.add(Restrictions.or(Restrictions.isNull("tuNgay"), Restrictions.and(Restrictions.isNotNull("tuNgay"),Restrictions.le("tuNgay", current))));
			criteria.add(Restrictions.or(Restrictions.isNull("denNgay"), Restrictions.and(Restrictions.isNotNull("denNgay"),Restrictions.ge("denNgay", current))));
			criteria.addOrder(Order.desc("modified"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(numberRecord);
			listThongBao = criteria.list();
		} catch (RuntimeException re) {
			log.error("getTopThongBao List<TblThongBao> failed", re);
		}
		return listThongBao;
	}
	
	public Long save(TblThongBao object) {
		log.debug("Call save TblVote");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblThongBao", e);
		}
		return returnId;
	}
	
	public TblThongBao get(Long thongBaoId) {
		log.debug("Call get TblThongBao with: " + thongBaoId);
		TblThongBao object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblThongBao.class);
			criteria.add(Restrictions.eq("thongBaoId", thongBaoId));
			object = (TblThongBao)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return object;
	}
	
	public void update(TblThongBao object) throws Exception {
		log.debug("Call update TblThongBao");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblThongBao", e);
			throw e;
		}
	}

	public String updateBatch(String arrthongBaoId) {
		String sReturn = "";
		String[] thongBaoIds = arrthongBaoId.split(",");
		log.debug("thongBaoIds.length: " + thongBaoIds.length);
		for (int i = 0; i<thongBaoIds.length; i++) {
			Long thongBaoId = null;
			try {
				thongBaoId = Long.parseLong(thongBaoIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "thongBaoId = " + thongBaoIds[i] + " là không hợp lệ";
				thongBaoId = null;
			}
			if (thongBaoId != null) {
				TblThongBao thongBao = get(thongBaoId);
				if (thongBao == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "thongBaoId là " + thongBaoIds[i] + " không tồn tại";
				} else {
					thongBao.setStatus((byte)3);
					Date current = new Date();
					thongBao.setModified(current);
					try {
						update(thongBao);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa thongBaoId: " + thongBaoIds[i];
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
	
	public Long countSearch(String sQuery) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(TblThongBao.class);
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
	
	public List<TblThongBao> getByPage(int rowOfPage, int page) {
		log.debug("Call get List<TblThongBao>");
		List<TblThongBao> list = new ArrayList<TblThongBao>();
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
			Criteria criteria = session.createCriteria(TblThongBao.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblThongBao> failed", e);
		}
		return list;
	}
	
	public Long countAll() throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblThongBao t where t.status = 1");
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
}
