<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<h1>Error!!</h1>
	<br>
	<br>
	<h3>Error Time --> ${error.timestamp}</h3>
	<h3>Error Message --> ${error.msg}</h3>
	<h3>Error Details --> ${error.details}</h3>
	<a href="/"><button>HOME</button></a>
</body>
</html>