package 数据服务层;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import 业务逻辑层.*;

public class BeanCar {
	private String cardNumber;//卡号
	private String chepaiNumber;//车牌号
	private String reason;//事由
	private String inTime;//入校时间
	private String outTime;//离校时间
	private String money;//计费
	//车辆删除
	public int writeToDB(CarDeleteAction cda){
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH)+1; 
		int date = c.get(Calendar.DATE); 
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		int minute = c.get(Calendar.MINUTE); 
		int second = c.get(Calendar.SECOND); 
		String outTime = year+"-"+month+"-"+date+"-"+hour+"-"+minute+"-"+second;
		String sql1 = "select * from 来访车辆  where 卡号=? and 离校时间='尚未离校'";
		String sql2 = "update 来访车辆  set 离校时间=?,计费=? where 卡号=? and 离校时间='尚未离校'";
		int sum = 0;
		try {
			ConnectDatabase con = new ConnectDatabase();
			PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql1);
			ps.setString(1, cda.getCardnumber());
			ResultSet rs = ps.executeQuery();
			String inTime = "";
			if(rs.next()){
				inTime = rs.getString(4);
			}
			String[] array = inTime.split("-");
			int gethour = Integer.parseInt(array[3]);
			int getminute = Integer.parseInt(array[4]);
			int getsecond = Integer.parseInt(array[5]);
			int secondsIn = gethour*60*60 + getminute*60 + getsecond;//入校时间的总的秒数
			int secondsOut = hour*60*60 + minute*60 + second;//离校时间的总的秒数
			int stayTime = (secondsOut - secondsIn)/60;//在学校待的分钟数
			ps = ConnectDatabase.dbconn.prepareStatement(sql2);
			ps.setString(1, outTime);
			ps.setString(3, cda.getCardnumber());
			if(stayTime < 15){//如果小于15分钟，则收费0元
				ps.setString(2, "0元");
				money = "0元";
			}else if(stayTime >= 15 && stayTime <= 45){//如果大于等于15分钟，并且小于等于45分钟，则收费5元
				ps.setString(2, "5元");
				money = "5元";
			}else{//如果大于45分钟，则收费10元
				ps.setString(2, "10元");
				money = "10元";
			}
			sum = ps.executeUpdate();
			rs.close();
			ps.close();
			ConnectDatabase.dbconn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
	//车辆修改
	//1.删除数据库对应数据；2.跳转到登记表
	public int writeModifyToDB(CarModifyAction cma){
		String sql = "delete from 来访车辆  where 卡号=? and 离校时间='尚未离校'";
		int sum = 0;
		try {
			ConnectDatabase con = new ConnectDatabase();
			PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
			ps.setString(1, cma.getCardnumber());
			sum = ps.executeUpdate();
			ps.close();
			ConnectDatabase.dbconn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
	//getter和setter方法
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getChepaiNumber() {
		return chepaiNumber;
	}
	public void setChepaiNumber(String chepaiNumber) {
		this.chepaiNumber = chepaiNumber;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
}
