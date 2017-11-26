package servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieGetServlet
 */
@WebServlet("/cookie/get.do")
public class CookieGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies;
		if(request.getCookies() != null) {
			cookies = request.getCookies();
			for(Cookie ck : cookies) {
				if(ck.getName().equals("id")) {
					request.setAttribute("id", ck.getValue());
				}
				if(ck.getName().equals("name")) {
					request.setAttribute("name", URLDecoder.decode(ck.getValue()));
				}
			}
		}
		request.getRequestDispatcher("get.jsp").forward(request, response);
	}

}
