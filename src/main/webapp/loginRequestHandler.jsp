<%@page import="dao.UserDao"%>
<%@page import="impl.UserDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userData" class="models.UserData" scope="session" />
<jsp:setProperty name="userData" property="*" />
<%
	UserDao userDao = new UserDaoImpl();
	String result = userDao.loginCheck(userData);

	if (result.equals("admin")) {
		session.setAttribute("email", userData.getEmail());
		response.sendRedirect("/travelagency/adminpanel");
	}
	if (result.equals("true")) {
		session.setAttribute("email", userData.getEmail());
		response.sendRedirect("home.jsp");
	}

	if (result.equals("false")) {
		response.sendRedirect("loginsystem.jsp?status=false");
	}

	if (result.equals("error")) {
		response.sendRedirect("loginsystem.jsp?status=error");
	}
%>