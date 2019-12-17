package day03;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {

		System.out.println("App 시작...");
		int kor = 0, eng = 0, math = 0;
		String name = null;

		Scanner scanner = new Scanner(System.in);

		System.out.println("성적처리를 종료하려변 quit를 입력하세요");
		String msg = scanner.nextLine();

		if (msg.toLowerCase().equals("quit")) {

			if (scanner != null) {
				scanner.close();
				scanner = null;
			}

			// scanner에 값이 들어있다면자원반납후 종료

			System.out.println("App 종료....");

			return;

		}

		System.out.println("학생이름 국어 영어 수학 점수를 입력하세요");
		System.out.println("ex) 홍길동 90 90 90");

		name = scanner.next();
		kor = scanner.nextInt();
		eng = scanner.nextInt();
		math = scanner.nextInt();
		// 한줄에서 한꺼번에 자료 받음

		// 엔터표시 소진이 안됨 -> nextline 필요
		scanner.nextLine();

		double sum = kor + eng + math;
		double avg = sum / 3;

		System.out.printf("이름 = %s %n", name);
		System.out.printf("국어= %d 영어= %d 수학= %d  ", kor, eng, math);
		System.out.printf("평균 = %.2f %n", avg);

		if (avg >= 80) {
			System.out.println("합격입니다");
		}
		if (avg < 80) {
			System.out.println("불합격입니다");
		}

		scanner.close();
		scanner = null;

		return;

	}

}
