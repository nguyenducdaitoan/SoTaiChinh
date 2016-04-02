package vn.softech.hibernate;

// Generated Apr 14, 2012 1:17:59 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TblVbDuthao generated by hbm2java
 */
public class TblVbDuthao implements java.io.Serializable {

	private Long vbDuthaoId;
	private String title;
	private String content;
	private Date created;
	private Date modified;
	private byte status;
	private Boolean approved;
	private Date ngayApproved;
	private List<TblVbDuthaoGopy> tblVbDuthaoGopies = new ArrayList<TblVbDuthaoGopy>();

	public TblVbDuthao() {
	}

	public TblVbDuthao(String title, String content, Date created,
			Date modified, byte status) {
		this.title = title;
		this.content = content;
		this.created = created;
		this.modified = modified;
		this.status = status;
	}

	public TblVbDuthao(String title, String content, Date created,
			Date modified, byte status, Boolean approved, Date ngayApproved,
			List<TblVbDuthaoGopy> tblVbDuthaoGopies) {
		this.title = title;
		this.content = content;
		this.created = created;
		this.modified = modified;
		this.status = status;
		this.approved = approved;
		this.ngayApproved = ngayApproved;
		this.tblVbDuthaoGopies = tblVbDuthaoGopies;
	}

	public Long getVbDuthaoId() {
		return this.vbDuthaoId;
	}

	public void setVbDuthaoId(Long vbDuthaoId) {
		this.vbDuthaoId = vbDuthaoId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Boolean getApproved() {
		return this.approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Date getNgayApproved() {
		return this.ngayApproved;
	}

	public void setNgayApproved(Date ngayApproved) {
		this.ngayApproved = ngayApproved;
	}

	public List<TblVbDuthaoGopy> getTblVbDuthaoGopies() {
		return this.tblVbDuthaoGopies;
	}

	public void setTblVbDuthaoGopies(List<TblVbDuthaoGopy> tblVbDuthaoGopies) {
		this.tblVbDuthaoGopies = tblVbDuthaoGopies;
	}

}
