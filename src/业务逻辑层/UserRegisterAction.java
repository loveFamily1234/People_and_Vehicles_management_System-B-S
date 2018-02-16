package 业务逻辑层;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import 数据服务层.ConnectDatabase;
import 数据服务层.UserRegSaveToDB;

public class UserRegisterAction extends ActionSupport{
	private String label;
	private String username;
	private String password;
	private String confirmPassword;
	private String nickname;
	private String name;
	private String ID;
	private String sex;
	private String address;
	private String status;
	//getter和setter方法
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//处理方法
	public String execute(){
		UserRegSaveToDB urst = new UserRegSaveToDB();
		int sum = urst.save(this);
		if(sum != 0){
			return "jumpToLogin";
		}else{
			return "jumpToUserReg";
		}
	}
}
