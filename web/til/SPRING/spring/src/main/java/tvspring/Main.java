package tvspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		

		//tvfactory가 아닌 spring으로 위임 ApplicationContext
		
		ApplicationContext factory =  new ClassPathXmlApplicationContext("tvspring/tv.xml");
		//tv.xml에 있는 객체만 
		//메인의 첫 시작은 항상 ApplicationContext
		
		TV tv = factory.getBean("tv",TV.class);
		
		//tv.xml에  아이디가 tv
		
		tv.powerOn();
		tv.SoundUp();
		tv.SoundDown();
		
		tv.powerOff();
		
		TV tv2 = factory.getBean("tv2",TV.class);
		
		tv2.powerOn();
		tv2.SoundUp();
		tv2.SoundDown();
		
		tv2.powerOff();

		
		
		

	}

}
