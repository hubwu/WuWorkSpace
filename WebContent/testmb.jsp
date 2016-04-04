<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<script type="text/javascript">
$(document).on("pageinit","#pageone",function(){

	$("a").on("tap",function(){
		alert("ssss");
		  $(this).hide();
		});
	
	$("a").on("swipe",function(){
		  $("span").text("Swipe detected!");
		});

});


</script>
</head>
<body>

<div data-role="page" id="pageone">
  <div data-role="header">
    <a href="#" data-role="button" data-icon="home" data-theme="b">首页</a>
    <h1>欢迎来到我的主页</h1>
    <a href="#" data-role="button" data-icon="search" data-theme="e">搜索</a>
  </div>

  <div data-role="content">
   <p>此处是内容...</p>
   <a href="#pagetwo" id="abtn" >转到页面二</a>
  </div>

  <div data-role="footer">
    <a href="#" data-role="button" data-theme="b" data-icon="plus">转播到新浪微博</a>
    <a href="#" data-role="button" data-theme="c" data-icon="plus">转播到腾讯微博</a>
    <a href="#" data-role="button" data-theme="e" data-icon="plus">转播到 QQ 空间</a>
  </div>
</div> 

</body>
</html>
