<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/validate.js"></script>

<title>Spring Boot</title>
</head>
<body>
  <h1>LOGIN APPLICATION</h1>
  <hr>

  <div class="form">
    <form action="logincheck" method="post" onsubmit="return validate()">
      <div>
          <label for="name">Enter Username:</label><input id="name" name="name"><br><br>
      </div>
      <div>
          <label>Enter Password:</label><input id="password" name="password"><br><br>
      </div>
      <div>
          <input type="submit" id="submit">
      </div>
    </form>
  </div>

</body>
</html>