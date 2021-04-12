<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/resources/css/addStudent_style.css">
<title>Student Details</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
</head>
<body>
	<h1>Student Details</h1>
	<form:form method="post" action="result" modelAttribute="student">
		<div>
		<table id="student">
		
			<tr>
				<td>Student ID:</td>
				<td><form:input type="number" name="id" path="id"/>
				<br><form:errors class="error" path="id"></form:errors></td>
			</tr>
			
			<tr>
				<td>Student Name:</td>
				<td><form:input type="text" name="name" path="name"/>
				<br><form:errors class="error" path="name"></form:errors></td>
			</tr>
			
			<tr>
				<td>Gender:</td>
				<td><input type="radio" id="gender" name="gender" value="male"/>
					<label for="gender">MALE</label></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="radio" id="gender" name="gender" value="female"/>
					<label for="gender">FEMALE</label></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="radio" id="gender" name="gender" value="other"/>
					<label for="gender">OTHER</label>
					<br><form:errors class="error" path="gender"></form:errors></td>
			</tr>
			
			<tr>
				<td>Student Age:</td>
				<td><form:input type="number" name="age" path="age"/>
				<br><form:errors class="error" path="age"></form:errors></td>
			</tr>
		
		</table>
		</div>
		
		<a href="${pageContext.request.contextPath }/"><button type="submit" id="submit" value="Submit">SUBMIT</button></a>
		
	</form:form>
</body>
</html>