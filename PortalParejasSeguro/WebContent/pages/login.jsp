<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="../j_spring_security_check" method="POST">
		<input type="text" name="j_username" />
		<input type="password" name="j_password" />
		<input name="submit" type="submit" value="Login" />
		<input type="checkbox" name="_spring_security_remember_me" />
	</form>
</body>
</html>