package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ListAction;
import action.ViewAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int index = uri.indexOf("/", 2);
		uri = uri.substring(index);
		
		String forwardPage = "error.jpg";
		
		if(uri.equals("/book/list.do")) {
			Action action = new ListAction();
			String result = action.execute(request, response);
			if(result.equals("success")) {
				forwardPage = "list.jsp";
			}
		}else if(uri.equals("/book/view.do")) {
			Action action = new ViewAction();
			String result = action.execute(request, response);
			if(result.equals("success")) {
				forwardPage = "view.jsp";
			}
			
		}
		
		request.getRequestDispatcher(forwardPage).forward(request, response);
		
	}

}
