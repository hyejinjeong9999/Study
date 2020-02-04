package annotation.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/aop1/aop.xml");
		
		Member m = factory.getBean("member",Member.class);
		Board b = factory.getBean("board",Board.class);
		
		//공통관심 = 횡단관심 = aspect클래스
		//Common c = factory.getBean("common",Common.class);
		//필요없음 spring에서 알아서 엮어줄것
		
		
		m.login("spring");
		b.insertBoard(100);
		b.getList();
		m.logout();
		
	}

}
