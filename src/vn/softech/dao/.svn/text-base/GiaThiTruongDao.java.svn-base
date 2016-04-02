package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.GenericJDBCException;

import vn.softech.hibernate.TblGiaThiTruong;
import vn.softech.hibernate.TblTinTuc;

public class GiaThiTruongDao {
	private static Logger log = Logger.getLogger(GiaThiTruongDao.class);
	
	public List<TblGiaThiTruong> get() {
		log.debug("Call get List<TblGiaThiTruong>");
		List<TblGiaThiTruong> list = new ArrayList<TblGiaThiTruong>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiaThiTruong.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("active"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGiaThiTruong> failed", re);
		}
		return list;
	}
	
	public List<TblGiaThiTruong> getGiaThiTruongByCm(Long giaThiTruongCmId) {
		log.debug("Call get List<TblGiaThiTruong>");
		List<TblGiaThiTruong> list = new ArrayList<TblGiaThiTruong>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiaThiTruong.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			if ((giaThiTruongCmId != null) && (giaThiTruongCmId.longValue()>0)) {
				criteria.add(Restrictions.eq("giattCatalogId", giaThiTruongCmId));
			}
			criteria.addOrder(Order.desc("active"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGiaThiTruong> failed", re);
		}
		return list;
	}
	
	public List<TblGiaThiTruong> menuGioiThieu() {
		log.debug("Call get List<TblGiaThiTruong>");
		List<TblGiaThiTruong> list = new ArrayList<TblGiaThiTruong>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiaThiTruong.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("active", true));
//			criteria.addOrder(Order.asc("priority"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGiaThiTruong> failed", re);
		}
		return list;
	}
	public Long save(TblGiaThiTruong object) {
		log.debug("Call save TblGiaThiTruong");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblGiaThiTruong", e);
		}
		return returnId;
	}
	
	public TblGiaThiTruong get(Long giaThiTruongId) {
		log.debug("Call get TblGiaThiTruong with: " + giaThiTruongId);
		TblGiaThiTruong object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiaThiTruong.class);
			criteria.add(Restrictions.eq("giaThiTruongId", giaThiTruongId));
			object = (TblGiaThiTruong)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblGiaThiTruongItem", e);
		}
		return object;
	}
	
	public void update(TblGiaThiTruong object) throws Exception {
		log.debug("Call update TblGiaThiTruong");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblGiaThiTruong", e);
			throw e;
		}
	}

	public List<TblGiaThiTruong> getGiaThiTruongByCatalog(int rowOfPage, int page, Long giattCatalogId) {
		log.debug("Call get List<TblGiaThiTruong>");
		List<TblGiaThiTruong> list = new ArrayList<TblGiaThiTruong>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countGiattCatalog(giattCatalogId);
			log.debug("totalRecord --> :"+ totalRecord);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		log.debug("totalPage: " + totalPage);
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiaThiTruong.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("active", true));
			criteria.add(Restrictions.eq("giattCatalogId", giattCatalogId));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
			log.debug("list size===> "+ list.size());
		} catch (GenericJDBCException e) {
			throw e;
		} catch (RuntimeException e) {
			log.error("get List<TblGiaThiTruong> failed", e);
		}
		return list;
	}
	
	public Long countGiattCatalog(Long giaThiTruongCmId) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblGiaThiTruong t where t.giattCatalogId = :giaThiTruongCmId");
		query.setLong("giaThiTruongCmId", giaThiTruongCmId);
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	
	public String updateBatch(String arrgiaThiTruongId) {
		String sReturn = "";
		String[] giaThiTruongIds = arrgiaThiTruongId.split(",");
		log.debug("giaThiTruongIds.length: " + giaThiTruongIds.length);
		for (int i = 0; i<giaThiTruongIds.length; i++) {
			Long giaThiTruongId = null;
			try {
				giaThiTruongId = Long.parseLong(giaThiTruongIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "giaThiTruongId = " + giaThiTruongIds[i] + " là không hợp lệ";
				giaThiTruongId = null;
			}
			if (giaThiTruongId != null) {
				TblGiaThiTruong gioiThieu = get(giaThiTruongId);
				if (gioiThieu == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "giaThiTruongId là " + giaThiTruongIds[i] + " không tồn tại";
				} else {
					gioiThieu.setStatus((byte)3);
					Date current = new Date();
					gioiThieu.setModified(current);
					try {
						update(gioiThieu);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa giaThiTruongId: " + giaThiTruongIds[i];
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
