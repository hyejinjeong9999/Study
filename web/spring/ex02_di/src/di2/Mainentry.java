package di2;

public class Mainentry {

	public static void main(String[] args) {

		MessageBeanimpEn en = new MessageBeanimpEn();
		MessageBeanimpKr KR = new MessageBeanimpKr();
		
		en.sayHello("hyejin");
		KR.sayHello("혜진");

	}

}
