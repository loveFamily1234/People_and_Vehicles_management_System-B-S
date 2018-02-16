package 数据服务层;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import 业务逻辑层.*;

public class PersonRecordSaveToDB {
	public int save(PersonRecordAction pra){
		String sql = "insert into 来访人员 values(?,?,?,?,?,?)";
		int sum = 0;//更新数据库时受影响的行数
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH)+1; 
		int date = c.get(Calendar.DATE); 
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		int minute = c.get(Calendar.MINUTE); 
		int second = c.get(Calendar.SECOND); 
		String inTime = year+"-"+month+"-"+date+"-"+hour+"-"+minute+"-"+second;
		try {
				ConnectDatabase con = new ConnectDatabase();
				PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
				ps.setString(1, pra.getName());
				ps.setString(2, pra.getPhonenumber());
				ps.setString(3, pra.getReason());
				ps.setString(4, pra.getSex());
				ps.setString(5, inTime);
				ps.setString(6, "尚未离校");
				sum = ps.executeUpdate();
				ps.close();
				ConnectDatabase.dbconn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
}
