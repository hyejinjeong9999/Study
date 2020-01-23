package di4;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainentry {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("di4/applicationCtx.xml");
		// spring 컨테이너 생성됨

		ScoreShowImp show = ctx.getBean("show", ScoreShowImp.class);
		show.print();
		
	

	}

}
