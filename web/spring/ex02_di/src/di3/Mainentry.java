package di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainentry {

	public static void main(String[] args) {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("di3/applicationCtx.xml");
	//spring 컨테이너 생성됨
	
	MessageBean bean = (MessageBean)ctx.getBean("en",MessageBean.class);
	bean.sayHello("Spring Fun!!");
	
	MessageBean beans = (MessageBean)ctx.getBean("kr",MessageBean.class);
	beans.sayHello("스프링재밌어요!!");
	
	MessageBean bean3 = (MessageBean)ctx.getBean("m2",MessageBean.class);
	bean3.sayHello("nickname");
	//별칭으로 꺼내기
	

	}

}
