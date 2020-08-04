package School;

public class Person {
	private String name;
	private int age;
	// private 처리하는 순간 다른 클래스들 접근 불가능
	// setter/ getter로 접근
	// defalut 같은 패키지
	// public 다른 패키지에서도 사용 가능

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;

	}// 오류를 최소화하기 위해 기본생성자 만들기

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void print() {

		System.out.printf("이  름   :  %-5s 나 이 : %-2d ", this.getName(), this.getAge());

	}// 강제오버라이딩

}
