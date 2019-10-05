<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="userData" class="models.UserData" scope="session"/>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login System</title>
</head>

<body>
	<%
        String email=(String)session.getAttribute("email");
        
       	response.sendRedirect("usercabinet.jsp");
       	
        //redirect user to login page if not logged in
        if(email==null){
        	response.sendRedirect("loginsystem.jsp");
        }  
       
        out.println(session.getId());
        Enumeration keys = session.getAttributeNames();
        while(keys.hasMoreElements()){
            out.println((String) keys.nextElement());
        }
        %>
</body>
</html>