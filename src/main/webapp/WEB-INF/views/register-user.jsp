<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add User Form</title>
<link rel="stylesheet" href="<c:url value="/resources/css/AdminStyle.css"/>">
<link rel="stylesheet"
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>">
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a class = "btn btn-primary" href="${contextPath}" > Job Portal</a>

	<h2>Register a New User</h2>

	<form:form action="${contextPath}/register.htm" commandName="user"
		method="post">

		<table class="table">
			<tr>
				<td>Name:</td>
				<td><form:input path="name" size="30" required="required" />
					<font color="red"><form:errors path="name" /></font></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><form:input path="email" size="30" required="required" />
					<font color="red"><form:errors path="email" /></font></td>
			</tr>


			<tr>
				<td>Phone No (Please enter with country code):</td>
				<td><form:input path="phoneNo" size="30" required="required" />
					<font color="red"><form:errors path="phoneNo" /></font></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:password path="password" size="30"
						required="required" /> <font color="red"><form:errors
							path="password" /></font></td>
			</tr>
			
			<tr>
				<td>Confirm Password:</td>
				<td><form:password path="password" size="30"
						required="required" /> <font color="red"><form:errors
							path="password" /></font></td>
			</tr>
			

			<tr>
				<td>Role :</td>
				<td> <select name="role">
		            <option value="TEACHER">Teacher</option>
		            <option value="STUDENT">Student/Parent</option>
	            </select>
	            </td>
			</tr>
			
			<tr>
				<td colspan="2"><input class = "btn btn-success" type="submit" value="Register" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>