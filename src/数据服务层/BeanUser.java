package 数据服务层;

import 业务逻辑层.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BeanUser {
	private String username;
	private String password;
	private String nickname;
	private String name;
	private String ID;
	private String sex;
	private String address;
	private String status;
	//读取数据库用户表
	public boolean readUserDB(LoginAction_login la){
		String sql = "select * from 用户 where 用户名=?";
		try {		
			ConnectDatabase con = new ConnectDatabase();
			PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
			ps.setString(1, la.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				username = rs.getString(1);
				password = rs.getString(2);
				nickname = rs.getString(3);
				name = rs.getString(4);
				ID = rs.getString(5);
				sex = rs.getString(6);
				address = rs.getString(7);
				status = rs.getString(8);
				rs.close();
				ps.close();
				ConnectDatabase.dbconn.close();
				return true;
			}
			rs.close();
			ps.close();
			ConnectDatabase.dbconn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//审核
	public int shenHe(ShenHeAction sha){
		int sum = 0;
		String sql = "update 用户  set 审核状态='审核通过' where 身份证号=?";
		try {		
			ConnectDatabase con = new ConnectDatabase();
			PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
			ps.setString(1, sha.getID());
			sum = ps.executeUpdate();
			ps.close();
			ConnectDatabase.dbconn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
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
	
}
