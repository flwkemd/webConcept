package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<String> bookList = new ArrayList<>();
		bookList.add("Jav Pro");
		bookList.add("oracle");
		bookList.add("abc");
		bookList.add("Spring");
		bookList.add("Ke");
		
		request.setAttribute("bookList", bookList);
		return "success";
		
	}

}
