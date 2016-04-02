package vn.softech.hibernate;
// Generated Feb 3, 2012 4:30:21 PM by Hibernate Tools 3.4.0.CR1


import java.util.Date;

/**
 * TblTthc generated by hbm2java
 */
public class TblTthc  implements java.io.Serializable {


     private Long tthcId;
     private TblTthcDm tblTthcDm;
     private String title;
     private String content;
     private String fileName;
     private byte[] data;
     private byte status;
     private boolean active;
     private Date created;
     private Date modified;
     private Integer usersId;

    public TblTthc() {
    }

	
    public TblTthc(TblTthcDm tblTthcDm, String title, String content, String fileName, byte[] data, byte status, boolean active, Date created, Date modified) {
        this.tblTthcDm = tblTthcDm;
        this.title = title;
        this.content = content;
        this.fileName = fileName;
        this.data = data;
        this.status = status;
        this.active = active;
        this.created = created;
        this.modified = modified;
    }
    public TblTthc(TblTthcDm tblTthcDm, String title, String content, String fileName, byte[] data, byte status, boolean active, Date created, Date modified, Integer usersId) {
       this.tblTthcDm = tblTthcDm;
       this.title = title;
       this.content = content;
       this.fileName = fileName;
       this.data = data;
       this.status = status;
       this.active = active;
       this.created = created;
       this.modified = modified;
       this.usersId = usersId;
    }
   
    public Long getTthcId() {
        return this.tthcId;
    }
    
    public void setTthcId(Long tthcId) {
        this.tthcId = tthcId;
    }
    public TblTthcDm getTblTthcDm() {
        return this.tblTthcDm;
    }
    
    public void setTblTthcDm(TblTthcDm tblTthcDm) {
        this.tblTthcDm = tblTthcDm;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public byte[] getData() {
        return this.data;
    }
    
    public void setData(byte[] data) {
        this.data = data;
    }
    public byte getStatus() {
        return this.status;
    }
    
    public void setStatus(byte status) {
        this.status = status;
    }
    public boolean isActive() {
        return this.active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    public Date getCreated() {
        return this.created;
    }
    
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getModified() {
        return this.modified;
    }
    
    public void setModified(Date modified) {
        this.modified = modified;
    }
    public Integer getUsersId() {
        return this.usersId;
    }
    
    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }




}


