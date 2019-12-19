package day04;

import java.io.FileInputStream;
import java.util.Scanner;

public class Test01_switch {

	public static void main(String[] args) throws Exception {

		System.out.println("App 시작...");
		int kor, eng, math;
		String name = null;

		Scanner scanner = new Scanner(new FileInputStream("c://lib/score.txt"), "UTF-8");
		// 인코딩타입 직접기술
		// 절대경로.

		name = scanner.next();
		kor = scanner.nextInt();
		eng = scanner.nextInt();
		math = scanner.nextInt();
		// 한줄에서 한꺼번에 자료 받음

		// 엔터표시 소진이 안됨 -> nextline 필요

		double sum = kor + eng + math;
		double avg = sum / 3;

		System.out.printf("이름 = %s %n", name);
		System.out.printf("국어= %d 영어= %d 수학= %d  ", kor, eng, math);
		System.out.printf("평균 = %.2f %n", avg);

		// 평균의 학점처리 ABCDF..

		char grade = 'F';

		switch ((int) avg / 10) {
		// int형과 String만 가능하다

		case 10:
		case 9:
			grade = 'A';
			break; // 항상 빠져나오기

		case 8:
			grade = 'B';
			break;

		case 7:
			grade = 'C';
			break;

		case 6:
			grade = 'D';
			break;

		default: // 그 외의 값 =f
			grade = 'F';
			break; // 생략가능

		}

		switch ((int) grade) {

		case 'A':
			System.out.println("우수한 학점입니다");
			break;

		case 'B':
		case 'C':
		case 'D':
			System.out.println("수고하셨습니다");
			break;

		default:
			System.out.println("재수강해야합니다.");

		}

		System.out.printf("grade %c 학점  %n", grade);

		if (scanner != null)
			scanner.close();
		scanner = null;

		return;

	}

}
