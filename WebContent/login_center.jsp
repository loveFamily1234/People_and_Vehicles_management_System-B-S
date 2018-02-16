<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>登录界面中间部分</title>
		<style type="text/css">
			*{margin:0;padding:0;}
			#login{
				width:100%;
				height:490px;
				background:url(images/1122.jpg)no-repeat; 
				background-size:cover;
			}
			.left{
				
				margin-top:25px;
				width:620px;
				height:90%;
				margin-left:680px;
				background:url(images/4.jpg)no-repeat; 
				background-size:cover;
				float:left;
			}
			.text{
				padding-top:100px;
				padding-left:100px;
				padding-right:100px;
				text-indent:2em;
				font:bold 30px 楷体;
				
			}
			.input{
				padding-top:20px;
				padding-left:180px;
			}
			input{
				border:none;
				font-size:20px;
				font-family:楷体;
				background-color:#808080;
				color:white;
			}
			.user{
				margin-bottom:5px;
				font-family:楷体;
			}
			.password{
				margin-bottom:5px;
				font-family:楷体;
			}
			.select{
				margin-bottom:5px;
				font-family:楷体;
				font-size:20px;
				margin-left:50px;
			}
			.submit{
				margin-left:8px;
			}
		</style>
		<Script Language="JavaScript"> 
		    function login() 
		    { 
			    document.form1.action="loginAction_login"; 
			    //window.parent.location.href="loginAction"//此方法不会传input中的值，此方法也可实现frameset框架整个页面的跳转
			    document.form1.submit(); 
		    } 
		     
		    function register() 
		    { 
			    document.form1.action="loginAction_register"; 
			    document.form1.submit(); 
		    	//window.parent.location.href="loginAction"//此方法不会传input中的值
		    } 
	    </Script> 
	</head>
	<body>
		<div id="login">
			<div class="left">
				<div class="text">
				欢迎使用高校进出人员及车辆管理系统，请先登录；若未在本站注册过，请先注册！
				</div>
				<div class="input">
					<form name="form1" method="post" target="_top">
						<tr>
							<td><img src="images/user_2.png"></td>
							<td><input class="user" type="text" name="username"></td>
						</tr>
						<hr size="1" width="235px">
						<br>
						<tr>
							<td><img src="images/password.png"></td>
							<td><input class="password" type="password" name="password"></td>
						</tr>
						<hr size="1" width="235px">
						<br>
						<tr>
							<td><img src="images/user_2.png"></td>
							<td>
								<select class="select" name="role">
									<option value="管理员">管理员</option>
									<option value="用户">用户</option>
								</select>
							</td>
						</tr>
						<hr size="1" width="235px">
						<br>
						<tr>
							<td><input class="submit" type="button" value="登录" onclick="login()"></td>
							<td>&nbsp;</td>
							<td><input type="button" value="忘记密码"></td>
							<td>&nbsp;</td>
							<td><input type="button" value="注册" onclick="register()"></td>
						</tr>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>