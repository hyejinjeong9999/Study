package day07;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d = new Dog();
		d.print();
		System.out.println(d.kind);
		System.out.println(d.getSuperkind()); 
		//main에서는 this super 안되기 때문에  getsuperKind 함수생성

		

	}

}
