package 业务逻辑层;

import 数据服务层.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.opensymphony.xwork2.ActionSupport;

import sun.misc.BASE64Encoder;

public class LoginAction_login extends ActionSupport{
	private String username;
	private String password;
	private String role;
	//对密码md5加密
		public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	        //确定计算方法
	        MessageDigest md5=MessageDigest.getInstance("MD5");
	        BASE64Encoder base64en = new BASE64Encoder();
	        //加密后的字符串
	        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
	        return newstr;
	    }
	//处理方法
	public String execute(){
		if(role.equals("用户")){
			BeanUser bu = new BeanUser();
			boolean flag = bu.readUserDB(this);
			if(flag){//数据库中有此用户名
				String newstr = "";
				try {
					newstr = EncoderByMd5(this.password);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(newstr.equals(bu.getPassword()) && bu.getStatus().trim().equals("审核通过")){//密码输入正确，并且审核通过
					return "jumpToIndexUser";
				}else{//密码输入错误或尚未审核通过
					return "jumpToLogin";
				}
			}else{//数据库中没有此用户名
				return "jumpToLogin";
			}
		}else if(role.equals("管理员")){
			BeanAdministrator ba = new BeanAdministrator();
			boolean flag = ba.readAdminDB(this);
			if(flag){//数据库中有此用户名
				String newstr2 = "";
				try {
					newstr2 = EncoderByMd5(this.password);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(newstr2.equals(ba.getPassword())){//密码输入正确
					return "jumpToIndexAdmin";
				}else{//密码输入错误
					return "jumpToLogin";
				}
			}else{//数据库中没有此用户名
				return "jumpToLogin";
			}
		}
		return "error";
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

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
