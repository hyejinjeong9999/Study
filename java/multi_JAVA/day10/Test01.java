package day10;

public class Test01 {

	public static void main(String[] args) {

		Employee<String> emp1 = new Employee("홍길동", "2019001");
		// T 타입 String으로 할거야

		System.out.println(emp1);
		System.out.println(emp1.number.charAt(3));
		//String 메소드 사용가능

		Employee<Integer> emp2 = new Employee("고길동", 2019002);
		// T타입 Integer로 할거야
		// 래퍼클래스만 올 수 있다
		// <> <- object밖에 안옴
		// int는 object의 자식이 아님 : 객체가 아니라서
		System.out.println(emp2);
		System.out.println(emp2.number.getClass());

		Employee emp3 = new Employee("김길동", 2019003);
		//타입언급 안하면 Object 타입으로 만들어짐

		System.out.println(emp3);
		
		System.out.println(emp3.number.getClass());
	}

}

class Employee<T> {

	String name;

	T number;

	// 무슨 타입으로 할지..
	// T class 없음 -> 오류
	// 제너릭 : 사용할때 알려줄게! 클래스에 <T>입력

	public Employee(String name, T number) {
		super();
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getNumber() {
		return number;
	}

	public void setNumber(T number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", number=" + number + "]";
	}

}