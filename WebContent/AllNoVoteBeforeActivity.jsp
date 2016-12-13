<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>AllNoVoteBeforeActivity</title>
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
    <th scope="col">Creater</th>
    <th scope="col">Activity Name</th>
    <th scope="col">Number Of People</th>
    <th scope="col">Sum Money</th>
    <th scope="col">Pay Type</th>
    <th scope="col">Modify</th>
    
  </tr>
  
  <s:iterator value="AllNoVoteBeforeActivitys" id="AllNoVoteBeforeActivity" status="ss">
  <tr>
    <td><s:property value="#AllNoVoteBeforeActivity.Owner"/></td>
    <td><s:property value="#AllNoVoteBeforeActivity.Act_name"/></td>
    <td><s:property value="#AllNoVoteBeforeActivity.Number"/></td>
    <td><s:property value="#AllNoVoteBeforeActivity.Sum"/></td>
    <td><s:property value="#AllNoVoteBeforeActivity.Type"/></td>
    <td><a href='<s:url action="NoVoteBeforeModify"><s:param name="Type" value="#AllNoVoteBeforeActivity.Type"/></s:url>'>Modify</a></td>
    
  </tr>
  </s:iterator>
  


</table>





</center>
</body>
</html>