package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class FrontControllerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> FrontControllerServlet </h1>");
		out.println(request.getRequestURL());
		out.println(request.getRequestURI());
		String s[] = request.getRequestURI().split("/");
		//슬래시가 나올때마다 문자열 문리
		out.println("<h1>"+s[s.length-1]+"</h1>");
		//맨 뒷 값만 가져옴
		//boardlist - 일시키자 mvc - spring 내부환경 이해 로직
		
		HandlerMapping mapping = new HandlerMapping();
		Controller controller = mapping.getController(s[s.length-1]);
		String viewname = controller.handleRequest(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher(viewname);
		rd.forward(request,response);//모든 요청변수와 응답하는 변수가 필요함
		

	}

}
