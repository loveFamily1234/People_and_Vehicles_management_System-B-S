package 业务逻辑层;

public class LoginAction_register {
	private String username;
	private String password;
	private String role;
	
	//处理方法
	public String execute(){
		if(role.equals("管理员")){
			return "jumpToAdminReg";
		}else if(role.equals("用户")){
			return "jumpToUserReg";
		}
		return "error";
	}
	//getter和setter方法
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

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
