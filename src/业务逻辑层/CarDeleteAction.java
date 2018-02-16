package 业务逻辑层;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import 数据服务层.*;
public class CarDeleteAction {
	private String cardnumber;
	//处理方法
	public String execute(){
		//写入离校时间
		BeanCar bc = new BeanCar();
		int sum = bc.writeToDB(this);
		if(sum != 0){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("fee", bc.getMoney());
			return "jumpTofee";
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
