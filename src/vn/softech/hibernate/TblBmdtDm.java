package vn.softech.hibernate;
// Generated Feb 18, 2012 8:30:00 AM by Hibernate Tools 3.4.0.CR1


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TblBmdtDm generated by hbm2java
 */
public class TblBmdtDm  implements java.io.Serializable {


     private Long bmdtDmId;
     private String name;
     private byte status;
     private Date created;
     private Date modified;
     private List<TblBmdt> tblBmdts = new ArrayList<TblBmdt>();

    public TblBmdtDm() {
    }

	
    public TblBmdtDm(String name, byte status, Date created, Date modified) {
        this.name = name;
        this.status = status;
        this.created = created;
        this.modified = modified;
    }
    public TblBmdtDm(String name, byte status, Date created, Date modified, List<TblBmdt> tblBmdts) {
       this.name = name;
       this.status = status;
       this.created = created;
       this.modified = modified;
       this.tblBmdts = tblBmdts;
    }
   
    public Long getBmdtDmId() {
        return this.bmdtDmId;
    }
    
    public void setBmdtDmId(Long bmdtDmId) {
        this.bmdtDmId = bmdtDmId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public byte getStatus() {
        return this.status;
    }
    
    public void setStatus(byte status) {
        this.status = status;
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
    public List<TblBmdt> getTblBmdts() {
        return this.tblBmdts;
    }
    
    public void setTblBmdts(List<TblBmdt> tblBmdts) {
        this.tblBmdts = tblBmdts;
    }




}


