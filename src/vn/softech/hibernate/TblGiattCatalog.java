package vn.softech.hibernate;

// Generated Jul 10, 2012 8:21:23 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TblGiattCatalog generated by hbm2java
 */
public class TblGiattCatalog implements java.io.Serializable {

	private Long giaThiTruongCmId;
	private String name;
	private Date created;
	private Date modified;
	private byte status;

	public TblGiattCatalog() {
	}

	public TblGiattCatalog(String name, Date created, Date modified, byte status) {
		this.name = name;
		this.created = created;
		this.modified = modified;
		this.status = status;
	}

	public Long getGiaThiTruongCmId() {
		return this.giaThiTruongCmId;
	}

	public void setGiaThiTruongCmId(Long giaThiTruongCmId) {
		this.giaThiTruongCmId = giaThiTruongCmId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
