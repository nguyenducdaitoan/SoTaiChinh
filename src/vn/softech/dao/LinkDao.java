package vn.softech.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblLink;

public class LinkDao {
	private static Logger log = Logger.getLogger(LinkDao.class);
	
	public List<TblLink> get() {
		log.debug("Call get List<TblLink>");
		List<TblLink> list = new ArrayList<TblLink>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLink.class);
//			criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblLink> failed", re);
		}
		return list;
	}
	
	public Long save(TblLink object) {
		log.debug("Call save TblVote");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblLink", e);
		}
		return returnId;
	}
	
	public TblLink get(Long linkId) {
		log.debug("Call get TblLink with: " + linkId);
		TblLink object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblLink.class);
			criteria.add(Restrictions.eq("linkId", linkId));
			object = (TblLink)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblVoteItem", e);
		}
		return object;
	}
	
	public void update(TblLink object) throws Exception {
		log.debug("Call update TblLink");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail update TblLink", e);
			throw e;
		}
	}

	public String updateBatch(String arrlinkId) {
		String sReturn = "";
		String[] linkIds = arrlinkId.split(",");
		log.debug("linkIds.length: " + linkIds.length);
		for (int i = 0; i<linkIds.length; i++) {
			Long linkId = null;
			try {
				linkId = Long.parseLong(linkIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "linkId = " + linkIds[i] + " là không hợp lệ";
				linkId = null;
			}
			if (linkId != null) {
				TblLink link = get(linkId);
				if (link == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "linkId là " + linkIds[i] + " không tồn tại";
				} else {
					link.setStatus((byte)3);
					Date current = new Date();
					link.setModified(current);
					try {
						update(link);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa linkId: " + linkIds[i];
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
