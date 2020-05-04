package proxypattern;

public class Proxymain {

	public static void main(String[] args) {
		
		//ProxyInter p = new A();
		ProxyInter p = new C();
		B b1 = new B(); //A객체든 C객체든 객체를 실행할 때 공통 실행 내용을 실행하는 객체
		b1.setP(p);
		b1.action();
		
		//b는 a의 대리자
		//a를 실행하려는데 b까지 같이 수행됨
		//a를 실행하면서 b까지 얹어져서 같이 수행
		
		
		
		System.out.println("=========================");
		
		p.action();

	}

}
