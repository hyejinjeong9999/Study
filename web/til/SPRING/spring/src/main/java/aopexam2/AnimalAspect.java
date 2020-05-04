package aopexam2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnimalAspect {

	@Pointcut("execution(public * aopexam.*.*(..))")
	public void pc() {
	}

	@Around("pc()")
	public void eating(ProceedingJoinPoint joinpoint) {

		try {
			System.out.println("오늘 점심에 뭐 먹었나요?");
			Object returnValue = joinpoint.proceed();
			System.out.println(returnValue + "를 먹었습니다");
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

}
