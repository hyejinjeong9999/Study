package chap01;

import java.util.*;

//do while을 이용해서 유효값만 받기
public class Exam07_SumForPos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int sum = 0;
		do {
			System.out.print("a의 값 :");
			a = sc.nextInt();
		} while (a <= 0);

		for (int i = 1; i < a; i++) {
			sum+=i;
		}
		System.out.println("1부터 " + a + "까지의 값은" + sum + "입니다");
		sc.close();

	}

}