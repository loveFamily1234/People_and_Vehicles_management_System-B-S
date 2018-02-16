package 数据服务层;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String dburl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=高校进出人员及车辆管理系统";
	private String username = "sa";
	private String password = "liuyaodong123456789";
	public static Connection dbconn = null;
	
	public ConnectDatabase(){
		try{
			Class.forName(driver);//加载驱动程序
			dbconn = DriverManager.getConnection(dburl,username,password);//创建连接对象
		}catch(ClassNotFoundException e1){
			System.out.println(e1);
		} catch (SQLException e2) {
			System.out.println(e2);
		}
		//System.out.println("驱动加载成功！！！");
		if(dbconn == null){
			System.out.println("连接对象为空！！！");
		}
	}
}
