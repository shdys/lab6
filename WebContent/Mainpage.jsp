<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<!-- Basic page needs 
======================================-->
<title>Homepage</title>
<meta charset="utf-8">
<meta name="author" content="">
<meta name="description" content="">
<meta name="keywords" content="">

<!-- Mobile specific meat 
==============================================-->
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!-- Favicon
============================================ -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">		

<!-- Template Fonts form google 
=============================================-->
<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>

<!-- Theme main CSS File 
==========================================================-->
<link rel="stylesheet" href="style.css">

<!-- Mordernizer Js -->
<script src="js/modernizr-2.8.3.min.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>

</head>
<body>
<!-- Start Header Top area -->

	<div class="header-top">
	<div class="container">
		<div class="row">
			<div class="col-md-5 col-sm-6">
				<div class="phone-mail-area">
						<li>
							<i class="fa fa-envelope-o"></i> <%  
								   String ename = request.getParameter("userEmail");  
								   out.println(ename);   
								    %>
							<div id='dv'></div>
						</li>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- End of Header Top area -->
<!-- Header Area Start -->
<header class="header-area">
	<div class="container">
			<div class="col-md-3">		
				<div class="logo-wrap">
					<a href="#"><img src="img/logo.jpg" height="200" width="200" alt=""></a>
				</div>
			</div>
	</div>
</header>
<!-- Header Area End -->

<!-- Slider area Start -->   

	<div class="item">
	  <div class="item">
	  <script type ="text/javascript" >
		 var curIndex=0;
		 //时间间隔 单位毫秒
		var timeInterval=10000;
		 var arr=new Array();
		 arr[0]="img/slider/2.jpg";
		 arr[1]="img/slider/3.jpg";
		 arr[2]="img/slider/4.jpg";
		 arr[3]="img/slider/5.jpg";
		setInterval(changeImg,timeInterval);
		function changeImg()
		{
		 var obj=document.getElementById("obj");
		 if (curIndex==arr.length-1) 
		 {
		 curIndex=0;
		 }
		 else
		 {
		 curIndex+=1;
		 }
		 obj.src=arr[curIndex];
		}
		</script>
		<img id=obj src ="img/slider/1.jpg" border =0 />

			<div class="slide-content carousel-caption hidden-xs">
				<div class="slide-content-top">
					<h1>Secret-recipe</h1>
					<h2>AA-Dutch-Calculator</h2>
					<p>This application is designed for people to calculate the sum for every one who take part in the activity</p>
				</div>
				<div class="slide-property-detail">
					<ul>
						<li>normal</li>
						<li>Girls for free</li>
						<li>Leaving early pay more</li>
						<li>Other</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
<!-- Slider Area End -->


<!-- Property query area start -->
<section class="property-query-area">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-6">
				<div class="query-title">
					<h2>Create Your Activity</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<form action="#">
				<div class="col-md-3 col-sm-6">
					<div class="single-query">
						<label for="keyword-input">Activity name</label>
						<input type="text" id="keyword-input" placeholder="">

					</div>
				</div>
				<div class="col-md-3 col-sm-6">
					<div class="single-query">
						<label for="keyword-input">Number of people</label>
						<input type="text" id="keyword-input" placeholder="">

					</div>
				</div>
				<div class="col-md-3 col-sm-6">
					<div class="single-query">
						<label for="keyword-input">Sum</label>
						<input type="text" id="keyword-input" placeholder="">

					</div>
				</div>
				<div class="col-md-3 col-sm-6">
					<div class="single-query">
						<label>Payment type</label>
						<select>
							<option value="1000 sf">Normal</option>
							<option value="2000 sf">Girls for free</option>
							<option value="3000 sf">Leaving early pay more</option>
							<option value="4000 sf">Other</option>
						</select>

					</div>
					<div class="query-submit-button pull-right">
						<input type="submit" value="Create">
					</div>  
				</div>
			</form>
		</div>
	</div>
</section>
<!--Property query area End-->

<!--Start of Properties Area-->
<section class="properties-area area-pading fix">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="properties-title">
					<h2>Featured Activities</h2>
					<a href="#" class="view-more">View all</a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-sm-6">
				<div class="single-featured-properties">
					<div class="properties-image">
						<a href="#"><img src="img/properties/1.jpg" alt=""></a>
					</div>
					<div class="sale-tag">
						<p>For Sale</p>
					</div>
					<div class="properties-include">
						<ul>
							<li><i class="fa fa-home"></i> 30,000 Acres</li>
							<li><i class="fa fa-bed"></i>4 Bedrooms</li>
							<li><i class="fa fa-tty"></i> 4 Bathrooms</li>
						</ul>
					</div>
					<div class="properties-content">
						<h3><a href="#">South Mervin Boulevard</a></h3>
						<p><i class="fa fa-map-marker"></i> Merrick Way, Miami, USA</p>
						<p class="detail-text">Lorem ipsum dolor sit amet, consectetuer adipiing elit. Aenean commodo ligula eget dolor. </p>
						<div class="price-detail">
							<p class="price-range pull-left">$ 1,23,00.000</p>
							<a href="#" class="price-detail pull-right">Details <i class="fa fa-angle-right"></i></a>
						</div>
					</div>
				</div>
			</div> 
			<!-- End of Single properties -->
			<div class="col-md-4 col-sm-6">
				<div class="single-featured-properties">
					<div class="properties-image">
						<a href="#"><img src="img/properties/2.jpg" alt=""></a>
					</div>
					<div class="sale-tag">
						<p>For Sale</p>
					</div>
					<div class="properties-include">
						<ul>
							<li><i class="fa fa-home"></i> 30,000 Acres</li>
							<li><i class="fa fa-bed"></i>4 Bedrooms</li>
							<li><i class="fa fa-tty"></i> 4 Bathrooms</li>
						</ul>
					</div>
					<div class="properties-content">
						<h3><a href="#">South Mervin Boulevard</a></h3>
						<p><i class="fa fa-map-marker"></i> Merrick Way, Miami, USA</p>
						<p class="detail-text">Lorem ipsum dolor sit amet, consectetuer adipiing elit. Aenean commodo ligula eget dolor. </p>
						<div class="price-detail">
							<p class="price-range pull-left">$ 1,23,00.000</p>
							<a href="#" class="price-detail pull-right">Details <i class="fa fa-angle-right"></i></a>
						</div>
					</div>
				</div>
			</div>
			<!-- End of Single properties -->
			<div class="col-md-4 col-sm-6">
				<div class="single-featured-properties">
					<div class="properties-image">
						<a href="#"><img src="img/properties/3.jpg" alt=""></a>
					</div>
					<div class="sale-tag">
						<p>For Sale</p>
					</div>
					<div class="properties-include">
						<ul>
							<li><i class="fa fa-home"></i> 30,000 Acres</li>
							<li><i class="fa fa-bed"></i>4 Bedrooms</li>
							<li><i class="fa fa-tty"></i> 4 Bathrooms</li>
						</ul>
					</div>
					<div class="properties-content">
						<h3><a href="#">South Mervin Boulevard</a></h3>
						<p><i class="fa fa-map-marker"></i> Merrick Way, Miami, USA</p>
						<p class="detail-text">Lorem ipsum dolor sit amet, consectetuer adipiing elit. Aenean commodo ligula eget dolor. </p>
						<div class="price-detail">
							<p class="price-range pull-left">$ 1,23,00.000</p>
							<a href="#" class="price-detail pull-right">Details <i class="fa fa-angle-right"></i></a>
						</div>
					</div>
				</div>
			</div>
			<!-- End of Single properties -->
			<div class="col-md-4 col-sm-6 hidden-md hidden-lg">
				<div class="single-featured-properties">
					<div class="properties-image">
						<a href="#"><img src="img/properties/3.jpg" alt=""></a>
					</div>
					<div class="sale-tag">
						<p>For Sale</p>
					</div>
					<div class="properties-include">
						<ul>
							<li><i class="fa fa-home"></i> 30,000 Acres</li>
							<li><i class="fa fa-bed"></i>4 Bedrooms</li>
							<li><i class="fa fa-tty"></i> 4 Bathrooms</li>
						</ul>
					</div>
					<div class="properties-content">
						<h3><a href="#">South Mervin Boulevard</a></h3>
						<p><i class="fa fa-map-marker"></i> Merrick Way, Miami, USA</p>
						<p class="detail-text">Lorem ipsum dolor sit amet, consectetuer adipiing elit. Aenean commodo ligula eget dolor. </p>
						<div class="price-detail">
							<p class="price-range pull-left">$ 1,23,00.000</p>
							<a href="#" class="price-detail pull-right">Details <i class="fa fa-angle-right"></i></a>
						</div>
					</div>
				</div>
			</div>
			<!-- End of Single Activities -->
		</div>
		<!-- Start of Recent Activities Title Area-->
		<div class="row">
			<div class="col-md-12">
				<div class="properties-title margintop100">
					<h2>Recent Activitiess</h2>
					<a href="#" class="view-more">View all</a>
				</div>
			</div>
		</div> 
		<!-- End of Recent Activities Title Area-->
		<!--Start of Recent Single Recent Properties  Area -->
		<div class="row">
			<div class="col-md-4 col-sm-6">
				<div class="single-featured-properties">
					<div class="properties-image">
						<a href="#"><img src="img/properties/4.jpg" alt=""></a>
					</div>
					<div class="sale-tag">
						<p>For Sale</p>
					</div>
					<div class="properties-include">
						<ul>
							<li><i class="fa fa-home"></i> 30,000 Acres</li>
							<li><i class="fa fa-bed"></i>4 Bedrooms</li>
							<li><i class="fa fa-tty"></i> 4 Bathrooms</li>
						</ul>
					</div>
					<div class="properties-content">
						<h3><a href="#">South Mervin Boulevard</a></h3>
						<p><i class="fa fa-map-marker"></i> Merrick Way, Miami, USA</p>
						<p class="detail-text">Lorem ipsum dolor sit amet, consectetuer adipiing elit. Aenean commodo ligula eget dolor. </p>
						<div class="price-detail">
							<p class="price-range pull-left">$ 1,23,00.000</p>
							<a href="#" class="price-detail pull-right">Details <i class="fa fa-angle-right"></i></a>
						</div>
					</div>
				</div>
			</div>
			<!-- End of Single properties -->
			<div class="col-md-4 col-sm-6">
				<div class="single-featured-properties">
					<div class="properties-image">
						<a href="#"><img src="img/properties/5.jpg" alt=""></a>
					</div>
					<div class="sale-tag">
						<p>For Sale</p>
					</div>
					<div class="properties-include">
						<ul>
							<li><i class="fa fa-home"></i> 30,000 Acres</li>
							<li><i class="fa fa-bed"></i>4 Bedrooms</li>
							<li><i class="fa fa-tty"></i> 4 Bathrooms</li>
						</ul>
					</div>
					<div class="properties-content">
						<h3><a href="#">South Mervin Boulevard</a></h3>
						<p><i class="fa fa-map-marker"></i> Merrick Way, Miami, USA</p>
						<p class="detail-text">Lorem ipsum dolor sit amet, consectetuer adipiing elit. Aenean commodo ligula eget dolor. </p>
						<div class="price-detail">
							<p class="price-range pull-left">$ 1,23,00.000</p>
							<a href="#" class="price-detail pull-right">Details <i class="fa fa-angle-right"></i></a>
						</div>
					</div>
				</div>
			</div>
			<!-- End of Single properties -->
			<div class="col-md-4 col-sm-6">
				<div class="single-featured-properties">
					<div class="properties-image">
						<a href="#"><img src="img/properties/6.jpg" alt=""></a>
					</div>
					<div class="sale-tag">
						<p>For Sale</p>
					</div>
					<div class="properties-include">
						<ul>
							<li><i class="fa fa-home"></i> 30,000 Acres</li>
							<li><i class="fa fa-bed"></i>4 Bedrooms</li>
							<li><i class="fa fa-tty"></i> 4 Bathrooms</li>
						</ul>
					</div>
					<div class="properties-content">
						<h3><a href="#">South Mervin Boulevard</a></h3>
						<p><i class="fa fa-map-marker"></i> Merrick Way, Miami, USA</p>
						<p class="detail-text">Lorem ipsum dolor sit amet, consectetuer adipiing elit. Aenean commodo ligula eget dolor. </p>
						<div class="price-detail">
							<p class="price-range pull-left">$ 1,23,00.000</p>
							<a href="#" class="price-detail pull-right">Details <i class="fa fa-angle-right"></i></a>
						</div>
					</div>
				</div>
			</div>
			<!-- End of Single properties -->
			<div class="col-md-4 col-sm-6 hidden-md hidden-lg">
				<div class="single-featured-properties">
					<div class="properties-image">
						<a href="#"><img src="img/properties/6.jpg" alt=""></a>
					</div>
					<div class="sale-tag">
						<p>For Sale</p>
					</div>
					<div class="properties-include">
						<ul>
							<li><i class="fa fa-home"></i> 30,000 Acres</li>
							<li><i class="fa fa-bed"></i>4 Bedrooms</li>
							<li><i class="fa fa-tty"></i> 4 Bathrooms</li>
						</ul>
					</div>
					<div class="properties-content">
						<h3><a href="#">South Mervin Boulevard</a></h3>
						<p><i class="fa fa-map-marker"></i> Merrick Way, Miami, USA</p>
						<p class="detail-text">Lorem ipsum dolor sit amet, consectetuer adipiing elit. Aenean commodo ligula eget dolor. </p>
						<div class="price-detail">
							<p class="price-range pull-left">$ 1,23,00.000</p>
							<a href="#" class="price-detail pull-right">Details <i class="fa fa-angle-right"></i></a>
						</div>
					</div>
				</div>
			</div>
			<!-- End of Single properties -->
		</div> 
		<!-- End of Recent Single Recent Properties  Area -->
	</div>
</section>
<!-- End of Properties Area-->
<!-- Placed js at the end of the document so the pages load faster -->
<!-- Main jQuery file -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- Bootstrap Js -->
<script src="js/bootstrap.min.js"></script>
<!-- Owl carousel js -->
<script src="js/owl.carousel.min.js"></script>
<!-- scroll up js -->
<script src="js/jquery.scrollUp.min.js"></script>
<!-- BX Slider js -->
<script src="js/jquery.bxslider.min.js"></script>
<!-- wow js -->
<script src="js/wow.min.js"></script>
<!-- meanmenu js -->
<script src="js/jquery.meanmenu.js"></script>
<!-- Initialize WOW js for Animation-->
<script>
	new WOW().init();
</script>
<!-- Theme jQuery Codes goes hear -->
<script src="js/script.js"></script>
</body>
<!-- Body End  -->
</html>
