package di5;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainentry {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("di5/applicationCtx.xml");
		// spring 컨테이너 생성됨

		PlayerImp game = ctx.getBean("soccer", PlayerImp.class);
		game.play();
		
		
		PlayerImp game2 = ctx.getBean("baseball", PlayerImp.class);
		game2.play();
		
		
		PlayerImp game3 = ctx.getBean("basketball", PlayerImp.class);
		game3.play();
		
		PlayerImp game4 = ctx.getBean("curling", PlayerImp.class);
		game4.play();
		
		
	

	}

}
