package 业务逻辑层;

import 数据服务层.*;

public class PersonModifyAction {
	private String phonenumber;
	//处理方法
	public String execute(){
		BeanPerson bp = new BeanPerson();
		int sum = bp.writeModifyToDB(this);
		if(sum != 0){
			return "jumpToIndexUser";
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
