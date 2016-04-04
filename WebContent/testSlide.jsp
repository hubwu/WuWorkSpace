<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>SlidesJS Standard Code Example</title>
  <meta name="description" content="SlidesJS is a simple slideshow plugin for jQuery. Packed with a useful set of features to help novice and advanced developers alike create elegant and user-friendly slideshows.">
  <meta name="author" content="Nathan Searles">

  <!-- SlidesJS Required (if responsive): Sets the page width to the device width. -->
  <meta name="viewport" content="width=device-width">

<link rel="stylesheet" type="text/css"
	href="css/jquery.mobile-1.1.2.min.css" />
  <link rel="stylesheet" href="css/example.css">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <!-- End CSS for slidesjs.com example -->

  <style>
    body {
      -webkit-font-smoothing: antialiased;
      font: normal 15px/1.5 "Helvetica Neue", Helvetica, Arial, sans-serif;
      color: #232525;
      padding-top:70px;
    }

    #slides {
      display: none;
      margin-bottom:50px;
    }

    .slidesjs-navigation {
      margin-top:3px;
    }

    .slidesjs-previous {
      margin-right: 5px;
      float: left;
    }

    .slidesjs-next {
      margin-right: 5px;
      float: left;
    }

    .slidesjs-pagination {
      margin: 6px 0 0;
      float: right;
      list-style: none;
    }

    .slidesjs-pagination li {
      float: left;
      margin: 0 1px;
    }

    .slidesjs-pagination li a {
      display: block;
      width: 13px;
      height: 0;
      padding-top: 13px;
      background-image: url(img/pagination.png);
      background-position: 0 0;
      float: left;
      overflow: hidden;
    }

    .slidesjs-pagination li a.active,
    .slidesjs-pagination li a:hover.active {
      background-position: 0 -13px
    }

    .slidesjs-pagination li a:hover {
      background-position: 0 -26px
    }

    a:link,
    a:visited {
      color: #333
    }

    a:hover,
    a:active {
      color: #9e2020
    }

    .navbar {
      overflow: hidden
    }
  </style>
  <!-- End SlidesJS Optional-->

  <!-- SlidesJS Required: These styles are required if you'd like a responsive slideshow -->
  <style>
    #slides {
      display: none
    }

    .container {
      margin: 0;
      padding:0;
    }

    /* For tablets & smart phones */
    @media (max-width: 767px) {
      body {
        padding-left: 20px;
        padding-right: 20px;
      }
      .container {
        width: auto
      }
    }

    /* For smartphones */
    @media (max-width: 480px) {
      .container {
        width: auto
      }
    }

    /* For smaller displays like laptops */
    @media (min-width: 768px) and (max-width: 979px) {
      .container {
        width: 724px
      }
    }

    /* For larger displays */
    @media (min-width: 1200px) {
      .container {
        width: 1170px
      }
    }
  </style>
  <!-- SlidesJS Required: -->
</head>
<body>
  <!-- SlidesJS Required: Start Slides -->
  <!-- The container is used to define the width of the slideshow -->
  	<div data-role="page" id="pageone">
		<div data-role="header" data-theme="e">
			<div>
				<img src="images/logo.png">亲，正在努力加载中……
			</div>
		</div>
<div data-role="content" style="margin:0;padding:0;">	
  <div class="container" style="width:100%;margin:0;padding:0;">
    <div id="slides" style="width:100%;margin:0;padding:0;">
	    <div><img src="images/advert1.png"></div>
	    <img src="images/advert2.jpg">
	    <img src="images/advert3.jpg">
      <!-- <a href="#" class="slidesjs-previous slidesjs-navigation"><i class="icon-chevron-left"></i></a>
      <a href="#" class="slidesjs-next slidesjs-navigation"><i class="icon-chevron-right"></i></a> -->
    </div>
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
<script src="js/jquery-1.8.0.min.js"></script>
<script src="js/jquery.mobile-1.1.2.min.js"></script>
<script src="js/jquery.slides.js"></script>
  <script>
    $(function() {
      $('#slides').slidesjs({
        width: 400,
        height: 470,
        pagination:false,
        navigation: false,
        play: {
            active: false,
            auto: true,
            interval: 2000,
            swap: false,
            pauseOnHover: true,
            restartDelay:3333333
        }
      });
    });
  </script>
  <!-- End SlidesJS Required -->
</body>
</html>
