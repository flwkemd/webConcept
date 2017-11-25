package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoInsertServlet
 */
@WebServlet("/photo/insert.do")
public class PhotoInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path="/upload";
		int maxSize = 1024*1024*10;
		String realPath = request.getServletContext().getRealPath(path);
		MultipartRequest mr = new MultipartRequest(
				request,
				realPath,
				maxSize,
				"utf-8",
				new DefaultFileRenamePolicy());
		
		String title = mr.getParameter("title");
		String pwd = mr.getParameter("pwd");
		PhotoVo vo = new PhotoVo();
		vo.setTitle(title);
		vo.setPwd(pwd);
		
		File photo = mr.getFile("photo");
		String filename="";
		if(photo != null) {
			filename = photo.getName();
		}
		
		vo.setFilename(filename);
		vo.setIp(request.getRemoteAddr());
		
		PhotoDao.getInstance().insert(vo);
		
		response.sendRedirect("list.do");
		
		
	}

}
