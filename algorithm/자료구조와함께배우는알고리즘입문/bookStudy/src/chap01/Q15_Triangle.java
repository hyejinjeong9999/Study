package chap01;

import java.util.Scanner;

public class Q15_Triangle {
	static void triangleLB(int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	static void triangleLU(int n) {

		for (int i = n; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	static void triangleRU(int n) {

		for (int i = n; i > 0; i--) {
			for (int k = i; k < n; k++)
				System.out.print(" ");
			for (int j = i; j > 0; j--)
				System.out.print("*");
			System.out.println();

		}

	}

	static void triangleRB(int n) {
		
		for (int i = 0; i < n; i++) {
			for(int k =n; k>i; k--)
				System.out.print(" ");
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		a = sc.nextInt();

		triangleLB(a);
		System.out.println("=============");
		triangleLU(a);
		System.out.println("=============");
		triangleRU(a);
		System.out.println("=============");
		triangleRB(a);
		System.out.println("=============");

		sc.close();

	}
}
