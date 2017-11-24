package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import vo.VisitVo;

/**
 * Servlet implementation class VisitListServlet
 */
@WebServlet("/visit/list.do")
public class VisitListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VisitVo> list = VisitDao.getInstance().selectList();
		
		//request binding¶õ?
		request.setAttribute("list", list);
		System.out.println(list.size());
		RequestDispatcher disp = request.getRequestDispatcher("list.jsp");
		disp.forward(request, response);
		
	}

}
