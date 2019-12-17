package day02;

public class Test05 {

	public static void main(String[] args) {

		byte num = 127;

		num = (byte) (num + 1);

		System.out.println(num);

		char c = '9';
		System.out.printf("숫자니? %b %n", Character.isDigit(c));
		
		

		System.out.println("abc" + "def");
		// abcdef 스트링병합
		System.out.println(1 + 1 + 2);
		// 4
		System.out.println(1 + 1 + "1");
		// 21 정수연산 + 스트링병합
		System.out.println("1" + 1 + 1);
		// 111

		String r1 = "100" + 1; // 오류x 1001
		// 내부적으로 1을 String으로 변환

		// int r2 = "100" +1; -> 오류 강제형변환 필욜
		int r2 = Integer.parseInt("100") + 1;
		//형변환 
		double r3 = Double.parseDouble("100.5")+1;
		int r4 = (int)(Double.parseDouble("100.5")+1);
		//강제형변환
		
		System.out.printf("r1 = %s , r2 = %d %n", r1,r2);
		System.out.println(r3);
		System.out.println(r4);
		
		System.out.println(Math.PI); //3.14159..
		
		//final 변경 x 변수명이 대문자 -> 상수구나!
		

	}

}
