package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MySearchUtil;
import vo.ProductVo;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/product/list.do")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String searchText= request.getParameter("searchText");
		if(searchText == null) {
			searchText = "computer";
		}
		
		int start = 1;
		int display = 10;
		
		List<ProductVo> list = MySearchUtil.searchShop(searchText, start, display);
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	
	}

}
