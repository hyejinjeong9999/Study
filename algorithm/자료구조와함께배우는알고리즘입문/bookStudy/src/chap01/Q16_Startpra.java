package chap01;

import java.util.Scanner;

public class Q16_Startpra {

	static void starPra(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++)
				System.out.print(' ');
			for (int j = 1; j <= (i - 1) * 2 + 1; j++)
				System.out.print('*');
			System.out.println();

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		a = sc.nextInt();

		starPra(a);

		sc.close();

	}
}
