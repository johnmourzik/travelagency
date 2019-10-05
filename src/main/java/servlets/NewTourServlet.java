package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TourDao;
import impl.TourDaoImpl;
import models.TourData;

public class NewTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/newtour.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String tourName = request.getParameter("tourName");
			String country = request.getParameter("country");
			String tourDesc = request.getParameter("tourDesc");
			String startDate = request.getParameter("startDate");
			int price = Integer.parseInt(request.getParameter("price"));
			TourData newTour = new TourData();
			newTour.setTourName(tourName);
			newTour.setCountry(country);
			newTour.setTourDesc(tourDesc);
			newTour.setStartDate(startDate);
			newTour.setPrice(price);
			TourDao tourDao = new TourDaoImpl();
			tourDao.addTour(newTour);
			response.sendRedirect(request.getContextPath() + "/alltours2");
		} catch (Exception ex) {

			getServletContext().getRequestDispatcher("/WEB-INF/views/newtour.jsp").forward(request, response);
		}
	}
}
