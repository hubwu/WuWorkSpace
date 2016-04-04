<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="css/jquery.mobile-1.1.2.min.css" />
<script src="js/jquery-1.8.0.min.js"></script>
<script src="js/jquery.mobile-1.1.2.min.js"></script>

<title>下载客户端</title>
<script type="text/javascript">
	$(document).on("pageinit", "#pageone", function() {
		
	    $('#slides').slidesjs({
	        width: 400,
	        height: 460,
	        play: {
	          active: true,
	          auto: true,
	          interval: 4000,
	          swap: true
	        }
	      });
		
	});
</script>

</head>
<body>
	<div data-role="page" id="pageone">
		<div data-role="header" data-theme="e">
			<div>
				<img src="images/logo.png">亲，正在努力加载中……
			</div>
		</div>

		<div data-role="content">
			<div  id="slides">
			<img src="images/advert1.png">
	        <img src="images/advert2.jpg">
	        <img src="images/advert3.png">
			
				<!-- <div class="pic" data-thumb="images/advert1.png"
					data-src="images/advert1.png">
					<div class="camera_caption fadeFromBottom">
						第<em>1</em> 幅图片的说明文字
					</div>
				</div>
				<div class="pic" data-thumb="images/advert2.png"
					data-src="images/advert2.jpg">
					<div class="camera_caption fadeFromBottom">
						第<em>2</em> 幅图片的说明文字
					</div>
				</div>
				<div class="pic" data-thumb="images/advert3.png"
					data-src="images/advert3.png">
					<div class="camera_caption fadeFromBottom">
						第<em>3</em> 幅图片的说明文字
					</div>
				</div> -->
			</div>
		</div>

		<div data-role="footer" data-theme="e"
			style="height: 80px; text-align: center;">
			<div>
				<div>
					<img src="images/ishow_logo.png" width="50px;" height="50px;" />
					<h5 style="margin: 0px; padding: 0px;">爱秀电影传媒</h5>
				</div>

			</div>
		</div>
	</div>

</body>
</html>
