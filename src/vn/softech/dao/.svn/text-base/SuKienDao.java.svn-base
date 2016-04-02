package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.GenericJDBCException;

import vn.softech.hibernate.TblSuKien;
import vn.softech.hibernate.TblSuKienTinTuc;
import vn.softech.hibernate.TblTinTuc;
import vn.softech.hibernate.TblVideo;

public class SuKienDao {
	private static Logger log = Logger.getLogger(SuKienDao.class);
	
	public List<TblSuKien> getSuKien() {
		log.debug("Call get List<TblSuKien>");
		List<TblSuKien> list = new ArrayList<TblSuKien>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblSuKien.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblSuKien> failed", re);
		}
		return list;
	}
	public List<TblSuKien> getSuKienPublic() {
		log.debug("Call get List<TblSuKien>");
		List<TblSuKien> list = new ArrayList<TblSuKien>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblSuKien.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("active", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblSuKien> failed", re);
		}
		return list;
	}
	
	public List<TblSuKien> get() {
		log.debug("Call get List<TblSuKien>");
		List<TblSuKien> list = new ArrayList<TblSuKien>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblSuKien.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
			//session.close();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblSuKien> failed", e);
		}
		return list;
	}
	
	public List<TblSuKienTinTuc> getSuKienTinTuc() {
		log.debug("Call get List<TblSuKienTinTuc>");
		List<TblSuKienTinTuc> list = new ArrayList<TblSuKienTinTuc>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblSuKienTinTuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblSuKienTinTuc> failed", re);
		}
		return list;
	}
	
	public List<TblSuKienTinTuc> getSuKienTinTucBySuKienId(Long suKienId) {
		log.debug("Call get List<TblSuKienTinTuc>");
		List<TblSuKienTinTuc> list = new ArrayList<TblSuKienTinTuc>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblSuKienTinTuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("suKienId", suKienId));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblSuKienTinTuc> failed", re);
		}
		return list;
	}
	
	public List<TblSuKienTinTuc> getSuKienTinTucBySuKienId(Long suKienId, int rowOfPage, int page) {
		log.debug("Call get List<TblSuKienTinTuc>");
		List<TblSuKienTinTuc> list = new ArrayList<TblSuKienTinTuc>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countSuKienTinTucBySuKienId(suKienId);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblSuKienTinTuc.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("suKienId", suKienId));
			criteria.add(Restrictions.eq("active", true));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblSuKienTinTuc> failed", re);
		}
		return list;
	}
	
	public Long countSuKienTinTucBySuKienId(Long suKienId) {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblSuKienTinTuc t where t.status = 1 and t.suKienId = :suKienId");
		query.setLong("suKienId", suKienId);
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	
	public List<TblSuKien> getActive() {
		log.debug("Call get List<TblSuKien>");
		List<TblSuKien> list = new ArrayList<TblSuKien>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblSuKien.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("active", true));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblSuKien> failed", re);
		}
		return list;
	}	
	
	public Long save(TblSuKienTinTuc object) {
		log.debug("Call save TblSuKienTinTuc");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblSuKienTinTuc", e);
		}
		return returnId;
	}
	
	public Long save(TblSuKien object) {
		log.debug("Call save TblSuKien");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblSuKien", e);
		}
		return returnId;
	}
	
	public TblSuKien getSuKien(Long suKienId) {
		log.debug("Call get TblSuKien with: " + suKienId);
		TblSuKien object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblSuKien.class);
			criteria.add(Restrictions.eq("suKienId", suKienId));
			object = (TblSuKien)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblSuKien", e);
		}
		return object;
	}
	
	public TblSuKienTinTuc getSuKienTinTuc(Long suKienTinTucId) {
		log.debug("Call get TblSuKienTinTuc with: " + suKienTinTucId);
		TblSuKienTinTuc object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblSuKienTinTuc.class);
			criteria.add(Restrictions.eq("suKienTinTucId", suKienTinTucId));
			object = (TblSuKienTinTuc)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblSuKien", e);
		}
		return object;
	}
	
	public void update(TblSuKien object) throws Exception {
		log.debug("Call update TblSuKien");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblSuKien", e);
			throw e;
		}
	}

	public void update(TblSuKienTinTuc object) throws Exception {
		log.debug("Call update TblSuKienTinTuc");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblSuKienTinTuc", e);
			throw e;
		}
	}
	
	public String updateBatch(String arrSuKienId) {
		String sReturn = "";
		String[] suKienIds = arrSuKienId.split(",");
		log.debug("suKienIds.length: " + suKienIds.length);
		for (int i = 0; i<suKienIds.length; i++) {
			Long suKienId = null;
			try {
				suKienId = Long.parseLong(suKienIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "suKienId = " + suKienIds[i] + " là không hợp lệ";
				suKienId = null;
			}
			if (suKienId != null) {
				TblSuKien suKien = getSuKien(suKienId);
				if (suKien == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "suKienId là " + suKienIds[i] + " không tồn tại";
				} else {
					suKien.setStatus((byte)3);
					Date current = new Date();
					suKien.setModified(current);
					try {
						update(suKien);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn += "Lỗi phát sinh trong quá trình xóa suKienId: " + suKienIds[i];
					}
				}				
			}
		}	
		return sReturn;
	}
	
	public String updateBatchSKTT(String suKienTinTucIds) {
		String sReturn = "";
		String[] skttIds = suKienTinTucIds.split(",");
		log.debug("skttIds.length: " + skttIds.length);
		for (int i = 0; i<skttIds.length; i++) {
			Long suKienTinTucId = null;
			try {
				suKienTinTucId = Long.parseLong(skttIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "suKienTinTucId = " + skttIds[i] + " là không hợp lệ";
				suKienTinTucId = null;
			}
			if (suKienTinTucId != null) {
				TblSuKienTinTuc sktt = getSuKienTinTuc(suKienTinTucId);
				if (sktt == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "suKienTinTucId là " + skttIds[i] + " không tồn tại";
				} else {
					sktt.setStatus((byte)3);
					Date current = new Date();
					sktt.setModified(current);
					try {
						update(sktt);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn += "Lỗi phát sinh trong quá trình xóa suKienTinTucId: " + skttIds[i];
					}
				}				
			}
		}	
		return sReturn;
	}
}
