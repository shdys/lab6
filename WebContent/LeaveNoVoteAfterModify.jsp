<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LeaveAfter</title>
</head>
<body>

<form name="form1" id="ff1" method="post" action="NormalAfterCalculate" >				
<input type="text" placeholder="Sum Price:" name="SumPrice" id="SumPrice" required>
<input type="text" placeholder="Sum People Number:" name="SumPeopleNumber" id="SumPeopleNumber" required>
<input type="text" placeholder="Sum Leaving People Number:" name="SumLeavingPeopleNumber" id="SumLeavingPeopleNumber" required>
<input type="text" placeholder="Pay More Percentage:" name="PayMorePercentage" id="PayMorePercentage" required>
<button type="submit" name="submit" id="submit">Submit</button>
</form>


</body>
</html>