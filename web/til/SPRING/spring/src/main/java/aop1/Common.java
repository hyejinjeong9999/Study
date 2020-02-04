package aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class Common {


	/*
	 * public void a() {// before
	 * 
	 * System.out.println("메소드 시작"); // 년도 월일시로 출력 }
	 * 
	 * public void b() {// after
	 * 
	 * System.out.println("메소드 끝"); }
	 */

	public void c(ProceedingJoinPoint joinpoint) {// round = before + after 수행 전후에같이 실행
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

		} // pointcut 문법으로 선탱한 핵심관심 메소드를 수행

	}

}
