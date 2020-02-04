package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
//controller를 spring에서 제공해 주는 것으로 함
public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("HelloController 실행 중립니다");
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "Hello Spring");
		// =request.setAttribute
		// 모델 세팅
		mv.setViewName("hello");
		// =return "/hello.jsp"
		// view를 세팅
		//뷰의 위치와 확장자가 변경될 때 소스변경 할 필요 없이 view 이름만 넣음 - 수정은 servlet context만 하면된다

		return mv;

	}

}
