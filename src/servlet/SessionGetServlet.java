package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UserVo;

/**
 * Servlet implementation class SessionGetServlet
 */
@WebServlet("/session/get.do")
public class SessionGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo vo = (UserVo)request.getSession().getAttribute("user");
		if(vo != null) {
			System.out.println(vo.getId());
			System.out.println(vo.getName());
			System.out.println(vo.getPwd());
		}
		request.getRequestDispatcher("get.jsp").forward(request, response);
	
	}

}
