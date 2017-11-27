package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction1 implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String msg = "내가 만든 MVC Framework입니다.";
		request.setAttribute("msg", msg);
			
		return "success";
	}

}
