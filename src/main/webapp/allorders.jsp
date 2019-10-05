<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

li a:hover:not(.active){
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
	border-collapse:separate; 
}
.myTable th { 
	background-color:#000080;
color:white; 
}
.myTable td, .myTable th { 
	padding:5px;
	border:3px solid #ffa500; 
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
	<h2 align="center">Все заказы</h2>
	<table class="myTable" align="center">
		<tr>
			<th>Код заказа</th>
			<th>Код клиента</th>
			<th>Код тура</th>
			<th>Код отеля</th>
			<th>Дата заказа</th>
			<th></th>
		</tr>
		<c:forEach var="order" items="${orders}">
			<tr>
				<td align="center">${order.orderCode}</td>
				<td align="center">${order.userCode}</td>
				<td align="center">${order.tourCode}</td>
				<td align="center">${order.hotelCode}</td>
				<td align="center">${order.orderDate}</td>
				<td align="center">
					<form method="post" action='<c:url value="/deleteorder" />'
						style="display: inline;">
						<input type="hidden" name="orderCode" value="${order.orderCode}">
						<input type="submit" value="Delete order">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>