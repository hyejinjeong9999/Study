package chap02;

import java.util.Scanner;

//배열 요소의 모든 값 카피하기
public class Q5_RCopy {

	static void rcopy(int[] a, int[] b) {

		for (int i = 0; i < a.length; i++) {
			a[i] = b[b.length - 1 - i];
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 개수 : ");
		int num = sc.nextInt();
		int a[] = new int[num];
		int b[] = new int[num];

		for (int i = 0; i < b.length; i++) {
			System.out.print(i + "위치의 값 입력");
			b[i] = sc.nextInt();
		}

		rcopy(a, b);


		System.out.println("배열 b");
		for (int bb : b) {
			System.out.print(bb + " ");
		}
		System.out.println();
		System.out.println("배열 a");
		for (int aa : a) {
			System.out.print(aa + " ");
		}

		sc.close();

	}

}
