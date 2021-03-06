package chap02;

import java.util.Random;
import java.util.Scanner;

//난수값으로 임의로 배열 요소에 값 넣기
public class Exam05_MaxOfArrayRand {
	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println("키의 최대값을 구하기");
		System.out.print("사람 수 :");
		int a = sc.nextInt();

		int[] height = new int[a];
		for (int i = 0; i < a; i++) {
			// 100 + 0부터 89사이의난수
			height[i] = 100 + rand.nextInt(90);
			System.out.println("height[" + i + "] :" + height[i]);

		}

		System.out.println("가장 큰 키는 " + maxOf(height) + "입니다");

		sc.close();

	}

}
