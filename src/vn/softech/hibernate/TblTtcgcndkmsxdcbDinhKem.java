package vn.softech.hibernate;
// Generated Feb 27, 2012 10:59:38 AM by Hibernate Tools 3.4.0.CR1


import java.util.Date;

/**
 * TblTtcgcndkmsxdcbDinhKem generated by hbm2java
 */
public class TblTtcgcndkmsxdcbDinhKem  implements java.io.Serializable {


     private Long ttcgcndkmsxdcbDinhKemId;
     private TblUsers tblUsers;
     private TblDocument tblDocument;
     private TblTtcgcndkmsxdcb tblTtcgcndkmsxdcb;
     private String tenHoSo;
     private Date created;
     private Date modified;
     private byte status;

    public TblTtcgcndkmsxdcbDinhKem() {
    }

	
    public TblTtcgcndkmsxdcbDinhKem(TblDocument tblDocument, TblTtcgcndkmsxdcb tblTtcgcndkmsxdcb, String tenHoSo, Date created, Date modified, byte status) {
        this.tblDocument = tblDocument;
        this.tblTtcgcndkmsxdcb = tblTtcgcndkmsxdcb;
        this.tenHoSo = tenHoSo;
        this.created = created;
        this.modified = modified;
        this.status = status;
    }
    public TblTtcgcndkmsxdcbDinhKem(TblUsers tblUsers, TblDocument tblDocument, TblTtcgcndkmsxdcb tblTtcgcndkmsxdcb, String tenHoSo, Date created, Date modified, byte status) {
       this.tblUsers = tblUsers;
       this.tblDocument = tblDocument;
       this.tblTtcgcndkmsxdcb = tblTtcgcndkmsxdcb;
       this.tenHoSo = tenHoSo;
       this.created = created;
       this.modified = modified;
       this.status = status;
    }
   
    public Long getTtcgcndkmsxdcbDinhKemId() {
        return this.ttcgcndkmsxdcbDinhKemId;
    }
    
    public void setTtcgcndkmsxdcbDinhKemId(Long ttcgcndkmsxdcbDinhKemId) {
        this.ttcgcndkmsxdcbDinhKemId = ttcgcndkmsxdcbDinhKemId;
    }
    public TblUsers getTblUsers() {
        return this.tblUsers;
    }
    
    public void setTblUsers(TblUsers tblUsers) {
        this.tblUsers = tblUsers;
    }
    public TblDocument getTblDocument() {
        return this.tblDocument;
    }
    
    public void setTblDocument(TblDocument tblDocument) {
        this.tblDocument = tblDocument;
    }
    public TblTtcgcndkmsxdcb getTblTtcgcndkmsxdcb() {
        return this.tblTtcgcndkmsxdcb;
    }
    
    public void setTblTtcgcndkmsxdcb(TblTtcgcndkmsxdcb tblTtcgcndkmsxdcb) {
        this.tblTtcgcndkmsxdcb = tblTtcgcndkmsxdcb;
    }
    public String getTenHoSo() {
        return this.tenHoSo;
    }
    
    public void setTenHoSo(String tenHoSo) {
        this.tenHoSo = tenHoSo;
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




}


