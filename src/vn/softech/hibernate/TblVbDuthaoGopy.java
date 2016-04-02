package vn.softech.hibernate;

// Generated Apr 14, 2012 1:17:59 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TblVbDuthaoGopy generated by hbm2java
 */
public class TblVbDuthaoGopy implements java.io.Serializable {

	private Long vbDuthaoGopyId;
	private TblVbDuthao tblVbDuthao;
	private String hoVaTen;
	private String ngaySinh;
	private String diaChi;
	private String dienThoai;
	private String fax;
	private String email;
	private String tieuDe;
	private String noiDung;
	private String ipAddress;
	private String fileName;
	private byte[] attachData;
	private Date ngayGoi;

	public TblVbDuthaoGopy() {
	}

	public TblVbDuthaoGopy(Long vbDuthaoGopyId, TblVbDuthao tblVbDuthao,
			String hoVaTen, String diaChi, String email, String tieuDe,
			String noiDung, Date ngayGoi) {
		this.vbDuthaoGopyId = vbDuthaoGopyId;
		this.tblVbDuthao = tblVbDuthao;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.email = email;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.ngayGoi = ngayGoi;
	}

	public TblVbDuthaoGopy(Long vbDuthaoGopyId, TblVbDuthao tblVbDuthao,
			String hoVaTen, String ngaiSinh, String diaChi, String dienThoai,
			String fax, String email, String tieuDe, String noiDung,
			String ipAddress, byte[] attachData, Date ngayGoi) {
		this.vbDuthaoGopyId = vbDuthaoGopyId;
		this.tblVbDuthao = tblVbDuthao;
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaiSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.fax = fax;
		this.email = email;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.ipAddress = ipAddress;
		this.attachData = attachData;
		this.ngayGoi = ngayGoi;
	}

	public Long getVbDuthaoGopyId() {
		return this.vbDuthaoGopyId;
	}

	public void setVbDuthaoGopyId(Long vbDuthaoGopyId) {
		this.vbDuthaoGopyId = vbDuthaoGopyId;
	}

	public TblVbDuthao getTblVbDuthao() {
		return this.tblVbDuthao;
	}

	public void setTblVbDuthao(TblVbDuthao tblVbDuthao) {
		this.tblVbDuthao = tblVbDuthao;
	}

	public String getHoVaTen() {
		return this.hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getNgaySinh() {
		return this.ngaySinh;
	}

	public void setNgaySinh(String ngaiSinh) {
		this.ngaySinh = ngaiSinh;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return this.dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTieuDe() {
		return this.tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public byte[] getAttachData() {
		return this.attachData;
	}

	public void setAttachData(byte[] attachData) {
		this.attachData = attachData;
	}

	public Date getNgayGoi() {
		return this.ngayGoi;
	}

	public void setNgayGoi(Date ngayGoi) {
		this.ngayGoi = ngayGoi;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}