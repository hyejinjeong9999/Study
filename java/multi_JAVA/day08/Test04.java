package day08;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg1 = "hello";
		String msg2 = "hello";

		System.out.println(msg1 + " " + msg2);
		System.out.println(msg1.equals(msg2));

		Person p1 = new Person("홍길동", 22);
		Person p2 = new Person("홍길동", 33);
		System.out.println(p1 + "" + p2);
		System.out.println(p1.equals(p2));
		System.out.println("이름 " + p1.name.equals(p2.name));
		System.out.println("=====================================");

		System.out.println(msg1.toString()); // hello
		System.out.println(msg2); // hi
		System.out.println(p1.toString()); // 주소값
		System.out.println(p2); // 주소값

		Object obj = p2; // 다 넣을 수 있는 객체 obj
		System.out.println(obj);
		Object obj2 = msg1; // 다 넣을 수 있는 객체 obj
		System.out.println(obj2);
		System.out.println(((Person) obj).name);
		// 이미 오버라이딩 되어있어서 노상관
		obj = msg1;
		System.out.println(((String) obj).toUpperCase());

	}

}

class Person {
	String name;
	int age;

	public Person() { // 기본생성자
		super();
	}

	public Person(String name, int age) { // 파라미터 2개 생성자
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {

		return "" + name + ":" + age; // 안좋은 예 string bulider로 사용해

	}

	@Override
	public boolean equals(Object obj) {
		boolean f = false;
		if (obj instanceof Person) { //person형태의 객체만 파악하겟다
			Person p = (Person) obj;

			if (name.equals(p.name) && age == p.age) {
				f = true;
			}

		}

		return f;
	}

}
