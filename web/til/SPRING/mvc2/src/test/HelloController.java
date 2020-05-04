package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("HelloController 실행 중립니다");
		//값을 전달
		//request.setAttribute("String형태의 이름", 모든값); model에 hellospring을 전달
		request.setAttribute("model", "Hello Spring");
		
		return "/hello.jsp";//view의 이름
		//request.getAtribute("model")
		//${model} : el표현식 버전
		
	}

}
