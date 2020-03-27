package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookTitleSearchServlet
 */
@WebServlet("/searchTitle")
public class BookTitleSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTitleSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // 입력,로직,출력의 코드가 하나의 method안에 옹기종기 모여있게되요! => Model1
    // Model1방식은 처음 작성하기에는 쉽고 빠른 방식이지만 추후에 유지보수가 X
    // Model1 방식에서 Model2방식으로 전환 => MVC pattern을 이용 
    // MVC Pattern(Model-View-Controller)을 이용해서 프로그램을 분할.
    // - 1. Controller : 클라이언트가 보내주는 입력을 받고 처리된 최종 결과를 출력
    // - 2. Service : 로직을 처리하는 역할
    // - 3. DAO(Data Access Object) : 모든 Database의 처리
    // - 4. DTO(Data Transfer Object) : VO(Value Object), DO(Domain Object)
    //                                  Entity
    // 우리 코드를 수정해야 해요!!
    // BookTitleSearchServlet 우리 Servlet은 controller의 역할을 담당
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET방식으로 Servlet이 호출되면 이 method가 호출!!
		// 1. 입력받고 ( 입력을 받는 방식도 정해져있어요 )
		// 2. 로직처리하고 ( 일반적인 로직처리 + DB처리 )
		// 3. 출력		
		//    - 3.1 클라이언트에 처리된 결과에 대한 종류, 인코딩에 대해 정보를
		//          알려줘야 해요!
		//      일반문자열이 결과로 출력되고 사용하는 인코딩은 유니코드 인코딩.
		response.setContentType("text/plain; charset=utf-8");
		//    - 3.2 클라이언트에게 결과를 보내주기 위한 데이터 통로를 열어야 되요
		PrintWriter out = response.getWriter();
		//    - 3.3 데이터통로(Stream)을 통해서 데이터를 출력!!
		out.println("이것은 소리없는 아우성!!");
		out.println("두번째 데이터예요!!");
		//    - 3.4 보낼 데이터가 다 준비되면 특정 method를 이용해서 진짜 보내요!
		out.flush();
		//    - 3.5 처리가 끝났으니 통로를 닫아야해요!
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
