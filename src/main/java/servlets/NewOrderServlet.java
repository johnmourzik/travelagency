package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import impl.OrderDaoImpl;
import models.OrderData;

public class NewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/neworder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int userCode = Integer.valueOf(request.getParameter("userCode"));
			int tourCode = Integer.valueOf(request.getParameter("tourCode"));
			int hotelCode = Integer.valueOf(request.getParameter("hotelCode"));
			String orderDate = request.getParameter("orderDate");
			OrderData neworder = new OrderData();
			neworder.setUserCode(userCode);
			neworder.setTourCode(tourCode);
			neworder.setHotelCode(hotelCode);
			neworder.setOrderDate(orderDate);
			OrderDao orderDao = new OrderDaoImpl();
			orderDao.addOrder(neworder);
			response.sendRedirect(request.getContextPath() + "/index.html");
		} catch (Exception ex) {

			getServletContext().getRequestDispatcher("/neworder.jsp").forward(request, response);
		}
	}
}
