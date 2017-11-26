package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieAddServlet
 */
@WebServlet("/cookie/add.do")
public class CookieAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ck_id = new Cookie("id", "abc");
		ck_id.setMaxAge(10);
		response.addCookie(ck_id);
		
		Cookie ck_name = new Cookie("name", URLEncoder.encode("∫∏¿ÃΩ∫"));
		ck_name.setMaxAge(20);
		response.addCookie(ck_name);
		
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

}
