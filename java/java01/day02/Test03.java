package day02;

public class Test03 {

	public static void main(String[] args) {
		int pw = 0;
		System.out.println(pw);
		// 0
		// 변수명 변경하고 싶을때 블록지정 - refactor - rename

		/*
		 * trim 공백제거 trim (리턴값 String 뒤에 . 사용가능) length (리턴값 int 뒤에 . 사용 불가능)
		 */

		pw = "hello".length();
		// pw = "hello".trim().toUpperCase();

		// pw 인트형 =/= touppercase가 문자열반환 ->오류

		System.out.println(pw);
		// hello의 사이즈 5

		pw = 0;
		System.out.println(pw);
		// 0

		System.out.println(pw > 3);

		System.out.println("============================");

		String msg = null;

		System.out.println(msg);
		// 빈공간 "null"

		msg = "hello java~~~";
		System.out.println(msg);

		String msg2 = msg;
		System.out.println(msg2);

		// String은 주소참조 -> msg2가 msg의 주소를 참조한다

		msg = null;
		msg2 = null;
		// null "빈공간"
		// null을 해줘야 가비지콜렉터의 대상이 된다

	}

}
