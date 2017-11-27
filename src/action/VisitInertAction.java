package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class VisitInertAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			String pwd =request.getParameter("pwd");
			
			VisitVo vo = new VisitVo(name, content, pwd);
			vo.setIp(request.getRemoteAddr());
			VisitDao.getInstance().insert(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}

}
