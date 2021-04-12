<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/index_style.css"> 
<title>Home Page</title>
</head>
<body>
	<h1>Welcome to Student App</h1>
	<div class="dataTable" id="tab">
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Age</th>
		</tr>
		<c:forEach items="${students}" var="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.name}</td>
				<td>${s.gender}</td>
				<td>${s.age}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div>
		<a href="add-student"><button>Add Student</button></a>
	</div>
</body>
</html>