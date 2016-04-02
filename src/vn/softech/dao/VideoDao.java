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

import vn.softech.hibernate.TblLdCap;
import vn.softech.hibernate.TblVideo;

public class VideoDao {
	private static Logger log = Logger.getLogger(VideoDao.class);
	
	public List<TblVideo> get() {
		log.debug("Call get List<TblVideo>");
		List<TblVideo> list = new ArrayList<TblVideo>();		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVideo.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("priority"));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
			//session.close();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblVideo> failed", e);
		}
		return list;
	}
	
	public Long save(TblVideo object) {
		log.debug("Call save TblVideo");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
			//session.close();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail save TblVideo", e);
		}
		return returnId;
	}
	
	public TblVideo get(Long videoId) {
		log.debug("Call get TblVideo with: " + videoId);
		TblVideo object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVideo.class);
			criteria.add(Restrictions.eq("videoId", videoId));
			object = (TblVideo)criteria.list().get(0);
			//session.close();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail get TblVideo", e);
		}
		return object;
	}
	
	public void update(TblVideo object) throws Exception {
		log.debug("Call update TblVideo");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();			
			//session.close();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.debug("fail update TblVideo", e);
			throw e;
		}
	}
	public Long countAll() {
		Long count = (long)0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblVideo t where t.status = 1");
		count = ((Long)query.uniqueResult()).longValue();
		//session.close();
		return count;
	}

	public List<TblVideo> getByPage(int rowOfPage, int page) {
		log.debug("Call get List<TblVideo>");
		List<TblVideo> list = new ArrayList<TblVideo>();
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
			Criteria criteria = session.createCriteria(TblVideo.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("priority"));
			int firstResult = (page - 1)*rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
			//session.close();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblVideo> failed", e);
		}
		return list;
	}
	
	public List<TblVideo> getTop(int numRecord) {
		log.debug("Call get List<TblVideo>");
		List<TblVideo> list = new ArrayList<TblVideo>();
		
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblVideo.class);
			criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("priority"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(numRecord);
			list = criteria.list();
			//session.close();
		} catch (GenericJDBCException e) {
			throw e;
		} catch (Exception e) {
			log.error("get List<TblVideo> failed", e);
		}
		return list;
	}
	
	public String updateBatch(String arrVideoId) {
		String sReturn = "";
		String[] videoIds = arrVideoId.split(",");
		log.debug("videoIds.length: " + videoIds.length);
		for (int i = 0; i<videoIds.length; i++) {
			Long videoId = null;
			try {
				videoId = Long.parseLong(videoIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "videoId = " + videoIds[i] + " là không hợp lệ";
				videoId = null;
			}
			if (videoId != null) {
				TblVideo video = get(videoId);
				if (video == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "videoId là " + videoIds[i] + " không tồn tại";
				} else {
					video.setStatus((byte)3);
					Date current = new Date();
					video.setModified(current);
					try {
						update(video);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa videoId: " + videoIds[i];
					}
				}				
			}
		}
		return sReturn;
	}
}
