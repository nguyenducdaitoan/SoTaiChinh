package vn.softech.util;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.io.StringWriter;
//import java.io.Writer;
//import java.util.List;
//import java.util.Properties;
import java.io.File;
import java.util.Random;

//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
//import org.apache.struts.upload.FormFile;
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.VelocityEngine;



public class StringUtils extends org.apache.commons.lang3.StringUtils {
	private static Logger log = Logger.getLogger(StringUtils.class);
	
	public static String randomPassword() {
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		int len = 6;		
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}
	
	public static String randomUUID() {
		return java.util.UUID.randomUUID().toString();
	}
	
	public static String md5Hex(String password) {
		String salt = "CFLpJJsrUtXVZ4nq";		
		return DigestUtils.md5Hex(salt + DigestUtils.md5Hex(password));
	}
	
	public static String md5HexByPasswordMd5(String passwordMd5) {
		String salt = "CFLpJJsrUtXVZ4nq";		
		return DigestUtils.md5Hex(salt + passwordMd5);
	}
	
	public static String getFileName(String path) {		
		String fileName = new File(path).getName();
		return fileName;
	}
	
/*
	public static void buildMenuGioiThieu(String path) {
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();			        	
		VelocityContext context = new VelocityContext();
		
		StringWriter writer = new StringWriter();
		try {        	
        	p.setProperty( "resource.loader", "class" );
        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
        	p.put("input.encoding", "UTF-8");
        	p.put("output.encoding", "UTF-8");
			ve.init(p);			
			Template t = ve.getTemplate("template_menu.vm");			
			GioiThieuDao dao = new GioiThieuDao();
			List<TblGioiThieu> list = dao.menuGioiThieu();
			writer.append("<%@ page language=\"java\" pageEncoding=\"UTF-8\"%>\n");
			for (TblGioiThieu object: list) {				
				context.put("HREF", "/gioithieu.do?gioiThieuId=" + object.getGioiThieuId());
		        context.put("TITLE", object.getTitleMenu());
		        writer.append("\t");
		        t.merge(context, writer);
		        writer.append("\n");
			}
			System.out.println(writer.toString());
			File file = new File(path);
			Writer output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			output.write(writer.toString());
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void buildMenuCmTinTuc(String path) {
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();			        	
		VelocityContext context = new VelocityContext();
		
		StringWriter writer = new StringWriter();
		try {        	
        	p.setProperty( "resource.loader", "class" );
        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
        	p.put("input.encoding", "UTF-8");
        	p.put("output.encoding", "UTF-8");
			ve.init(p);			
			Template t = ve.getTemplate("template_menu.vm");			
			ChuyenMucDao dao = new ChuyenMucDao();
			
			List<TblChuyenMuc> list = dao.menuChuyenMuc();
			writer.append("<%@ page language=\"java\" pageEncoding=\"UTF-8\"%>\n");
			for (TblChuyenMuc object: list) {				
				context.put("HREF", "/categories.do?catId=" + object.getChuyenMucId());
		        context.put("TITLE", object.getTitle());
		        writer.append("\t");
		        t.merge(context, writer);
		        writer.append("\n");
			}
			System.out.println(writer.toString());
			File file = new File(path);
			Writer output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			output.write(writer.toString());
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void buildMenuCmTthc(String path) {
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();			        	
		VelocityContext context = new VelocityContext();
		
		StringWriter writer = new StringWriter();
		try {        	
        	p.setProperty( "resource.loader", "class" );
        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
        	p.put("input.encoding", "UTF-8");
        	p.put("output.encoding", "UTF-8");
			ve.init(p);			
			Template t = ve.getTemplate("template_menu.vm");			
			TthcDmDao dao = new TthcDmDao();
			
			List<TblTthcDm> list = dao.get();
			writer.append("<%@ page language=\"java\" pageEncoding=\"UTF-8\"%>\n");
			for (TblTthcDm object: list) {				
				context.put("HREF", "/chuyenmuc_tthc.do?chuyenMucId=" + object.getTthcDmId());
		        context.put("TITLE", object.getName());
		        writer.append("\t");
		        t.merge(context, writer);
		        writer.append("\n");
			}
			System.out.println(writer.toString());
			File file = new File(path);
			Writer output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			output.write(writer.toString());
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void buildMenuCmBmdt(String path) {
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();			        	
		VelocityContext context = new VelocityContext();
		
		StringWriter writer = new StringWriter();
		try {        	
        	p.setProperty( "resource.loader", "class" );
        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
        	p.put("input.encoding", "UTF-8");
        	p.put("output.encoding", "UTF-8");
			ve.init(p);			
			Template t = ve.getTemplate("template_menu.vm");			
			BmdtDmDao dao = new BmdtDmDao();
			
			List<TblBmdtDm> list = dao.getMenuHeader();
			writer.append("<%@ page language=\"java\" pageEncoding=\"UTF-8\"%>\n");
			for (TblBmdtDm object: list) {				
				context.put("HREF", "/bmdt_cm.do?chuyenMucId=" + object.getBmdtDmId());
		        context.put("TITLE", object.getName());
		        writer.append("\t");
		        t.merge(context, writer);
		        writer.append("\n");
			}
			System.out.println(writer.toString());
			File file = new File(path);
			Writer output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			output.write(writer.toString());
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void buildMenuCktcCm(String path) {
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();			        	
		VelocityContext context = new VelocityContext();
		
		StringWriter writer = new StringWriter();
		try {        	
        	p.setProperty( "resource.loader", "class" );
        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
        	p.put("input.encoding", "UTF-8");
        	p.put("output.encoding", "UTF-8");
			ve.init(p);			
			Template t = ve.getTemplate("template_menu.vm");			
			CktcDao dao = new CktcDao();
			
			List<TblCktcCm> list = dao.getCktcCmHienThi();
			writer.append("<%@ page language=\"java\" pageEncoding=\"UTF-8\"%>\n");
			for (TblCktcCm object: list) {				
				context.put("HREF", "/cktclist.do?cktcCmId=" + object.getCktcCmId());
		        context.put("TITLE", object.getName());
		        writer.append("\t");
		        t.merge(context, writer);
		        writer.append("\n");
			}
			System.out.println(writer.toString());
			File file = new File(path);
			Writer output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			output.write(writer.toString());
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void buildVideo(String path) {
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();			        	
		VelocityContext context = new VelocityContext();
		
		StringWriter writer = new StringWriter();
		try {        	
        	p.setProperty( "resource.loader", "class" );
        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
        	p.put("input.encoding", "UTF-8");
        	p.put("output.encoding", "UTF-8");
			ve.init(p);			
			Template t = ve.getTemplate("template_video.vm");			
			VideoDao dao = new VideoDao();
			
			List<TblVideo> list = dao.getByPage(10, 1);
			writer.append("<%@ page language=\"java\" pageEncoding=\"UTF-8\"%>\n");
			for (TblVideo object: list) {				
				context.put("LINK", object.getUrl());
		        context.put("TITLE", object.getTitle());
		        writer.append("\t");
		        t.merge(context, writer);
		        writer.append("\n");
			}
			System.out.println(writer.toString());
			File file = new File(path);
			Writer output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			output.write(writer.toString());
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void buildLink(String path) {
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();			        	
		VelocityContext context = new VelocityContext();
		
		StringWriter writer = new StringWriter();
		try {        	
        	p.setProperty( "resource.loader", "class" );
        	p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
        	p.put("input.encoding", "UTF-8");
        	p.put("output.encoding", "UTF-8");
			ve.init(p);			
			Template t = ve.getTemplate("template_link.vm");			
			LinkDao dao = new LinkDao();
			
			List<TblLink> list = dao.get();
			writer.append("<%@ page language=\"java\" pageEncoding=\"UTF-8\"%>\n");
			for (TblLink object: list) {				
				context.put("LINK", object.getHref());
		        context.put("NAME", object.getName());
		        writer.append("\t");
		        t.merge(context, writer);
		        writer.append("\n");
			}
			System.out.println(writer.toString());
			File file = new File(path);
			Writer output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			output.write(writer.toString());
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String toISO88591Encoding(String value){
		try {
			return new String(value.getBytes("utf-8"), "iso-8859-1");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void writeToDisk(FormFile file, String fileName, String destinationPath) {
		try	{
	        InputStream stream = null;
	        OutputStream bos = null;
	        int bytesRead = 0;
	        int fileSize = 0;
	        byte[] buffer = null;
	        
	        stream = file.getInputStream();
	        bos = new FileOutputStream(destinationPath + fileName);
	        
	        fileSize = file.getFileSize();
	        
	        bytesRead = 0;
	        buffer = new byte[fileSize];
	        while ((bytesRead = stream.read(buffer, 0, fileSize)) != -1) {
	            bos.write(buffer, 0, bytesRead);
	        }
	        bos.close();
	        stream.close();
		} catch(FileNotFoundException e) {
			log.error(e.toString());
		} catch(IOException e) {
			log.error(e.toString());
		} catch (Exception e) {
			log.error(e.toString());
		}
    }
	
	public static String stripExtension(String str) {
        if (str == null) return null;
        int pos = str.lastIndexOf(".");
        if (pos == -1) return str;
        return str.substring(0, pos);
    }
	
	public static void main(String[] args) {
		System.out.println(DigestUtils.md5Hex("12345"));
	}
*/
}
