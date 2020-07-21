package chap01;

import java.util.*;


public class Exam08_Digits{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.println("두자리의 정수를 입력하세요");
		do {
			System.out.print("a의 값 :");
			a = sc.nextInt();
		} while (a <10 || a>99);

		System.out.println("a는" + a+"입니다");
	
		sc.close();

	}

}