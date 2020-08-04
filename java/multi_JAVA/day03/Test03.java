package day03;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {

		String name = null;
		int kor = 0;
		int math = 0;

		Scanner scanner = new Scanner(System.in);
		System.out.println("키보드로 이름을 입력하세요");
		name = scanner.nextLine();

		System.out.println("국어 점수를 입력하세요");
		kor = Integer.parseInt(scanner.nextLine());
		// 점수는 int형 nextline은 String 형변환 필요 ->parseInt

		System.out.println("수학 점수를 입력하세요");
		math = scanner.nextInt();
		// nextint는 int형반환

		scanner.nextLine();
		// ->nextInt 후 남아있는 엔터표시 소진시킴 (nextline은 필요없음)

		double avg = (kor + math) / 2.;
		// .을 붙이면 실수값을 갖게됨

		System.out.printf("이름 :  %s 국어 : %d 수학 : %d %n", name, kor, math);
		System.out.println(avg + ":" + (avg >= 80 ? "합격" : "불합격"));

		// 3항연산자의 참,거짓결과의 데이터결과값은 일치해야한다

		scanner.close();
		// 자원반납

		scanner = null;
		// 더이상 사용하지 않는 scanner는 초기화한다!
		   
		return;
	}

}
