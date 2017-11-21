package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/parameter.do")
public class ParameterServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		if(method.equals("GET")) {
			doGet(request, response);
		}else {
			doPost(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String hobby[] = request.getParameterValues("hobby");
		
		System.out.println(name);
		for(String ho : hobby) {
			System.out.println(ho);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post ������� �ѱ� �����͸� ���� ���, request�� encoding ������� �����ؾ��Ѵ�.
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String hobby[] = request.getParameterValues("hobby");
		
		System.out.println(name);
		for(String ho : hobby) {
			System.out.println(ho);
		}
	
	}

}
