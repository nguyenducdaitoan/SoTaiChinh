package vn.softech.form;

import java.util.Date;

public class SuKienTinTucForm {
	private Long suKienTinTucId;
	private long suKienId;
	private String title;
	private String summary;
	private String content;
	private String pathImage;
	private Date created;
	private Date modified;
	private boolean active;
	private byte status;
	
	public Long getSuKienTinTucId() {
		return suKienTinTucId;
	}
	public void setSuKienTinTucId(Long suKienTinTucId) {
		this.suKienTinTucId = suKienTinTucId;
	}
	public long getSuKienId() {
		return suKienId;
	}
	public void setSuKienId(long suKienId) {
		this.suKienId = suKienId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPathImage() {
		return pathImage;
	}
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
}
