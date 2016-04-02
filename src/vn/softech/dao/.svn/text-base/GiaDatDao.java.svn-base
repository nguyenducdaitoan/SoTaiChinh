package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblGiaDat;
import vn.softech.hibernate.TblQuanHuyen;
import vn.softech.hibernate.TblXaPhuong;

public class GiaDatDao {
	private static Logger log = Logger.getLogger(GiaDatDao.class);
	
	public List<TblGiaDat> get(int rowOfPage, int page, Long nam, String tenDuongPho) {
		log.debug("Call get List<TblGiaDat>");
		List<TblGiaDat> list = new ArrayList<TblGiaDat>();
		
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = countAll(nam, tenDuongPho);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiaDat.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("nam", nam));
			criteria.add(Restrictions.eq("parent", false));
			if ((tenDuongPho != null) && (!"".equals(tenDuongPho))){
				criteria.add(Restrictions.like("tenDuongPho", "%" + tenDuongPho + "%"));
			}
			criteria.addOrder(Order.desc("tblGiaDat.giaDatId"));
			criteria.addOrder(Order.asc("tenDuongPho"));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGiaDat> failed", re);
		}
		return list;
	}
	
	public List<TblGiaDat> getTimKiemGiaDat(Long xaPhuongId, Long quanHuyenId, String textQuery) {
		log.debug("Call getTimKiemGiaDat List<TblGiaDat>");
		List<TblGiaDat> list = new ArrayList<TblGiaDat>();
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		Long nam = (long)calendar.get(java.util.Calendar.YEAR);
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiaDat.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			if (xaPhuongId != null) {
				criteria.add(Restrictions.eq("tblXaPhuong.xaPhuongId", xaPhuongId));
			}
			if (quanHuyenId != null) {
				criteria.add(Restrictions.eq("tblQuanHuyen.quanHuyenId", quanHuyenId));
			}
			if ((textQuery != null) && (!"".equals(textQuery))) {
				criteria.add(Restrictions.like("tenDuongPho", "%" + textQuery + "%"));
			}
			criteria.add(Restrictions.eq("nam", nam));
			criteria.add(Restrictions.eq("parent", false));
			criteria.addOrder(Order.desc("tblGiaDat.giaDatId"));
			criteria.addOrder(Order.asc("tenDuongPho"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGiaDat> failed", re);
		}
		
		return list;
	}
	
	public List<TblGiaDat> getTimKiemGiaDat(String textQuery, Long donGiaFrom, Long donGiaTo, int page, int rowOfPage) {
		log.debug("Call getTimKiemGiaDat List<TblGiaDat>");
		List<TblGiaDat> list = new ArrayList<TblGiaDat>();
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		Long nam = (long)calendar.get(java.util.Calendar.YEAR);
		
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			long totalRecord = getCountTimKiemGiaDat(textQuery, donGiaFrom, donGiaTo);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiaDat.class);
			criteria.add(Restrictions.eq("status", (byte)1));
//			if (xaPhuongId != null) {
//				criteria.add(Restrictions.eq("tblXaPhuong.xaPhuongId", xaPhuongId));
//			}
//			if (quanHuyenId != null) {
//				criteria.add(Restrictions.eq("tblQuanHuyen.quanHuyenId", quanHuyenId));
//			}
			if ((textQuery != null) && (!"".equals(textQuery))) {
				criteria.add(Restrictions.like("tenDuongPho", "%" + textQuery + "%"));
			}
			if (donGiaFrom != null) {
				criteria.add(Restrictions.ge("donGia", donGiaFrom));
			}
			if (donGiaTo != null) {
				criteria.add(Restrictions.le("donGia", donGiaTo));
			}
			criteria.add(Restrictions.eq("nam", nam));
			criteria.add(Restrictions.eq("parent", false));
			criteria.addOrder(Order.desc("tblGiaDat.giaDatId"));
			criteria.addOrder(Order.asc("tenDuongPho"));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGiaDat> failed", re);
		}
		
		return list;
	}
	
	public long getCountTimKiemGiaDat(String textQuery, Long donGiaFrom, Long donGiaTo) {
		log.debug("Call getCountTimKiemGiaDat List<TblGiaDat>");
		List<TblGiaDat> list = new ArrayList<TblGiaDat>();
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		Long nam = (long)calendar.get(java.util.Calendar.YEAR);
		long cntRow = 0;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiaDat.class);
			criteria.add(Restrictions.eq("status", (byte)1));
//			if (xaPhuongId != null) {
//				criteria.add(Restrictions.eq("tblXaPhuong.xaPhuongId", xaPhuongId));
//			}
//			if (quanHuyenId != null) {
//				criteria.add(Restrictions.eq("tblQuanHuyen.quanHuyenId", quanHuyenId));
//			}
			if ((textQuery != null) && (!"".equals(textQuery))) {
				criteria.add(Restrictions.like("tenDuongPho", "%" + textQuery + "%"));
			}
			if (donGiaFrom != null) {
				criteria.add(Restrictions.ge("donGia", donGiaFrom));
			}
			if (donGiaTo != null) {
				criteria.add(Restrictions.le("donGia", donGiaTo));
			}
			criteria.add(Restrictions.eq("nam", nam));
			criteria.add(Restrictions.eq("parent", false));
//			criteria.addOrder(Order.desc("tblGiaDat.giaDatId"));
//			criteria.addOrder(Order.asc("tenDuongPho"));
//			criteria.addOrder(Order.desc("modified"));
			criteria.setProjection(Projections.rowCount());
			cntRow = (Long)criteria.uniqueResult();

		} catch (RuntimeException re) {
			log.error("getCountTimKiemGiaDat failed", re);
		}
		
		return cntRow;
	}
	
	public List<TblGiaDat> getAllParent(Long nam) {
		log.debug("Call get List<TblGiaDat>");
		List<TblGiaDat> list = new ArrayList<TblGiaDat>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiaDat.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.add(Restrictions.eq("nam", nam));
			criteria.add(Restrictions.eq("parent", true));
			criteria.addOrder(Order.asc("tenDuongPho"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGiaDat> failed", re);
		}
		return list;
	}
	
	public Long countAll(Long nam, String tenDuongPho) throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		String sSQL = "select count(*) from TblGiaDat t where t.status = 1 and nam =:nam";
		if ((tenDuongPho != null) && (!"".equals(tenDuongPho))) {
			sSQL += " and tenDuongPho like :tenDuongPho";
		}
		Query query = session.createQuery(sSQL);
		query.setLong("nam", nam);
		if ((tenDuongPho != null) && (!"".equals(tenDuongPho))) {
			query.setString("tenDuongPho", "%" + tenDuongPho + "%");
		}
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}
	
	public Long save(TblGiaDat object) {
		log.debug("Call save TblGiaDat");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblGiaDat", e);
		}
		return returnId;
	}
	
	public int delete(Long nam) throws Exception {
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("update TblGiaDat set status = 3 where nam =:nam");
		query.setLong("nam", nam);
		int rowCount = query.executeUpdate();
		session.flush();
		return rowCount;
	}
	
	public TblGiaDat get(Long giaDatId) {
		log.debug("Call get TblGiaDat with: " + giaDatId);
		TblGiaDat object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiaDat.class);
			criteria.add(Restrictions.eq("giaDatId", giaDatId));
			object = (TblGiaDat)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblGiaDat", e);
		}
		return object;
	}
	
	public TblQuanHuyen getQuanHuyen(Long quanHuyenId) {
		log.debug("Call get TblQuanHuyen with: " + quanHuyenId);
		TblQuanHuyen object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblQuanHuyen.class);
			criteria.add(Restrictions.eq("quanHuyenId", quanHuyenId));
			object = (TblQuanHuyen)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblQuanHuyen", e);
		}
		return object;
	}
	
	public TblXaPhuong getXaPhuong(Long xaPhuongId) {
		log.debug("Call get TblXaPhuong with: " + xaPhuongId);
		TblXaPhuong object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblXaPhuong.class);
			criteria.add(Restrictions.eq("xaPhuongId", xaPhuongId));
			object = (TblXaPhuong)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblXaPhuong", e);
		}
		return object;
	}
	
	public void update(TblGiaDat object) throws Exception {
		log.debug("Call update TblGiaDat");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblGiaDat", e);
			throw e;
		}
	}

	public String updateBatch(String arrgiaDatId) {
		String sReturn = "";
		String[] giaDatIds = arrgiaDatId.split(",");
		log.debug("giaDatIds.length: " + giaDatIds.length);
		for (int i = 0; i<giaDatIds.length; i++) {
			Long giaDatId = null;
			try {
				giaDatId = Long.parseLong(giaDatIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "giaDatId = " + giaDatIds[i] + " là không hợp lệ";
				giaDatId = null;
			}
			if (giaDatId != null) {
				TblGiaDat giaDat = get(giaDatId);
				if (giaDat == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "giaDatId là " + giaDatIds[i] + " không tồn tại";
				} else {
					giaDat.setStatus((byte)3);
					Date current = new Date();
					giaDat.setModified(current);
					try {
						update(giaDat);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa giaDatId: " + giaDatIds[i];
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
	
	public List<TblQuanHuyen> getQuanHuyen() {
		log.debug("Call get List<TblQuanHuyen>");
		List<TblQuanHuyen> list = new ArrayList<TblQuanHuyen>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblQuanHuyen.class);
			criteria.add(Restrictions.eq("status", (byte)1));			
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblQuanHuyen> failed", re);
		}
		return list;
	}
	
	public List<TblXaPhuong> getListXaPhuong(Long quanHuyenId) {
		log.debug("Call get List<TblXaPhuong> with quanHuyenId = " + quanHuyenId);
		List<TblXaPhuong> list = new ArrayList<TblXaPhuong>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblXaPhuong.class);
			criteria.add(Restrictions.eq("tblQuanHuyen.quanHuyenId", quanHuyenId));
			criteria.add(Restrictions.eq("status", (byte)1));			
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblXaPhuong> failed", re);
		}
		return list;
	}
}
