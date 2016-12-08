<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DravenTest1</title>
      <style type="text/css">
body {
	background-image: url(images/340362-106.jpg);
}
</style>
</head>
<body>
<li><a href="LoginAndRegistration.jsp" class="current">Return to the page of login and registration.</a></li>
<center>


<form name="form1" id="ff1" method="post" action="CreatVoteActivityName">
<input type="text" class="form-control" placeholder="Email Address :" name="userEmail" id="userEmail" required>
<input type="text" class="form-control" placeholder="Vote Activity Name :" name="voteActivityName" id="voteActivityName" required>
<select name="BeforeOrAfter" id="BeforeOrAfter">
							<option value="Before">Before</option>
							<option value="After">After</option>
</select>
<button type="submit" class="btn btn-1" name="Create" id="Create">Create</button>
</form>











创建投票活动














</center>
</body>
</html>