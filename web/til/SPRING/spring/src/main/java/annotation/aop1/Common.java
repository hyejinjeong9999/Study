package annotation.aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // <bean~~>
@Aspect // <aop:aspect id = "c" ref="common">
public class Common {
	// <aop:pointcut expression="~~"> 이런 메소드를 선택해 올거임
	// 이조건에 만족하는 모든 메소드를 pc라고 하겠다
	@Pointcut("execution(public* annotation.aop1.*.*(..))")
	public void pc() {
	} // 내용이 아무것도 없어야 한다

	long starttime = System.currentTimeMillis();// 현재시각을 1/1000초 리턴

	// pc메소드 실행 전에 실행하겟다!
	@Before("pc()") // <aop:before method = "a" ref-pointcut="">
	public void a() {// before

		System.out.println("===메소드호출시각===" + new Date(starttime));
		// 년도 월일시로 출력
	}

	@After("pc()")
	public void b() {// after
		long endtime = System.currentTimeMillis();

		System.out.println("===메소드 실행 소요 시간(1/1000)===" + (endtime - starttime));
	}

	@Around("pc()")
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
