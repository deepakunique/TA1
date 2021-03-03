<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Teaching Details	</title>
<link rel="stylesheet" href="<c:url value="/resources/css/AdminStyle.css"/>">
<link rel="stylesheet"
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>">
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a class = "btn btn-primary" href="${contextPath}" > Job Portal</a>

	<h2>Teaching Details</h2>

	<form:form action="${contextPath}/register-teaching-details.htm" commandName="user"
		method="post">
		 <form:hidden  path="userId"  />
		<table class="table">
			<tr>
				<td>I Charge:</td>
				<td> <select name="frequency">
            		<option value="Hourly">Hourly</option>
            		<option value="Daily">Daily</option>
            		<option value="Monthly">Monthly</option>
            		</select>
           	 	</td>
			</tr>

			<tr>
				<td>Minimum fee:</td>
				<td><form:input path="minimumFee" size="30" required="required" />
					<font color="red"><form:errors path="minimumFee" /></font></td>
			</tr>
			
			<tr>
				<td>Maximum fee:</td>
				<td><form:input path="maximumFee" size="30" required="required" />
					<font color="red"><form:errors path="maximumFee" /></font></td>
			</tr>
			
			<tr>
				<td>Fee Details (Optional):</td>
				<td><form:input path="feeDescription" size="30"  />
					<font color="red"><form:errors path="feeDescription" /></font></td>
			</tr>
			
			<tr>
				<td>Total experience:</td>
				<td><form:input path="totalExp" size="30" required="required" />
					<font color="red"><form:errors path="totalExp" /></font></td>
			</tr>
			
			<tr>
				<td>Teaching experience:</td>
				<td><form:input path="teachingExp" size="30" required="required" />
					<font color="red"><form:errors path="teachingExp" /></font></td>
			</tr>
			
			<tr>
				<td>Online teaching experience:</td>
				<td><form:input path="onlineTeachingExp" size="30" required="required" />
					<font color="red"><form:errors path="onlineTeachingExp" /></font></td>
			</tr>
			
			<tr>
				<td>Are you willing to travel to student:</td>
				<td>
					<input type="radio" id="true" name="travel" value="true"> Yes
				 	<input type="radio" id="false" name="travel" value="false"> No
  				</td>
			</tr>
			
			<tr>
				<td>Available for online teaching:</td>
				<td>
					<input type="radio" id="true" name="onlineTeaching" value="true"> Yes
				 	<input type="radio" id="false" name="onlineTeaching" value="false"> No
  				</td>
			</tr>
			
			<tr>
				<td>Do you have digital Pen:</td>
				<td>
					<input type="radio" id="true" name="digitalPen" value="true"> Yes
				 	<input type="radio" id="false" name="digitalPen" value="false"> No
  				</td>
			</tr>
			
			<tr>
				<td>Do you help with homework and assignments:</td>
				<td>
					<input type="radio" id="true" name="homeworkHelp" value="true"> Yes
				 	<input type="radio" id="false" name="homeworkHelp" value="false"> No
  				</td>
			</tr>
			
			<tr>
				<td>Are you currently a full time teacher employed by a School/College:</td>
				<td>
					<input type="radio" id="true" name="employed" value="true"> Yes
				 	<input type="radio" id="false" name="employed" value="false"> No
  				</td>
			</tr>
			
			<tr>
				<td>Opportunity:</td>
				<td> <select name="oppertunities">
            		<option value="Full Time">Full Time</option>
            		<option value="Part Time">Part Time</option>
            		<option value="Both">Both (Full Time and Part Time)</option>
            		</select>
           	 	</td>
			</tr>
			
			<tr>
				<td colspan="2"><input class = "btn btn-success" type="submit" value="Save" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>