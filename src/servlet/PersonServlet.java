package servlet;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import vo.Person1Vo;
import vo.PersonVo;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/person.do")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strURL = "http://localhost:9090/webConcept/person.xml";
		URL url = new URL(strURL);
		
		List<Person1Vo> p_list = new ArrayList<Person1Vo>();
	
		SAXBuilder sb = new SAXBuilder();
		try {
			Document doc = sb.build(url);
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren("person");
			for(Element person : list) {
				String name = person.getChildText("name");
				String nickname = person.getChild("name").getAttributeValue("nickname");
				int age = Integer.parseInt(person.getChildText("age"));
				String tel = person.getChildText("tel");
				String hometel = person.getChild("tel").getAttributeValue("hometel");
				
				Person1Vo vo = new Person1Vo(name, nickname, age, hometel, hometel);
				p_list.add(vo);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("p_list", p_list);
		request.getRequestDispatcher("xml/personList.jsp").forward(request, response);
		
	}

}
