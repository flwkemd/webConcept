package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentDao;
import vo.DepartmentVo;
import vo.EmployeeVo;

/**
 * Servlet implementation class DepartmentListServlet
 */
@WebServlet("/department/list.do")
public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DepartmentVo> list = DepartmentDao.getInstance().selectList();
		for(DepartmentVo dvo : list) {
			System.out.printf("부서번호:%d, 부서이름:%s",
					dvo.getDepartment_id(), dvo.getDepartment_name());
			System.out.println();
			for(EmployeeVo evo : dvo.getEmpList()) {
				System.out.printf("--사원번호:%d, 사원이름:%s",evo.getEmp_id(), evo.getFir_name());
			}
		}
	}

}
