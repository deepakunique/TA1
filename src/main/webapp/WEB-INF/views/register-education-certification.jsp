<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Education/ Certification Details	</title>
<link rel="stylesheet" href="<c:url value="/resources/css/AdminStyle.css"/>">
<link rel="stylesheet"
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>">
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a class = "btn btn-primary" href="${contextPath}" > Job Portal</a>

	<h2>Education/ Certification Details</h2>

	<form:form action="${contextPath}/register-education-certification.htm" commandName="educationDetail"
		method="post">
		 <form:hidden  path="userId"  />
		<table class="table">
			<tr>
				<td>Institution name with city:</td>
				<td><form:input path="institution" size="30" required="required" />
					<font color="red"><form:errors path="institution" /></font></td>
			</tr>

			<tr>
				<td>Degree Type:</td>
				<td> <select name="degreeType">
            		<option value="Secondary">Secondary</option>
            		<option value="Higher Secondary">Higher Secondary</option>
            		<option value="Diploma">Diploma</option>
            		<option value="Graduation">Graduation</option>
            		<option value="Advance Diploma">Advance Diploma</option>
            		<option value="Post Graduation">Post Graduation</option>
            		<option value="Doctor/Phd">Doctor/Phd</option>
            		<option value="Certification">DiCertificationploma</option>
            		<option value="Other">Other</option>
            		
            		</select>
           	 	</td>
			</tr>
			
			<tr>
				<td>Degree Name:</td>
				<td><form:input path="degreeName" size="30" required="required" />
					<font color="red"><form:errors path="degreeName" /></font></td>
			</tr>
			
			<tr>
				<td>Start Date:</td>
				<td><form:input path="startMonth" size="30" required="required" />
					<font color="red"><form:errors path="startMonth" /></font></td>
			</tr>
			
			<tr>
				<td>End Date (Optional):</td>
				<td><form:input path="endMonth" size="30" required="required" />
					<font color="red"><form:errors path="endMonth" /></font></td>
			</tr>
			
			<tr>
				<td>Association:</td>
				<td> <select name="association">
            		<option value="Full Time">Full Time</option>
            		<option value="Part Time">Part Time</option>
            		<option value="Corespondance / Distance Learning">Correspondance / Distance Learning</option>
            		</select>
           	 	</td>
			</tr>
			
			<tr>
				<td>Speciality (Optional):</td>
				<td><form:input path="speciality" size="30" required="required" />
					<font color="red"><form:errors path="speciality" /></font></td>
			</tr>
			
			<tr>
				<td>Score (Optional):</td>
				<td><form:input path="score" size="30" required="required" />
					<font color="red"><form:errors path="score" /></font></td>
			</tr>
			
			<tr>
				<td colspan="2"><input class = "btn btn-success" type="submit" value="Next" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>