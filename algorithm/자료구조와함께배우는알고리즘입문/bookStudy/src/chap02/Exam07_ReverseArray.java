package chap02;

import java.util.Scanner;

//배열 요소에 값을 읽어들여역순으로 정렬
public class Exam07_ReverseArray {
	static boolean equals(int[] a, int[] b) {
		
		if (a.length != b.length)
			return false;
		else {
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i])
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//배열 값 입력
		
		System.out.println("배열 a의 요솟수");
		int anum = sc.nextInt();
		int a[] = new int[anum];

		for (int i = 0; i < anum; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = sc.nextInt();
		}

		System.out.println("배열 b의 요솟수");
		int bnum = sc.nextInt();
		int b[] = new int[bnum];

		for (int i = 0; i < bnum; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = sc.nextInt();
		}
		
		//함수 호출
		System.out.println("배열 a와 b는" + (equals(a, b) ? "같습니다" : "같지 않습니다"));

		sc.close();

	}

}
