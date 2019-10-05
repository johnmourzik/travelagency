package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import impl.UserDaoImpl;
import models.UserData;

public class SelectOneUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/usercabinet.jsp").forward(request, response);
		String email = request.getParameter("email");
		UserDao userDao = UserDaoImpl.getUserDaoInstance();
		UserData userByEmail = userDao.selectOne(email);
		response.getWriter().println(userByEmail);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		UserDao userDao = new UserDaoImpl();
		UserData user = userDao.selectOne(email);
		if (user != null) {
			request.setAttribute("userCode", user);
			request.setAttribute("userName", user);
			request.setAttribute("userSurname", user);
			request.setAttribute("birthday", user);
			request.setAttribute("email", user);
			request.setAttribute("password", user);
			request.setAttribute("user", user);
			getServletContext().getRequestDispatcher("/usercabinet.jsp").forward(request, response);
		}
	}
}
