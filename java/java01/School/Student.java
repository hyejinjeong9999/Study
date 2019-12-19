package School;

public class Student extends Person {
	private String id;

	public Student() {
		super();
	}

	public Student(String name, int age, String stunum) {
		super(name, age);
		//this.setName(name);
		//this.setAge(age);
		// 위의 두 문장을 줄인것 super
		//person의 생성자에서 직접 설정!
		this.id = stunum;
	}

	public String getStunum() {
		return id;
	}

	public void setStunum(String stunum) {
		this.id = stunum;
	}

	public void print() {
		super.print();
		System.out.printf("학 번 : %-5s %n",  id);
	}

}
