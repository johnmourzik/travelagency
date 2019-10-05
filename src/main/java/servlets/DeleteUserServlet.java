package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import impl.UserDaoImpl;
import models.UserData;

public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userCode = Integer.valueOf(request.getParameter("userCode"));
		UserDao userDao = UserDaoImpl.getUserDaoInstance();
		UserData userById = userDao.selectOne(userCode);
		response.getWriter().println(userById);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userCode = Integer.valueOf(request.getParameter("userCode"));
		UserDao userDao = UserDaoImpl.getUserDaoInstance();
		userDao.deleteUser(userCode);
		response.sendRedirect(request.getContextPath() + "/index.html");
	}
}
