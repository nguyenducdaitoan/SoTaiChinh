package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblGiattCatalog;
import vn.softech.hibernate.TblThongBao;

public class GiattCatalogDao {
	private static Logger log = Logger.getLogger(GiattCatalogDao.class);
	
	public List<TblGiattCatalog> get() {
		log.debug("Call get List<TblGiattCatalog>");
		List<TblGiattCatalog> list = new ArrayList<TblGiattCatalog>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiattCatalog.class);
//			criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblGiattCatalog> failed", re);
		}
		return list;
	}
	

	public Long save(TblGiattCatalog object) {
		log.debug("Call save TblGiattCatalog");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblGiattCatalog", e);
		}
		return returnId;
	}
	
	public TblGiattCatalog get(Long giaThiTruongCmId) {
		log.debug("Call get TblGiattCatalog with: " + giaThiTruongCmId);
		TblGiattCatalog object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblGiattCatalog.class);
			criteria.add(Restrictions.eq("giaThiTruongCmId", giaThiTruongCmId));
			object = (TblGiattCatalog)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblGiattCatalog", e);
		}
		return object;
	}
	
	public void update(TblGiattCatalog object) throws Exception {
		log.debug("Call update TblGiattCatalog");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblGiattCatalog", e);
			throw e;
		}
	}

	public String updateBatch(String arrGiattCatalogId) {
		String sReturn = "";
		String[] giattCatalogIds = arrGiattCatalogId.split(",");
		log.debug("giattCatalogIds.length: " + giattCatalogIds.length);
		for (int i = 0; i<giattCatalogIds.length; i++) {
			Long giattCatalogId = null;
			try {
				giattCatalogId = Long.parseLong(giattCatalogIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "giattCatalogIds = " + giattCatalogIds[i] + " là không hợp lệ";
				giattCatalogId = null;
			}
			if (giattCatalogId != null) {
				TblGiattCatalog giattCatalog = get(giattCatalogId);
				if (giattCatalog == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "giattCatalogId là " + giattCatalogIds[i] + " không tồn tại";
				} else {
					giattCatalog.setStatus((byte)3);
					Date current = new Date();
					giattCatalog.setModified(current);
					try {
						update(giattCatalog);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa giattCatalogId: " + giattCatalogIds[i];
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
