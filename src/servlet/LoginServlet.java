package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberVo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String isSave = request.getParameter("save");
		
		MemberVo vo = new MemberVo("hong", "1111", "ȫ�浿");
		
		if(isSave.equals("y")) {
			Cookie ck = new Cookie("id", id);
			ck.setMaxAge(20);
			ck.setPath("/");
			response.addCookie(ck);
		}
		
		if(id.equals(vo.getId()) && pwd.equals(vo.getPwd())) {
			request.getSession().setMaxInactiveInterval(10);
			request.getSession().setAttribute("user", vo);
			response.sendRedirect("/login/main.do");
		}else {
			response.sendRedirect("/login/form.do");
		}
		
	}

}
