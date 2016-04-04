
<%@ page language="java" pageEncoding="UTF-8"%>

<html>
<head>
<link href="style.css" rel="stylesheet">
</head>
<body>
<div class="wrap nonav">
	<header>
		<div class="lbtn"><a href="javaScript:void(0)" onclick="goBack()"><i class="ic_back"></i></a></div>
	    <h1>电影详情</h1>
	</header>
	<div class="main">
		<div class="dy_info">
			<div class="dy_img">
	         	<img src="600/1.jpg" />
			</div>
			<div class="dy_img">
	         	<img src="600/2.jpg" />
			</div>
			<div class="dy_img">
	         	<img src="600/3.jpg" />
			</div>
			<div class="dy_bg">
		 		<h2>${film.filmName }</h2>
				<p>导演：{film.director }</p>
				<p>主演：{film.protagonist }</p>
				<p>地区：{film.area }</p>
				<p>类型：{film.type }</p>
				<p>上映：<fmt:formatDate value="{film.onlineTime }" pattern="yyyy-MM-dd"/></p>
				<p>时长：{film.mins }分钟</p>
	         </div>
	         <p class="dy_xq" style="margin-bottom: 40px">
	         	电影简介：{film.contentAbstract }
	         </p>
	         <p class="dy_bg" style="margin-bottom: 40px">
	         	影评：
	         	<br/>&nbsp;&nbsp;&nbsp;&nbsp;
	    			{film.cinecismTxt}
	    		<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    		
	         </p>
	    </div>
	</div>
	<bottom id="bottom" align="center">
		<button class="button" onclick="toChooseOrgBuy({film.filmID},'aa')">选择影院购票</button>
	</bottom>
</div>
<div class="dialog" style="display:none" id="loading">
	<div class="dialog_con dialog_loading"></div>
</div>
</body>
</html>