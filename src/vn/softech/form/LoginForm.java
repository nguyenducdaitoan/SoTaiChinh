package vn.softech.form;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {
	@NotEmpty
	@Size(min = 3, max = 50)
	private String userName;
	@NotEmpty
	@Size(min = 6, max = 30)
	private String password;
	@NotEmpty
	private String passwordMd5;
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public String getPasswordMd5() {
		return passwordMd5;
	}
	public void setPasswordMd5(String passwordMd5) {
		this.passwordMd5 = passwordMd5;
	}
}