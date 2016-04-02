package vn.softech.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblLegalDocuments;
import vn.softech.hibernate.TblTinTuc;

public class LegalDocumentsDao {
	private static Logger log = Logger.getLogger(LegalDocumentsDao.class);
	
	public List<TblLegalDocuments> get() {
		log.debug("Call get List<TblLegalDocuments>");
		List<TblLegalDocuments> list = new ArrayList<TblLegalDocuments>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLegalDocuments.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblLegalDocuments> failed", re);
		}
		return list;
	}

	public List<TblLegalDocuments> getSearch(String soHieuVb, String sQuery, int rowOfPage, int page) {
		return getSearch(null, null, null, null, null, null, null, sQuery, rowOfPage, page);
	}
	public List<TblLegalDocuments> getSearch(Short ldCoQuanId, Short ldLinhVucId, Short ldLoaiVbId, Short ldCapId, Date from, Date to, String soHieuVb, String sQuery, int rowOfPage, int page) {
		log.debug("Call getSearch List<TblLegalDocuments>");
		log.debug("ldCoQuanId: " + ldCoQuanId);
		log.debug("ldLinhVucId: " + ldLinhVucId);
		log.debug("ldLoaiVbId: " + ldLoaiVbId);
		log.debug("ldCapId: " + ldCapId);
		log.debug("from: " + from);
		log.debug("to: " + to);
		log.debug("sQuery: " + sQuery);
		log.debug("rowOfPage: " + rowOfPage);
		log.debug("page: " + page);
		List<TblLegalDocuments> list = new ArrayList<TblLegalDocuments>();
		if (rowOfPage <= 0) return list;
		if (page <= 0) return list;
		long totalPage = 0;
		try {
			int totalRecord = countSearch(ldCoQuanId, ldLinhVucId, ldLoaiVbId, ldCapId, from, to, soHieuVb, sQuery);
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
			String sSQL = "from TblLegalDocuments t where t.status = 1";
			if ((ldCoQuanId != null) && (ldCoQuanId.shortValue() > 0)) {
				sSQL += " and tblLdCoQuan.ldCoQuanId = :ldCoQuanId";
			}
			if ((ldLinhVucId != null) && (ldLinhVucId.shortValue() > 0)) {
				sSQL += " and tblLdLinhVuc.ldLinhVucId = :ldLinhVucId";
			}
			if ((ldLoaiVbId != null) && (ldLoaiVbId.shortValue() > 0)) {
				sSQL += " and tblLdLoaiVb.ldLoaiVbId = :ldLoaiVbId";
			}
			if ((ldCapId != null) && (ldCapId.shortValue() > 0)) {
				sSQL += " and tblLdCoQuan.tblLdCap.ldCapId = :ldCapId";
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
			if ((ldCapId != null) && (ldCapId.shortValue() > 0)) {
				query.setShort("ldCapId", ldCapId);
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
			log.error("get List<TblLegalDocuments> failed", re);
		}
		return list;
	}

	public Long save(TblLegalDocuments object) {
		log.debug("Call save TblLegalDocuments");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblLegalDocuments", e);
		}
		return returnId;
	}
	
	public TblLegalDocuments get(Long legalDocumentsId) {
		log.debug("Call get TblLegalDocuments with: " + legalDocumentsId);
		TblLegalDocuments object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLegalDocuments.class);
			criteria.add(Restrictions.eq("legalDocumentsId", legalDocumentsId));
			object = (TblLegalDocuments)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblLegalDocuments", e);
		}
		return object;
	}
	
	public void update(TblLegalDocuments object) throws Exception {
		log.debug("Call update TblLegalDocuments");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblLegalDocuments", e);
			throw e;
		}
	}

	public Long countAll() throws Exception {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblLegalDocuments t where t.status = 1");
		count = ((Long)query.uniqueResult()).longValue();
		return count;
	}

	public int countSearch(Short ldCoQuanId, Short ldLinhVucId, Short ldLoaiVbId, Short ldCapId, Date from, Date to, String soHieuVb, String sQuery) throws Exception {
		int count = 0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		String sSQL = "select count (*) from TblLegalDocuments t where t.status = 1";
		if ((ldCoQuanId != null) && (ldCoQuanId.shortValue() > 0)) {
			sSQL += " and tblLdCoQuan.ldCoQuanId = :ldCoQuanId";
		}
		if ((ldLinhVucId != null) && (ldLinhVucId.shortValue() > 0)) {
			sSQL += " and tblLdLinhVuc.ldLinhVucId = :ldLinhVucId";
		}
		if ((ldLoaiVbId != null) && (ldLoaiVbId.shortValue() > 0)) {
			sSQL += " and tblLdLoaiVb.ldLoaiVbId = :ldLoaiVbId";
		}
		if ((ldCapId != null) && (ldCapId.shortValue() > 0)) {
			sSQL += " and tblLdCoQuan.tblLdCap.ldCapId = :ldCapId";
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
		if ((ldCapId != null) && (ldCapId.shortValue() > 0)) {
			query.setShort("ldCapId", ldCapId);
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
//		count = query.list().size();
		count = ((Long)query.uniqueResult()).intValue();
//		count = ((Integer)query.iterate().next()).intValue();
		return count;
/*		
		Integer count = 0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(TblLegalDocuments.class);
		criteria.add(Restrictions.eq("status", (byte)1));
		if ((sQuery != null) && (!"".equals(sQuery))) {
			log.debug("query is not null");
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.like("tenVb", "%" + sQuery + "%"));
//			disjunction.add(Restrictions.like("soHieuVb", "%" + sQuery + "%"));
			disjunction.add(Restrictions.like("nguoiKyVb", "%" + sQuery + "%"));
			criteria.add(disjunction);
		}
		
		if ((ldCoQuanId != null) && (ldCoQuanId.shortValue() > 0)) {
			criteria.add(Restrictions.eq("tblLdCoQuan.ldCoQuanId", ldCoQuanId));
		}
		if ((ldLinhVucId != null) && (ldLinhVucId.shortValue() > 0)) {
			criteria.add(Restrictions.eq("tblLdLinhVuc.ldLinhVucId", ldCoQuanId));
		}
		if ((ldLoaiVbId != null) && (ldLoaiVbId.shortValue() > 0)) {
			criteria.add(Restrictions.eq("tblLdLoaiVb.ldLoaiVbId", ldLoaiVbId));
		}
		
		if (from!= null) {
			if (to != null) {
				criteria.add(Restrictions.between("ngayBh", from, to));
			} else {
				criteria.add(Restrictions.ge("ngayBh", from));
			}
		} else if (to != null) {
			criteria.add(Restrictions.le("ngayBh", to));
		}

		count = (Integer)criteria.uniqueResult();
		return count;
*/
	}
	
	public String updateBatch(String arrLegalDocumentsId) {
		String sReturn = "";
		String[] legalDocumentsIds = arrLegalDocumentsId.split(",");
		log.debug("legalDocumentsIds.length: " + legalDocumentsIds.length);
		for (int i = 0; i<legalDocumentsIds.length; i++) {
			Long legalDocumentsId = null;
			try {
				legalDocumentsId = Long.parseLong(legalDocumentsIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "legalDocumentsId = " + legalDocumentsIds[i] + " là không hợp lệ";
				legalDocumentsId = null;
			}
			if (legalDocumentsId != null) {
				TblLegalDocuments legalDocuments = get(legalDocumentsId);
				if (legalDocuments == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "legalDocumentsId là " + legalDocumentsIds[i] + " không tồn tại";
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
						sReturn = "Lỗi phát sinh trong quá trình xóa legalDocumentsId: " + legalDocumentsIds[i];
					}
				}				
			}
		}
		return sReturn;
	}
}
