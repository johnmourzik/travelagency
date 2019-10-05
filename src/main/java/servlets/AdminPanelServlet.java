package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TourDao;
import impl.TourDaoImpl;
import models.TourData;

public class AdminPanelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TourDao tourDao = new TourDaoImpl();
		List<TourData> tours = tourDao.getAllTours();
		request.setAttribute("tours", tours);
		getServletContext().getRequestDispatcher("/adminpanel.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
