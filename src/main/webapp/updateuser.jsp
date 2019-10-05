<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Change user data</h3>
	<form method="post">
		<input type="hidden" value="${user.email}" name="email" /> <label>Email</label><br>
		<input name="email" /><br>
		<br> <label>Password</label><br> <input name="password" /><br>
		<br> <input type="submit" value="Update" />
	</form>
</body>
</html>