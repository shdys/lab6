<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result of Girls For Free</title>
</head>
<body>
    people:<s:property value="act.Number"/><br>
    total money:<s:property value="act.Sum"/><br>
    average payment for men:<s:property value="g.average"/><br>
	payment for female:<s:property value="g.girls"/><br>
</body>
</html>