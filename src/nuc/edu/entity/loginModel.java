package nuc.edu.entity;

/**
 * 登录属性（供学生，老师，管理员使用）
 * @author TaoXu
 *
 */
public class loginModel {
	private String no;
	private String username;
	private String password;
	private String checking;
	private String type;
	private String email;
	
	
    public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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
	
		public String getChecking() {
		return checking;
	}

	public void setChecking(String checking) {
		this.checking = checking;
	}
    
		public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	
}
