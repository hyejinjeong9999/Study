package School;

public class Teacher extends Person {

	private String subject;

	public Teacher() { //기본생성자
		super();
	}

	public Teacher(String name, int age, String sub) {
		super(name, age);
		
		//this.setName(name);
		//this.setAge(age);
		this.subject = sub;
	}

	public String getSub() {
		return subject;
	}

	public void setSub(String sub) {
		this.subject = sub;
	}

	public void print() {
		super.print();
		System.out.printf("담 당 : %-5s %n",  subject);
	}

}
