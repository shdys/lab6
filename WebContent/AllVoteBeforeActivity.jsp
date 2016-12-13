<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>AllVoteBeforeActivity</title>
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
  
  <s:iterator value="AllVoteBeforeActivitys" id="AllVoteBeforeActivity" status="ss">
  <tr>
    <td><s:property value="#AllVoteBeforeActivity.Owner"/></td>
    <td><s:property value="#AllVoteBeforeActivity.Act_name"/></td>
    <td><s:property value="#AllVoteBeforeActivity.Number"/></td>
    <td><s:property value="#AllVoteBeforeActivity.Sum"/></td>
    <td><s:property value="#AllVoteBeforeActivity.Type"/></td>
    <td><a href='<s:url action="VoteBeforeModify"><s:param name="Type" value="#AllVoteBeforeActivity.Type"/></s:url>'>Modify</a></td>
    
  </tr>
  </s:iterator>
  


</table>





</center>
</body>
</html>