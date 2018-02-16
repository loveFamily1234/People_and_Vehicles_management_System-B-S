package 业务逻辑层;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class SearchCarAction {
	private String year;
	private String month;
	private String day;
	//处理方法
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		return "jumpToSearchCar";
	}
	//getter和setter方法
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
}
