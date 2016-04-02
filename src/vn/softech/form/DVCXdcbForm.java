package vn.softech.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vn.softech.hibernate.TblCongDan;
import vn.softech.hibernate.TblDocument;
import vn.softech.hibernate.TblToChuc;
import vn.softech.hibernate.TblTtcgcndkmsxdcb;
import vn.softech.hibernate.TblTtcgcndkmsxdcbButPhe;
import vn.softech.hibernate.TblTtcgcndkmsxdcbChuyenhs;
import vn.softech.hibernate.TblTtcgcndkmsxdcbDinhKem;
import vn.softech.hibernate.TblUsers;

public class DVCXdcbForm {
	private static Logger log = Logger.getLogger(DVCXdcbForm.class);
	private static final long serialVersionUID = 1L;
	private String hoTen;
	private String chucDanh;
	private String soCmnd;
	private String noiCapCmnd;
    private String ngayCapCmnd;
    private String diaChiCaNhan;
    private String emailCaNhan;
    private String dienThoaiCaNhan;
    
    private Long ttcgcndkmsxdcbId;
    private TblCongDan tblCongDan;
    private TblUsers tblUsersByUsersThuLyId;
    private TblUsers tblUsersByUsersXuLyId;
    private TblToChuc tblToChuc;
    private String soBienNhan;
    private byte lanSua;
    private Byte trangThai;
    private Date ngayThuLy;
    private Date ngayXuLy;
    private Date ngayHoanThanh;
    private Date created;
    private Date modified;
    private Byte status;
	private String maAnToan;
    private Long toChucId;
    private String tenCoQuan;
    private String diaChi;
    private String email;
    private String soDienThoai;
    private String soFax;
    private String maSoDonVi;
    private String tinhThanh;
    private String quanHuyen;
    private String xaPhuong;
    private String tenDuAn;
    
    private Long ttcgcndkmsxdcbDinhKemId;
    private TblUsers tblUsers;
    private TblDocument tblDocument;
    private TblTtcgcndkmsxdcb tblTtcgcndkmsxdcb;
    private List<String> tenHoSo ;
    private Long documentId;
    private String name;
    private List<CommonsMultipartFile> files;  
	
    private List<TblTtcgcndkmsxdcbDinhKem> listTtcgcndkmsxdcbDinhKems = new ArrayList<TblTtcgcndkmsxdcbDinhKem>();
    
    private List<TblDocument> listTDocument = new ArrayList<TblDocument>();
	private List<TblToChuc> listToChuc = new ArrayList<TblToChuc>();
	private List<TblCongDan> listCongDan = new ArrayList<TblCongDan>();
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getChucDanh() {
		return chucDanh;
	}
	public void setChucDanh(String chucDanh) {
		this.chucDanh = chucDanh;
	}
	public String getSoCmnd() {
		return soCmnd;
	}
	public void setSoCmnd(String soCmnd) {
		this.soCmnd = soCmnd;
	}
	public String getNoiCapCmnd() {
		return noiCapCmnd;
	}
	public void setNoiCapCmnd(String noiCapCmnd) {
		this.noiCapCmnd = noiCapCmnd;
	}
	public String getNgayCapCmnd() {
		return ngayCapCmnd;
	}
	public void setNgayCapCmnd(String ngayCapCmnd) {
		this.ngayCapCmnd = ngayCapCmnd;
	}
	public String getDiaChiCaNhan() {
		return diaChiCaNhan;
	}
	public void setDiaChiCaNhan(String diaChiCaNhan) {
		this.diaChiCaNhan = diaChiCaNhan;
	}
	public String getEmailCaNhan() {
		return emailCaNhan;
	}
	public void setEmailCaNhan(String emailCaNhan) {
		this.emailCaNhan = emailCaNhan;
	}
	public String getDienThoaiCaNhan() {
		return dienThoaiCaNhan;
	}
	public void setDienThoaiCaNhan(String dienThoaiCaNhan) {
		this.dienThoaiCaNhan = dienThoaiCaNhan;
	}
	public Long getTtcgcndkmsxdcbId() {
		return ttcgcndkmsxdcbId;
	}
	public void setTtcgcndkmsxdcbId(Long ttcgcndkmsxdcbId) {
		this.ttcgcndkmsxdcbId = ttcgcndkmsxdcbId;
	}
	public TblCongDan getTblCongDan() {
		return tblCongDan;
	}
	public void setTblCongDan(TblCongDan tblCongDan) {
		this.tblCongDan = tblCongDan;
	}
	public TblUsers getTblUsersByUsersThuLyId() {
		return tblUsersByUsersThuLyId;
	}
	public void setTblUsersByUsersThuLyId(TblUsers tblUsersByUsersThuLyId) {
		this.tblUsersByUsersThuLyId = tblUsersByUsersThuLyId;
	}
	public TblUsers getTblUsersByUsersXuLyId() {
		return tblUsersByUsersXuLyId;
	}
	public void setTblUsersByUsersXuLyId(TblUsers tblUsersByUsersXuLyId) {
		this.tblUsersByUsersXuLyId = tblUsersByUsersXuLyId;
	}
	public TblToChuc getTblToChuc() {
		return tblToChuc;
	}
	public void setTblToChuc(TblToChuc tblToChuc) {
		this.tblToChuc = tblToChuc;
	}
	public String getSoBienNhan() {
		return soBienNhan;
	}
	public void setSoBienNhan(String soBienNhan) {
		this.soBienNhan = soBienNhan;
	}
	public byte getLanSua() {
		return lanSua;
	}
	public void setLanSua(byte lanSua) {
		this.lanSua = lanSua;
	}
	public Byte getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(Byte trangThai) {
		this.trangThai = trangThai;
	}
	public Date getNgayThuLy() {
		return ngayThuLy;
	}
	public void setNgayThuLy(Date ngayThuLy) {
		this.ngayThuLy = ngayThuLy;
	}
	public Date getNgayXuLy() {
		return ngayXuLy;
	}
	public void setNgayXuLy(Date ngayXuLy) {
		this.ngayXuLy = ngayXuLy;
	}
	public Date getNgayHoanThanh() {
		return ngayHoanThanh;
	}
	public void setNgayHoanThanh(Date ngayHoanThanh) {
		this.ngayHoanThanh = ngayHoanThanh;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public String getMaAnToan() {
		return maAnToan;
	}
	public void setMaAnToan(String maAnToan) {
		this.maAnToan = maAnToan;
	}
	public Long getToChucId() {
		return toChucId;
	}
	public void setToChucId(Long toChucId) {
		this.toChucId = toChucId;
	}
	public String getTenCoQuan() {
		return tenCoQuan;
	}
	public void setTenCoQuan(String tenCoQuan) {
		this.tenCoQuan = tenCoQuan;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getSoFax() {
		return soFax;
	}
	public void setSoFax(String soFax) {
		this.soFax = soFax;
	}
	public String getMaSoDonVi() {
		return maSoDonVi;
	}
	public void setMaSoDonVi(String maSoDonVi) {
		this.maSoDonVi = maSoDonVi;
	}
	public String getTinhThanh() {
		return tinhThanh;
	}
	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}
	public String getQuanHuyen() {
		return quanHuyen;
	}
	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}
	public String getXaPhuong() {
		return xaPhuong;
	}
	public void setXaPhuong(String xaPhuong) {
		this.xaPhuong = xaPhuong;
	}
	public String getTenDuAn() {
		return tenDuAn;
	}
	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}
	public Long getTtcgcndkmsxdcbDinhKemId() {
		return ttcgcndkmsxdcbDinhKemId;
	}
	public void setTtcgcndkmsxdcbDinhKemId(Long ttcgcndkmsxdcbDinhKemId) {
		this.ttcgcndkmsxdcbDinhKemId = ttcgcndkmsxdcbDinhKemId;
	}
	public TblUsers getTblUsers() {
		return tblUsers;
	}
	public void setTblUsers(TblUsers tblUsers) {
		this.tblUsers = tblUsers;
	}
	public TblDocument getTblDocument() {
		return tblDocument;
	}
	public void setTblDocument(TblDocument tblDocument) {
		this.tblDocument = tblDocument;
	}
	public TblTtcgcndkmsxdcb getTblTtcgcndkmsxdcb() {
		return tblTtcgcndkmsxdcb;
	}
	public void setTblTtcgcndkmsxdcb(TblTtcgcndkmsxdcb tblTtcgcndkmsxdcb) {
		this.tblTtcgcndkmsxdcb = tblTtcgcndkmsxdcb;
	}
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public List<TblTtcgcndkmsxdcbDinhKem> getListTtcgcndkmsxdcbDinhKems() {
		return listTtcgcndkmsxdcbDinhKems;
	}
	public void setListTtcgcndkmsxdcbDinhKems(
			List<TblTtcgcndkmsxdcbDinhKem> listTtcgcndkmsxdcbDinhKems) {
		this.listTtcgcndkmsxdcbDinhKems = listTtcgcndkmsxdcbDinhKems;
	}
	public List<TblDocument> getListTDocument() {
		return listTDocument;
	}
	public void setListTDocument(List<TblDocument> listTDocument) {
		this.listTDocument = listTDocument;
	}
	public List<TblToChuc> getListToChuc() {
		return listToChuc;
	}
	public void setListToChuc(List<TblToChuc> listToChuc) {
		this.listToChuc = listToChuc;
	}
	public List<TblCongDan> getListCongDan() {
		return listCongDan;
	}
	public void setListCongDan(List<TblCongDan> listCongDan) {
		this.listCongDan = listCongDan;
	}
	/**
	 * @return the tenHoSo
	 */
	public List<String> getTenHoSo() {
		return tenHoSo;
	}
	/**
	 * @param tenHoSo the tenHoSo to set
	 */
	public void setTenHoSo(List<String> tenHoSo) {
		this.tenHoSo = tenHoSo;
	}
	/**
	 * @return the files
	 */
	public List<CommonsMultipartFile> getFiles() {
		return files;
	}
	/**
	 * @param files the files to set
	 */
	public void setFiles(List<CommonsMultipartFile> files) {
		this.files = files;
	}

}
