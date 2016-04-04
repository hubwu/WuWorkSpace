<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();


	String userAgent = request.getHeader("user-agent").toUpperCase();
	System.out.println(userAgent);
	boolean flag = false;
	if (userAgent.indexOf("MICROMESSENGER") == -1) {
		flag=true;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- SUCCESS_HEAD -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<link rel="stylesheet" type="text/css" href="css/panel.css" />
<link rel="stylesheet" type="text/css" href="css/title.css" />
<link rel="stylesheet" type="text/css" href="css/copyright.css" />
<title>下载客户端</title>
<style>
#mcover {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.7);
	display: none;
	z-index: 99998;
}

#mcover img {
	position: fixed;
	right: 18px;
	top: 5px;
	width: 260px;
	height: 180px;
	z-index: 99999;
}

.inButtonColor {
	background-image: url(images/chick.jpg);
	width: 107px;
	height: 32px;
	display: inline-block;
	position: relative;
	margin: 20px;
	padding: 0 20px;
	text-align: center;
	text-decoration: none;
	font: bold 12px/25px Arial, sans-serif;
	text-shadow: 1px 1px 1px rgba(255, 255, 255, .22);
	-webkit-border-radius: 30px;
	-moz-border-radius: 30px;
	border-radius: 30px;
	-webkit-box-shadow: 1px 1px 1px rgba(0, 0, 0, .29), inset 1px 1px 1px
		rgba(255, 255, 255, .44);
	-moz-box-shadow: 1px 1px 1px rgba(0, 0, 0, .29), inset 1px 1px 1px
		rgba(255, 255, 255, .44);
	box-shadow: 1px 1px 1px rgba(0, 0, 0, .29), inset 1px 1px 1px
		rgba(255, 255, 255, .44);
	-webkit-transition: all 0.15s ease;
	-moz-transition: all 0.15s ease;
	-o-transition: all 0.15s ease;
	-ms-transition: all 0.15s ease;
	transition: all 0.15s ease;
	color: #19667d;
}

.linet {
	margin: 20px;
	border: 1px solid #ddd;
	background: #ddd;
}
</style>
<script type="text/javascript">
	function downApp() {
		if (<%=flag%>==true) {
			window.location.href="http://itunes.apple.com/us/app/angry-birds/id343200656?mt=8";
		}
	}
</script>
<style>
img {
	max-width: 100% !important;
}
</style>
</head>
<!-- onload="downApp();" -->
<body style="height: 100%" onload="downApp()">

	<div id="mcover"
		onclick="document.getElementById('mcover').style.display='';"
		style="z-index: 3000; display: none; top: 0px; right: 40px; position: fixed;">
		<img src="images/guide.png" width="150px" />
	</div>
	<br />
	<div class="panel" id="panelDiv">
		<div class="panel-title" style="text-align: center !important">
			<font> &nbsp&nbsp&nbsp&nbsp&nbsp你将要下载客户端</font>
		</div>
		<div class="linet"></div>
		<div class="panel-content"
			style="white-space: normal; word-break: break-all; overflow: hidden; margin: 10px 0px 0px 0px; display: block;">
			<font id="chickurl"> <!-- $chickurl$ -->
			</font> <span id="spanId" class="font"
				style="font-size: 14px; Line-height: 25px; color: red; margin: 0px 20px 0px 20px; display: block;">由于众所周知的原因，此链接无法在微信中打开。如需浏览，可点击右上角在“浏览器中打开”。</span>
		</div>
		<div class="linet"></div>
		<div class="panel-title" style="text-align: center !important">
			<button class="inButtonColor"
				onclick="document.getElementById('mcover').style.display='block';">
				立即访问</button>
		</div>
	</div>


</body>

</html>
