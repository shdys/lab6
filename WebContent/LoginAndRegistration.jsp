<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title>login and registration</title>
      <style type="text/css">
body {
	background-image: url(images/226989-106.jpg);
}
</style>
	
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap2.min.css"  type="text/css">
	
	<!-- Custom CSS -->
    <link rel="stylesheet" href="css/style2.css">
	
	
	<!-- Custom Fonts -->
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="fonts/font-slider2.css" type="text/css">
	
	<!-- jQuery and Modernizr-->
	<script src="js/jquery-2.1.1.js"></script>
	
	<!-- Core JavaScript Files -->  	 
    <script src="js/bootstrap.min.js"></script>
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body>    
	<!--//////////////////////////////////////////////////-->
	<!--///////////////////Account Page///////////////////-->
	<!--//////////////////////////////////////////////////-->
	<center><h1>Welcome to our website</h1></center>
	<div id="page-content" class="single-page">
		<div class="container">
			
			<div class="row">
				<div class="col-md-6">
					<div class="heading"><h2>Login</h2></div>
					
					<form name="form1" id="ff1" method="post" action="CheckUserRightOrNot">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Email Address :" name="userEmail" id="userEmail" required>
						</div>
						
						
						
						
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Password :" name="userPassword" id="email" required>
						</div>
						<button type="submit" class="btn btn-1" name="login" id="login">Login</button>
					</form>
					
				</div>
				<div class="col-md-6">
					<div class="heading"><h2>New User ? Create An Account.</h2></div>
					
					<form name="form2" id="ff2" method="post" action="Registration">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Name :" name="userName" id="firstname" required>
						</div>

						<div class="form-group">
							<input type="tel" class="form-control" placeholder="Email Address :" name="userEmail" id="email2" required>
						</div>
						
						<div class="form-group">
							<input name="userSex" id="gender" type="radio" value = "male" required> Male <input name="userSex" id="gender" type="radio" value = "female" required> Female 
						</div>
						
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Password :" name="userPassword" id="password" required>
						</div>
						
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Retype Password :" name="rePassword" id="repassword" required>
						</div>
						
						<button onclick="return check1()" type="submit" class="btn btn-1" name="registration">Create</button>
						<button type="reset" class="btn btn-1" name="reset">Reset</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>

<script language="JavaScript">

function check1() 
{
var email2=document.getElementById("email2").value;
var apos=email2.indexOf("@");
var dotpos=email2.lastIndexOf(".");
if(apos<1||dotpos-apos<2)
{
	alert("邮箱格式不正确！");
	return false;
}

	

var pd1=document.getElementById("password").value;
var pd2=document.getElementById("repassword").value;
if (pd1!=pd2) 
{
alert("两次密码不一致！");
return false;
}
return true;
}

</script> 