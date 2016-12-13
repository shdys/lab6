<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DravenTest4</title>
</head>
<body>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = "jdbc:mysql://localhost:3306/aa_dutch";
String qstr="select * from activity";
String ename = request.getParameter("userEmail");  
if (ename==null)
{
    request.setCharacterEncoding("gbk");
    Object ename1= request.getSession().getAttribute("ename");
    ename = (String)ename1;
}
session.setAttribute("ename",ename);
%>


<!-- 
<form name="form1" id="ff1" method="post" action="AllSelfCreateActivity">
<input type="text" class="form-control" placeholder="Email Address :" name="userEmail" id="userEmail" required>
<button type="submit" class="btn btn-1" name="Submit" id="Creat">Submit</button>
</form> -->

<s:action name="AllSelfCreateActivity" executeResult="true"></s:action>
























</body>
</html>