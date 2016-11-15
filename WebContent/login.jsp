<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="css/style.css" rel='stylesheet' type='text/css' />

</head>
<body>
<script>
$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	  
});

function SetCookie(name,value) {
    document.cookie=name + "="+ escape(value);
}

</script>
<script type="text/javascript">  
function GetCookie (name)   
{   
    var arg = name + "=";   
    var alen = arg.length;   
    var clen = window.document.cookie.length;   
    var i = 0;   
    while (i < clen)   
    {   
        var j = i + alen;   
        if (window.document.cookie.substring(i, j) == arg) return getCookieVal (j);   
        i = window.document.cookie.indexOf(" ", i) + 1;   
        if (i == 0)  
            break;   
    }   
    return null;  
}  
function getCookieVal (offset)  
{   
    var endstr = window.document.cookie.indexOf (";", offset);   
    if (endstr == -1)  
        endstr = window.document.cookie.length;   
    return unescape(window.document.cookie.substring(offset, endstr));  
}  
function SetCookie (name, value)  
{   
    var exp = new Date();   
    exp.setTime(exp.getTime() + (30*24*60*60*1000));  
    window.document.cookie = name + "=" + escape (value) + "; expires=" + exp.toGMTString()+";path=/";  
}  
function DeleteCookie (name)  
{   
    var exp = new Date();   
    exp.setTime (exp.getTime() - 100);   
    var cval = GetCookie (name);   
    window.document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString()+";path=/";  
}  
  
function DelCookie()  
{  
    DeleteCookie(document.getElementById("email").value);  
}  
function remember()  
{  
    if(document.getElementById("remember").checked){  
        SetCookie(document.getElementById("email").value,document.getElementById("password").value);  
        alert("Saved!");  
    }     
}  
function showpassword()  
{  
     var p=GetCookie(document.getElementById("email").value);  
     if(p!=null)  
    document.getElementById("password").value= p;  
}  
</script>  
 <!--SIGN UP-->
 <h1>Welcome to our websit!</h1>
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img src="images/avtar.png" />
	</div>
			<form action="CheckUserRightOrNot" method="post">
					<input type="text"  id="email" value="Email Address"  onblur="showpassword()" >
					<input type="password" id="password" value="Password">
			</form>
	<div class="signin">
		<button type="submit" onclick="remember()" value="Login" ></button>
	</div>								
		<script src="jquery.cookie.js" type="text/javascript"></script>
		<script> 

		</script>
</div>

</body>
</html>