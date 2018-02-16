package 业务逻辑层;

import 数据服务层.*;

public class Admin_deleteCarAction {
	private String cardnumber;
	private String outTime;
	//处理方法
	public String execute(){
		Admin_deleteCarDB adcdb = new Admin_deleteCarDB();
		int sum = adcdb.delete(this);
		if(sum != 0){
			return "success";
		}else{
			return "error";
		}
	}
	//getter和setter方法
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	
}
