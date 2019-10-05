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

public class AllOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDao orderDao = new OrderDaoImpl();
		List<OrderData> orders = orderDao.getAllOrders();
		request.setAttribute("orders", orders);
		getServletContext().getRequestDispatcher("/allorders.jsp").forward(request, response);
	}
}
