package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("HelloController 실행 중립니다");
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "Hello Spring(어노테이션)");
		//mv.setViewName("hello");
		//없어도 됨 view를 명시하는 파일이 없으면 위의 /hello와 같은 뷰를 찾는다

		return mv;

	}

}
