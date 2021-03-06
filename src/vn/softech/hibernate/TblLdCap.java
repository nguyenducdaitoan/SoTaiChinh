package vn.softech.hibernate;
// Generated Feb 7, 2012 11:41:35 AM by Hibernate Tools 3.4.0.CR1


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TblLdCap generated by hbm2java
 */
public class TblLdCap  implements java.io.Serializable {


     private Short ldCapId;
     private String name;
     private Date created;
     private Date modified;
     private byte status;
     private boolean macDinh;
     private Integer usersId;
     private List<TblLdCoQuan> tblLdCoQuans = new ArrayList<TblLdCoQuan>();

    public TblLdCap() {
    }

	
    public TblLdCap(String name, Date created, Date modified, byte status, boolean macDinh) {
        this.name = name;
        this.created = created;
        this.modified = modified;
        this.status = status;
        this.macDinh = macDinh;
    }
    public TblLdCap(String name, Date created, Date modified, byte status, boolean macDinh, Integer usersId, List<TblLdCoQuan> tblLdCoQuans) {
       this.name = name;
       this.created = created;
       this.modified = modified;
       this.status = status;
       this.macDinh = macDinh;
       this.usersId = usersId;
       this.tblLdCoQuans = tblLdCoQuans;
    }
   
    public Short getLdCapId() {
        return this.ldCapId;
    }
    
    public void setLdCapId(Short ldCapId) {
        this.ldCapId = ldCapId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    public boolean isMacDinh() {
        return this.macDinh;
    }
    
    public void setMacDinh(boolean macDinh) {
        this.macDinh = macDinh;
    }
    public Integer getUsersId() {
        return this.usersId;
    }
    
    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }
    public List<TblLdCoQuan> getTblLdCoQuans() {
        return this.tblLdCoQuans;
    }
    
    public void setTblLdCoQuans(List<TblLdCoQuan> tblLdCoQuans) {
        this.tblLdCoQuans = tblLdCoQuans;
    }




}


