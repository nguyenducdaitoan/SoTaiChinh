package vn.softech.hibernate;
// Generated Jan 18, 2012 3:03:09 PM by Hibernate Tools 3.4.0.CR1


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TblChuyenMuc generated by hbm2java
 */
public class TblChuyenMuc  implements java.io.Serializable {


     private Short chuyenMucId;
     private String title;
     private Date created;
     private Date modified;
     private byte status;
     private int usersId;
     private Byte priority;
     private List<TblTinTuc> tblTinTucs = new ArrayList<TblTinTuc>();

    public TblChuyenMuc() {
    }

	
    public TblChuyenMuc(String title, Date created, Date modified, byte status, int usersId) {
        this.title = title;
        this.created = created;
        this.modified = modified;
        this.status = status;
        this.usersId = usersId;
    }
    public TblChuyenMuc(String title, Date created, Date modified, byte status, int usersId, List<TblTinTuc> tblTinTucs) {
       this.title = title;
       this.created = created;
       this.modified = modified;
       this.status = status;
       this.usersId = usersId;
       this.tblTinTucs = tblTinTucs;
    }
   
    public Short getChuyenMucId() {
        return this.chuyenMucId;
    }
    
    public void setChuyenMucId(Short chuyenMucId) {
        this.chuyenMucId = chuyenMucId;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
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
    public int getUsersId() {
        return this.usersId;
    }
    
    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }
    public List<TblTinTuc> getTblTinTucs() {
        return this.tblTinTucs;
    }
    
    public void setTblTinTucs(List<TblTinTuc> tblTinTucs) {
        this.tblTinTucs = tblTinTucs;
    }


	public Byte getPriority() {
		return priority;
	}


	public void setPriority(Byte priority) {
		this.priority = priority;
	}
}


