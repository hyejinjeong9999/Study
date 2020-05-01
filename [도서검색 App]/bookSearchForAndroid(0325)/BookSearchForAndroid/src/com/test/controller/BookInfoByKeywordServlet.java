package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.service.BookService;
import com.test.vo.BookVO;

/**
 * Servlet implementation class BookInfoByKeywordServlet
 */
@WebServlet("/bookinfo")
public class BookInfoByKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInfoByKeywordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet method를 작성!!
		// 1. 클라이언트가 보내주는 입력을 받아요!!
		String keyword = request.getParameter("keyword");
		// 2. 로직처리를 진행해요! => service라고 불리는 로직처리 객체를 이용
		BookService service = new BookService();
		//    로직처리 객체를 이용해서 일을 시켜요!!(특정 method를 호출)
		//    검색어를 이용해서 책의 제목과 ISBN번호을 알아오는 일을 시켜요!
		//    데이터 전달객체(VO,DTO)를 이용해야 데이터 전달이 편해요!
		ArrayList<BookVO> result = service.getBookInfo(keyword);
		// 3. 결과를 얻어왔어요!!
		//    결과데이터를 JSON으로 만들어야 해요!
		//    JSON문자열을 만들어서 Android App에게 Stream을 이용해서 출력
		//    Jackson library를 이용해서 결과데이터를 JSON으로 변경
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(result);
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonData);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
