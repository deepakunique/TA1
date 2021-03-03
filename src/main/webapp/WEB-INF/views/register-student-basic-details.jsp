<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Basic Details</title>
<link rel="stylesheet" href="<c:url value="/resources/css/AdminStyle.css"/>">
<link rel="stylesheet"
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>">
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a class = "btn btn-primary" href="${contextPath}" > Job Portal</a>

	<h2>Basic Details</h2>

	<form:form action="${contextPath}/register-student-basic-details.htm" commandName="user"
		method="post">
		<form:hidden  path="userId"  />
		<table class="table">
			<tr>
				<td>I am:</td>
				<td> <select name="userType">
            		<option value="Student">Student</option>
            		<option value="Parent">Parent/Guardian</option>
            		<option value="Professional">Professional</option>
            		<option value="Company">Company/Mediator</option>
            		</select>
           	 	</td>
			</tr>
			
			<tr>
				<td>Gender :</td>
				<td> <select name="gender">
            		<option value="Male">Male</option>
            		<option value="Female">Female</option>
            		<option value="Transgender">Transgender</option>
            		</select>
           	 	</td>
			</tr>
			
			<tr>
				<td>Date of Birth:</td>
				<td><form:input path="dob" size="100" required="required" />
					<font color="red"><form:errors path="dob" /></font></td>
			</tr>
			
			
			<tr>
				<td>Location:</td>
				<td><form:input path="locality" size="100" required="required" />
					<font color="red"><form:errors path="locality" /></font></td>
			</tr>
			
			<tr>
				<td colspan="2"><input class = "btn btn-success" type="submit" value="Save and Next" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>