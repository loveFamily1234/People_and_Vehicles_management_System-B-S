package 数据服务层;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sun.misc.BASE64Encoder;
import 业务逻辑层.AdministratorRegisterAction;
import 业务逻辑层.UserRegisterAction;

public class AdminRegSaveToDB {
	//对密码md5加密
		public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	        //确定计算方法
	        MessageDigest md5=MessageDigest.getInstance("MD5");
	        BASE64Encoder base64en = new BASE64Encoder();
	        //加密后的字符串
	        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
	        return newstr;
	    }
		
	public int save(AdministratorRegisterAction adra){
		String sql = "insert into 管理员 values(?,?,?)";
		int sum = 0;//更新数据库时受影响的行数
		try {
			if(adra.getPassword().length()>=6 && adra.getPassword().length()<=12
					&& adra.getPassword().equals(adra.getConfirmPassword())){
				ConnectDatabase con = new ConnectDatabase();
				PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
				String newstr = "";
				try {
					newstr = EncoderByMd5(adra.getPassword());
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps.setString(1, adra.getUsername());
				ps.setString(2, newstr);
				ps.setString(3, adra.getNickname());
				sum = ps.executeUpdate();
				ps.close();
				ConnectDatabase.dbconn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
}
