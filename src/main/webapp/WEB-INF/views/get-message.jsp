<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.me.JobPortal.pojo.User1" %>
<!DOCTYPE html>
<html>
<head>
<title>Email Verification	</title>
<link rel="stylesheet" href="<c:url value="/resources/css/AdminStyle.css"/>">
<link rel="stylesheet"
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>">
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a class = "btn btn-primary" href="${contextPath}" > Job Portal</a>

	<h2>Messages for  !</h2>
	
	<table>
	<c:forEach items="${conversationWrapper.messageList}" var="msg">
		 <tr>
		<td>${msg.message}</td>
		<td>${msg.createdAt}</td>
		</tr>
	</c:forEach>
	</table>
	<form:form action="${contextPath}/chat-message.htm" method="POST" commandName="conversation">
		<form:hidden  path="jobPostId"  />
		<form:hidden  path="fromId"  />
		<form:hidden  path="toId"  />
		
		<label >Message:</label>
		<textarea id="message" name="message" rows="4" cols="500" path=message></textarea>
  		<br><br>
  		<input type="submit" value="Send">
	</form:form>



	

</body>
</html>