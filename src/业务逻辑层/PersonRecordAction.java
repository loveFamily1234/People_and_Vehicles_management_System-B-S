package 业务逻辑层;

import 数据服务层.*;
public class PersonRecordAction {
	private String name;
	private String phonenumber;
	private String reason;
	private String sex;
	//处理方法
	public String execute(){
		PersonRecordSaveToDB prst = new PersonRecordSaveToDB();
		int sum = prst.save(this);
		if(sum != 0){
			return "success";
		}else{
			return "error";
		}
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
}
