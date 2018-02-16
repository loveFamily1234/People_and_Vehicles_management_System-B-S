package 数据服务层;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import 业务逻辑层.LoginAction_login;

public class BeanAdministrator {
	private String username;
	private String password;
	private String nickname;
	
	//读取数据库管理员表
		public boolean readAdminDB(LoginAction_login la){
			String sql = "select * from 管理员 where 用户名=?";
			try {		
				ConnectDatabase con = new ConnectDatabase();
				PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
				ps.setString(1, la.getUsername());
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					username = rs.getString(1);
					password = rs.getString(2);
					nickname = rs.getString(3);
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
	
}
