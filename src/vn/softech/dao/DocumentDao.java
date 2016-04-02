package vn.softech.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import vn.softech.hibernate.TblChuyenMuc;
import vn.softech.hibernate.TblDocument;

public class DocumentDao {
	private static Logger log = Logger.getLogger(DocumentDao.class);
	public Long save(TblDocument object) {
		log.debug("Call save TblDocument");
		Long returnId = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			returnId = (Long)session.save(object);
			session.flush();			
		} catch (Exception e) {
			log.debug("fail save TblDocument", e);
		}
		return returnId;
	}
	
	public TblDocument get(Long documentId) {
		log.debug("Call get TblDocument with: " + documentId);
		TblDocument object = null;
		try {
			org.hibernate.Session session = vn.softech.hibernate.HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(TblDocument.class);
			criteria.add(Restrictions.eq("documentId", documentId));
			object = (TblDocument)criteria.list().get(0);
		} catch (Exception e) {
			log.debug("fail get TblDocument", e);
		}
		return object;
	}
	
	public static void main(String[] args) {
		DocumentDao dao = new DocumentDao();
		File file = new File("C://Users//vulh//Desktop//Untitled.png");
        byte[] bFile = new byte[(int) file.length()]; 
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			// convert file into array of bytes
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TblDocument document = new TblDocument();
		document.setName("hx.png");
		Date created = new Date();
		document.setCreated(created);
		document.setData(bFile);
		Long documentId = dao.save(document);
		log.debug("documentId: " + documentId);
		
		TblDocument document2 = dao.get(documentId);
        byte[] bAvatar = document2.getData();
 
        try{
            FileOutputStream fos = new FileOutputStream("C://Users//vulh//Desktop//" + document2.getName()); 
            fos.write(bAvatar);
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
	}

}
