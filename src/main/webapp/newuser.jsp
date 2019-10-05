<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
			<li><a href="loginsystem.jsp">Личный кабинет</a></li>
			<li><a href="contacts.html">Контакты</a></li>
		</ul>
	</div>
	</nav>
	<h3 align="center">Введите Ваши данные</h3>
	<div align="center">
		<form method="post">
			<div class="name_validation_block">
				<label>Имя</label>
			</div>
			<input id="name" name="userName" /><br> <br>
			<div class="surname_validation_block">
				<label>Фамилия</label>
			</div>
			<input id="surname" name="userSurname" /><br> <br>
			<div class="birthday_validation_block">
				<label>Дата рождения</label>
			</div>
			<input id="birthday" name="birthday" /><br> <br>
			<div class="email_validation_block">
				<label>Емайл</label>
			</div>
			<input id="email" name="email" /><br> <br>
			<div class="password_validation_block">
				<label>Пароль</label>
			</div>
			<input id="password" name="password" /><br> <br> <input
				type="submit" value="Save" />
		</form>
	</div>
	<script type="text/javascript">
	var nameInput = document.querySelector("#name");
	var surnameInput = document.querySelector("#surname");
	var birthdayInput = document.querySelector("#birthday");
	var today = new Date().getFullYear()+'-'+("0"+(new Date().getMonth()+1)).slice(-2)+'-'+("0"+new Date().getDate()).slice(-2);
	var emailInput = document.querySelector("#email");
	var passwordInput = document.querySelector("#password");
	var nameValidationBlock = document.querySelector(".name_validation_block");
	var surnameValidationBlock = document.querySelector(".surname_validation_block");
	var birthdayValidationBlock = document.querySelector(".birthday_validation_block");
	var emailValidationBlock = document.querySelector(".email_validation_block");
	var passwordValidationBlock = document.querySelector(".password_validation_block");
	
	nameInput.addEventListener("input", function(){
		if(nameInput.value.length < 2){
			nameValidationBlock.style.display="block";
			nameValidationBlock.innerHTML = "Имя не менее 2 символов!"	
		} else {
			nameValidationBlock.style.display="none";
		}
	});
	surnameInput.addEventListener("input", function(){
		if(surnameInput.value.length < 2){
			surnameValidationBlock.style.display="block";
			surnameValidationBlock.innerHTML = "Фамилия не менее 2 символов!"	
		} else {
			surnameValidationBlock.style.display="none";
		}
	});
	birthdayInput.addEventListener("input", function(){
		if(birthdayInput.value > today){
			birthdayValidationBlock.style.display="block";
			birthdayValidationBlock.innerHTML = "Ошибка ввода даты! Будущий день!"	
		} else {
			birthdayValidationBlock.style.display="none";
		}
	});
	emailInput.addEventListener("input", function(){
		if(emailInput.value.indexOf("@") < 0){
			emailValidationBlock.style.display="block";
			emailValidationBlock.innerHTML = "Введите корректный емайл!"	
		} else {
			emailValidationBlock.style.display="none";
		}
	});
	passwordInput.addEventListener("input", function(){
		if(passwordInput.value.length <= 1){
			passwordValidationBlock.style.display="block";
			passwordValidationBlock.innerHTML = "Пароль не меньше 1 символа!"	
		} else {
			passwordValidationBlock.style.display="none";
		}
	});
</script>
</body>
</html>