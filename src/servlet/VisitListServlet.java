package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		request.setCharacterEncoding("utf-8");
		String search_option = request.getParameter("search_option");
		String search_text = request.getParameter("search_text");
		Map<String, String> map = new HashMap<>();
		
		if(search_option != null && !search_option.equals("all")) {
			//조건 검색이라면
			map.put("search_option", search_option);
			map.put("search_text", search_text);
		}
		
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
		
		//request binding란?
		request.setAttribute("list", list);
		System.out.println(list.size());
		RequestDispatcher disp = request.getRequestDispatcher("list.jsp");
		disp.forward(request, response);
		
	}

}
