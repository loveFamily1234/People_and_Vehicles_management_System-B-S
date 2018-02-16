package 数据服务层;

import 业务逻辑层.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class BeanPerson {
	private String name;
	private String phonenumber;
	private String reason;
	private String sex;
	private String inTime;
	private String outTime;
	//人员删除，将离校时间写入数据库
	public int writeToDB(PersonDeleteAction pda){//人员删除
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH)+1; 
		int date = c.get(Calendar.DATE); 
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		int minute = c.get(Calendar.MINUTE); 
		int second = c.get(Calendar.SECOND); 
		String outTime = year+"-"+month+"-"+date+"-"+hour+"-"+minute+"-"+second;
		String sql = "update 来访人员  set 离校时间=? where 手机号码=? and 离校时间='尚未离校'";
		int sum = 0;
		try {
			ConnectDatabase con = new ConnectDatabase();
			PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
			ps.setString(1, outTime);
			ps.setString(2, pda.getPhonenumber());
			sum = ps.executeUpdate();
			ps.close();
			ConnectDatabase.dbconn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
	//人员修改
	//1.删除数据库对应数据；2.跳转到登记表
	public int writeModifyToDB(PersonModifyAction pma){//人员修改
		String sql = "delete from 来访人员  where 手机号码=? and 离校时间='尚未离校'";
		int sum = 0;
		try {
			ConnectDatabase con = new ConnectDatabase();
			PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
			ps.setString(1, pma.getPhonenumber());
			sum = ps.executeUpdate();
			ps.close();
			ConnectDatabase.dbconn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
	//getter和setter方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	
}
