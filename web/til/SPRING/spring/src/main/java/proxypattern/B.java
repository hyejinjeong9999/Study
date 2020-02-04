package proxypattern;

public class B implements ProxyInter {
	
	ProxyInter p = new A();
	//인터페이스는 new 안되기 때문에 상속받은 다른 클래스로 new 해야함



	public void setP(ProxyInter p) {
		this.p = p;
	}
	
	@Override
	public void action() {
		
		System.out.println("B클래스 action 시작");
		p.action();
		System.out.println("B클래스 action 종료");
	}
	

}
