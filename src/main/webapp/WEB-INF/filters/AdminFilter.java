//package filters;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import models.UserData;
//import static models.UserData.ADMIN_ROLE;
//
//public class AdminFilter implements Filter {
//
//	public void destroy() {
//	}
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpSession session = null;
//		if (request instanceof HttpServletRequest) {
//			session = ((HttpServletRequest) request).getSession(false);
//			Object obj = session.getAttribute("admin");
//			if (obj != null && obj instanceof UserData) {
//				UserData userData = (UserData) obj;
//				String role = userData.getEmail();
//				if (email.equals("asd@asd")) {
//					chain.doFilter(request, response);
//				} else {
//					responseNotAllowed(response);
//				}
//			} else {
//				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adminpanel.jsp");
//			}
//		}
//	}
//
//	private void responseNotAllowed(ServletResponse response) throws IOException {
//		HttpServletResponse httpResp = (HttpServletResponse) response;
//		httpResp.sendError(403, "You are not allowed to access this resource");
//	}
//
//	public void init(FilterConfig fConfig) throws ServletException {
//	}
//
//}