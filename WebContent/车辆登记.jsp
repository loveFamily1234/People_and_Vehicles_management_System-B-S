<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>外来车辆登记表</title>
		<style type="text/css">
			body{
				text-align:center;
				margin-top:50px;
				margin-left:60px;
				width:90%;
				height:350px;
				background:url(images/1117.jpg)no-repeat; 
				background-size:cover;
			}
			h1{font-size:25px;text-align:center;color:white;}
			.dengji{font-size:14px;align:center;width:840px;margin:0 auto;background:#f7f7f7;}
			.dengji td{border:1px solid #ccc;padding:2px 3px;text-align:center;}
			.dengji .ibg{text-align:left;}
			.dengji .bbg{height:30px;}
		</style>
	</head>
	<body>
		<h1>外来车辆登记表</h1>
		<form method="post" action="carRecordAction">
			<table class="dengji">
				<tr>
					<td width="100">卡号</td>
					<td colspan="4" class="ibg">
						<input type="text" name="cardNumber"/>
					</td>
					<td>车牌号</td>
					<td colspan="3" class="ibg">
						<input name="chepaiNumber" type="text"/>
					</td>
				</tr>
				<tr>
					<td>事由</td>
					<td colspan="8" class="ibg">
						<input name="reason" type="text" style="width:500px;"/>
					</td>
				</tr>
				<tr>
					<td colspan="9" class="bbg">
						<input type="submit" name="submit" value="登记" style="width:500px;height:30px;background-color:#E6941A;font-size:20px;"/>
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>