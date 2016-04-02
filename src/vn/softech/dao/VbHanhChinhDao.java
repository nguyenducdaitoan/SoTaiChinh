package vn.softech.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblVbHanhChinh;

public class VbHanhChinhDao {
private static Logger log = Logger.getLogger(VbHanhChinhDao.class);
	
	public List<TblVbHanhChinh> get() {
		log.debug("Call get List<TblVbHanhChinh>");
		List<TblVbHanhChinh> list = new ArrayList<TblVbHanhChinh>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbHanhChinh.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblVbHanhChinh> failed", re);
		}
		return list;
	}
	
	public List<TblVbHanhChinh> getSearch(String soHieuVb, String sQuery, int rowOfPage, int page) {
		return getSearch(null, null, null, null, null, null, sQuery, rowOfPage, page);
	}
	public List<TblVbHanhChinh> getSearch(Short ldCoQuanId, Short ldLinhVucId, Short ldLoaiVbId, Date from, Date to, String soHieuVb, String sQuery, int rowOfPage, int page) {
		log.debug("Call getSearch List<TblVbHanhChinh>");
		log.debug("ldCoQuanId: " + ldCoQuanId);
		log.debug("ldLinhVucId: " + ldLinhVucId);
		log.debug("ldLoaiVbId: " + ldLoaiVbId);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("sQuery: " + sQuery);
		log.debug("rowOfPage: " + rowOfPage);
		log.debug("page: " + page);
		List<TblVbHanhChinh> list = new ArrayList<TblVbHanhChinh>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			int totalRecord = countSearch(ldCoQuanId, ldLinhVucId, ldLoaiVbId, from, to, soHieuVb, sQuery);
			totalPage = totalRecord/rowOfPage;
			if ((totalRecord%rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if (page > totalPage) page = 1;
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			String sSQL = "from TblVbHanhChinh t where t.status = 1";
			if ((ldCoQuanId != null) && (ldCoQuanId.shortValue() > 0)) {
				sSQL += " and tblLdCoQuan.ldCoQuanId = :ldCoQuanId";
			}
			if ((ldLinhVucId != null) && (ldLinhVucId.shortValue() > 0)) {
				sSQL += " and tblLdLinhVuc.ldLinhVucId = :ldLinhVucId";
			}
			if ((ldLoaiVbId != null) && (ldLoaiVbId.shortValue() > 0)) {
				sSQL += " and tblLdLoaiVb.ldLoaiVbId = :ldLoaiVbId";
			}

			if (from!= null) {
				if (to != null) {
					sSQL += " and ngayBh between :from and :to";
				} else {
					sSQL += " and ngayBh >= :from";
				}
			} else if (to != null) {
				sSQL += " and ngayBh <= :to";
			}
			if ((soHieuVb != null) && (!"".equals(soHieuVb))) {
				sSQL += " and soHieuVb like :soHieuVb";
			}
			if ((sQuery != null) && (!"".equals(sQuery))) {
				sSQL += " and ((tenVb like :tenVb) or (nguoiKyVb like :nguoiKyVb))";
			}
			sSQL += " order by ngayBh desc";
			log.debug("sSQL: " + sSQL);
			Query query = session.createQuery(sSQL);
			if ((ldCoQuanId != null) && (ldCoQuanId.shortValue() > 0)) {
				query.setShort("ldCoQuanId", ldCoQuanId);
			}
			if ((ldLinhVucId != null) && (ldLinhVucId.shortValue() > 0)) {
				query.setShort("ldLinhVucId", ldLinhVucId);
			}
			if ((ldLoaiVbId != null) && (ldLoaiVbId.shortValue() > 0)) {
				query.setShort("ldLoaiVbId", ldLoaiVbId);
			}
			if (from!= null) {
				if (to != null) {
					query.setDate("from", from);
					query.setDate("to", to);
				} else {
					query.setDate("from", from);
				}
			} else if (to != null) {
				query.setDate("to", to);
			}
			if ((soHieuVb != null) && (!"".equals(soHieuVb))) {
				query.setString("soHieuVb", "%" + soHieuVb + "%");
			}
			if ((sQuery != null) && (!"".equals(sQuery))) {
				query.setString("tenVb", "%" + sQuery + "%");
				query.setString("nguoiKyVb", "%" + sQuery + "%");
			}
			int firstResult = (page - 1)*rowOfPage;
			query.setFirstResult(firstResult);
			query.setMaxResults(rowOfPage);
			list = query.list();
		} catch (RuntimeException re) {
			log.error("get List<TblVbHanhChinh> failed", re);
		}
		return list;
	}	
	
	public Long save(TblVbHanhChinh object) {
		log.debug("Call save TblVbHanhChinh");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblVbHanhChinh", e);
		}
		return returnId;
	}
	
	public TblVbHanhChinh get(Long vbHanhChinhId) {
		log.debug("Call get TblVbHanhChinh with: " + vbHanhChinhId);
		TblVbHanhChinh object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVbHanhChinh.class);
			criteria.add(Restrictions.eq("vbHanhChinhId", vbHanhChinhId));
			object = (TblVbHanhChinh)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblVbHanhChinh", e);
		}
		return object;
	}
	
	public void update(TblVbHanhChinh object) throws Exception {
		log.debug("Call update TblVbHanhChinh");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblVbHanhChinh", e);
			throw e;
		}
	}

	public Long countAll() throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblVbHanhChinh t where t.status = 1");
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}

	public int countSearch(Short ldCoQuanId, Short ldLinhVucId, Short ldLoaiVbId, Date from, Date to, String soHieuVb, String sQuery) throws Exception {
		int count = 0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		String sSQL = "select count (*) from TblVbHanhChinh t where t.status = 1";
		if ((ldCoQuanId != null) && (ldCoQuanId.shortValue() > 0)) {
			sSQL += " and tblLdCoQuan.ldCoQuanId = :ldCoQuanId";
		}
		if ((ldLinhVucId != null) && (ldLinhVucId.shortValue() > 0)) {
			sSQL += " and tblLdLinhVuc.ldLinhVucId = :ldLinhVucId";
		}
		if ((ldLoaiVbId != null) && (ldLoaiVbId.shortValue() > 0)) {
			sSQL += " and tblLdLoaiVb.ldLoaiVbId = :ldLoaiVbId";
		}

		if (from!= null) {
			if (to != null) {
				sSQL += " and ngayBh between :from and :to";
			} else {
				sSQL += " and ngayBh >= :from";
			}
		} else if (to != null) {
			sSQL += " and ngayBh <= :to";
		}
		if ((soHieuVb != null) && (!"".equals(soHieuVb))) {
			sSQL += " and soHieuVb like :soHieuVb";
		}
		if ((sQuery != null) && (!"".equals(sQuery))) {
			sSQL += " and ((tenVb like :tenVb) or (nguoiKyVb like :nguoiKyVb))";
		}
		log.debug("sSQL: " + sSQL);
		Query query = session.createQuery(sSQL);
		if ((ldCoQuanId != null) && (ldCoQuanId.shortValue() > 0)) {
			query.setShort("ldCoQuanId", ldCoQuanId);
		}
		if ((ldLinhVucId != null) && (ldLinhVucId.shortValue() > 0)) {
			query.setShort("ldLinhVucId", ldLinhVucId);
		}
		if ((ldLoaiVbId != null) && (ldLoaiVbId.shortValue() > 0)) {
			query.setShort("ldLoaiVbId", ldLoaiVbId);
		}
		if (from!= null) {
			if (to != null) {
				query.setDate("from", from);
				query.setDate("to", to);
			} else {
				query.setDate("from", from);
			}
		} else if (to != null) {
			query.setDate("to", to);
		}
		if ((soHieuVb != null) && (!"".equals(soHieuVb))) {
			query.setString("soHieuVb", "%" + soHieuVb + "%");
		}
		if ((sQuery != null) && (!"".equals(sQuery))) {
			query.setString("tenVb", "%" + sQuery + "%");
			query.setString("nguoiKyVb", "%" + sQuery + "%");
		}
		count = ((Long)query.uniqueResult()).intValue();
		return count;
	}
	
	public String updateBatch(String arrvbHanhChinhId) {
		String sReturn = "";
		String[] vbHanhChinhIds = arrvbHanhChinhId.split(",");
		log.debug("vbHanhChinhIds.length: " + vbHanhChinhIds.length);
		for (int i = 0; i<vbHanhChinhIds.length; i++) {
			Long vbHanhChinhId = null;
			try {
				vbHanhChinhId = Long.parseLong(vbHanhChinhIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "vbHanhChinhId = " + vbHanhChinhIds[i] + " là không hợp lệ";
				vbHanhChinhId = null;
			}
			if (vbHanhChinhId != null) {
				TblVbHanhChinh legalDocuments = get(vbHanhChinhId);
				if (legalDocuments == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "vbHanhChinhId là " + vbHanhChinhIds[i] + " không tồn tại";
				} else {
					legalDocuments.setStatus((byte)3);
					Date current = new Date();
					legalDocuments.setModified(current);
					try {
						update(legalDocuments);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa vbHanhChinhId: " + vbHanhChinhIds[i];
					}
				}				
			}
		}
		return sReturn;
	}
}
