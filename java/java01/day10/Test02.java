package day10;

public class Test02 {

	public static void main(String[] args) {

		Employee2<String, Integer> emp1 = 
				new Employee2("홍길동", 2019001);
		System.out.println(emp1);
		// 박싱/언박싱
		// int와 Integer 사이에서는 형변환이 자유자재로 바뀐다

		Employee2<String, Double> emp2 = 
				new Employee2("박길동", 2019002.0);
		System.out.println(emp2);
		
		Employee2 emp4 = new Employee2("최길동", 2019003);
		System.out.println(emp4);
		System.out.println(emp4.number.getClass());

	}

}

class Employee2<T, P extends Number> {

	// Object name;
	// Object number;
	// Object : 모든타입이 들어오지만 무조건 다운캐스팅이 필요함
	T name;
	P number;

	public Employee2(T name, P number) {
		super();
		this.name = name;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", number=" + number + "]";
	}

}