package day08;

public abstract class Animal { 
	//추상메소드가 있기때문에 객체생성 불가능
	//Animal에도 abstract에도 써야함

	String kind = "동물의 종류";

	public abstract void breath() ;

	public Animal() {
		super(); // 생략해도 자동호출 됨
	}

	public Animal(String kind) {
		super();
		this.kind = kind;
	}
}
