package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class VisitInsertFromAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "success";
	}

}
