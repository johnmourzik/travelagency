<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
body {
	background: url(font_index2.jpg);
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
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="active"><a href="index.html">Главная</a></li>
			<li><a href="alltours">Наши туры</a></li>
			<li><a href="loginsystem.jsp">Личный кабинет</a></li>
			<li><a href="contacts.html">Контакты</a></li>
		</ul>
	</div>
	</nav>
	<h2>Панель администратора</h2>
	<div align="center">
		<a href="logout.jsp">Logout</a>
	</div>
	<p><a href='<c:url value="/newtour" />'>Создать новый тур</a></p>
	<p><a href='<c:url value="/allorders" />'>Все заказы</a></p>
	<table class="myTable" align="center">
		<tr>
			<th>Наименование тура</th>
			<th>Страна</th>
			<th>Описание</th>
			<th>Дата начала</th>
			<th>Стоимость</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="tour" items="${tours}">
			<tr>
				<td id='tourname'>${tour.tourName}</td>
				<td id='country'>${tour.country}</td>
				<td id='tourdesc'>${tour.tourDesc}</td>
				<td id='startdate'>${tour.startDate}</td>
				<td id='price'>${tour.price}</td>
				<td><a
					href='<c:url value="/updatetour?tourCode=${tour.tourCode}" />'>
					Обновить тур</a></td>
				<td><form method="post" action='<c:url value="/deletetour" />'
						style="display: inline;">
						<input type="hidden" name="tourCode" value="${tour.tourCode}">
						<input type="submit" value="Удалить тур">
					</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>