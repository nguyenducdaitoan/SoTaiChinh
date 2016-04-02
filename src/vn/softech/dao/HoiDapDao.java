package vn.softech.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblAnswer;
import vn.softech.hibernate.TblQuestion;
import vn.softech.hibernate.TblQuestionAssign;
import vn.softech.hibernate.TblUsers;

public class HoiDapDao {
	private static Logger log = Logger.getLogger(HoiDapDao.class);

	public List<TblQuestion> get() {
		log.debug("Call get List<TblQuestion>");
		List<TblQuestion> list = new ArrayList<TblQuestion>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory
					.getSession();
			Criteria criteria = session.createCriteria(TblQuestion.class);
			// criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte) 1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblQuestion> failed", re);
		}
		return list;
	}

	public List<TblQuestion> getByUser(long usersId) {
		log.debug("Call get List<TblQuestion>");
		List<TblQuestion> listQuestion = new ArrayList<TblQuestion>();
		List<TblQuestionAssign> listQuestionAssign = new ArrayList<TblQuestionAssign>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory
					.getSession();
			Criteria criteria = session.createCriteria(TblQuestionAssign.class).createAlias("tblQuestion","tblQuestion");
			criteria.add(Restrictions.eq("assignToUsersId.usersId", usersId));
			criteria.add(Restrictions.eq("tblQuestion.status", (byte)1));
			criteria.addOrder(Order.asc("assignDate"));
			listQuestionAssign = criteria.list();
			if ((listQuestionAssign != null) && (listQuestionAssign.size() > 0)) {
				for (TblQuestionAssign qa: listQuestionAssign) {
					listQuestion.add(qa.getTblQuestion());
				}
			}
		} catch (RuntimeException re) {
			log.error("get List<TblQuestion> failed", re);
		}
		return listQuestion;
	}

	public List<TblQuestion> getPage(int rowOfPage, int page) {
		log.debug("Call get List<TblQuestion>");
		List<TblQuestion> list = new ArrayList<TblQuestion>();
		if (rowOfPage <= 0)
			return list;
		if (page <= 0)
			return list;
		long totalPage = 0;
		try {
			long totalRecord = countAll();
			totalPage = totalRecord / rowOfPage;
			if ((totalRecord % rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch (Exception e) {
		}
		log.debug("totalPage: " + totalPage);
		if (page > totalPage)
			page = 1;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory
					.getSession();
			Criteria criteria = session.createCriteria(TblQuestion.class);
			// criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte) 1));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1) * rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblQuestion> failed", re);
		}
		return list;
	}

	public List<TblQuestion> getQuestion(int rowOfPage, int page) {
		log.debug("Call getQuestion List<TblQuestion>");
		List<TblQuestion> list = new ArrayList<TblQuestion>();
		if (rowOfPage <= 0)
			return list;
		if (page <= 0)
			return list;
		long totalPage = 0;
		try {
			long totalRecord = countQuestion();
			totalPage = totalRecord / rowOfPage;
			if ((totalRecord % rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch (Exception e) {
		}
		log.debug("totalPage: " + totalPage);
		if (page > totalPage)
			page = 1;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblQuestion.class);
			criteria.add(Restrictions.eq("status", (byte) 1));
			criteria.add(Restrictions.isNotEmpty("tblAnswers"));
			criteria.addOrder(Order.desc("modified"));
			int firstResult = (page - 1) * rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblQuestion> failed", re);
		}
		return list;
	}
	
	public Long countAll() {
		Long count = (long) 0;
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblQuestion t where t.status = 1");
		count = ((Long) query.uniqueResult()).longValue();
		return count;
	}

	public Long countQuestion() {
		Long rowCount = (long) 0;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblQuestion.class).setProjection(Projections.rowCount());
			criteria.add(Restrictions.eq("status", (byte) 1));
			criteria.add(Restrictions.isNotEmpty("tblAnswers"));
			List result = criteria.list();
			if (!result.isEmpty()) {
				rowCount = Long.parseLong(result.get(0).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public List<TblQuestionAssign> getQuestionAssign() {
		log.debug("Call get List<TblQuestionAssign>");
		List<TblQuestionAssign> list = new ArrayList<TblQuestionAssign>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblQuestionAssign.class);
			// criteria.setCacheMode(CacheMode.IGNORE);
			// criteria.add(Restrictions.eq("status", (byte)1));
			criteria.addOrder(Order.desc("assignDate"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblQuestionAssign> failed", re);
		}
		return list;
	}

	public List<TblAnswer> getAnswer(Long questionId) {
		log.debug("Call get List<TblAnswer>");
		List<TblAnswer> list = new ArrayList<TblAnswer>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblAnswer.class);
			criteria.add(Restrictions.eq("tblQuestion.questionId", questionId));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblAnswer> failed", re);
		}
		return list;
	}

	public List<TblAnswer> getAnswerPage(int rowOfPage, int page,Long questionId) {
		log.debug("Call get List<TblAnswer>");
		List<TblAnswer> list = new ArrayList<TblAnswer>();
		if (rowOfPage <= 0)
			return list;
		if (page <= 0)
			return list;
		long totalPage = 0;
		try {
			long totalRecord = countAnswerByQestionId(questionId);
			totalPage = totalRecord / rowOfPage;
			if ((totalRecord % rowOfPage) > 0) {
				totalPage += 1;
			}
		} catch (Exception e) {
		}

		if (page > totalPage)
			page = 1;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblAnswer.class);
			criteria.add(Restrictions.eq("tblQuestion.questionId", questionId));
			criteria.addOrder(Order.desc("modified"));
			criteria.add(Restrictions.eq("status", (byte) 1));
			int firstResult = (page - 1) * rowOfPage;
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(rowOfPage);
			list = criteria.list();
			log.debug("Dao list.size():" + list.size());
		} catch (RuntimeException re) {
			log.error("get List<TblAnswer> failed", re);
		}
		return list;
	}

	public Long countAnswerByQestionId(Long questionId) throws Exception {
		Long count = (long) 0;
		log.debug("questionId Dao ; " + questionId);
		org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
		Query query = session.createQuery("select count(*) from TblAnswer t where t.tblQuestion.questionId = :questionId and t.status = 1");
		query.setLong("questionId", questionId);
		count = ((Long) query.uniqueResult()).longValue();
		return count;
	}

	public List<TblUsers> getUsers() {
		log.debug("Call get List<TblUsers>");
		List<TblUsers> list = new ArrayList<TblUsers>();
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory
					.getSession();
			Criteria criteria = session.createCriteria(TblUsers.class);
			// criteria.setCacheMode(CacheMode.IGNORE);
			criteria.add(Restrictions.eq("status", (byte) 1));
			criteria.addOrder(Order.desc("modified"));
			list = criteria.list();
		} catch (RuntimeException re) {
			log.error("get List<TblUsers> failed", re);
		}
		return list;
	}

	public Long save(TblQuestion object) {
		log.debug("Call save TblQuestion");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long) session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblLink", e);
		}
		return returnId;
	}

	public void update(TblQuestion object) throws Exception {
		log.debug("Call update TblQuestion");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblQuestion", e);
			throw e;
		}
	}
	public void deleteAnswer(TblAnswer object) throws Exception {
		log.debug("Call delete TblAnswer");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.delete(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblAnswer", e);
			throw e;
		}
	}

	public Long save(TblAnswer object) {
		log.debug("Call save TblAnswer");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long) session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblAnswer", e);
		}
		return returnId;
	}

	public void update(TblAnswer object) throws Exception {
		log.debug("Call update TblAnswer");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblAnswer", e);
			throw e;
		}
	}

	public Integer save(TblQuestionAssign object) {
		log.debug("Call save TblQuestionAssign");
		Integer returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Integer) session.save(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail save TblQuestionAssign", e);
		}
		return returnId;
	}

	public void update(TblQuestionAssign object) throws Exception {
		log.debug("Call update TblQuestionAssign");
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			session.update(object);
			session.flush();
		} catch (Exception e) {
			log.debug("fail update TblQuestionAssign", e);
			throw e;
		}
	}

	public TblQuestion getQuestion(Long questionId) {
		log.debug("Call get TblQuestion with: " + questionId);
		TblQuestion object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblQuestion.class);
			criteria.add(Restrictions.eq("questionId", questionId));
			object = (TblQuestion) criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblQuestion", e);
		}
		return object;
	}
	
	public TblAnswer getAnswerById(Long answerId) {
		log.debug("Call get TblAnswer with: " + answerId);
		TblAnswer object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblAnswer.class);
			criteria.add(Restrictions.eq("answerId", answerId));
			object = (TblAnswer) criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblAnswer", e);
		}
		return object;
	}


	// public TblQuestion getQuestionTitle(String title) {
	// log.debug("Call get TblQuestion with: " + title);
	// TblQuestion object = null;
	// try {
	// org.hibernate.Session session =
	// vn.softech.hibernate.HibernateSessionFactory.getSession();
	// Criteria criteria = session.createCriteria(TblQuestion.class);
	// criteria.add(Restrictions.eq("title", title));
	// object = (TblQuestion)criteria.list().get(0);
	// } catch (Exception e) {
	// log.debug("fail get TblQuestion", e);
	// }
	// return object;
	// }

	public TblAnswer getQuestionAnswer(Long answerId) {
		log.debug("Call get TblAnswer with: " + answerId);
		TblAnswer object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblAnswer.class);
			criteria.add(Restrictions.eq("answerId", answerId));
			object = (TblAnswer) criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblQuestion", e);
		}
		return object;
	}

	public TblQuestionAssign getQuestionAssign(Long questionAssignId) {
		log.debug("Call get TblQuestionAssign with: " + questionAssignId);
		TblQuestionAssign object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblQuestionAssign.class);
			criteria.add(Restrictions.eq("questionAssignId", questionAssignId));
			object = (TblQuestionAssign) criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblQuestion", e);
		}
		return object;
	}

	public String updateBatch(String arrQuestionId) {
		String sReturn = "";
		String[] questionIds = arrQuestionId.split(",");
		log.debug("questionIds.length: " + questionIds.length);
		for (int i = 0; i < questionIds.length; i++) {
			Long questionId = null;
			try {
				questionId = Long.parseLong(questionIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "questionId = " + questionIds[i] + " là không hợp lệ";
				questionId = null;
			}
			if (questionId != null) {
				TblQuestion question = getQuestion(questionId);
				if (question == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "questionId là " + questionIds[i]
							+ " không tồn tại";
				} else {
					question.setStatus((byte) 3);
					Date current = new Date();
					question.setModified(current);
					try {
						update(question);
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa questionId: "
								+ questionIds[i];
					}
				}
			}
		}
		/*
		 * try { sReturn = new String(sReturn.getBytes("iso-8859-1"),"UTF-8"); }
		 * catch (Exception e) { log.error(e.toString()); e.printStackTrace(); }
		 */
		return sReturn;
	}
	
	/*
	 * delete answer
	 */
	public String deleteAnswerBatch(String arrAnswerId) {
		String sReturn = "";
		String[] answerIds = arrAnswerId.split(",");
		log.debug("questionIds.length: " + answerIds.length);
		for (int i = 0; i < answerIds.length; i++) {
			Long answerId = null;
			try {
				answerId = Long.parseLong(answerIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "answerId = " + answerIds[i] + " là không hợp lệ";
				answerId = null;
			}
			if (answerId != null) {
				//TblQuestion question = getQuestion(answerId);
			
				TblAnswer answer = getAnswerById(answerId);
				if (answer == null) {
					if (!"".equals(sReturn)) {
						sReturn = "\n";
					}
					sReturn = "answerId là " + answerIds[i]
							+ " không tồn tại";
				} else {
					try {
						deleteAnswer(answer);
						
					} catch (Exception e) {
						if (!"".equals(sReturn)) {
							sReturn = "\n";
						}
						sReturn = "Lỗi phát sinh trong quá trình xóa answerId: "
								+ answerIds[i];
					}
				}
			}
		}
		/*
		 * try { sReturn = new String(sReturn.getBytes("iso-8859-1"),"UTF-8"); }
		 * catch (Exception e) { log.error(e.toString()); e.printStackTrace(); }
		 */
		return sReturn;
	}

	/*
	 * public String updateAssignBatch(String arrQuestionAssignId) { String
	 * sReturn = ""; String[] usersIds = arrQuestionAssignId.split(",");
	 * log.debug("usersIds.length: " + usersIds.length); for (int i = 0;
	 * i<usersIds.length; i++) { Long usersId = null; try { usersId =
	 * Long.parseLong(usersIds[i]); } catch (Exception e) { if
	 * (!"".equals(sReturn)) { sReturn = "\n"; } sReturn = "usersId = " +
	 * usersIds[i] + " là không hợp lệ"; usersId = null; } if (usersId != null)
	 * { TblQuestionAssign questionAssign = getQuestionAssign(usersId); if
	 * (questionAssign == null) { if (!"".equals(sReturn)) { sReturn = "\n"; }
	 * sReturn = "usersId là " + usersIds[i] + " không tồn tại"; } else { //
	 * questionAssign.setStatus((byte)3); // Date current = new Date(); //
	 * questionAssign.setModified(current);
	 * 
	 * UsersDao dao = new UsersDao(); List<TblUsers> listUsers = new
	 * ArrayList<TblUsers>(); listUsers = dao.get(); if (listUsers != null &&
	 * (listUsers.size() > 0)) { questionAssign.setListUsers(listUsers);
	 * 
	 * } questionAssign.setAssignToUsersId(assignToUsersId)//(usersIds[i]);
	 * 
	 * 
	 * 
	 * 
	 * try { update(questionAssign); } catch (Exception e) { if
	 * (!"".equals(sReturn)) { sReturn = "\n"; } sReturn =
	 * "Lỗi phát sinh trong quá trình xóa usersId: " + usersIds[i]; } } } }
	 * 
	 * try { sReturn = new String(sReturn.getBytes("iso-8859-1"),"UTF-8"); }
	 * catch (Exception e) { log.error(e.toString()); e.printStackTrace(); }
	 * 
	 * return sReturn; }
	 */
	public void deleteAllUsersAssign(Long questionId) {
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory
					.getSession();
			String hql = "delete from TblQuestionAssign where tblQuestion.questionId = :questionId";
			Query query = session.createQuery(hql);
			query.setLong("questionId", questionId);
			int rowCount = query.executeUpdate();
			log.debug("delete " + rowCount
					+ " in TblQuestionAssign with questionId = " + questionId);
			session.flush();
			//session.close();
		} catch (Exception e) {
			log.debug("fail get TblQuestion", e);
		}
	}

	public String deleteUsersAssign(String sQuestionId,
			String arrQuestionAssignId, TblUsers assigner) {
		String sReturn = "";
		String[] usersIds = arrQuestionAssignId.split(",");
		log.debug("usersIds.length: " + usersIds.length);

		Long questionId = null;
		try {
			questionId = Long.parseLong(sQuestionId);
		} catch (Exception e) {
			questionId = null;
		}
		// delete old assign
		TblQuestion question = null;
		if (questionId != null) {
			question = getQuestion(questionId);
			if (question != null) {
				deleteAllUsersAssign(questionId);
			}
		}
		UsersDao usersDao = new UsersDao();
		for (int i = 0; i < usersIds.length; i++) {
			Long usersId = null;
			try {
				usersId = Long.parseLong(usersIds[i]);
			} catch (Exception e) {
				if (!"".equals(sReturn)) {
					sReturn = "\n";
				}
				sReturn = "usersId = " + usersIds[i] + " là không hợp lệ";
				usersId = null;
			}
			if ((usersId != null) && (question != null)) {
				TblUsers assignToUsersId = usersDao.get(usersId);
				if (assignToUsersId != null) {
					TblQuestionAssign questionAssign = new TblQuestionAssign();
					questionAssign.setAssignDate(new Date());
					questionAssign.setAssigner(assigner);
					questionAssign.setAssignToUsersId(assignToUsersId);
					questionAssign.setTblQuestion(question);
					save(questionAssign);
				}
			}
		}

		try {
			sReturn = new String(sReturn.getBytes("iso-8859-1"), "UTF-8");
		} catch (Exception e) {
			log.error(e.toString());
			e.printStackTrace();
		}

		return sReturn;
	}

	public String deleteUserAssign(String sQuestionId, String strUserIdAssign,
			TblUsers assigner) {
		String sReturn = "";

		Long questionId = null;
		try {
			questionId = Long.parseLong(sQuestionId);
		} catch (Exception e) {
			questionId = null;
		}
		// delete old assign
		TblQuestion question = null;
		if (questionId != null) {
			question = getQuestion(questionId);
			// if (question != null) {
			// deleteAllUsersAssign(questionId);
			// }
		}
		UsersDao usersDao = new UsersDao();

		Long usersId = null;
		try {
			usersId = Long.parseLong(strUserIdAssign);
		} catch (Exception e) {
			if (!"".equals(sReturn)) {
				sReturn = "\n";
			}
			sReturn = "usersId = " + strUserIdAssign + " là không hợp lệ";
			usersId = null;
		}
		if ((usersId != null) && (question != null)) {
			TblUsers assignToUsersId = usersDao.get(usersId);
			if (assignToUsersId != null) {
				TblQuestionAssign questionAssign = new TblQuestionAssign();
				questionAssign.setAssignDate(new Date());
				questionAssign.setAssigner(assigner);
				questionAssign.setAssignToUsersId(assignToUsersId);
				questionAssign.setTblQuestion(question);
				save(questionAssign);
			}
		}

		try {
			sReturn = new String(sReturn.getBytes("iso-8859-1"), "UTF-8");
		} catch (Exception e) {
			log.error(e.toString());
			e.printStackTrace();
		}

		return sReturn;
	}
	
	public static void main(String[] args) throws Exception {
		HoiDapDao dao = new HoiDapDao();
		List<TblQuestion> questions = dao.getQuestion(5, 1);
		log.debug("questions.size(): " + questions.size());
		log.debug("Count: " + dao.countQuestion());
	}
}
