<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<form action="loginUser" method= "POST">
			Username:<input type="text" required="required" name="username">
			Password:<input type="password" required="required" name="password">
			<input type="submit" value="login">
		</form>
	</body>
</html>