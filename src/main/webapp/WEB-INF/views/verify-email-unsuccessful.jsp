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

	<h2>Email Verification Failed!</h2>

	

		<table class="table">
		
			<tr>
			
			
			Email verification failed. Please try again.
			</tr>
		
			
		</table>


</body>
</html>