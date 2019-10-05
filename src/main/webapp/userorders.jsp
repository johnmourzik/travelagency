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
		<tr>
			<th>Order code</th>
			<th>User code</th>
			<th>Tour code</th>
			<th>Hotel code</th>
			<th>Order date</th>
			<th></th>
		</tr>
		<c:forEach var="order" items="${orders}">
			<tr>
				<td>${order.orderCode}</td>
				<td>${order.userCode}</td>
				<td>${order.tourCode}</td>
				<td>${order.hotelCode}</td>
				<td>${order.orderDate}</td>
				<td>
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