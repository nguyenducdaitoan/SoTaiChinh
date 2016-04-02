package vn.softech.form;

import java.util.Date;
public class LinkFrom {
	private Long linkId;
    private String name;
    private String href;
    private String description;
    private Date created;
    private Date modified;
    private Byte status;
    private String action;
    
    public Long getLinkId() {
		return linkId;
	}
	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

}
