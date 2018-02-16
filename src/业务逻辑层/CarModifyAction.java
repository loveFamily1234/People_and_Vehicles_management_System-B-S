package 业务逻辑层;

import 数据服务层.BeanCar;
import 数据服务层.BeanPerson;

public class CarModifyAction {
	private String cardnumber;
	//处理方法
	public String execute(){
		BeanCar bc = new BeanCar();
		int sum = bc.writeModifyToDB(this);
		if(sum != 0){
			return "jumpToCardengji";
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
	
}
