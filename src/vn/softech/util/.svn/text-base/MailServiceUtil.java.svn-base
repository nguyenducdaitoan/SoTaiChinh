/*
 * MailService.java
 *
 * Created on February 28, 2007, 2:23 PM
 *
 */

package vn.softech.util;

//import java.io.File;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
//import com.sun.mail.util.LineInputStream;
import javax.mail.internet.*;
//import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import vn.softech.dao.DichVuCongDao;
import vn.softech.hibernate.TblTtcgcndkmsxdcb;
import vn.softech.hibernate.TblTtcgcndkmsxdcbButPhe;
import vn.softech.hibernate.TblTtcmsdvsdns;
import vn.softech.hibernate.TblTtcmsdvsdnsButPhe;
import vn.softech.hibernate.TblTtpapbdtns;
import vn.softech.hibernate.TblTtpapbdtnsButPhe;
import vn.softech.hibernate.TblTtpdgmsts;
import vn.softech.hibernate.TblTtpdgmstsButPhe;

/**
 * Utility class to send e-mail.
 *     MailServiceUtil mail = new MailServiceUtil();
 *     mail.message("lehvuk22@yahoo.com", "Tiêu đề message", "Nội dung message");
 *     mail.start();
 * @author lehvuk22@gmail.com
 * @version 1.0
 */
public class MailServiceUtil extends Thread {
	private static Logger log = Logger.getLogger(MailServiceUtil.class);
	private int countDown = 50;
	private Session session = null;
	private MimeMessage message = null;
	private String transport = "smtp";
	private String emailAddressFrom = "sotaichinhdng@gmail.com";
	private String emailAddressTo = "stcdanang@mof.gov.vn";
	private String emailAddressBCC = "taichinh@danang.gov.vn";
	private String host = "mail.danang.gov.vn";
//	private static MailServiceUtil instance = null;
	
	public MailServiceUtil() {
		ResourceBundle mailProps = ResourceBundle.getBundle("config");
		if ((mailProps.getString("mail.from") != null) && (!"".equals(mailProps.getString("mail.from")))) {
			emailAddressFrom = mailProps.getString("mail.from");
		}
		if ((mailProps.getString("mail.to") != null) && (!"".equals(mailProps.getString("mail.to")))) {
			emailAddressTo = mailProps.getString("mail.to");
		}
		if ((mailProps.getString("mail.bcc") != null) && (!"".equals(mailProps.getString("mail.bcc")))) {
			emailAddressBCC = mailProps.getString("mail.bcc");
		}
		if ((mailProps.getString("mail.transport.protocol") != null) && (!"".equals(mailProps.getString("mail.transport.protocol")))) {
			transport = mailProps.getString("mail.transport.protocol");
		}
		if ((mailProps.getString("mail.host") != null) && (!"".equals(mailProps.getString("mail.host")))) {
			host = mailProps.getString("mail.host");
		}
		session = getSession();		
	}
/*	
	private synchronized static void createInstance() {
        if (instance == null) {
        	log.debug("call createInstance()");
        	instance = new MailServiceUtil();
        }
    }
	
	public static MailServiceUtil getInstance() {
        if (instance == null) {
        	log.debug("call createInstance()");
            createInstance();
        } else {
        	log.debug("return instance exist");
        }
        return instance;
    }
*/	
	private Session getSession() {
		log.debug("call getSession()");
		Session session = null;
		Properties props = new Properties();
/*
		props.put("mail.smtp.host", host);
		session = Session.getDefaultInstance(props, null);
*/		

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("sotaichinhdng", "taichinh9872012");
					}
				});

		return session;
	}
	public void message(String emailAddressTo, String subject, String textContent) {
		try {
			message = new MimeMessage(session);
			log.debug("emailAddressFrom: " + emailAddressFrom);
			log.debug("emailAddressTo: " + emailAddressTo);
			message.setFrom(new InternetAddress(emailAddressFrom));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddressTo));			
			message.setSubject(subject,"UTF-8");
			message.addRecipient(Message.RecipientType.BCC, new InternetAddress(emailAddressBCC));
			message.setHeader("X-Priority", "1 (Highest)");
            message.setHeader("X-MSMail-Priority", "High");
            message.setHeader("Importance", "High");
            message.setHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.5843");
            message.setSentDate(new Date());

			StringBuffer template = new StringBuffer();
            template.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n")
                .append("<HTML><HEAD>\n")
                .append("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n")
                .append("</HEAD>\n")
                .append("<BODY topmargin=\"1\" leftmargin=\"2\" rightmargin=\"0\" bottommargin=\"1\">\n")
                .append("<div>\n")
                .append(textContent)
                .append("\n</div>\n")
                .append("</BODY></HTML>\n");
            String bodyText = template.toString();
//          Create your new message part
            BodyPart messageBodyPart = new MimeBodyPart();
//          Set the content of the body part
            messageBodyPart.setContent(bodyText, "text/html;charset=UTF-8");
//          Create a related multi-part to combine the parts
            MimeMultipart multipart = new MimeMultipart();
//          Add body part to multipart
            multipart.addBodyPart(messageBodyPart);            
			message.setContent(multipart);
//			message.setContent(bodyText, "text/html;charset=utf-8");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void message(String emailAddressTo, String subject, String textContent, String fileAttachment) {
		try {
			message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailAddressFrom));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddressTo));
			message.setSubject(subject);
			message.addRecipient(Message.RecipientType.BCC, new InternetAddress(emailAddressBCC));
			message.setHeader("X-Priority", "1 (Highest)");
            message.setHeader("X-MSMail-Priority", "High");
            message.setHeader("Importance", "High");
            message.setHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.5843");
            message.setSentDate(new Date());

			StringBuffer template = new StringBuffer();
            template.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n")
                .append("<HTML><HEAD>\n")
                .append("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n")
                .append("</HEAD>\n")
                .append("<BODY topmargin=\"1\" leftmargin=\"2\" rightmargin=\"0\" bottommargin=\"1\">\n")
                .append("<div>\n")
                .append(textContent)
                .append("\n</div>\n")
                .append("</BODY></HTML>\n");
            String bodyText = template.toString();
//          Create your new message part
            BodyPart messageBodyPart = new MimeBodyPart();
//          Set the content of the body part
            messageBodyPart.setContent(bodyText, "text/html;charset=UTF-8");
//          Create a related multi-part to combine the parts
            MimeMultipart multipart = new MimeMultipart();
//          Add body part to multipart
            multipart.addBodyPart(messageBodyPart);
            
         // Part two is attachment
            MimeBodyPart attachFilePart = new MimeBodyPart();
            DataSource source = new FileDataSource(fileAttachment);
            attachFilePart.setDataHandler(new DataHandler(source));
            attachFilePart.setFileName(StringUtils.getFileName(fileAttachment));
            multipart.addBodyPart(attachFilePart);
			message.setContent(multipart);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void messageGopY(String hoTen, String diaChi, String dienThoai, String email, String noiDung, String fileAttachment) {
		try {
			message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailAddressFrom));
			Address toUserAddress = new InternetAddress(email);
			message.addRecipient(Message.RecipientType.CC, toUserAddress);
			Address toAddress = new InternetAddress(emailAddressTo);
			message.addRecipient(Message.RecipientType.TO, toAddress);
			Address bccAddress = new InternetAddress(emailAddressBCC);
			message.addRecipient(Message.RecipientType.BCC, bccAddress);
			
			message.setSubject("Thông tin góp ý website sở tài chính thành phố Đà Nẵng","UTF-8");
			message.addRecipient(Message.RecipientType.BCC, new InternetAddress(emailAddressBCC));
			message.setHeader("X-Priority", "1 (Highest)");
            message.setHeader("X-MSMail-Priority", "High");
            message.setHeader("Importance", "High");
            message.setHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.5843");
            message.setSentDate(new Date());
            VelocityEngine ve = new VelocityEngine();
            String content = "";
            
			try {
	        	Properties p = new Properties();
	        	p.setProperty( "resource.loader", "class" );
	        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
	        	p.put("input.encoding", "UTF-8");
	        	p.put("output.encoding", "UTF-8");
				ve.init(p);				
				VelocityContext context = new VelocityContext();	        				
				context.put("NGUOIGOI", hoTen);
				context.put("DIACHI", diaChi);
				context.put("DIENTHOAI", dienThoai);
				context.put("EMAIL", email);
				context.put("NOIDUNG", noiDung);
//		        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		        StringWriter writer = new StringWriter();
		        Template t = ve.getTemplate("email_gopy.vm");
		        t.merge(context, writer);
		        content = writer.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			StringBuffer template = new StringBuffer();
            template.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n")
                .append("<HTML><HEAD>\n")
                .append("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n")
                .append("</HEAD>\n")
                .append("<BODY topmargin=\"1\" leftmargin=\"2\" rightmargin=\"0\" bottommargin=\"1\">\n")
                .append("<div>\n")
                .append(content)
                .append("\n</div>\n")
                .append("</BODY></HTML>\n");
            String bodyText = template.toString();
//          Create your new message part
            BodyPart messageBodyPart = new MimeBodyPart();
//          Set the content of the body part
            messageBodyPart.setContent(bodyText, "text/html;charset=UTF-8");
//          Create a related multi-part to combine the parts
            MimeMultipart multipart = new MimeMultipart();
//          Add body part to multipart
            multipart.addBodyPart(messageBodyPart);
            
         // Part two is attachment
            if (fileAttachment != null) {
	            MimeBodyPart attachFilePart = new MimeBodyPart();
	            DataSource source = new FileDataSource(fileAttachment);
	            attachFilePart.setDataHandler(new DataHandler(source));
	            attachFilePart.setFileName(StringUtils.getFileName(fileAttachment));
	            multipart.addBodyPart(attachFilePart);
            }
			message.setContent(multipart);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param id
	 * @param code
	 * 		TTCGCNDKMSXDCB: Thủ tục cấp giấy chứng nhận đăng ký mã số xây dựng cơ bản
	 * 		TTCMSDVSDNS: Thủ tục cấp mã số đơn vị sử dụng ngân sách
	 * 		TTPAPBDTNS: Thẩm tra phương án phân bổ dự toán ngân sách
	 * 		TTPDGMSTS: Thẩm tra phê duyệt giá mua sắm tài sản
	 */
	public boolean messageSoBienNhan(Long id, String code) {
		boolean bReturn = false;
		DichVuCongDao dao = new DichVuCongDao();
		if ("TTCGCNDKMSXDCB".equals(code)) {
			TblTtcgcndkmsxdcb object = dao.getTtcgcndkmsxdcb(id);
			if (object != null) {
				VelocityEngine ve = new VelocityEngine();
				try {
    	        	Properties p = new Properties();
    	        	p.setProperty( "resource.loader", "class" );
    	        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
    	        	p.put("input.encoding", "UTF-8");
    	        	p.put("output.encoding", "UTF-8");
    				ve.init(p);
    				String emailAddressTo = object.getTblCongDan().getEmail();
    				String subject = "Mã số hồ sơ 'Thủ tục cấp giấy chứng nhận đăng ký mã số xây dựng cơ bản'";
    				String content = "";
    				
    				VelocityContext context = new VelocityContext();	        				
    				context.put("NGUOIGOI", object.getTblCongDan().getTen());
    		        context.put("DICHVUCONG", "Thủ tục cấp giấy chứng nhận đăng ký mã số xây dựng cơ bản");
    		        
    		        context.put("TOCHUC", "<strong>Tên chủ đầu tư:</strong>&nbsp;<span>" + object.getTblToChuc().getTenCoQuan() + "</span>");
    		        context.put("NOIDUNG", "<strong>Tên dự án:</strong>&nbsp;<span>" + object.getTenDuAn() + "</span>");
    		        
    		        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    		        context.put("NGAYGOI", dateFormat.format(object.getCreated()));
    		        context.put("SOBIENNHAN", object.getSoBienNhan());
    		        context.put("CODETRACUU", object.getCodeTraCuu());
    		        StringWriter writer = new StringWriter();
    		        Template t = ve.getTemplate("email_sobiennhan.vm");
    		        t.merge(context, writer);
    		        content = writer.toString();
    		        message(emailAddressTo, subject, content);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
				bReturn = true;
			} else {
				log.debug("Khong tim thay id: " + id + " code= " + code);
			}
		} else if ("TTCMSDVSDNS".equals(code)) {
			TblTtcmsdvsdns object = dao.getTtcmsdvsdns(id);
			if (object != null) {
				VelocityEngine ve = new VelocityEngine();
				try {
    	        	Properties p = new Properties();
    	        	p.setProperty( "resource.loader", "class" );
    	        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
    	        	p.put("input.encoding", "UTF-8");
    	        	p.put("output.encoding", "UTF-8");
    				ve.init(p);
    				String emailAddressTo = object.getTblCongDan().getEmail();
    				String subject = "Mã số hồ sơ 'Thủ tục cấp mã số đơn vị sử dụng ngân sách'";
    				String content = "";
    				
    				VelocityContext context = new VelocityContext();	        				
    				context.put("NGUOIGOI", object.getTblCongDan().getTen());
    		        context.put("DICHVUCONG", "Thủ tục cấp mã số đơn vị sử dụng ngân sách");

    		        context.put("TOCHUC", "<strong>Tên đơn vị:</strong>&nbsp;<span>" + object.getTblToChuc().getTenCoQuan() + "</span>");
    		        context.put("NOIDUNG", "<strong>Cấp mã cho đơn vị:</strong>&nbsp;<span>" + object.getNoiDung() + "</span>");

    		        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    		        context.put("NGAYGOI", dateFormat.format(object.getCreated()));
    		        context.put("SOBIENNHAN", object.getSoBienNhan());
    		        context.put("CODETRACUU", object.getCodeTraCuu());
    		        StringWriter writer = new StringWriter();
    		        Template t = ve.getTemplate("email_sobiennhan.vm");
    		        t.merge(context, writer);
    		        content = writer.toString();
    		        message(emailAddressTo, subject, content);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
				bReturn = true;
			} else {
				log.debug("Khong tim thay id: " + id + " code= " + code);
			}
		} else if ("TTPAPBDTNS".equals(code)) {
			TblTtpapbdtns object = dao.getTtpapbdtns(id);
			if (object != null) {
				VelocityEngine ve = new VelocityEngine();
				try {
    	        	Properties p = new Properties();
    	        	p.setProperty( "resource.loader", "class" );
    	        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
    	        	p.put("input.encoding", "UTF-8");
    	        	p.put("output.encoding", "UTF-8");
    				ve.init(p);
    				String emailAddressTo = object.getTblCongDan().getEmail();
    				String subject = "Mã số hồ sơ 'Thẩm tra phương án phân bổ dự toán ngân sách'";
    				String content = "";
    				
    				VelocityContext context = new VelocityContext();	        				
    				context.put("NGUOIGOI", object.getTblCongDan().getTen());
    		        context.put("DICHVUCONG", "Thẩm tra phương án phân bổ dự toán ngân sách");
    		        
    		        context.put("TOCHUC", "<strong>Tên tổ chức:</strong>&nbsp;<span>" + object.getTblToChuc().getTenCoQuan() + "</span>");
    		        context.put("NOIDUNG", "<strong>Nội dung:</strong>&nbsp;<span>" + object.getNoiDung() + "</span>");
    		        
    		        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    		        context.put("NGAYGOI", dateFormat.format(object.getCreated()));
    		        context.put("SOBIENNHAN", object.getSoBienNhan());
    		        context.put("CODETRACUU", object.getCodeTraCuu());
    		        StringWriter writer = new StringWriter();
    		        Template t = ve.getTemplate("email_sobiennhan.vm");
    		        t.merge(context, writer);
    		        content = writer.toString();
    		        message(emailAddressTo, subject, content);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
				bReturn = true;
			} else {
				log.debug("Khong tim thay id: " + id + " code= " + code);
			}
		} else if ("TTPDGMSTS".equals(code)) {
			TblTtpdgmsts object = dao.getTtpdgmsts(id);
			if (object != null) {
				VelocityEngine ve = new VelocityEngine();
				try {
    	        	Properties p = new Properties();
    	        	p.setProperty( "resource.loader", "class" );
    	        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
    	        	p.put("input.encoding", "UTF-8");
    	        	p.put("output.encoding", "UTF-8");
    				ve.init(p);
    				String emailAddressTo = object.getTblCongDan().getEmail();
    				String subject = "Mã số hồ sơ 'Thẩm tra phê duyệt giá mua sắm tài sản'";
    				String content = "";
    				
    				VelocityContext context = new VelocityContext();	        				
    				context.put("NGUOIGOI", object.getTblCongDan().getTen());
    		        context.put("DICHVUCONG", "Thẩm tra phê duyệt giá mua sắm tài sản");
    		        
    		        context.put("TOCHUC", "<strong>Tên tổ chức:</strong>&nbsp;<span>" + object.getTblToChuc().getTenCoQuan() + "</span>");
    		        context.put("NOIDUNG", "<strong>Nội dung:</strong>&nbsp;<span>" + object.getNoiDung() + "</span>");
    		        
    		        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    		        context.put("NGAYGOI", dateFormat.format(object.getCreated()));
    		        context.put("SOBIENNHAN", object.getSoBienNhan());
    		        context.put("CODETRACUU", object.getCodeTraCuu());
    		        StringWriter writer = new StringWriter();
    		        Template t = ve.getTemplate("email_sobiennhan.vm");
    		        t.merge(context, writer);
    		        content = writer.toString();
    		        message(emailAddressTo, subject, content);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
				bReturn = true;
			} else {
				log.debug("Khong tim thay id: " + id + " code= " + code);
			}
		}
		return bReturn;
	}
	
	public boolean messageThongBao(Long idThongBao, String code) {
		boolean bReturn = false;
		DichVuCongDao dao = new DichVuCongDao();
		if ("TTCGCNDKMSXDCB".equals(code)) {
			TblTtcgcndkmsxdcbButPhe object = dao.getTtcgcndkmsxdcbButPhe(idThongBao);
			if (object != null) {
				VelocityEngine ve = new VelocityEngine();
				try {
    	        	Properties p = new Properties();
    	        	p.setProperty( "resource.loader", "class" );
    	        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
    	        	p.put("input.encoding", "UTF-8");
    	        	p.put("output.encoding", "UTF-8");
    				ve.init(p);
    				String emailAddressTo = object.getTblTtcgcndkmsxdcb().getTblCongDan().getEmail();
    				String subject = "Thông báo 'Thủ tục cấp giấy chứng nhận đăng ký mã số xây dựng cơ bản'";
    				String content = "";
    				
    				VelocityContext context = new VelocityContext();	        				
    				context.put("NGUOIGOI", object.getTblTtcgcndkmsxdcb().getTblCongDan().getTen());
    		        context.put("DICHVUCONG", "Thủ tục cấp giấy chứng nhận đăng ký mã số xây dựng cơ bản");
    		        
    		        context.put("TOCHUC", "<strong>Tên chủ đầu tư:</strong>&nbsp;<span>" + object.getTblTtcgcndkmsxdcb().getTblToChuc().getTenCoQuan() + "</span>");
    		        context.put("NOIDUNG", "<strong>Tên dự án:</strong>&nbsp;<span>" + object.getTblTtcgcndkmsxdcb().getTenDuAn() + "</span>");
    		        
    		        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    		        context.put("NGAYGOI", dateFormat.format(object.getTblTtcgcndkmsxdcb().getCreated()));
    		        context.put("SOBIENNHAN", object.getTblTtcgcndkmsxdcb().getSoBienNhan());
    		        context.put("CODETRACUU", object.getTblTtcgcndkmsxdcb().getCodeTraCuu());
    		        context.put("NGAYGOITB", dateFormat.format(object.getCreated()));
    		        context.put("NOIDUNG", object.getNoiDung());
    		        StringWriter writer = new StringWriter();
    		        Template t = ve.getTemplate("email_thongbao.vm");
    		        t.merge(context, writer);
    		        content = writer.toString();
    		        message(emailAddressTo, subject, content);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
				bReturn = true;
			} else {
				log.debug("Khong tim thay id: " + idThongBao + " code= " + code);
			}
		} else if ("TTCMSDVSDNS".equals(code)) {
			TblTtcmsdvsdnsButPhe object = dao.getTtcmsdvsdnsButPhe(idThongBao);
			if (object != null) {
				VelocityEngine ve = new VelocityEngine();
				try {
    	        	Properties p = new Properties();
    	        	p.setProperty( "resource.loader", "class" );
    	        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
    	        	p.put("input.encoding", "UTF-8");
    	        	p.put("output.encoding", "UTF-8");
    				ve.init(p);
    				String emailAddressTo = object.getTblTtcmsdvsdns().getTblCongDan().getEmail();
    				String subject = "Thông báo 'Thủ tục cấp mã số đơn vị sử dụng ngân sách'";
    				String content = "";
    				
    				VelocityContext context = new VelocityContext();	        				
    				context.put("NGUOIGOI", object.getTblTtcmsdvsdns().getTblCongDan().getTen());
    		        context.put("DICHVUCONG", "Thủ tục cấp mã số đơn vị sử dụng ngân sách");
    		        
    		        context.put("TOCHUC", "<strong>Tên đơn vị:</strong>&nbsp;<span>" + object.getTblTtcmsdvsdns().getTblToChuc().getTenCoQuan() + "</span>");
    		        context.put("NOIDUNG", "<strong>Cấp mã cho đơn vị:</strong>&nbsp;<span>" + object.getTblTtcmsdvsdns().getNoiDung() + "</span>");
    		        
    		        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    		        context.put("NGAYGOI", dateFormat.format(object.getTblTtcmsdvsdns().getCreated()));
    		        context.put("SOBIENNHAN", object.getTblTtcmsdvsdns().getSoBienNhan());
    		        context.put("CODETRACUU", object.getTblTtcmsdvsdns().getCodeTraCuu());
    		        context.put("NGAYGOITB", dateFormat.format(object.getCreated()));
    		        context.put("NOIDUNG", object.getNoiDung());
    		        StringWriter writer = new StringWriter();
    		        Template t = ve.getTemplate("email_thongbao.vm");
    		        t.merge(context, writer);
    		        content = writer.toString();
    		        message(emailAddressTo, subject, content);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
				bReturn = true;
			} else {
				log.debug("Khong tim thay id: " + idThongBao + " code= " + code);
			}
		} else if ("TTPAPBDTNS".equals(code)) {
			TblTtpapbdtnsButPhe object = dao.getTtpapbdtnsButPhe(idThongBao);
			if (object != null) {
				VelocityEngine ve = new VelocityEngine();
				try {
    	        	Properties p = new Properties();
    	        	p.setProperty( "resource.loader", "class" );
    	        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
    	        	p.put("input.encoding", "UTF-8");
    	        	p.put("output.encoding", "UTF-8");
    				ve.init(p);
    				String emailAddressTo = object.getTblTtpapbdtns().getTblCongDan().getEmail();
    				String subject = "Thông báo 'Thẩm tra phương án phân bổ dự toán ngân sách'";
    				String content = "";
    				
    				VelocityContext context = new VelocityContext();	        				
    				context.put("NGUOIGOI", object.getTblTtpapbdtns().getTblCongDan().getTen());
    		        context.put("DICHVUCONG", "Thẩm tra phương án phân bổ dự toán ngân sách");
    		        
    		        context.put("TOCHUC", "<strong>Tên tổ chức:</strong>&nbsp;<span>" + object.getTblTtpapbdtns().getTblToChuc().getTenCoQuan() + "</span>");
    		        context.put("NOIDUNG", "<strong>Nội dung:</strong>&nbsp;<span>" + object.getTblTtpapbdtns().getNoiDung() + "</span>");
    		        
    		        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    		        context.put("NGAYGOI", dateFormat.format(object.getTblTtpapbdtns().getCreated()));
    		        context.put("SOBIENNHAN", object.getTblTtpapbdtns().getSoBienNhan());
    		        context.put("CODETRACUU", object.getTblTtpapbdtns().getCodeTraCuu());
    		        context.put("NGAYGOITB", dateFormat.format(object.getCreated()));
    		        context.put("NOIDUNG", object.getNoiDung());
    		        StringWriter writer = new StringWriter();
    		        Template t = ve.getTemplate("email_thongbao.vm");
    		        t.merge(context, writer);
    		        content = writer.toString();
    		        message(emailAddressTo, subject, content);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
				bReturn = true;
			} else {
				log.debug("Khong tim thay id: " + idThongBao + " code= " + code);
			}
		} else if ("TTPDGMSTS".equals(code)) {
			TblTtpdgmstsButPhe object = dao.getTtpdgmstsButPhe(idThongBao);
			if (object != null) {
				VelocityEngine ve = new VelocityEngine();
				try {
    	        	Properties p = new Properties();
    	        	p.setProperty( "resource.loader", "class" );
    	        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
    	        	p.put("input.encoding", "UTF-8");
    	        	p.put("output.encoding", "UTF-8");
    				ve.init(p);
    				String emailAddressTo = object.getTblTtpdgmsts().getTblCongDan().getEmail();
    				String subject = "Thông báo 'Thẩm tra phê duyệt giá mua sắm tài sản'";
    				String content = "";
    				
    				VelocityContext context = new VelocityContext();	        				
    				context.put("NGUOIGOI", object.getTblTtpdgmsts().getTblCongDan().getTen());
    		        context.put("DICHVUCONG", "Thẩm tra phê duyệt giá mua sắm tài sản");
    		        
    		        context.put("TOCHUC", "<strong>Tên tổ chức:</strong>&nbsp;<span>" + object.getTblTtpdgmsts().getTblToChuc().getTenCoQuan() + "</span>");
    		        context.put("NOIDUNG", "<strong>Nội dung:</strong>&nbsp;<span>" + object.getTblTtpdgmsts().getNoiDung() + "</span>");
    		        
    		        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    		        context.put("NGAYGOI", dateFormat.format(object.getTblTtpdgmsts().getCreated()));
    		        context.put("SOBIENNHAN", object.getTblTtpdgmsts().getSoBienNhan());
    		        context.put("CODETRACUU", object.getTblTtpdgmsts().getCodeTraCuu());
    		        context.put("NGAYGOITB", dateFormat.format(object.getCreated()));
    		        context.put("NOIDUNG", object.getNoiDung());
    		        StringWriter writer = new StringWriter();
    		        Template t = ve.getTemplate("email_thongbao.vm");
    		        t.merge(context, writer);
    		        content = writer.toString();
    		        message(emailAddressTo, subject, content);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
				bReturn = true;
			} else {
				log.debug("Khong tim thay id: " + idThongBao + " code= " + code);
			}
		}
		return bReturn;
	}
	
	@Override
	public synchronized void start() {
		super.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (session == null) {
					session = getSession();
				}
				if (message == null) {
					log.error("message is null");
					return;
				}
//				session.getTransport(transport).send(message);
				Transport.send(message);
				log.debug("Send mail success!");
				return;
			} catch (MessagingException e) {
				log.error("Send mail fail (" + countDown + ")");
				e.printStackTrace();
			} catch (Exception e) {
				log.error("Send mail fail");
				e.printStackTrace();
			}
			if (--countDown <= 0) {
				log.error("Mail Message retried over");
				return;
			}
			try {
				this.sleep(60000); //delay 60s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}

	public static void main(String[] args) {
		MailServiceUtil mail = new MailServiceUtil();
//		mail.message("lehvuk22@gmail.com", "Tiêu đề message", "Nội dung message");
		mail.messageSoBienNhan((long)48, "TTCGCNDKMSXDCB");
//		mail.message("vulh@softech.vn","Tiêu đề email", "Nội dung message","d:/template.doc");
		mail.start();
		log.debug("end send message");
	}
}