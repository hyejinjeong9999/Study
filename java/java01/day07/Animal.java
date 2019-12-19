package day07;

public class Animal {

	String kind = "동물의 종류";

	public void breath() {
		System.out.println("폐로 숨");
	}

	public Animal() {
		super(); // 생략해도 자동호출 됨
	}

	public Animal(String kind) {
		super();
		this.kind = kind;
	}
}
