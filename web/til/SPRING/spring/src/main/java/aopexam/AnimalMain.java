package aopexam;

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
			//String s = a.lunch(); - null이나옴 
			//aspect-around 일부를 쓰고 lunch- eating메소드가 사용하고 버림
			//해결책 : eating메소드의 리턴타입을 Object로 주면 리턴이되어 실행 됨
			// 이때 Object o = try 밖 o = ~~는 try 안에 쓰기
			a.lunch();
		}
		
	}

}


