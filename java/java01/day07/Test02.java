package day07;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object a = new Animal();
		// Object 영역것만 사용 가능

		// a.breath >>불가능

		// 다운캐스팅
		((Animal) a).breath();
		// a.breath >>가능

		Animal a2 = new Animal();
		a2.breath();
		Object obj = a2;
		// a2가 animal 타입이지만 obj 타입에 넣어도 오류안남
		// obj는 animal의 부모기 때문에 괜찮

		// Animal temp = obj;
		// > 오류

		Animal temp = (Animal) obj;
		// 다운캐스팅

		temp.breath();

		Dog d = new Dog();
		Object obj2 = d;
		System.out.println(d.kind);
		Animal a3 = (Animal) obj2;
		System.out.println(a3.kind);

		Object obj7; // 자바의 모든 객체 다 넣을수 있어!!
		String msg = "helllo java";
		obj7 = a;
		obj7 = d;
		obj7 = msg; // 스트링타입도 다 가능!

		if (obj7 instanceof Dog)
			System.out.println(((Dog) obj7).kind);
		// String.kind가 됨 -> 오류 다운캐스팅은 위험
		// if문으로 잡기
		if (obj7 instanceof Animal)
			System.out.println(((Animal) obj7).kind);

		if (obj7 instanceof String)
			System.out.println(((String) obj7).toUpperCase());

	}

}
