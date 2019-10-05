<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<%@ page isELIgnored="false"%>
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
	background-color:#111;
}

.active {
	background-color: #4CAF50;
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
<title>Наши туры</title>
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
	<div align="right">
		<form>
			<a href="loginsystem.jsp">Вход</a> <a href="/travelagency/newuser">Регистрация</a>
		</form>
	</div>
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
	<h2 align="justify">Наши туры</h2>
	<table class="myTable">
		<tr>
			<th>Название тура</th>
			<th>Страна</th>
			<th>Описание</th>
			<th>Дата начала</th>
			<th>Стоимость</th>
			<th></th>
		</tr>
		<mytag:ourtours coll="${tour}" />
	</table>
</body>
</html>