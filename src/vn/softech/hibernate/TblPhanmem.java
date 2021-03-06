package vn.softech.hibernate;

// Generated May 3, 2012 4:34:45 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TblPhanmem generated by hbm2java
 */
public class TblPhanmem implements java.io.Serializable {

	private Long phanmemId;
	private String title;
	private String url;
	private String phienBan;
	private String moTa;
	private Date created;
	private Date modified;
	private Byte priority;
	private Byte status;

	public TblPhanmem() {
	}

	public TblPhanmem(String title, String url, Date created, Date modified) {
		this.title = title;
		this.url = url;
		this.created = created;
		this.modified = modified;
	}

	public TblPhanmem(String title, String url, String phienBan, String moTa,
			Date created, Date modified, Byte priority, Byte status) {
		this.title = title;
		this.url = url;
		this.phienBan = phienBan;
		this.moTa = moTa;
		this.created = created;
		this.modified = modified;
		this.priority = priority;
		this.status = status;
	}

	public Long getPhanmemId() {
		return this.phanmemId;
	}

	public void setPhanmemId(Long phanmemId) {
		this.phanmemId = phanmemId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPhienBan() {
		return this.phienBan;
	}

	public void setPhienBan(String phienBan) {
		this.phienBan = phienBan;
	}

	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
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

	public Byte getPriority() {
		return this.priority;
	}

	public void setPriority(Byte priority) {
		this.priority = priority;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}
