package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class VisitDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idx = Integer.parseInt(request.getParameter("idx"));
			VisitDao.getInstance().delete(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}

}
