<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Leaving Early Pay More</title>
	<style type="text/css">
		
		.col-center-block {
			float:none;
			display:block;
			margin-left: auto;
			margin-right: auto;
			margin-top:20%;
		}
		h2 {
			margin-top:20px;
			margin-bottom:20px;
		}
	</style>
</head>
<body>
	<%  session.getAttribute("name");  %>
	<div class="container">
		<div class="row">
			<div class="col-xl-6 col-md-4 col-center-block">
				<form action="Add">
					<input type="hidden" name="name" value="name">
					<h2>Leaving Early Pay More</h2>
					
					<div class="form-group">
						<p>please input the percent:</p>
						<input type="text" id="searchbox" name="Percent">
					</div>
					<div class="form-group">
						<p>please input the number of early-leaving:</p>
						<input type="text" id="searchbox" name="Leavenumber">
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">calculation</button>  
				</form>
			</div>
		</div>
	</div>

</body>
</html>