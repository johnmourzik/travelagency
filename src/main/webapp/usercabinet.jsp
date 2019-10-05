<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not (.active ) {
	background-color: #111;
}

.active {
	background-color: #4CAF50;
}
</style>
<style>
.myTable {
	border-collapse: separate;
}

.myTable th {
	background-color: #000080;
	color: white;
}

.myTable td, .myTable th {
	padding: 5px;
	border: 3px solid #ffa500;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Наши туры</title>
<style>
body {
	background: url(font_index2.jpg);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
	<h1 align="justify">
		<img src="logo_index.jpg" alt="logo" width="100" height="100" />
		Туристическое агентство Амур-Тур
	</h1>
	</header>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="active"><a href="index.html">Главная</a></li>
			<li><a href="alltours">Наши туры</a></li>
			<li><a href="usercabinet.jsp">Личный кабинет</a></li>
			<li><a href="contacts.html">Контакты</a></li>
		</ul>
	</div>
	</nav>
	<h2 align="center">Добро пожаловать в Ваш личный кабинет!</h2>

	<div align="center">
		<a href="logout.jsp">Logout</a>
	</div>
	<p align="center">
		<a href='<c:url value="/neworder" />'>New order</a>
	</p>
	<table class="myTable" align="center">
		<tr>
			<th>email</th>
			<th>Password</th>
			<th></th>
		</tr>
		<tr>
			<td align="center">${userData.email}</td>
			<td align="center">${userData.password}</td>
			<td><a
				href='<c:url value="/updateuser?email=${userData.email}" />'>Change
					my data</a></td>
		</tr>
	</table>
	<p align="center">
		<a href='<c:url value="/deleteuser" />'>Delete my account</a>
	</p>
</body>
</html>