package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UserVo;

/**
 * Servlet implementation class SessionAddServlet
 */
@WebServlet("/session/add.do")
public class SessionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setMaxInactiveInterval(30*60); //30분
		request.getSession().setAttribute("msg", "안녕하세요");
		UserVo vo = new UserVo();
		vo.setId("voice");
		vo.setPwd("1234");
		vo.setName("보이스");
		request.getSession().setAttribute("user", vo);
		
		System.out.println(request.getSession().getId());
		
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

}
