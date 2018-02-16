<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>网站声明</title>
		<style type="text/css">
			*{
				margin:0px;
				padding:0px;
			}
			body{
				width:100%;
				height:100%;
				background:url(images/网站声明.jpg)no-repeat; 
				background-size:cover;
				text-align:center;
			}
			
			a{
				color:#11EE96;
			}
			tr{font-family:"楷体",Tahoma;font-size:14pt;text-align:left;color:#ffffff;}
			#td1{text-align:center;font-family:楷体;font-size:36px;color:#d10000;line-height:30px;padding:8px 10px 15px 10px;}
			#p1{text-align:right;}
			#p2{text-indent:2em;}
			#td2{text-align:left;vertical-align:top;font-family:楷体;font-size:18px;color:#ffffff;line-height:26px;}
		</style>
		<script language="javascript">
			function doZoom(size){
				document.getElementById("zoom").style.fontSize=size+'px';
			}
			function ChangeColor(ColorName){
				document.getElementById("c").style.background=ColorName;
			}
		</script>
	</head>
	<body>
		<table id="table" width="100%" style="border:0px solid #d5d5d5">
			<tr><td width="80%" style="padding:30px 40px;">
				<table id="c">
					<tr>
						<td id="td1">网站声明</td>
					</tr>
					<tr>
						<td height="5"><hr color="#cccccc"></td>
					</tr>
					<tr>
						<td height="28" align="center">
							<span>日期：2017-06-20</span>
							<span>来源：志东工作室</span>
							<span>浏览次数：</span>
							<span>
								字号：[
								<a href="javascript:doZoom(20)">大</a>
								<a href="javascript:doZoom(18)">中</a>
								<a href="javascript:doZoom(16)">小</a>
								]
							</span>
							<span style="padding-left:10px">视力保护色：
								<input type="button" value="色1" onclick="ChangeColor('#808080')" height="13" width="13"/>
								<input type="button" value="色2" onclick="ChangeColor('#BBA344')" height="13" width="13"/>
								<input type="button" value="色3" onclick="ChangeColor('#91836F')" height="13" width="13"/>
								<input type="button" value="色4" onclick="ChangeColor('#7755AA')" height="13" width="13"/>
								<input type="button" value="色5" onclick="ChangeColor('#EE9611')" height="13" width="13"/>
								<input type="button" value="色6" onclick="ChangeColor('#000000')" height="13" width="13"/>
							</span>
						</td>
					</tr>
					<tr>
						<td id="td2">
							<div id="zoom">
								<p id="p2">当今社会的车辆数量正在以指数的形式增长，车辆为我们的生活和工作带来了极大的方便，因此越来越多的车辆也加入到高等学校中，
								并且在高校的日常生活办公中扮演着重要的角色。虽然车辆的增加使得高等学校的日常工作和办公的效率得到了大大的提升，
								但是越来越多的车辆涌入校园却给高校的车辆管理带来了麻烦。如果能更好的实现车辆管理，那么可以进一步提高高等学校的日常工作和办公的效率，
								同时也可以大大地节约学校在车辆上投入的成本，最重要的是可以更好的实现高等学校为学生服务的宗旨。</p>
								<P id="p2">本网站虽然十分简洁，但是基本功能都已基本实现！另外，凡是有认为本站侵犯了您的权利，请您联系我们，我们必将立刻改正！</p>
								<p id="p2">最后，感谢网友对本站的大力支持！！！</p>
								<p id="p1">志东工作室</p>
								<p id="p1">2017年06月20日</p>
							</div>
						</td>
					</tr>
				</table>
			</td></tr>
		</table>
	</body>
</html>