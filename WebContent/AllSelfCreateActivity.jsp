<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>AllSelfCreateActivity</title>
</head>
<body>

<center>


<s:iterator value="AllSelfCreateActivitys" id="AllSelfCreateActivity" status="ss">        	
	<s:property value="#AllSelfCreateActivity.Act_name"/><a href='<s:url action="AllSelfCreateActivityDetail"><s:param name="Act_name" value="#AllSelfCreateActivity.Act_name"/></s:url>'>Detail</a><br>
</s:iterator>


</center>


</body>
</html>