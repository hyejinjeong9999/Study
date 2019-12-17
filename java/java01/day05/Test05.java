package day05;

public class Test05 {

	public static void main(String[] args) {
		// 지역변수들

		Employee emp1 = new Employee(); // 하드디스크에 있던 Employee 클래스를 메모리에 할당
		emp1.name = "홍길동";
		emp1.dept = "기술부";
		emp1.age = 32;

		Employee emp2 = new Employee();
		emp2.name = "고길동";
		emp2.dept = "교육부";
		emp2.age = 29;

		Employee emp3 = emp1;

		emp1.print();
		emp2.print();
		emp3.print();

		Employee[] employees = new Employee[3];

	}

}

class Employee { // Employee 클래스 생성 publicX 다른 패키지에서 사용 불가능

	String name;
	String dept;
	int age;
	// 데이터
	// 멤버변수 (클래스 안에 있음)

	public void print() {
		// void 반환값 없음
		System.out.printf("[%s,%s,%d] %n", this.name, this.dept, this.age);
		return;
	}
	// 기능

}
