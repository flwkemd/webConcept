<%@page import="org.json.simple.JSONArray"%>
<%@page import="vo.VideoVo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<VideoVo> videoList = new ArrayList<>();
	VideoVo vo = new VideoVo();
	
	vo.setTitle("포켓몬 1화");
	vo.setPath("video/poket1.mp4");
	videoList.add(vo);
	
	VideoVo vo2 = new VideoVo();
	
	vo2.setTitle("포켓몬 2화");
	vo2.setPath("video/poket2.mp4");
	videoList.add(vo2);
	
	pageContext.setAttribute("videoList", videoList);

	out.print(JSONArray.toJSONString(videoList));
%>
<%-- [
	<c:forEach var="i" begin="0" end="${videoList.size() -1 }">
		<c:if test="${i != videoList.size() -1 }">
			{title:"${videoList.get(i).title }", path:"${videoList.get(i).path }"},
		</c:if>
		<c:if test="${i == videoList.size() -1 }">
			{title:"${videoList.get(i).title }", path:"${videoList.get(i).path }"}
		</c:if>
	</c:forEach>
]

 --%>