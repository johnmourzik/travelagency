<?xml version="1.0" encoding="UTF-8"?>
<%@ attribute name="coll" type="java.util.Collection" required="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="tour" items="${tours}">
	<tr align="center">
		<td align="left">${tour.tourName}</td>
		<td>${tour.country}</td>
		<td>${tour.tourDesc}</td>
		<td>${tour.startDate}</td>
		<td>${tour.price}</td>
		<td>
			<form method="post" action='<c:url value="/neworder" />'
				style="display: inline;">
				<input type="hidden" name="id" value="${order.id}"><input
					type="submit" value="Order">
			</form>
		</td>
	</tr>
</c:forEach>
