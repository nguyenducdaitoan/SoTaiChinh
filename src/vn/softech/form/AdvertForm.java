package vn.softech.form;

import java.util.Date;

public class AdvertForm {
	private static final long serialVersionUID = 1L;
	private Long advertId;
    private String name;
    private Byte priority;
    private Byte status;
    private String link;
    private String pathImage;
    private Byte position;
    private Date exprire;
    private String fileType;
    private Date created;
    private Date modified;
    private long usersId;
    private String action;   
    private String strExprire;   
    
    public AdvertForm(){
    	
    }
    public Long getAdvertId() {
		return advertId;
	}
	public void setAdvertId(Long advertId) {
		this.advertId = advertId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Byte getPriority() {
		return priority;
	}
	public void setPriority(Byte priority) {
		this.priority = priority;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPathImage() {
		return pathImage;
	}
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	public Byte getPosition() {
		return position;
	}
	public void setPosition(Byte position) {
		this.position = position;
	}
	public Date getExprire() {
		return exprire;
	}
	public void setExprire(Date exprire) {
		this.exprire = exprire;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
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
	public long getUsersId() {
		return usersId;
	}
	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the str_exprire
	 */
	/**
	 * @return the strExprire
	 */
	public String getStrExprire() {
		return strExprire;
	}
	/**
	 * @param strExprire the strExprire to set
	 */
	public void setStrExprire(String strExprire) {
		this.strExprire = strExprire;
	}


}
