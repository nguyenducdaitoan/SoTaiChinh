package vn.softech.hibernate;
// Generated Feb 28, 2012 9:43:33 AM by Hibernate Tools 3.4.0.CR1


import java.util.Date;

/**
 * TblLienHe generated by hbm2java
 */
public class TblLienHe  implements java.io.Serializable {


     private Long lienHeId;
     private String hoTen;
     private String chucDanh;
     private String soCmnd;
     private String noiCapCmnd;
     private Date ngayCapCmnd;
     private String diaChi;
     private String email;
     private String soDienThoai;
     private String noiDung;
     private String fileName;
     private byte[] fileData;
     private Date created;
     private Date modified;
     private byte status;

    public TblLienHe() {
    }

	
    public TblLienHe(String hoTen, String diaChi, String noiDung, Date created, Date modified, byte status) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.noiDung = noiDung;
        this.created = created;
        this.modified = modified;
        this.status = status;
    }
    public TblLienHe(String hoTen, String chucDanh, String soCmnd, String noiCapCmnd, Date ngayCapCmnd, String diaChi, String email, String soDienThoai, String noiDung, String fileName, byte[] fileData, Date created, Date modified, byte status) {
       this.hoTen = hoTen;
       this.chucDanh = chucDanh;
       this.soCmnd = soCmnd;
       this.noiCapCmnd = noiCapCmnd;
       this.ngayCapCmnd = ngayCapCmnd;
       this.diaChi = diaChi;
       this.email = email;
       this.soDienThoai = soDienThoai;
       this.noiDung = noiDung;
       this.fileName = fileName;
       this.fileData = fileData;
       this.created = created;
       this.modified = modified;
       this.status = status;
    }
   
    public Long getLienHeId() {
        return this.lienHeId;
    }
    
    public void setLienHeId(Long lienHeId) {
        this.lienHeId = lienHeId;
    }
    public String getHoTen() {
        return this.hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getChucDanh() {
        return this.chucDanh;
    }
    
    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }
    public String getSoCmnd() {
        return this.soCmnd;
    }
    
    public void setSoCmnd(String soCmnd) {
        this.soCmnd = soCmnd;
    }
    public String getNoiCapCmnd() {
        return this.noiCapCmnd;
    }
    
    public void setNoiCapCmnd(String noiCapCmnd) {
        this.noiCapCmnd = noiCapCmnd;
    }
    public Date getNgayCapCmnd() {
        return this.ngayCapCmnd;
    }
    
    public void setNgayCapCmnd(Date ngayCapCmnd) {
        this.ngayCapCmnd = ngayCapCmnd;
    }
    public String getDiaChi() {
        return this.diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSoDienThoai() {
        return this.soDienThoai;
    }
    
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public String getNoiDung() {
        return this.noiDung;
    }
    
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public byte[] getFileData() {
        return this.fileData;
    }
    
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
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


