package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import impl.OrderDaoImpl;
import models.OrderData;

public class UserOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

		int userCode = Integer.parseInt(request.getParameter("userCode"));
		OrderDao orderDao = new OrderDaoImpl();
		List<OrderData> orders = orderDao.getOrdersByUserCode(userCode);
		request.setAttribute("orders", orders);
		getServletContext().getRequestDispatcher("/userorders.jsp").forward(request, response);
	}
}
