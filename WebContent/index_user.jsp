<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>高校进出人员及车辆管理系统</title>
		<script type="text/javascript">
			document.onkeydown = function () {
			    if (window.event && window.event.keyCode == 8) {
			        window.event.returnValue = false;
			    }
			}
		</script>
		<style type="text/css">
			*{
				margin:0px;
				padding:0px;
			}
		</style>
	</head>
	<frameset rows="20%,75%,5%" frameborder="0" name="allframe">
		<frame src="head.jsp" name="topframe" scrolling="no" noresize>
		<frameset cols="15%,85%" frameborder="0">
			<frame src="left_1.jsp" name="leftframe" scrolling="no" noresize>
			<frame src="网站声明.jsp" name="mainframe">
		</frameset>
		<frame src="bottom.jsp" name="footframe" scrolling="no" noresize>
	</frameset>
</html>