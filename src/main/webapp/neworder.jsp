<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background: url(font_index2.jpg);
}
</style>
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
			<li><a href="loginsystem.jsp">Личный кабинет</a></li>
			<li><a href="contacts.html">Контакты</a></li>
		</ul>
	</div>
	</nav>
	<div align="center">
		<h3>Новый заказ</h3>
		<form method="post">
			<label>Код юзера</label><br> <input name="userCode" /><br>
			<br> <label>Код тура</label><br> <input name="tourCode" /><br>
			<br> <label>Код отеля</label><br> <input name="hotelCode" /><br>
			<br> <label>Дата заказа</label><br> <input name="orderDate" /><br>
			<br> <input type="submit" value="Сохранить заказ" />
		</form>
	</div>
</body>
</html>