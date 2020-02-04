<%-- <%@page import="test.BoardVO"%>
<%@page import="java.util.ArrayList"%> --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 mvc 테스트</title>
</head>
<body>



	<%-- 	<%
		ArrayList<BoardVO> list = (ArrayList<BoardVO>) request.getAttribute("boardlist");

		for (BoardVO vo : list) {
			out.println("<h3> 번호 : " + vo.getSeq());
			out.println("제목 : " + vo.getTitle());
			out.println("내용 : " + vo.getContents());
			out.println("작성자 : " + vo.getWriter());

			out.println("작성시간 : " + vo.getTime());
			out.println("조회수 : " + vo.getViewcount() +"</h3>");
		}
	%>
 --%>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:forEach items="${list}" var="vo">
		<h3>번호 : ${vo.seq} 제목 : ${vo.title} 내용 : ${vo.contents} 작성자 :
			${vo.writer} 조회수 :${vo.viewcount}</h3>
</c:forEach>




</body>
</html>