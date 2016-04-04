<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<link rel="stylesheet" type="text/css" href="css/jquery.mobile-1.1.2.min.css" />
<script src="js/jquery.mobile-1.1.2.min.js"/>
<script src="js/jquery-1.8.0.min.js"/>
<title>下载客户端</title>
<script type="text/javascript">

</script>
</head>
<body>

<div data-role="header">
  <a href="#" data-role="button" data-icon="home" data-theme="b">Home</a>
  <h1>Welcome To My Homepage</h1>
  <a href="#" data-role="button" data-icon="search" data-theme="e">Search</a>
</div>


  <div data-role="content">
    <p>我是一名移动开发者！</p>
  </div>
<form method="post" action="demoform.asp">
  <div data-role="fieldcontain">
    <label for="fullname">全名：</label>
    <input type="text" name="fullname" id="fullname">

    <label for="bday">生日：</label>
    <input type="date" name="bday" id="bday">

    <label for="email">电邮：</label>
    <input type="email" name="email" id="email" placeholder="您的邮件地址..">
    <label for="email">日期：</label>
  <select name="day" id="day" multiple data-native-menu="false">
  <option value="mon">星期一</option>
         <option value="tue">星期二</option>
         <option value="wed">星期三</option>
         <option value="thu">星期四</option>
         <option value="fri">星期五</option>
         <option value="sat">星期六</option>
         <option value="sun">星期日</option>
  
  </select>
    <label for="points">Points:</label>
    <input type="range" name="points" id="points" value="50" min="0" max="100">
  </div>
</form>


</div>
<div data-role="footer">
  <a href="#" data-role="button" data-theme="b" data-icon="plus">Button 1</a>
  <a href="#" data-role="button" data-theme="c" data-icon="plus">Button 2</a>
  <a href="#" data-role="button" data-theme="e" data-icon="plus">Button 3</a>
</div>

</body>

</html>
