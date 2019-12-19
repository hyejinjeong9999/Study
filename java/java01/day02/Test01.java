package day02;

public class Test01 {
	// 클래스의 구성요소
	// Data(변수) + 기능(함수 + method)
	public static void main(String[] args) {
		// main은 기능임 (메인함수)
		// Data , 메인 내의 데이터는 지역변수 , 초기화 해야 사용이 가능하다
		// 데이터를 저장하기 위해서 '변수' 필요

		// <<기본형>>
		int i = 900;
		// 정수형은 int
		// int i2 = 9999999999999999 >오류 int 범위 밖
		// long i2 = 9999999999999 >오류 자바는 int를 기본형을 잡기 때문에 long표시를 해야함
		long i2 = 99999999999999999l;

		double f = 99.9;
		// 실수형은 double
		// float f2 = f; ->오류, 형변환 안돼서

		char c = 'A';
		// 문자는 char A는 아스키코드로 65 ->char타입은 int형 변환이 가능하다

		int c2 = c; // 'A'의 아스키코드값 65
		// char -> int promotion 자동형변환

		int c3 = 97;
		// char c4 = c3; //오류 4바이트(int)가 2바이트(char)로 가려고함 ->데이터손실발생

		char c4 = (char) c3; // 해결책 강제형변환 casting ->소문자'a'출력
		// int -> char casting 강제형변환

		// 알아두기 : 대소문자의 값차이는 32

		System.out.println("============");
		System.out.printf("1/2= %d %n", 1 / 2);
		// 정수연산 ->결과는 정수값 = 0
		System.out.printf("1/2= %.2f %n", 1 / 2.);
		// 1/2.0 -> 실수연산 결과값 'f'로
		System.out.println("============");

		boolean b = true;
		// 참거짓은 boolean 불리안은 형변환이 불가능함

		System.out.printf("%d %f %c %b %n", i, f, c, b);
		System.out.printf("%s %s %s %s %n", i, f, c, b);
		// 문자들은 Stirng화가 가능하다
		System.out.printf("i=%d f=%.2f c=%c b=%b %n", i, f, c, b);
		// 다양한 형식 가능

		// <<참조형>>
		String name = "홍길동";
		System.out.println(name);
		// 문자열은 String -> Reference타입
		// reference타입은 .가 가능하다

	}

}
