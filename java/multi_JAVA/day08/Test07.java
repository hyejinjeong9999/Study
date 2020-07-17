package day08;

public class Test07 {// 원의 면적을 구하는 circle class

	public static void main(String[] args) {
		Circle_a a = new Circle_a();
		System.out.println(a.cArea(5));
		a.print();
		a.color = "핑크";
		System.out.println(a.color);
		
		Circle_i i = new Circle_i();
		System.out.println(i.cArea(5));
		//i.color = "핑크"; ->오류
		//있지만 상수화처리되서 color 못바꿈
		System.out.println(i.color);

	}

}

class Circle_a extends Shape_a {

	@Override
	public double cArea(double r) {

		return Math.PI * r * r;
	}

}

abstract class Shape_a {
	String color;

	public abstract double cArea(double r);

	public void print() {
	}
	// 추상클래스에 abstract가 아닌 일반 instance자원이 와도 된다

}

interface Shape_i {
	// String color; -> 인스턴스 안됨
	final static String color = "red";
	// 상수화처리된 변수만 가능하다

	double cArea(double r);
	// interface에서는 당연히 abstract만 들어오기때문에 지워도인식
	// public 없애도 public으로만 인식

	// public void print() {} -> 오류
	// 추상메소드만 올 수 있다

}

class Circle_i extends Object implements Shape_i {
//부모가 두개 :  object , shape_i
	@Override
	public double cArea(double r) {
		return Math.PI * r * r;
	}

}
