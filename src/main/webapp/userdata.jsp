<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr align="center">
			<th>User code</th>
			<th>User name</th>
			<th>User Surname</th>
			<th>Birthday</th>
			<th>email</th>
			<th>Password</th>
			<th></th>
		</tr>

		<tr align="center">
			<td>${user.userCode}</td>
			<td>${user.userName}</td>
			<td>${user.userSurname}</td>
			<td>${user.birthday}</td>
			<td>${user.email}</td>
			<td>${user.password}</td>
			<td><a href='<c:url value="/updateuser?email=${user.email}" />'>Change
					my data</a></td>
		</tr>
	</table>
</body>
</html>