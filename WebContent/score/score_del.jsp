<%@page import="dao.ScoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("code");
	
	ScoreDao.getInstance().delete(Integer.parseInt(code));
	response.sendRedirect("score_list.jsp");
	
%>