package vn.softech.hibernate;
// Generated Feb 27, 2012 10:59:38 AM by Hibernate Tools 3.4.0.CR1


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Thủ tục cấp giấy chứng nhận đăng ký mã số xây dựng cơ bản
 */
public class TblTtcgcndkmsxdcb  implements java.io.Serializable {

     private Long ttcgcndkmsxdcbId;
     private TblCongDan tblCongDan;
     private TblUsers tblUsersByUsersThuLyId;
     private TblUsers tblUsersByUsersXuLyId;
     private TblToChuc tblToChuc;
     private String tenDuAn;
     private String maSoCap;
     private Boolean isTraLai;
     private String lyDoTraLai;
     private String soBienNhan;
     private String bienNhanTmc;
     private String codeTraCuu;
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
     private List<TblTtcgcndkmsxdcbDinhKem> tblTtcgcndkmsxdcbDinhKems = new ArrayList<TblTtcgcndkmsxdcbDinhKem>();
     private List<TblTtcgcndkmsxdcbButPhe> tblTtcgcndkmsxdcbButPhes = new ArrayList<TblTtcgcndkmsxdcbButPhe>();
     private List<TblTtcgcndkmsxdcbChuyenhs> tblTtcgcndkmsxdcbChuyenhses = new ArrayList<TblTtcgcndkmsxdcbChuyenhs>();
    public TblTtcgcndkmsxdcb() {
    }

	
    public TblTtcgcndkmsxdcb(TblCongDan tblCongDan, TblToChuc tblToChuc, String soBienNhan, byte lanSua, Date ngayHoanThanh, Date created, Date modified) {
        this.tblCongDan = tblCongDan;
        this.tblToChuc = tblToChuc;
        this.soBienNhan = soBienNhan;
        this.lanSua = lanSua;
        this.ngayHoanThanh = ngayHoanThanh;
        this.created = created;
        this.modified = modified;
    }
    public TblTtcgcndkmsxdcb(TblCongDan tblCongDan, TblUsers tblUsersByUsersThuLyId, TblUsers tblUsersByUsersXuLyId, TblToChuc tblToChuc, String soBienNhan, byte lanSua, Byte trangThai, Date ngayThuLy, Date ngayXuLy, Date ngayHoanThanh, Date created, Date modified, Byte status, List<TblTtcgcndkmsxdcbDinhKem> tblTtcgcndkmsxdcbDinhKems, List<TblTtcgcndkmsxdcbButPhe> tblTtcgcndkmsxdcbButPhes) {
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
       this.tblTtcgcndkmsxdcbDinhKems = tblTtcgcndkmsxdcbDinhKems;
       this.tblTtcgcndkmsxdcbButPhes = tblTtcgcndkmsxdcbButPhes;
    }
   
    public Long getTtcgcndkmsxdcbId() {
        return this.ttcgcndkmsxdcbId;
    }
    
    public void setTtcgcndkmsxdcbId(Long ttcgcndkmsxdcbId) {
        this.ttcgcndkmsxdcbId = ttcgcndkmsxdcbId;
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
    public List<TblTtcgcndkmsxdcbDinhKem> getTblTtcgcndkmsxdcbDinhKems() {
        return this.tblTtcgcndkmsxdcbDinhKems;
    }
    
    public void setTblTtcgcndkmsxdcbDinhKems(List<TblTtcgcndkmsxdcbDinhKem> tblTtcgcndkmsxdcbDinhKems) {
        this.tblTtcgcndkmsxdcbDinhKems = tblTtcgcndkmsxdcbDinhKems;
    }
    public List<TblTtcgcndkmsxdcbButPhe> getTblTtcgcndkmsxdcbButPhes() {
        return this.tblTtcgcndkmsxdcbButPhes;
    }
    
    public void setTblTtcgcndkmsxdcbButPhes(List<TblTtcgcndkmsxdcbButPhe> tblTtcgcndkmsxdcbButPhes) {
        this.tblTtcgcndkmsxdcbButPhes = tblTtcgcndkmsxdcbButPhes;
    }


	public List<TblTtcgcndkmsxdcbChuyenhs> getTblTtcgcndkmsxdcbChuyenhses() {
		return tblTtcgcndkmsxdcbChuyenhses;
	}


	public void setTblTtcgcndkmsxdcbChuyenhses(
			List<TblTtcgcndkmsxdcbChuyenhs> tblTtcgcndkmsxdcbChuyenhses) {
		this.tblTtcgcndkmsxdcbChuyenhses = tblTtcgcndkmsxdcbChuyenhses;
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


	public String getTenDuAn() {
		return tenDuAn;
	}


	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}


	public String getMaSoCap() {
		return maSoCap;
	}


	public void setMaSoCap(String maSoCap) {
		this.maSoCap = maSoCap;
	}


	public String getBienNhanTmc() {
		return bienNhanTmc;
	}


	public void setBienNhanTmc(String bienNhanTmc) {
		this.bienNhanTmc = bienNhanTmc;
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




}


