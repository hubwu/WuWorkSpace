<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	
	String fileName=request.getParameter("fileName");
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
.blue {
	color: #d9eef7;
	border: solid 1px #0076a3;
	background: #0095cd;
	background: -webkit-gradient(linear, left top, left bottom, from(#00adee),
		to(#0078a5) );
	background: -moz-linear-gradient(top, #00adee, #0078a5);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00adee',
		endColorstr='#0078a5' );
	height: 30px;
	width:100px;
}

.blue:hover {
	background: #007ead;
	background: -webkit-gradient(linear, left top, left bottom, from(#0095cc),
		to(#00678e) );
	background: -moz-linear-gradient(top, #0095cc, #00678e);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#0095cc',
		endColorstr='#00678e' );
}

.blue:active {
	color: #80bed6;
	background: -webkit-gradient(linear, left top, left bottom, from(#0078a5),
		to(#00adee) );
	background: -moz-linear-gradient(top, #0078a5, #00adee);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#0078a5',
		endColorstr='#00adee' );
}

</style>
<script type="text/javascript">
function downapp(flag){
	if(flag=="ios"){
		<%-- document.getElementById("downForm").action="ios_temp.jsp?fileName=<%=fileName%>"; --%>
		document.getElementById("downForm").action="<%=basePath%>/downapp.do?flag=ios&fileName=<%=fileName%>";
	}else{
		document.getElementById("downForm").action="<%=basePath%>/downapp.do?flag=android&fileName=<%=fileName%>";
	}
    document.getElementById("downForm").method="post";
	document.getElementById("downForm").submit();
}
</script>
<style>
img {
	max-width: 100% !important;
}
</style>
</head>
<body style="height: 100%">

	<div id="mcover"
		onclick="document.getElementById('mcover').style.display='';"
		style="z-index: 3000; display: none; top: 0px; right: 40px; position: fixed;">
		<img src="images/guide.png" width="150px"/>
	</div>
	<br />
	<div class="panel" id="panelDiv">
		<div class="panel-title" style="text-align:center !important"> 
			<font>请选择要下载的客户端</font>
		</div>
		<div class="linet"></div>
		<div class="panel-content"  style="white-space: normal; word-break: break-all; overflow: hidden; margin: 10px 0px 0px 0px; display: block;">
			
			<form id="downForm" style="width: 100%; height: 100%">
			<table style="width: 100%;">
				<tr>
					<td style="width:60%">
						<a href="<%=basePath%>/downapp.do?flag=ios">&nbsp&nbsp&nbsp下载IOS版客户端</a>
					</td>
					<td><input type="button" id="" value="点击下载" class="blue"
						onclick="javascript:downapp('ios')" /></td>
				</tr>
				<tr style="height:20px;">
				<td></td>
				<td></td>
				</tr>
				
				<tr>
					<td><a href="<%=basePath%>/downapp.do?flag=android">&nbsp&nbsp&nbsp下载Android版客户端</a>
					</td>
					<td><input type="button" id="" value="点击下载" class="blue"
						onclick="javascript:downapp('android')" />
					</td>
				</tr>
			</table>
		</form>
			<!-- <font id="chickurl">
				$chickurl$
			</font> <span id="spanId" class="font"
				style="font-size: 14px; Line-height: 25px; color: red; margin: 0px 20px 0px 20px; display: block;">由于众所周知的原因，此链接无法在微信中打开。如需浏览，可点击右上角在“浏览器中打开”。</span> -->
		</div>
		<div class="linet"></div>
		<!-- <div class="panel-title">
			<button class="inButtonColor"
				onclick="document.getElementById('mcover').style.display='block';">
				立即访问</button>
		</div> -->
	</div>


</body>

</html>
