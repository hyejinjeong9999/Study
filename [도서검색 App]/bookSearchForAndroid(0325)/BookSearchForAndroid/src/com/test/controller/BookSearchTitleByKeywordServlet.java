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

/**
 * Servlet implementation class BookSearchTitleByKeywordServlet
 */
@WebServlet("/searchTitlebyKeyword")
public class BookSearchTitleByKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchTitleByKeywordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이부분을 작성해요!!
		// 1. 클라이언트가 보내주는 입력을 받아요!! 입력은 무조건 String으로 받아요!
		String keyword = request.getParameter("keyword");		
		// 2. 로직처리를 하는 객체를 생성해서 그 객체한테 일을 시켜요!
		//    그리고 결과를 다시 받아와요!
		//    로직처리하는 객체(Service)가 존재해야 해요!
		BookService service = new BookService();
		ArrayList<String> result = service.getBookTitle(keyword);
		// 3. 처리된 결과를 클라이언트에게 출력해요!
		//    일반 문자열 형태가 아니라..JSON형태로 데이터를 전달해야해요!
		//    JSON으로 결과데이터를 변경하기 위해서 JACKSON library를 이용
		
		// Jackson library를 이용하기 위해서 ObjectMapper를 생성
		ObjectMapper mapper = new ObjectMapper();
		
		// ArrayList형태의 데이터를 String 배열형태의 JSON으로 변환
		String jsonString = mapper.writeValueAsString(result);
				
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jsonString);
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
