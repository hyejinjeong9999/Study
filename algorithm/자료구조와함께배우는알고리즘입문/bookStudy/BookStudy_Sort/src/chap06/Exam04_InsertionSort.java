package chap06;

import java.util.Scanner;

public class Exam04_InsertionSort {

	static void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int j;
			int tmp = a[i];
			for (j = i; j > 0 && a[j - 1] > tmp; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("단순 삽입 정렬");
		System.out.print("요솟수");
		int nx = sc.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		insertionSort(x, nx);
		
		System.out.println("오름차순 정렬완료");
		for(int i : x) {
			System.out.println(i);
		}

	}

}
