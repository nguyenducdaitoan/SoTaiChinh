package vn.softech.hibernate;
// Generated Feb 27, 2012 10:59:38 AM by Hibernate Tools 3.4.0.CR1


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Thẩm tra phương án phân bổ dự toán ngân sách
 */
public class TblTtpapbdtns  implements java.io.Serializable {


     private Long ttpapbdtnsId;
     private TblCongDan tblCongDan;
     private TblUsers tblUsersByUsersThuLyId;
     private TblUsers tblUsersByUsersXuLyId;
     private TblToChuc tblToChuc;
     private String soBienNhan;
     private String bienNhanTmc;
     private String codeTraCuu;
     private String noiDung;
     private Boolean isTraLai;
     private String lyDoTraLai;
     private String soHieuVb;
     private byte lanSua;
     private Byte trangThai;
     private Date ngayThuLy;
     private Date ngayHenTra;
     private Date ngayXuLy;
     private Date ngayHoanThanh;
     private Date created;
     private Date modified;
     private Byte status;
     private String lyDoXoa;
     private List<TblTtpapbdtnsDinhKem> tblTtpapbdtnsDinhKems = new ArrayList<TblTtpapbdtnsDinhKem>();
     private List<TblTtpapbdtnsButPhe> tblTtpapbdtnsButPhes = new ArrayList<TblTtpapbdtnsButPhe>();
     private List<TblTtpapbdtnsChuyenhs> tblTtpapbdtnsChuyenhses = new ArrayList<TblTtpapbdtnsChuyenhs>();

    public TblTtpapbdtns() {
    }

	
    public TblTtpapbdtns(TblCongDan tblCongDan, TblToChuc tblToChuc, String soBienNhan, byte lanSua, Date ngayHoanThanh, Date created, Date modified) {
        this.tblCongDan = tblCongDan;
        this.tblToChuc = tblToChuc;
        this.soBienNhan = soBienNhan;
        this.lanSua = lanSua;
        this.ngayHoanThanh = ngayHoanThanh;
        this.created = created;
        this.modified = modified;
    }
    public TblTtpapbdtns(TblCongDan tblCongDan, TblUsers tblUsersByUsersThuLyId, TblUsers tblUsersByUsersXuLyId, TblToChuc tblToChuc, String soBienNhan, byte lanSua, Byte trangThai, Date ngayThuLy, Date ngayXuLy, Date ngayHoanThanh, Date created, Date modified, Byte status, List<TblTtpapbdtnsDinhKem> tblTtpapbdtnsDinhKems, List<TblTtpapbdtnsButPhe> tblTtpapbdtnsButPhes) {
       this.tblCongDan = tblCongDan;
       this.tblUsersByUsersThuLyId = tblUsersByUsersThuLyId;
       this.tblUsersByUsersXuLyId = tblUsersByUsersXuLyId;
       this.tblToChuc = tblToChuc;
       this.soBienNhan = soBienNhan;
       this.lanSua = lanSua;
       this.trangThai = trangThai;
       this.ngayThuLy = ngayThuLy;
       this.ngayXuLy = ngayXuLy;
       this.ngayHoanThanh = ngayHoanThanh;
       this.created = created;
       this.modified = modified;
       this.status = status;
       this.tblTtpapbdtnsDinhKems = tblTtpapbdtnsDinhKems;
       this.tblTtpapbdtnsButPhes = tblTtpapbdtnsButPhes;
    }
   
    public Long getTtpapbdtnsId() {
        return this.ttpapbdtnsId;
    }
    
    public void setTtpapbdtnsId(Long ttpapbdtnsId) {
        this.ttpapbdtnsId = ttpapbdtnsId;
    }
    public TblCongDan getTblCongDan() {
        return this.tblCongDan;
    }
    
    public void setTblCongDan(TblCongDan tblCongDan) {
        this.tblCongDan = tblCongDan;
    }
    public TblUsers getTblUsersByUsersThuLyId() {
        return this.tblUsersByUsersThuLyId;
    }
    
    public void setTblUsersByUsersThuLyId(TblUsers tblUsersByUsersThuLyId) {
        this.tblUsersByUsersThuLyId = tblUsersByUsersThuLyId;
    }
    public TblUsers getTblUsersByUsersXuLyId() {
        return this.tblUsersByUsersXuLyId;
    }
    
    public void setTblUsersByUsersXuLyId(TblUsers tblUsersByUsersXuLyId) {
        this.tblUsersByUsersXuLyId = tblUsersByUsersXuLyId;
    }
    public TblToChuc getTblToChuc() {
        return this.tblToChuc;
    }
    
    public void setTblToChuc(TblToChuc tblToChuc) {
        this.tblToChuc = tblToChuc;
    }
    public String getSoBienNhan() {
        return this.soBienNhan;
    }
    
    public void setSoBienNhan(String soBienNhan) {
        this.soBienNhan = soBienNhan;
    }
    public byte getLanSua() {
        return this.lanSua;
    }
    
    public void setLanSua(byte lanSua) {
        this.lanSua = lanSua;
    }
    public Byte getTrangThai() {
        return this.trangThai;
    }
    
    public void setTrangThai(Byte trangThai) {
        this.trangThai = trangThai;
    }
    public Date getNgayThuLy() {
        return this.ngayThuLy;
    }
    
    public void setNgayThuLy(Date ngayThuLy) {
        this.ngayThuLy = ngayThuLy;
    }
    public Date getNgayXuLy() {
        return this.ngayXuLy;
    }
    
    public void setNgayXuLy(Date ngayXuLy) {
        this.ngayXuLy = ngayXuLy;
    }
    public Date getNgayHoanThanh() {
        return this.ngayHoanThanh;
    }
    
    public void setNgayHoanThanh(Date ngayHoanThanh) {
        this.ngayHoanThanh = ngayHoanThanh;
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
    public Byte getStatus() {
        return this.status;
    }
    
    public void setStatus(Byte status) {
        this.status = status;
    }
    public List<TblTtpapbdtnsDinhKem> getTblTtpapbdtnsDinhKems() {
        return this.tblTtpapbdtnsDinhKems;
    }
    
    public void setTblTtpapbdtnsDinhKems(List<TblTtpapbdtnsDinhKem> tblTtpapbdtnsDinhKems) {
        this.tblTtpapbdtnsDinhKems = tblTtpapbdtnsDinhKems;
    }
    public List<TblTtpapbdtnsButPhe> getTblTtpapbdtnsButPhes() {
        return this.tblTtpapbdtnsButPhes;
    }
    
    public void setTblTtpapbdtnsButPhes(List<TblTtpapbdtnsButPhe> tblTtpapbdtnsButPhes) {
        this.tblTtpapbdtnsButPhes = tblTtpapbdtnsButPhes;
    }


	public List<TblTtpapbdtnsChuyenhs> getTblTtpapbdtnsChuyenhses() {
		return tblTtpapbdtnsChuyenhses;
	}


	public void setTblTtpapbdtnsChuyenhses(List<TblTtpapbdtnsChuyenhs> tblTtpapbdtnsChuyenhses) {
		this.tblTtpapbdtnsChuyenhses = tblTtpapbdtnsChuyenhses;
	}


	public String getCodeTraCuu() {
		return codeTraCuu;
	}


	public void setCodeTraCuu(String codeTraCuu) {
		this.codeTraCuu = codeTraCuu;
	}


	public String getLyDoXoa() {
		return lyDoXoa;
	}


	public void setLyDoXoa(String lyDoXoa) {
		this.lyDoXoa = lyDoXoa;
	}


	public Date getNgayHenTra() {
		return ngayHenTra;
	}


	public void setNgayHenTra(Date ngayHenTra) {
		this.ngayHenTra = ngayHenTra;
	}


	public String getBienNhanTmc() {
		return bienNhanTmc;
	}


	public void setBienNhanTmc(String bienNhanTmc) {
		this.bienNhanTmc = bienNhanTmc;
	}


	public String getNoiDung() {
		return noiDung;
	}


	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}


	public Boolean getIsTraLai() {
		return isTraLai;
	}


	public void setIsTraLai(Boolean isTraLai) {
		this.isTraLai = isTraLai;
	}


	public String getLyDoTraLai() {
		return lyDoTraLai;
	}


	public void setLyDoTraLai(String lyDoTraLai) {
		this.lyDoTraLai = lyDoTraLai;
	}


	public String getSoHieuVb() {
		return soHieuVb;
	}


	public void setSoHieuVb(String soHieuVb) {
		this.soHieuVb = soHieuVb;
	}




}


