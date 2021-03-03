<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Subjects/Skills	</title>
<link rel="stylesheet" href="<c:url value="/resources/css/AdminStyle.css"/>">
<link rel="stylesheet"
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>">
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a class = "btn btn-primary" href="${contextPath}" > Job Portal</a>

	<h2>Subjects You Teach</h2>
	
		<table class="table">
		
			<tr>
				<td>Subject</td>
				<td>Teach Up to: </td>	
			</tr>
			
			<c:forEach items="${subjectWrapper.subjectList}" var="sb">

<%-- <form:form action="${contextPath}/jobs/add.htm" commandName="subjectWrapper"
		method="post">
 --%>
 
 <tr>
<td>${sb.subjectName}</td>
<td>${sb.subjectLevel}</td>
</tr>
<%-- </form:form> --%>
</c:forEach>
		</table>

	<form:form action="${contextPath}/register-subjects-skills.htm" commandName="subjectDetail"
		method="post">

 <form:hidden  path="userId"  />
 
		<table class="table">
			<tr>
				<td>Subject:</td>
				<!-- <td><input id="pinCountryCode" size="30" required="required" /> -->
			 <td><form:input path="subjectId" size="30" required="required" />
					<font color="red"><form:errors path="subjectId" /></font></td> 
								</tr>

			<tr>
				<td>Up to Level:</td>
				<td> <select name="level">
            		<option value="Beginner">Beginner</option>
            		<option value="Intermediate">Intermediate</option>
            		<option value="Expert">Expert</option>
            		</select>
           	 	</td>
			</tr>
			<tr>
				<td colspan="2"><input class = "btn btn-success" type="submit" value="Add Subject" /></td>
			</tr>
		</table>

	</form:form>
	<form:form action="${contextPath}/register-education-certification.htm" method="GET">
	
		<tr>
				<td colspan="2"><input class = "btn btn-success" type="submit" value="Next" /></td>
			</tr>
			
		</form:form>


</body>
</html>