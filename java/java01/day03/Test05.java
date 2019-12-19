package day03;

import java.io.FileInputStream;
import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) throws Exception {

		System.out.println("App 시작...");
		int kor = 0, eng = 0, math = 0;
		String name = null;

		Scanner scanner = new Scanner(new FileInputStream("c://lib/score.txt"));
		// 절대경로

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

		// 평균의 학점처리 ABCDF..

		char grade = 'F';

		if (avg >= 90) {
			grade = 'A';
		} else if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 70) {
			grade = 'C';
		} else if (avg >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}

		System.out.printf("grade %c 학점  %n", grade);

		if (scanner != null)
			scanner.close();
		scanner = null;

		return;

	}

}
