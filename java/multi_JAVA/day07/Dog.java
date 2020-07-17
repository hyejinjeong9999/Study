package day07;

public class Dog extends Animal {
	// Animal을 상속받은 Dog 클래스

	String kind = "강아지 종류";
	String name = "강아지 이름";

	public String getSuperkind() {
		return super.kind;

	}

	public void print() {
		System.out.printf("[%s,%s,%s]%n", super.kind, kind, name);
		// super.kind / this.kind / this.name
		// super : Animal의 하단부부터 접근
		// this : 메모리 하단부 부터 접근
	}

	public Dog() {
		super("강아지");// 동물의 종류animal 세팅
	}

	public Dog(String kind, String name) {
		super("강아지");

		this.kind = kind;
		this.name = name;
	}

}
