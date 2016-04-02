package vn.softech.form;

import java.util.Date;

public class HinhAnhForm {

	 private Integer hinhAnhId;
     public Integer getHinhAnhId() {
		return hinhAnhId;
	}
	public void setHinhAnhId(Integer hinhAnhId) {
		this.hinhAnhId = hinhAnhId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	private String title;
     private String path;
     private Date created;
     private Date modified;
     private byte status;
     private Integer usersId;

}
