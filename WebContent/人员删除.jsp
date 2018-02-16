<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*,数据服务层.*" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>进出人员管理</title>
		<style type="text/css">
			td{text-align:center;}
		</style>
	</head>
	<body>
		<form>
			<table border="1" width="100%">
				<tr>
					<td width="10%">姓名</td>
					<td width="15%">手机号码</td>
					<td width="20%">事由</td>
					<td width="5%">性别</td>
					<td width="20%">入校时间</td>
					<td width="20%">离校时间</td>
					<td width="10%">操作</td>
				 </tr>
		     </table>
		</form>         
		<%
		ConnectDatabase con = new ConnectDatabase();
		String sql="SELECT * from 来访人员  where 离校时间='尚未离校'";
		PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){//表单一定要写在while循环里面，否则action无法获取每个按钮对应的phonenumber
		%>
		<form method="post" action="personDeleteAction">
			<table border="1" width="100%">
		         <tr>
		           <td width="10%"><%=rs.getString(1) %></td>
		           <td width="15%"><%=rs.getString(2) %></td>
		           <td width="20%"><%=rs.getString(3) %></td>
		           <td width="5%"><%=rs.getString(4) %></td>
		           <td width="20%"><%=rs.getString(5) %></td>
		           <td width="20%"><%=rs.getString(6) %></td>
		           <td width="10%">
		           		<input type="submit" name="operation" value="删除"/>
		           		<input type="hidden" name="phonenumber" value=<%=rs.getString(2) %>>
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