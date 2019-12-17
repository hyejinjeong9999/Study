package day08;

public class Test08 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Object [] ss = {new Circle(), new Rectangle()};
		// 다양한 도형,, 모아서 관리하고 싶어-> 부모타입 필요
		// Object 다 들어갈수 있다 다운캐스팅 필요함

		Drawable[] s = { new Circle(), new Rectangle() };
		// Move호출시 캐스팅 필요함
		for (Drawable data : s) {
			data.draw();
			((Moveable) data).move();
		}

		System.out.println("==========");

		T[] t = { new Circle(), new Rectangle() };
		for (T data : t) {
			data.draw();
			data.move();
			// 캐스팅 없이 쓸 수 있음
		}

	}

}

interface T extends Drawable, Moveable {
	// Drawable과 Moveable을 통합한 T

}

interface Drawable {
	void draw();
	// interface, public 생략 가능
}

interface Moveable {
	void move();
}

class figure3 {

}

class Circle implements T {
	String name = "Circle";

	@Override
	public void move() {
		System.out.println(name + "  이동하기 move");
	}

	@Override
	public void draw() {
		System.out.println(name + "  그리기draw");
	}

}

class Rectangle implements T {
	String name = "Rectangle";

	@Override
	public void move() {
		System.out.println(name + "  이동하기 move");
	}

	@Override
	public void draw() {
		System.out.println(name + "  그리기 draw");
	}

}