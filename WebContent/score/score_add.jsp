<%@page import="dao.ScoreDao"%>
<%@page import="vo.ScoreVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//post방식으로 요청이 올 것이기 때문에 한글을 받으려면 인코딩을 지정
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String korean = request.getParameter("korean");
	String english = request.getParameter("english");
	String math = request.getParameter("math");
	
	ScoreVo svo = new ScoreVo();
	svo.setName(name);
	svo.setKorean(Integer.parseInt(korean));
	svo.setEnglish(Integer.parseInt(english));
	svo.setMath(Integer.parseInt(math));
	
	ScoreDao.getInstance().insert(svo);
	response.sendRedirect("score_list.jsp");
%>