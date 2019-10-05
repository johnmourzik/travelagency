package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TourDao;
import impl.TourDaoImpl;

public class DeleteTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int tourCode = Integer.parseInt(request.getParameter("tourCode"));
			TourDao tourDao = new TourDaoImpl();
			tourDao.deleteTour(tourCode);
			response.sendRedirect(request.getContextPath() + "/alltours2");
		} catch (Exception ex) {
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		}
	}
}
