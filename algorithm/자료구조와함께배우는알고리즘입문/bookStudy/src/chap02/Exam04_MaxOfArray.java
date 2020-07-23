package chap02;

import java.util.Scanner;

public class Exam04_MaxOfArray {
	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("키의 최대값을 구하기");
		System.out.print("사람 수 :");
		int a = sc.nextInt();

		int[] height = new int[a];
		for (int i = 0; i < a; i++) {
			System.out.print("height[" + i + "] : ");
			height[i] = sc.nextInt();
		}

		System.out.println("가장 큰 키는 " + maxOf(height) + "입니다");

		sc.close();

	}

}
