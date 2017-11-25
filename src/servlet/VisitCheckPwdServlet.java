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
 * Servlet implementation class VisitCheckPwdServlet
 */
@WebServlet("/visit/checkPwd.do")
public class VisitCheckPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pwd = request.getParameter("pwd");
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		/*if(vo.getPwd().equals(pwd)) {
			response.getWriter().write("yes");
		}else {
			response.getWriter().write("no");
		}*/
	
		response.setContentType("text/xml; charset=utf-8");
		response.getWriter().write("<visit>");
		response.getWriter().write("<name>"+vo.getName()+"</name>");
		response.getWriter().write("<pwd>"+vo.getPwd()+"</pwd>");
		response.getWriter().write("</visit>");
	}

}
