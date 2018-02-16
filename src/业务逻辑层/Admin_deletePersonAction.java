package 业务逻辑层;

import 数据服务层.*;
public class Admin_deletePersonAction {
	private String phonenumber;
	private String outTime;
	//处理方法
	public String execute(){
		Admin_deletePersonDB adpdb = new Admin_deletePersonDB();
		int sum = adpdb.delete(this);
		if(sum != 0){
			return "success";
		}else{
			return "error";
		}
	}
	//getter和setter方法
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	
}
