package vn.softech.hibernate;
// Generated Mar 24, 2012 9:50:03 AM by Hibernate Tools 3.4.0.CR1


import java.util.Date;

/**
 * TblTtcgcndkmsxdcbChuyenhs generated by hbm2java
 */
public class TblTtcgcndkmsxdcbChuyenhs  implements java.io.Serializable {


     private Long ttcgcndkmsxdcbChuyenhsId;
     private TblUsers tblUsersByUsersChuyenId;
     private TblTtcgcndkmsxdcb tblTtcgcndkmsxdcb;
     private TblUsers tblUsersByUsersNhanId;
     private Date ngayChuyen;
     private String ghiChu;
     private Byte status;

    public TblTtcgcndkmsxdcbChuyenhs() {
    }

	
    public TblTtcgcndkmsxdcbChuyenhs(TblUsers tblUsersByUsersChuyenId, TblTtcgcndkmsxdcb tblTtcgcndkmsxdcb, TblUsers tblUsersByUsersNhanId, Date ngayChuyen) {
        this.tblUsersByUsersChuyenId = tblUsersByUsersChuyenId;
        this.tblTtcgcndkmsxdcb = tblTtcgcndkmsxdcb;
        this.tblUsersByUsersNhanId = tblUsersByUsersNhanId;
        this.ngayChuyen = ngayChuyen;
    }
    public TblTtcgcndkmsxdcbChuyenhs(TblUsers tblUsersByUsersChuyenId, TblTtcgcndkmsxdcb tblTtcgcndkmsxdcb, TblUsers tblUsersByUsersNhanId, Date ngayChuyen, String ghiChu, Byte status) {
       this.tblUsersByUsersChuyenId = tblUsersByUsersChuyenId;
       this.tblTtcgcndkmsxdcb = tblTtcgcndkmsxdcb;
       this.tblUsersByUsersNhanId = tblUsersByUsersNhanId;
       this.ngayChuyen = ngayChuyen;
       this.ghiChu = ghiChu;
       this.status = status;
    }
   
    public Long getTtcgcndkmsxdcbChuyenhsId() {
        return this.ttcgcndkmsxdcbChuyenhsId;
    }
    
    public void setTtcgcndkmsxdcbChuyenhsId(Long ttcgcndkmsxdcbChuyenhsId) {
        this.ttcgcndkmsxdcbChuyenhsId = ttcgcndkmsxdcbChuyenhsId;
    }
    public TblUsers getTblUsersByUsersChuyenId() {
        return this.tblUsersByUsersChuyenId;
    }
    
    public void setTblUsersByUsersChuyenId(TblUsers tblUsersByUsersChuyenId) {
        this.tblUsersByUsersChuyenId = tblUsersByUsersChuyenId;
    }
    public TblTtcgcndkmsxdcb getTblTtcgcndkmsxdcb() {
        return this.tblTtcgcndkmsxdcb;
    }
    
    public void setTblTtcgcndkmsxdcb(TblTtcgcndkmsxdcb tblTtcgcndkmsxdcb) {
        this.tblTtcgcndkmsxdcb = tblTtcgcndkmsxdcb;
    }
    public TblUsers getTblUsersByUsersNhanId() {
        return this.tblUsersByUsersNhanId;
    }
    
    public void setTblUsersByUsersNhanId(TblUsers tblUsersByUsersNhanId) {
        this.tblUsersByUsersNhanId = tblUsersByUsersNhanId;
    }
    public Date getNgayChuyen() {
        return this.ngayChuyen;
    }
    
    public void setNgayChuyen(Date ngayChuyen) {
        this.ngayChuyen = ngayChuyen;
    }
    public String getGhiChu() {
        return this.ghiChu;
    }
    
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    public Byte getStatus() {
        return this.status;
    }
    
    public void setStatus(Byte status) {
        this.status = status;
    }




}


