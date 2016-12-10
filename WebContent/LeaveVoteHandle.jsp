<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LeaveVoteHandle</title>
</head>
<body>


<form name="form1" id="ff1" method="post" action="LeaveVoteHandle">
<input type="text" class="form-control" placeholder="Sum Money:" name="Sum_money" id="Sum_money" required>
<input type="text" class="form-control" placeholder="Leave Pay More Percentage:" name="payMorePercentage" id="payMorePercentage" required>
<button type="submit" class="btn btn-1" name="Submit" id="Creat">Submit</button>
</form>


</body>
</html>