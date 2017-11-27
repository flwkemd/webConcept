package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class VisitCheckPwdAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idx = Integer.parseInt(request.getParameter("idx"));
			String pwd = request.getParameter("pwd");
			VisitVo vo = VisitDao.getInstance().selectOne(idx);
			
			if(vo.getPwd().equals(pwd)) {
				response.getWriter().write("yes");
			}else {
				response.getWriter().write("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "async";
	}

}
