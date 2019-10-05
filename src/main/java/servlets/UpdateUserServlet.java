package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import impl.UserDaoImpl;
import models.UserData;

public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		UserData user = new UserData();
		UserDao userDao;
		userDao = UserDaoImpl.getUserDaoInstance();
		userDao.selectOne(email);
		if (user != null) {
			request.setAttribute("user", user);
			getServletContext().getRequestDispatcher("/updateuser.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			UserData newuser = new UserData();
			newuser.setEmail(email);
			newuser.setPassword(password);
			UserDao userDao = new UserDaoImpl();
			userDao.updateEmailUser(newuser);
			response.sendRedirect(request.getContextPath() + "/index.html");
		} catch (Exception ex) {
			getServletContext().getRequestDispatcher("/updateuser.jsp").forward(request, response);
		}
	}
}
