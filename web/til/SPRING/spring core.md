

class A {

HttpServlet s = new LoginServlet()

HttpServlet s = new HttpServlet();

HttpServlet s = new BoardServlet()

}

class LoginServlet extends HttpServlet{



}

class BoardServlet extends HttpServlet{

}

-> 결합도가 높음 (하나를 수정하려면 )

객체는 외부에서 주는것만 받아

class A {

HttpServlet s =;

setHttpServlet(HttpServlet h){

s = h;

}

}

A a1 = new A();

ae.



class LoginServlet extends HttpServlet{



}

class BoardServlet extends HttpServlet{

}





spring은 객체를 생성 관리 소멸하여 객체의 라이프 사이클을 관리함

의



---

## Spring

![img](Study/Study/md_img/clip_image002.jpg)

* Spring은 자바 언어를 사용하는 어플리케이션을 개발하는 기술
* Spring은 일정한 틀(프로그램 규칙) 내에서 어플리케이션을 개발
* Spring은 어플리케이션 내부에서 필요한 객체를 직접 생성하지 않고 Spring에 서 제공하는 객체를 사용하도록 함(singletonpattern)
* Spring은 객체를 생성 - 관리 - 소멸해 객체의 라이프 사이클을 관리

![image-20200203182928180](Study/Study/md_img/image-20200203182928180.png)

* 객체간의 의존성(dependency)을 표현할 때 결합도(coupling)를 낮춘다



* Spring Core : Spring의 중심적 기능으로 ioc , di 기능을 사용할 수 있다

## IOC /DI

![image-20200203182858034](Study/Study/md_img/image-20200203182858034.png)

![image-20200203182911482](Study/Study/md_img/image-20200203182911482.png)

* Inversion of control
* Dependency Injection
* ioc는 기능, 개념의 의미
  * 프로그래밍 하는 방법은 DI
* Ioc기능에는 DL, DI가 있음
  * DL : 거의 사용하지 않음
  * DI : setter DI, constructor DI
    * 주로 Setter DI를 사용



## ANNOTATION



## AOP

* 공통의 코드는 따로 만들기
* 관점지향 프로그래밍
* 기능을 *핵심비즈니스 기능*과 *공통기능* 으로 구분하고 공통기능을 개발자의 ==코드 밖==에서 필요한 시점에 적용하는 프로그래밍 방법



![image-20200203183015085](Study/Study/md_img/image-20200203183015085.png)





#### AOP 예제1

* 로그인 후 게시물 등록, 게시물 list 출력후 로그아웃

* Main

````java
package aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("aop1/aop.xml");
		
		Member m = factory.getBean("member",Member.class);
		Board b = factory.getBean("board",Board.class);
				
		
		m.login("spring");  //로그인
		b.insertBoard(100); //~번째 게시물 등록
		b.getList(); //List 출력
		m.logout(); //로그아웃
		
	}

}

````

* Board

````java
package aop1;

import java.util.ArrayList;

public class Board {
	
	public Integer insertBoard(int seq) {
		System.out.println(seq+"번째 게시물을 등록합니다");
		return seq;
	}
	public ArrayList<String> getList(){
		System.out.println("게시물 리스트를 출력합니다");
		ArrayList<String> list = new ArrayList<String>();
		list.add("1 : 1번게시물 : 스프링수업중입니다");
		list.add("2 : 2번게시물 : 안드로이드수업중입니다");
		list.add("3 : 3번게시물 : 하둡수업중입니다");
		return list;
	}

}
````

* Member

````java
package aop1;

public class Member {
	public void login(String id) {
		System.out.println(id+"회원님이 로그인 하셨습니다.");
	}
	
	public void logout() {
		System.out.println("회원님이 로그아웃 하셨습니다.");
	}

}


````

* Common (before/after)

  * 공통으로 사용되는 메서드를 모아둔 곳
  *  메소드가 실행될때마다 메소드 시작/끝 출력

  * before after 메소드 사용

````java
package aop1;
import java.util.Date;
import org.aspectj.lang.ProceedingJoinPoint;

public class Common {
	long starttime = System.currentTimeMillis();// 현재시각을 1/1000초 리턴
    
	public void a() {// before
		System.out.println("메소드 시작");
	
	}

	public void b() {// after
		System.out.println("메소드 끝");
	}

	
}

````



* aop.xml  (before/after)
  * before after 메소드 사용

````xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd">

	<bean id="member" class="aop1.Member" />
	<bean id="board" class="aop1.Board" />
	<bean id="common" class="aop1.Common" />

	<aop:config>
		<aop:pointcut expression="execution (public * aop1.*.*(..))" id="pc" />
		<aop:aspect id="aspect1" ref="common">
			<aop:before method="a" pointcut-ref="pc" />
			<aop:after method="b" pointcut-ref="pc" />
		</aop:aspect>
	</aop:config>

</beans>
````

* Common (round)
  * round는 before + after를 합친 것
  * jointpoint(메소드)가 실행되는 이전 이후에 출력할 수 있음

````java
package aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class Common {

	public void c(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("메소드 수행 이전");
			Object returnvalue = joinpoint.proceed();
			System.out.println("메소드 수행 이후");
		} catch (Throwable e) {
			e.printStackTrace();

		} 

	}

}

````

##### ProceedingJoinPoint joinpoint

````java
	public void c(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("메소드 수행 이전");

			Object returnvalue = joinpoint.proceed();
			System.out.println("리턴값 = " + returnvalue);

			System.out.println("" + joinpoint.getTarget());
			System.out.println("" + joinpoint.getArgs());
			System.out.println("" + joinpoint.toLongString());

			System.out.println("메소드 수행 이후");
		} catch (Throwable e) {
			e.printStackTrace();

		} 

	}

````

* `System.out.println("리턴값 = " + returnvalue);`

  * 리턴값 = [1 : 1번게시물 : 스프링수업중입니다, 2 : 2번게시물 : 안드로이드수업중입니다, 3 : 3번게시물 : 하둡수업중입니다]
  * 메소드 수행 후 반환 값을 출력한다

* `System.out.println("" + joinpoint.getTarget());`

  * aop1.Board@6356695f

* `System.out.println("" + joinpoint.getArgs());`

  * [Ljava.lang.Object;@359f7cdf

* `System.out.println("" + joinpoint.toLongString());`

  * execution(public java.util.ArrayList aop1.Board.getList())

  

* aop.xml  (round)

````java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd">

	<bean id="member" class="aop1.Member" />
	<bean id="board" class="aop1.Board" />
	<bean id="common" class="aop1.Common" />

	<aop:config>
		<aop:pointcut expression="execution (public * aop1.*.*(..))" id="pc" />
		<aop:aspect id="aspect1" ref="common">
			<aop:around method="c" pointcut-ref = "pc"/> 
		</aop:aspect>
	</aop:config>

</beans>

````



결과

메소드 시작
spring회원님이 로그인 하셨습니다.
메소드 끝
메소드 시작
100번째 게시물을 등록합니다
메소드 끝
메소드 시작
게시물 리스트를 출력합니다
메소드 끝
메소드 시작
회원님이 로그아웃 하셨습니다.
메소드 끝



## aopExam

 AoP를 이용해 출력하기

 오늘 점심에 뭐먹었어요?
생선을 먹었습니다 야옹야옹
냥이-생선을 먹었군요

오늘 점심에 뭐먹었어요?
사료를 먹었습니다 멍멍
강아지-사료를 먹었군요

오늘 점심에 뭐먹었어요?
당근을 먹었습니다
토끼-당근을 먹었군요

1. animal.xml 파일생성
2. animalAspect 클래스 생성 : 메소드 이름, 구현 - before after ->around
3. 



### Code

