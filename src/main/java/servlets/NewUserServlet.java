package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import impl.UserDaoImpl;
import models.UserData;

public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/newuser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userName = request.getParameter("userName");
			String userSurname = request.getParameter("userSurname");
			String birthday = request.getParameter("birthday");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			UserData newuser = new UserData();
			newuser.setUserName(userName);
			newuser.setUserSurname(userSurname);
			newuser.setBirthday(birthday);
			newuser.setEmail(email);
			newuser.setPassword(password);
			UserDao userDao = new UserDaoImpl();
			userDao.addUser(newuser);
			response.sendRedirect(request.getContextPath() + "/index.html");
		} catch (Exception ex) {
			getServletContext().getRequestDispatcher("/newuser.jsp").forward(request, response);
		}
	}
}
