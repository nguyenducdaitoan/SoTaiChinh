package vn.softech.form;

import java.util.Date;


public class TthcForm {
	private Long tthcId;
    private Long tthcDmId;
	private String title;
    private String content;
    private String fileName;
    private byte[] data;
    private byte status;
    private boolean active;
    private Date created;
    private Date modified;
    private Integer usersId;
    
	public Long getTthcId() {
		return tthcId;
	}
	public void setTthcId(Long tthcId) {
		this.tthcId = tthcId;
	}
	public Long getTthcDmId() {
		return tthcDmId;
	}
	public void setTthcDmId(Long tthcDmId) {
		this.tthcDmId = tthcDmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
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
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
}
