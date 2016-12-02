<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>AllParticipants</title>
      <style type="text/css">
body {
	background-image: url(images/340362-106.jpg);
}
</style>
</head>
<body>
<li><a href="LoginAndRegistration.jsp" class="current">Return to the page of login and registration.</a></li>
<center>

<table width="200" border="1">
  <tr>
    <th scope="col">userName</th>
    <th scope="col">userEmail</th>
    <th scope="col">userSex</th>
    <th scope="col">IsCreater</th>
  </tr>
  
  <s:iterator value="Participants" id="Participant" status="ss">
  <tr>
    <td><s:property value="#Participant.userName"/></td>
    <td><s:property value="#Participant.userEmail"/></td>
    <td><s:property value="#Participant.userSex"/></td>
    <td><s:property value="#Participant.IsCreater"/></td>
  </tr>
  </s:iterator>

</table>



</center>
</body>
</html>