<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SCVACTD</title>
</head>
<body>	       		
	       		
	       		
<table width="200" border="1">
  <tr>
  	<th scope="col">Act_name</th>
    <th scope="col">UserName</th>
    <th scope="col">UserEmail</th>
    <th scope="col">UserSex</th>
    <th scope="col">LeaveEarly</th>
    <th scope="col">PayMorePercentage</th>
    <th scope="col">MoneyShouldPay</th>
    <th scope="col">Sum</th>
    <th scope="col">Type</th>
    <th scope="col">IsCreater</th>
    <th scope="col">VoteResult</th>
  </tr>
  
  <s:iterator value="VoteParticipants" id="VoteParticipant" status="ss">
  <tr>
  	<td><s:property value="ActivityDetail.Act_name"/></td>
    <td><s:property value="#VoteParticipant.userName"/></td>
    <td><s:property value="#VoteParticipant.userEmail"/></td>
    <td><s:property value="#VoteParticipant.userSex"/></td>
    <td><s:property value="#VoteParticipant.leaveEarly"/></td>
    <td><s:property value="#VoteParticipant.payMorePercentage"/></td>
    <td><s:property value="#VoteParticipant.moneyShouldPay"/></td>
    <td><s:property value="#VoteParticipant.Sum"/></td>
    <td><s:property value="#VoteParticipant.Type"/></td>
    <td><s:property value="#VoteParticipant.IsCreater"/></td>
    <td><s:property value="#VoteParticipant.VoteResult"/></td>
  </tr>
  </s:iterator>

</table>





</body>
</html>