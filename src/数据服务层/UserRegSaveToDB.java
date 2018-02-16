package 数据服务层;

import 业务逻辑层.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sun.misc.BASE64Encoder;

public class UserRegSaveToDB {
	//对密码md5加密
	public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
	public int save(UserRegisterAction ura){
		String sql = "insert into 用户 values(?,?,?,?,?,?,?,?)";
		int sum = 0;//更新数据库时受影响的行数
		try {
			if(ura.getPassword().length()>=6 && ura.getPassword().length()<=12
					&& ura.getPassword().equals(ura.getConfirmPassword())){
				ConnectDatabase con = new ConnectDatabase();
				PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
				String newstr = "";
				try {
					newstr = EncoderByMd5(ura.getPassword());//获取加密后的密码
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps.setString(1, ura.getUsername());
				ps.setString(2, newstr);
				ps.setString(3, ura.getNickname());
				ps.setString(4, ura.getName());
				ps.setString(5, ura.getID());
				ps.setString(6, ura.getSex());
				ps.setString(7, ura.getAddress());
				ps.setString(8, "待审核");
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
