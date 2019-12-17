package day03;

public class Test06 {

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			System.out.println("hello java " + i);
		}
		System.out.println("-----------------");

		int sum = 0;

		for (int i = 1; i <= 10; i++) {

			if (i % 2 == 0) {
				System.out.print(i + "  ");
				sum += i;
			}

		}

		System.out.println(sum);

		System.out.println("==========================");
		String name = "홍길동";
		System.out.println(name.charAt(0)+"**");
		String msg = "hello java";

		for(int i=0; i<msg.length();i++) {
			
			System.out.println(msg.charAt(i));
		}
	}

}
