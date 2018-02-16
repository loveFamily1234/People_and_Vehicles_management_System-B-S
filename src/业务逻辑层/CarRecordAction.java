package 业务逻辑层;

import 数据服务层.*;

public class CarRecordAction {
	private String cardNumber;//卡号
	private String chepaiNumber;//车牌号
	private String reason;//事由
	private String inTime;//入校时间
	private String outTime;//离校时间
	private String money;//计费
	//处理方法
	public String execute(){
		CarRecordSaveToDB crst = new CarRecordSaveToDB();
		int sum = crst.save(this);
		if(sum != 0){
			return "success";
		}else{
			return "error";
		}
	}
	//getter和setter方法
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getChepaiNumber() {
		return chepaiNumber;
	}
	public void setChepaiNumber(String chepaiNumber) {
		this.chepaiNumber = chepaiNumber;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
}
