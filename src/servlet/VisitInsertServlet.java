package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitInsertServlet
 */
@WebServlet("/visit/insert.do")
public class VisitInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd =request.getParameter("pwd");
		
		VisitVo vo = new VisitVo(name, content, pwd);
		vo.setIp(request.getRemoteAddr());
		VisitDao.getInstance().insert(vo);
		
		response.sendRedirect("list.do");
	}

}
