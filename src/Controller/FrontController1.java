package Controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 * Servlet implementation class FrontController1
 */
/*@WebServlet(
		urlPatterns= {"/"},
		initParams= {
				@WebInitParam(name="myName",value="ȫ�浿");
		}
)*/
public class FrontController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Map<String, String>> actionMap = new HashMap<>();

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
//		String myName = config.getInitParameter("myName");
//		System.out.println(myName);
		String contextPath = config.getInitParameter("contextPath");
		String contextFilename = config.getInitParameter("contextFilename");
		
		//������ -> ���Ͻý��ۻ��� ���(������)
		String absPath = config.getServletContext().getRealPath(contextPath);
		File actionXml = new File(absPath, contextFilename);
		try {
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(actionXml);
			Element actions = doc.getRootElement();
			List<Element> actionList = actions.getChildren("action");
			for(Element action : actionList) {
				String path = action.getAttributeValue("path");
				String className = action.getAttributeValue("className");
				String methodName = action.getAttributeValue("methodName");
				if(methodName == null) {
					methodName = "execute";
				}
				
				Element result = action.getChild("result");
				String resultType = result.getAttributeValue("type");
				if(resultType == null) {
					resultType="dispatcher";
				}
				
				String resultPage = result.getText();
				
				Map<String, String> map = new HashMap<>();
				map.put("className", className);
				map.put("methodName", methodName);
				map.put("resultType", resultType);
				map.put("resultPage", resultPage);
				
				actionMap.put(path, map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("��û�Ϸ�");
		String uri = request.getRequestURI();
//		System.out.println(uri);
		int index = uri.indexOf("/",2);
		String path = uri.substring(index);
		
		Map<String, String> map = actionMap.get(path);
		if(map == null) {
			response.sendError(404);
			return;
		}
		
		String className = map.get("className");
		String methodName = map.get("methodName");
		String resultType = map.get("resultType");
		String resultPage = map.get("resultPage");
		
		try {
			//���� Ŭ���� ����
			Class c = Class.forName(className);
			
			//���� ��ü ����
			Object obj = c.newInstance();
			
			//���� �޼ҵ� ����
			Method method = c.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			//���� �޼ҵ� ȣ��
			String result = (String)method.invoke(obj, request, response);
			
			if(result.equals("success")) {
				if(resultType.equals("dispatcher")) {
					request.getRequestDispatcher(resultPage).forward(request, response);
				}else {
					response.sendRedirect(resultPage);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
