package vn.softech.hibernate;
// Generated Mar 19, 2012 8:28:27 AM by Hibernate Tools 3.4.0.CR1


import java.util.Date;

/**
 * TblVbHuongDan generated by hbm2java
 */
public class TblVbHuongDan  implements java.io.Serializable {


     private Long vbHuongDanId;
     private String title;
     private String summary;
     private String content;
     private Date created;
     private Date modified;
     private byte status;
     private boolean active;
     private Long usersId;

    public TblVbHuongDan() {
    }

	
    public TblVbHuongDan(String title, String content, Date created, Date modified, byte status, boolean active) {
        this.title = title;
        this.content = content;
        this.created = created;
        this.modified = modified;
        this.status = status;
        this.active = active;
    }
    public TblVbHuongDan(String title, String summary, String content, Date created, Date modified, byte status, boolean active, Long usersId) {
       this.title = title;
       this.summary = summary;
       this.content = content;
       this.created = created;
       this.modified = modified;
       this.status = status;
       this.active = active;
       this.usersId = usersId;
    }
   
    public Long getVbHuongDanId() {
        return this.vbHuongDanId;
    }
    
    public void setVbHuongDanId(Long vbHuongDanId) {
        this.vbHuongDanId = vbHuongDanId;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSummary() {
        return this.summary;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
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
    public Long getUsersId() {
        return this.usersId;
    }
    
    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }




}

