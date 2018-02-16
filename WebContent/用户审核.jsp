<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*,数据服务层.*" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户审核</title>
		<style type="text/css">
			td{text-align:center;}
		</style>
	</head>
	<body>
		<form>
			<table border="1" width="100%">
				<tr>
					<td width="10%">用户名</td>
					<td width="20%">密码</td>
					<td width="5%">昵称</td>
					<td width="10%">姓名</td>
					<td width="15%">身份证号</td>
					<td width="5%">性别</td>
					<td width="15%">家庭住址</td>
					<td width="10%">审核状态</td>
					<td width="10%">操作</td>
				 </tr>
		     </table>
		</form>         
		<%
		ConnectDatabase con = new ConnectDatabase();
		String sql="SELECT * from 用户  where 审核状态='待审核'";
		PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){//表单一定要写在while循环里面，否则action无法获取每个按钮对应的ID
		%>
		<form method="post" action="ShenHeAction">
			<table border="1" width="100%">
		         <tr>
		           <td width="10%"><%=rs.getString(1) %></td>
		           <td width="20%"><%=rs.getString(2) %></td>
		           <td width="5%"><%=rs.getString(3) %></td>
		           <td width="10%"><%=rs.getString(4) %></td>
		           <td width="15%"><%=rs.getString(5) %></td>
		           <td width="5%"><%=rs.getString(6) %></td>
		           <td width="15%"><%=rs.getString(7) %></td>
		           <td width="10%"><%=rs.getString(8) %></td>
		           <td width="10%">
		           		<input type="submit" name="operation" value="通过审核"/>
		           		<input type="hidden" name="ID" value=<%=rs.getString(5) %>>
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