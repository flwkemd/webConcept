package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginFormServlet
 */
@WebServlet("/login/form.do")
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getCookies() != null) {
			for(Cookie ck : request.getCookies()) {
				if(ck.getName().equals("id")) {
					request.setAttribute("saveId", ck.getValue());
				}
			}
		}
		request.getRequestDispatcher("/login/form.jsp").forward(request, response);
	}

}
