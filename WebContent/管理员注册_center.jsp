<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>注册界面中间部分</title>
		<style type="text/css">
			*{margin:0;padding:0;font-family:楷体;}
			#register{
				width:100%;
				height:490px;
				background:url(images/1114.jpg)no-repeat; 
				background-size:cover;
			}
			.input{
				padding-top:80px;
				padding-left:535px;
			}
			input{
				border:none;
				font-size:20px;
				font-family:楷体;

				color:black;
			}
			.user{
				margin-bottom:5px;
				font-family:楷体;
				margin-left:17px;
			}
			.password{
				margin-bottom:5px;
				font-family:楷体;
				margin-left:34px;
			}
			.confirmPassword{
				margin-bottom:5px;
			}
			.select{
				margin-bottom:5px;
				font-family:楷体;
				font-size:20px;
				margin-left:122px;
			}
			.nickname{
				margin-bottom:5px;
				margin-left:34px;
			}
			hr{
				width:300px;
			}
			.button{
				margin-left:100px;
			}
		</style>
	</head>
	<body>
		<div id="register">
			<div class="left">
				<div class="input">
					<form target="_top" action="AdministratorRegisterAction">
						<tr>
							<td><b>用户名：</b></td>
							<td><input class="user" type="text" name="username"></td>
						</tr>
						<hr size="1">
						<br>
						<tr>
							<td><b>密码：</b></td>
							<td><input class="password" type="password" name="password"></td>
						</tr>
						<hr size="1">
						<br>
						<tr>
							<td><b>确认密码：</b></td>
							<td><input class="confirmPassword" type="password" name="confirmPassword"></td>
						</tr>
						<hr size="1">
						<br>
						<tr>
							<td><b>昵称：</b></td>
							<td><input class="nickname" type="text" name="nickname"></td>
						</tr>
						<hr size="1">
						<br>
						<tr>
							<td colspan="2">
								<label>用户名为手机号或邮箱号，密码6-12个字符。若注册成功，跳转到登录页面；否则，继续注册。</label>
							</td>
						</tr>
						<hr size="1">
						<br>
						<tr>
							<td><input class="button" type="submit" value="注册" onclick="checkReg()"></td>
							<td><input type="reset" value="重置"></td>
						</tr>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>