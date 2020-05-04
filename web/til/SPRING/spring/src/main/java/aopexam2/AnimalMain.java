package aopexam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		Animal [] ani = new Animal[3];
		//인터페이스라더라도 객채생성 가능 애니멀 타입이 될 수 있는 배열 3개 만글기
		//Animal aa = new Animal; <-오류
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("aopexam/animal.xml");
		
		ani[0] = factory.getBean("cat",Animal.class);
		//==ani[0] = (Animal)factory.getBean("cat");
		
		ani[1] = factory.getBean("dog",Animal.class);
		ani[2] = factory.getBean("rabbit",Animal.class);
		
		for(Animal a : ani) {
			a.lunch();
		}
		
	}

}


