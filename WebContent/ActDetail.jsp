<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page import="java.sql.*" %>

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





<html>
  <head>
     
    <title>插入信息</title>
     
 
  </head>
    <body>
    <% 
 
    request.setCharacterEncoding("gbk");
    Object ename= session.getAttribute("ename");
    ename = (String)ename;
    out.println(ename);
    String name = request.getParameter("name");
    out.println(name);
    String num = request.getParameter("num");
    out.println(num);
    String sum = request.getParameter("sum");
    out.println(sum);
    String type = request.getParameter("type");
    if(type.substring(0,1).equals("1"))
    {
    	type="Normal";
    	response.sendRedirect("normal.jsp");
    }
    if(type.substring(0,1).equals("2"))
	{
		type="Girls for free";
	    response.sendRedirect("Girls.jsp");
	}
    if(type.substring(0,1).equals("3"))
	{
		type="Leaving early pay more";
		response.sendRedirect("Leaving.jsp");
	}
    if(type.substring(0,1).equals("4"))
	{
		type="Other";
	}
    out.println(type);

    
    
    
    System.out.println(name);
    Connection conn = null; 
    Statement stat = null; 
    ResultSet rs = null;
    Class.forName("com.mysql.jdbc.Driver"); 
    String url = "jdbc:mysql://localhost:3306/draven"; 
    String user = "root"; 
    String password = "4217";
    try{
 
	conn = DriverManager.getConnection(url, user, password);
    stat = conn.createStatement(); 
    String IsVoteVary = "No";
    String IsCreaterVary = "Yes";
    String sql = "insert into activity(Owner,Act_name,Number,Sum,Type,IsVote,IsCreater) values('" + ename + "','" + name + "','" + num + "','" + sum + "','" + type+ "','"+ IsVoteVary+ "','" + IsCreaterVary+ "')";
    stat.executeUpdate(sql); 
    rs = stat.executeQuery("select * from activity"); }
 
catch(Exception e){} 
    
%>
    
   <center>
   <%
    try{
     
     
    if(rs.next())
    {
    out.println("<br><h3>成功输入！</h3>");
    }
    else{
    out.println("<br><h3>输入失败！</h3>");
    }
  }
  catch(Exception e){}
    %>
   
    
      <br>
    <a href=Mainpage.jsp>返回添加信息页面</a> 
    </center>
     <%
    if(rs != null)
    {
        rs.close();
        rs = null;
    }
        if(stat != null)
    {
        stat.close();
        stat = null;
    }
        if(conn != null)
    {
        conn.close();
        conn = null;
    }
    %>     
    <%  session.setAttribute("actname",name);  %>
      </body>
</html>



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
