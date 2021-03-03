<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View All Jobs</title>
<link rel="stylesheet" href="<c:url value="/resources/css/AdminStyle1.css"/>">
<link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>">
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="joblist" value="${jobs}" />

<a class = "btn btn-success" href="${contextPath}/user/login.htm" >Login And Start Applying</a>



<table class="table-condensed" border="1">

<tr>



</tr>
<c:forEach items="${joblist}" var="job">
<br>
<tr>
${job.description} <br>
${job.subjectTemp} &emsp
 ${job.budget}  &bsp  &emsp
 ${job.budgetCurency}  &emsp


</c:forEach>
</table> 
</body>
</html>