package chap06;

//Bubble sort ver2
import java.util.Scanner;

public class Exam01_BubbleSort {
	// Swap
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// BubbleSort2
	static void bubbleSort(int[] a, int n) {
		int exchg = 0;
		// 배열으 길이만큼 반복
		for (int i = 0; i < n - 1; i++) {
			// 배열 밴 끝에서부터 i일때까지 내려오기
			for (int j = n - 1; j > i; j--)
				// 앞값과 비교해서 앞값이 더 크면 swap
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					//교환 횟수 증가
					exchg++;
				}
			//더이상 교환을 안할때 => 정렬완료일 때 반복문 빠져나가기
			if (exchg == 0)
				break;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("=====Bubble Sort version 1=====");
		System.out.print("요솟 수 : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}

		bubbleSort(x, nx);

		System.out.println("=====Sort ASCE Complet=====");
		for (int i : x) {
			System.out.print(i + " ");
		}

	}
}
