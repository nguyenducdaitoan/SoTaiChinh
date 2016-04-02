package vn.softech.hibernate;
// Generated Mar 14, 2012 8:28:15 AM by Hibernate Tools 3.4.0.CR1


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TblQuanHuyen generated by hbm2java
 */
public class TblQuanHuyen  implements java.io.Serializable {


     private Long quanHuyenId;
     private String tenQuanHuyen;
     private Boolean isTrungTam;
     private Date created;
     private Date modified;
     private byte status;
     private List<TblXaPhuong> tblXaPhuongs = new ArrayList<TblXaPhuong>();

    public TblQuanHuyen() {
    }

	
    public TblQuanHuyen(String tenQuanHuyen, Date created, Date modified, byte status) {
        this.tenQuanHuyen = tenQuanHuyen;
        this.created = created;
        this.modified = modified;
        this.status = status;
    }
    public TblQuanHuyen(String tenQuanHuyen, Boolean isTrungTam, Date created, Date modified, byte status, List<TblXaPhuong> tblXaPhuongs) {
       this.tenQuanHuyen = tenQuanHuyen;
       this.isTrungTam = isTrungTam;
       this.created = created;
       this.modified = modified;
       this.status = status;
       this.tblXaPhuongs = tblXaPhuongs;
    }
   
    public Long getQuanHuyenId() {
        return this.quanHuyenId;
    }
    
    public void setQuanHuyenId(Long quanHuyenId) {
        this.quanHuyenId = quanHuyenId;
    }
    public String getTenQuanHuyen() {
        return this.tenQuanHuyen;
    }
    
    public void setTenQuanHuyen(String tenQuanHuyen) {
        this.tenQuanHuyen = tenQuanHuyen;
    }
    public Boolean getIsTrungTam() {
        return this.isTrungTam;
    }
    
    public void setIsTrungTam(Boolean isTrungTam) {
        this.isTrungTam = isTrungTam;
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
    public List<TblXaPhuong> getTblXaPhuongs() {
        return this.tblXaPhuongs;
    }
    
    public void setTblXaPhuongs(List<TblXaPhuong> tblXaPhuongs) {
        this.tblXaPhuongs = tblXaPhuongs;
    }




}


