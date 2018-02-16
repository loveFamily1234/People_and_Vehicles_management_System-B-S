<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>进出车辆管理垂直导航</title>
		<style type="text/css">
			*{
				margin:0px;
				padding:0px;
			}
			#main_left{
				width:100%;
				height:100%;
				background:url(images/left_4.jpg)no-repeat; 
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
					<td><a href="车辆登记.jsp" target="mainframe">登记</a></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><a href="车辆删除.jsp" target="mainframe">删除</a></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><a href="车辆修改.jsp" target="mainframe">修改</a></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><a href="index_user.jsp" target="_top">返回主页面</a></td>
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