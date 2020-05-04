package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
@RequestMapping(name="/login", method = RequestMethod.GET)
	public String loginform(){
	//매핑메소드의 리턴타입string = 뷰 이름
	//로그인 폼을 출력하자 html태그로 만들어야함 jsp파일 필요
	return "loginform";
		
	}
@RequestMapping(name="/login",method = RequestMethod.POST)
public ModelAndView loginsuccess(HttpServletRequest request) {
	ModelAndView mv = new ModelAndView();
	mv.addObject("loginresult",true);
	mv.setViewName("loginsuccess");
	return mv;
	
}

}
