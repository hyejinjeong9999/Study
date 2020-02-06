###### LoginController

같은 url을 매핑 한 것이 두개



1. get방식
2. post방식

```java
package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(name = "/login", method = RequestMethod.GET)
	public String loginform() {
		// 매핑메소드의 리턴타입string = 뷰 이름
		// 로그인 폼을 출력하자 html태그로 만들어야함 jsp파일 필요
		return "loginform";

	}

	@RequestMapping(name = "/login", method = RequestMethod.POST)
	public ModelAndView loginsuccess(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//id와 pw를 가져옴
		ModelAndView mv = new ModelAndView();
		
//	=====id spring이고 pw spring일 때만 로그인 상태 만들기=====
		
		if(id.equalsIgnoreCase("spring")&&pw.equals("spring")) {
			mv.addObject("loginresult", true);
		}
		
		else mv.addObject("loginresult",false);
				
		
		mv.setViewName("loginsuccess"); 
		//출력화면 - loginsuccess.jsp
		return mv;

	}

}


```





###### login.jsp

* view의 역할
  * c -> m -> v 항상 마지막
* WEB-INF
  * 접근할 수 없는 폴더
  * jsp를 바로 실행할 수 없다

````jsp

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>loginform.jsp 파일이 보입니다</h1>
<form action = "http://localhost:8081/mvc/login"method="post">
<!-- post방식으로 로그인하는 form -->
아이디 <input type = text name= id>
암호 <input type = "password" name= "pw">

<input type = submit value = "로그인">

</body>
</html>
````





###### loginsuccess.jsp

````jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>loginsuccess.jsp 파일이 보입니다</h1>
${loginresult} 
</form>
</body>
</html>
````





![image-20200205093857105](C:\Users\student\Desktop\Study\Study\md_img\image-20200205093857105.png)

![image-20200205093907924](C:\Users\student\Desktop\Study\Study\md_img\image-20200205093907924.png)





---

상품관리

상품 등록 / 수정 / 삭제 / 조회

관리 - 조회 / 저장 / 수정 / 삭제

crud - create / read / update / delete



boardT - BoardVO - BoardDAO - 

BoardController : 4개의 RequestMapping(조회 저장 수정 삭제)

폼 / 폼처리

member 테이블 

product 테이블





-컨트롤러 메소드의 리턴타입이 바뀌면 의미가 어떻게 변하는지

String

void

Map



### Return type 

* ModelAndView
  * model 과view 둘 다 피룡할 때
* String
  * 뷰(수동)
* void 
  * 뷰(자동)
* Map
  * 모델, 뷰(자동)



### 매개변수 타입

* HttpServletRequest 등의 서블릿 api
  * 코드가 길어진다

* String, int double boolean 타입
  * 타입 + 변수명 (=요청 파라미터명)
  * 요청 파라미터 값 자동 저장
* @RequestParam("i") String j,
  * int, double, boolean 타입 + 변수명 (=요청 파라미터 명)
  * 요청 파라미터 값 자동 저장
* 요청 파라미터의 개수가 많으면 VO객체를 정의
  * @modelAtribute("m")xxxVO v
    * 따로 이름 정할때
  * xxxVo v
  * 요청 파라미터명과 xxxVo 멤버변수명 동일 자동 저장
  * XXXVo 객체는 자동으로 MODEL - JSP에 전달



@Controller

@RequestMapping (url="",method=...)

@RequestParam(value="",required=true/false, defaultValue="")

@ModelAttribute("") LoginVO

---

