<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*,数据服务层.*" %>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>进出车辆管理</title>
		<style type="text/css">
			td{text-align: center;}
		</style>
	</head>
	<body>
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
		ConnectDatabase con = new ConnectDatabase();
		String sql="SELECT * from 来访车辆  where 离校时间='尚未离校'";
		PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){//表单一定要写在while循环里面，否则action无法获取每个按钮对应的cardnumber
		%>
		<form method="post" action="carModifyAction">
			<table border="1" width="100%">
		         <tr>
		           <td width="10%"><%=rs.getString(1) %></td>
		           <td width="10%"><%=rs.getString(2) %></td>
		           <td width="20%"><%=rs.getString(3) %></td>
		           <td width="20%"><%=rs.getString(4) %></td>
		           <td width="20%"><%=rs.getString(5) %></td>
		           <td width="10%"><%=rs.getString(6) %></td>
		           <td width="10%">
		           		<input type="submit" name="operation" value="修改"/>
		           		<input type="hidden" name="cardnumber" value=<%=rs.getString(1) %>>
		           </td>
		         </tr>   
	         </table>
		</form>         
		<%
		} 
		rs.close(); 
		ps.close();
		ConnectDatabase.dbconn.close();
		%>
	</body>
</html>