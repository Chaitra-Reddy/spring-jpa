<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Activity</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
</head>
<body>
	<h1>Activity Details</h1>
	
	<form:form method="post" action="after-add" modelAttribute="activity">
		<div>
		<table>
		
			<tr>
				<td>Activity Name</td>
				<td><form:input type="text" name="name" path="name"/></td>
			</tr>
		
		</table>
		</div>
		
		<a href="localhost:8080/"><button type="submit" id="submitButton" value="Submit">SUBMIT</button></a>
		
	</form:form>
</body>
</html>