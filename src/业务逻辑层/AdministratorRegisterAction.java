package 业务逻辑层;
import 数据服务层.*;
import java.sql.*;

public class AdministratorRegisterAction{
	private String username;
	private String password;
	private String confirmPassword;
	private String nickname;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	//处理方法
	public String execute(){
		AdminRegSaveToDB arst = new AdminRegSaveToDB();
		int sum = arst.save(this);
		if(sum != 0){
			return "jumpToLogin";
		}else{
			return "jumpToAdminReg";
		}
	}
}
