package day07;

public class Fish extends Animal {
	String name;

	public Fish() {// 기본생성자
		super("물고기"); // 자동호출
	}

	public Fish(String name) {// 파라미터1
		super("물고기"); //Animal의 kind 값 변경
		this.name = name;
	}

	public void print() {
		System.out.printf("[%s,%s]%n", kind, name);
	}
	
	@Override //오버라이드 에노테이션 : 문법적으로 오버라이딩 되었는지 확인
	public void breath() {
		System.out.println("아가미로 숨쉬기");   //오버라이딩
	}

}
