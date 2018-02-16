<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*,数据服务层.*" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>车流量查看</title>
		<style type="text/css">
			td{text-align:center;}
		</style>
	</head>
	<body>
		<form method="post" action="searchCarAction">
			<table border="0" width="100%">
				<tr>
					<td colspan="7">
						<select name="year">
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
						</select>年
						<select name="month">
							<option value="all">all</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>月
						<select name="day">
							<option value="all">all</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
							<option value="21">21</option>
							<option value="22">22</option>
							<option value="23">23</option>
							<option value="24">24</option>
							<option value="25">25</option>
							<option value="26">26</option>
							<option value="27">27</option>
							<option value="28">28</option>
							<option value="29">29</option>
							<option value="30">30</option>
							<option value="31">31</option>
						</select>日
						<input type="submit" name="submit" value="查询">
						<a href="downloadCarAction">下载</a>
					</td>		
				</tr>
			</table>
		</form>
		<hr size="5px" color="#808080">
		<form>
			<table border="1" width="100%">
				<tr>
					<td width="10%">卡号</td>
					<td width="10%">车牌号</td>
					<td width="20%">事由</td>
					<td width="20%">入校时间</td>
					<td width="20%">离校时间</td>
					<td width="10%">计费</td>
					<td width="10%">操作</td>
				 </tr>
		     </table>
		</form>         
		<%
		int number = 0;//统计人数
		int number1=0;
		int number2=0;
		ConnectDatabase con = new ConnectDatabase();
		String sql1="SELECT * from 来访车辆  where 离校时间!='尚未离校'";
		String sql2="SELECT * from 来访车辆  where 离校时间='尚未离校'";
		PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql1);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){//表单一定要写在while循环里面，否则action无法获取每个按钮对应的phonenumber和outTime
			number1++;
		%>
		<form method="post" action="admin_deleteCarAction">
			<table border="1" width="100%">
		         <tr>
		           <td width="10%"><%=rs.getString(1) %></td>
		           <td width="10%"><%=rs.getString(2) %></td>
		           <td width="20%"><%=rs.getString(3) %></td>
		           <td width="20%"><%=rs.getString(4) %></td>
		           <td width="20%"><%=rs.getString(5) %></td>
		           <td width="10%"><%=rs.getString(6) %></td>
		           <td width="10%">
		           		<input type="submit" name="operation" value="删除"/>
		           		<input type="hidden" name="cardnumber" value=<%=rs.getString(1) %>>
		           		<input type="hidden" name="outTime" value=<%=rs.getString(5) %>>
		           </td>
		         </tr>   
	         </table>
		</form>         
		<%
		} %>
		<%
		ps = ConnectDatabase.dbconn.prepareStatement(sql2);
		rs = ps.executeQuery();
		while(rs.next()){//表单一定要写在while循环里面，否则action无法获取每个按钮对应的phonenumber和outTime
			number2++;
		%>
		<form method="post" action="admin_deleteCarAction">
			<table border="1" width="100%">
		         <tr>
		           <td width="10%"><%=rs.getString(1) %></td>
		           <td width="10%"><%=rs.getString(2) %></td>
		           <td width="20%"><%=rs.getString(3) %></td>
		           <td width="20%"><%=rs.getString(4) %></td>
		           <td width="20%"><%=rs.getString(5) %></td>
		           <td width="10%"><%=rs.getString(6) %></td>
		           <td width="10%">
		           		<input type="hidden" name="cardnumber" value=<%=rs.getString(1) %>>
		           		<input type="hidden" name="outTime" value=<%=rs.getString(5) %>>
		           </td>
		         </tr>   
	         </table>
		</form>         
		<%
		}
		rs.close(); 
		ps.close();
		ConnectDatabase.dbconn.close();
		number = number1+number2;
		%>
		<table>
			<tr>
				<td>
					总人数：<%=number %>
				</td>
			</tr>
		</table>
	</body>
</html>