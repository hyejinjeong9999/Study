package School;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student[] s;
		Teacher[] t;
		Employee[] e;

		// 다양한 타입의 객체를 담을 수 있는 person
		// 부모타입의 이점!!
		// 문제점 :
		Person[] persons = { new Teacher("김선생", 35, "JAVA"), new Teacher("홍선생", 37, "sql"),
				new Teacher("고선생", 25, "DB"), new Student("김학생", 21, "201901"), new Student("박학생", 23, "201904"),
				new Employee("김사원", 51, "교학부"),

		};

		// 향상된 for문 연습하기!
		// 콜렉션에가면 써야함.. ㅠ

		for (Person data : persons) {
			data.print();
			// 타입이 안맞음 -> 다운캐스팅 해야함
//
//			if (data instanceof Employee)
//				((Employee) data).print();
//			if (data instanceof Teacher)
//				((Teacher) data).print();
//			if (data instanceof Student)
//				((Student) data).print();
		}

////		Person p1 = new Employee("홍길동", 20, "교무과");
//		Person p2 = new Student("김길동", 23, "2016247");
//		Person p3 = new Teacher("정길동", 40, "수학");
//
//		if (p1 instanceof Person)
//			((Employee) p1).print();
//
//		if (p2 instanceof Person)
//			((Student) p2).print();
//
//		if (p3 instanceof Person)
//			((Teacher) p3).print();
	}

}
