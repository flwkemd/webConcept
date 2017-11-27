package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class VisitUpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				int idx = Integer.parseInt(request.getParameter("idx"));
				
				VisitVo vo = VisitDao.getInstance().selectOne(idx);
				request.setAttribute("vo", vo);
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}else {
				int idx = Integer.parseInt(request.getParameter("idx"));

				String name = request.getParameter("name");
				String content = request.getParameter("content");
				String pwd = request.getParameter("pwd");
				
				VisitVo vo = new VisitVo(name, content, pwd);
				vo.setIdx(idx);
				VisitDao.getInstance().update(vo);
				response.sendRedirect("list.do");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "end";
	}

}
