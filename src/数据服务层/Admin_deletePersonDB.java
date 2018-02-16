package 数据服务层;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import 业务逻辑层.*;

public class Admin_deletePersonDB {
	public int delete(Admin_deletePersonAction adpa){
		String sql = "delete from 来访人员  where 手机号码=? and 离校时间=?";
		int sum = 0;
		try {
			ConnectDatabase con = new ConnectDatabase();
			PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
			ps.setString(1, adpa.getPhonenumber());
			ps.setString(2, adpa.getOutTime());
			sum = ps.executeUpdate();
			ps.close();
			ConnectDatabase.dbconn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
}
