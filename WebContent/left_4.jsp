<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>垂直导航</title>
		<style type="text/css">
			*{
				margin:0px;
				padding:0px;
			}
			#main_left{
				width:100%;
				height:100%;
				background:url(images/left.png)no-repeat; 
				background-size:cover;
				float:left;
				overflow:hidden;
			}
			a{
				color:white;
				font:bolder 18px 楷体;
				text-decoration:none;
			}
			a:hover{
				padding:5px 5px;
				background-color:#cae4ff;
				border:4px groove #f9f9f9;
				color:#333333;
			}
			table{
				width:180px;
				height:460px;
				cellspacing:5px;
				padding:0px auto;
				text-align:center;
				vertical-align:middle;
				font-size:16px;
			}
		</style>
	</head>
	<body>
		<div id="main_left">
			<table>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><a href="用户审核.jsp" target="mainframe">用户审核</a></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><a href="人流量查看.jsp" target="mainframe">人流量查看</a></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><a href="车流量查看.jsp" target="mainframe">车流量查看</a></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><a href="login.jsp" target="_top">注销</a></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
	</body>
</html>