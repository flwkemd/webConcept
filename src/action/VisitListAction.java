package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class VisitListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String search_option = request.getParameter("search_option");
			String search_text = request.getParameter("search_text");
			Map<String, String> map = new HashMap<>();
			
			if(search_option != null && !search_option.equals("all")) {
				//조건 검색이라면
				map.put("search_option", search_option);
				map.put("search_text", search_text);
			}
			
			List<VisitVo> list = VisitDao.getInstance().selectList(map);
			
			//request binding란?
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}

}
