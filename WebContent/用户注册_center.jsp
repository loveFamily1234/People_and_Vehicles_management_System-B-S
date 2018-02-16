<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>用户注册表</title>
		<style type="text/css">
			body{
				text-align:center;
				width:100%;
				height:490px;
				background:url(images/1115.jpg)no-repeat; 
				background-size:cover;
				padding-top:50px;
			}
			h1{font-size:25px;text-align:center;color:white;}
			.zhuce{font-size:14px;align:center;width:840px;background:#f7f7f7;}
			.zhuce td{border:1px solid #ccc;padding:2px 3px;text-align:center;}
			.zhuce .ibg{text-align:left;}
			.zhuce .bbg{padding:20px 0;font-size:13px;}
		</style>
	</head>
	<body>
		<h1>用户注册表</h1>
		<form target="_top" action="UserRegisterAction">
			<table class="zhuce" align="center">
				<tr>
					<td colspan="9">
						<label for="label">用户名为手机号或邮箱号，密码6-12个字符。若注册成功，跳转到登录页面；否则，继续注册。</label>
					</td>
				</tr>
				<tr>
					<td width="100">用户名</td>
					<td colspan="4" class="ibg">
						<input type="text" name="username"/>
					</td>
					<td>密码</td>
					<td colspan="3" class="ibg">
						<input name="password" type="password"/>
					</td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td colspan="8" class="ibg">
						<input name="confirmPassword" type="password" style="width:500px;"/>
					</td>
				</tr>
				<tr>
					<td>昵称</td>
					<td colspan="2" class="ibg">
						<input name="nickname" type="text"/>
					</td>
					<td>姓名</td>
					<td class="ibg">
						<input name="name" type="text"/>
					</td>
					<td colspan="3">身份证号</td>
					<td class="ibg">
						<input name="ID" type="text"/>
					</td>
				</tr>
				<tr>
					<td>家庭住址</td>
					<td colspan="6" class="ibg">
						<input name="address" type="text" style="width:400px;"/>
					</td>
					<td>审核状态</td>
					<td class="ibg">
						<input name="status" type="text" value="待审核" disabled="true"/>
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td colspan="8" class="ibg">
						<select name="sex" style="width:180px;">
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="9” class="bbg">
						<input type="submit" name="submit" value="注册" style="width:500px;height:30px;background-color:#E6941A;font-size:20px;"/>
						<input type="reset" name="reset" value="重置"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>