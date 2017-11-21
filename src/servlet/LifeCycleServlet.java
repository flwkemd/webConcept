package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/life.do")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycleServlet() {
    	System.out.println("-----������-----");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("----inti()----");
	}
	public void destroy() {
		System.out.println("----destory()----");
		//������ ��Ʈ���� �ݰų�, ����� �޸𸮸� ��ȯ(close());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----service()----");
		System.out.println(request.getMethod());
		
		//get�̵� post�̵� �������� �����ؾ��� ���� �ۼ�
		String method = request.getMethod();
		if(method.equals("GET")) {
			doGet(request, response);
		}else {
			doPost(request, response);
		}
		
		
		//��û�� �����ؼ� ��û ����� get�̸� doGet()ȣ��
		// post�� postȣ��
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----doGet()----");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----doPost()----");
	}

}
