package 数据服务层;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import 业务逻辑层.Admin_deleteCarAction;

public class Admin_deleteCarDB {
	public int delete(Admin_deleteCarAction adca){
		String sql = "delete from 来访车辆  where 卡号=? and 离校时间=?";
		int sum = 0;
		try {
			ConnectDatabase con = new ConnectDatabase();
			PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
			ps.setString(1, adca.getCardnumber());
			ps.setString(2, adca.getOutTime());
			sum = ps.executeUpdate();
			ps.close();
			ConnectDatabase.dbconn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
}
