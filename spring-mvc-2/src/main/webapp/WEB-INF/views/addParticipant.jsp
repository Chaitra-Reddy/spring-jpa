<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Participant</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
	<h1>Participant Details</h1>

	<form:form method="post" action="after-add-part"
		modelAttribute="participant">
		<div>
			<table>

				<tr>
					<td>Participant Name</td>
					<td><form:input type="text" name="name" path="name" /></td>
				</tr>

				<tr>
					<td>Participant Age:</td>
					<td><form:input type="number" name="age" path="age" /></td>
				</tr>

				<tr>
					<td>Activity ID:</td>
					<td><form:select path="activity">
							<c:forEach var="val" items="${activities}">
								<form:option value="${val}" label="${val.id}" />
							</c:forEach>
						</form:select></td>
				</tr>

			</table>
		</div>

		<a href="localhost:8080/"><button type="submit" id="submitButton"
				value="Submit" onclick="myFunction()">SUBMIT</button></a>
		<script>
			function myFunction() {
				var id = ${id};
			    alert("Participant ID: " + id);
			}
		</script>
	</form:form>
</body>
</html>