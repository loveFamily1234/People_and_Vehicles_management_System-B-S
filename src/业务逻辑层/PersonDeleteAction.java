package 业务逻辑层;

import 数据服务层.*;
public class PersonDeleteAction {
	private String phonenumber;
	//处理方法
	public String execute(){
		//写入离校时间
		BeanPerson bp = new BeanPerson();
		int sum = bp.writeToDB(this);
		if(sum != 0){
			return "jumpToPersonDelete";
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
}
