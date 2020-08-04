package chap02;

import java.util.Scanner;

//배열 요소의 모든 값 합하기
public class Q3_SumOf {

	static int sumOf(final int a[]) {
		System.out.println("요소 합계 구하기");

		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 개수");
		int num = sc.nextInt();
		int arr[] = new int[num];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("숫자입력");
			arr[i] = sc.nextInt();
		}
		System.out.println(sumOf(arr));
		sc.close();

	}

}
