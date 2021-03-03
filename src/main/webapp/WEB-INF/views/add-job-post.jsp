<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Request a tutor</title>
<link rel="stylesheet" href="<c:url value="/resources/css/AdminStyle.css"/>">
<link rel="stylesheet"
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>">
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a class = "btn btn-primary" href="${contextPath}" > Job Portal</a>

	<h2>Request a tutor</h2>

	<form:form action="${contextPath}/add-job-post.htm" commandName="jobPost"
		method="post">
	<form:hidden  path="userId"  />
	<form:hidden  path="userName"  />
		<table class="table">
		
			<tr>
				<td>Location:</td>
				<td><form:input path="tutorCount" size="100" required="required" />
					<font color="red"><form:errors path="tutorCount" /></font></td>
			</tr>
			
			<tr>
				<td>Phone no (Please include the country code as well):</td>
				<td><form:input path="phone" size="50" required="required" />
					<font color="red"><form:errors path="phone" /></font></td>
			</tr>
			
			<tr>
				<td>Details of your requirement:</td>
				<td><form:input path="description" size="1000" required="required" />
					<font color="red"><form:errors path="description" /></font></td>
			</tr>
			
			<tr>
				<td>Subjects:</td>
				<td><form:input path="subjectTemp" size="50" required="required" />
					<font color="red"><form:errors path="subjectTemp" /></font></td>
			</tr>	
			
			<tr>
				<td>Level:</td>
				<td> <select name="level">
            		<option value="Beginner">Beginner</option>
            		<option value="Intermediate">Intermediate</option>
            		<option value="Expert">Expert</option>
            		</select>
           	 	</td>
			</tr>
			
			
			<tr>
			
			
				<td>I want:</td>
				<td> <select name="helpType">
            		<option value="Tutoring">Tutoring help</option>
            		<option value="Assignment">Assignment</option>
            		</select>
           	 	</td>
			</tr>

			<tr>
				<td>Meeting options:</td>
				<td> <select name=visibility>
            		<option value="Online">Online</option>
            		<option value="Offline">Offline</option>
            		</select>
           	 	</td>
			</tr>

			<tr>
				<td>Budget:</td>
				<td><form:input path="budget" size="50" required="required" />
					<font color="red"><form:errors path="budget" /></font></td>
				<td><form:input path="budgetCurency" size="50" required="required" />
					<font color="red"><form:errors path="budgetCurency" /></font></td>
					
			</tr>
			
			
			<tr>
				<td>Payment Frequency :</td>
				<td> <select name="frequency">
            		<option value="Fixed">Fixed</option>
            		<option value="Per Hour">Per Hour</option>
            		<option value="Per Week">Per Week</option>
            		<option value="Per Month">Per Month</option>
            		<option value="Per Year">Per Year</option>
            		</select>
           	 	</td>
			</tr>
			
			<tr>
				<td>Gender Preference :</td>
				<td> <select name="genderPreference">
            		<option value="None">None</option>
            		<option value="Preferably Male">Preferably Male</option>
            		<option value="Preferably Female">Preferably Female</option>
            		<option value="Only Male">Only Male</option>
            		<option value="Only Female">Only Female</option>
            		</select>
           	 	</td>
			</tr>

			<tr>
				<td colspan="2"><input class = "btn btn-success" type="submit" value="Post" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>