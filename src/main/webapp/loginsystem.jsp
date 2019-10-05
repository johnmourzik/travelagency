<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/login.js"></script>
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

li a:hover:not (.active ){
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
<title>Login System</title>
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
			<li><a href="#">Наши туры</a></li>
			<li><a href="#">Личный кабинет</a></li>
			<li><a href="contacts.html">Контакты</a></li>
		</ul>
	</div>

	</nav>
	<br></br>
	<div align="center">Введите Ваш емайл и пароль</div>
	<%
		String email = (String) session.getAttribute("email");

		//redirect user to home page if already logged in
		if (email != null) {
			response.sendRedirect("home.jsp");
		}

		String status = request.getParameter("status");

		if (status != null) {
			if (status.equals("false")) {
				out.print("Incorrect login details!");
			} else {
				out.print("Some error occurred!");
			}
		}
	%>
	<div align="center">
		<form action="loginRequestHandler.jsp">
			<table cellpadding="5">
				<tr>
					<td><b>Email:</b></td>
					<td><input id="email" type="text" name="email" required /></td>
				</tr>
				<tr>
					<td><b>Password:</b></td>
					<td><input id="password" type="password" name="password"
						required /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login" /></td>
				</tr>
			</table>
		</form>
		<div class="password_validation_block"></div>
		<div class="email_validation_block"></div>
	</div>
<script type="text/javascript">
	var passwordInput = document.querySelector("#password");
	var emailInput = document.querySelector("#email");
	var passwordValidationBlock = document.querySelector(".password_validation_block");
	var emailValidationBlock = document.querySelector(".email_validation_block");
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
			passwordValidationBlock.innerHTML = "Пароль не менее 1 символа!"	
		} else {
			passwordValidationBlock.style.display="none";
		}
	});
</script>
</body>
</html>