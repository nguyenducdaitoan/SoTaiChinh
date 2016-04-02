package vn.softech.form;

import java.util.Date;

public class UsersForm {
	private Long usersId;   
	private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private boolean active;
    private Long phongBanId;
    
    public Long getUsersId() {
		return usersId;
	}
	public void setUsersId(Long usersId) {
		this.usersId = usersId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Long getPhongBanId() {
		return phongBanId;
	}
	public void setPhongBanId(Long phongBanId) {
		this.phongBanId = phongBanId;
	}
}
