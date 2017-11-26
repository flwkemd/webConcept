package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		int idx = Integer.parseInt(request.getParameter("idx"));
		
		Map book = new HashMap<>();
		book.put("title", "java");
		book.put("price", 30000);
		book.put("author", "ȫ�浿");
		book.put("publisher", "inde");
		
		request.setAttribute("book", book);
		
		return "success";
		
		
	}

}
