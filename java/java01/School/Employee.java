package School;

public class Employee extends Person {

	private String dept;

	public Employee() {
		super();
	}

	public Employee(String name, int age, String part) {
		super(name, age);
		this.dept = part;
	}

	public String getPart() {
		return dept;
	}

	public void setPart(String part) {
		this.dept = part;
	}

	public void print() {
		super.print(); //person에 있는 이름, 나이 출력
		
		System.out.printf("부 서 : %-5s %n", dept);
	}

}
