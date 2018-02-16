package 业务逻辑层;

import 数据服务层.*;
public class ShenHeAction {
	private String ID;
	//处理方法
	public String execute(){
		BeanUser bu = new BeanUser();
		int sum = bu.shenHe(this);
		if(sum != 0){
			return "jumpToUserShenHe";
		}else{
			return "error";
		}
	}
	//getter和setter方法
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
}
