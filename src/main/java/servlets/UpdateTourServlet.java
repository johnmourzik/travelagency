package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TourDao;
import impl.TourDaoImpl;
import models.TourData;

public class UpdateTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int tourCode = Integer.parseInt(request.getParameter("tourCode"));
		TourData tour = new TourData();
		TourDao tourDao = new TourDaoImpl();
		tourDao.selectOne(tourCode);
		if (tour != null) {
			request.setAttribute("tour", tour);
			getServletContext().getRequestDispatcher("/updatetour.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int tourCode = Integer.parseInt(request.getParameter("tourCode"));
			String tourName = request.getParameter("tourName");
			String country = request.getParameter("country");
			String tourDesc = request.getParameter("tourDesc");
			String startDate = request.getParameter("startDate");
			int price = Integer.parseInt(request.getParameter("price"));
			TourData newTour = new TourData();
			newTour.setTourCode(tourCode);
			newTour.setTourName(tourName);
			newTour.setCountry(country);
			newTour.setTourDesc(tourDesc);
			newTour.setStartDate(startDate);
			newTour.setPrice(price);
			TourDao tourDao = new TourDaoImpl();
			tourDao.updateTour(newTour);
			response.sendRedirect(request.getContextPath() + "/alltours2");
		} catch (Exception ex) {
			getServletContext().getRequestDispatcher("/newtour.jsp").forward(request, response);
		}
	}

}
