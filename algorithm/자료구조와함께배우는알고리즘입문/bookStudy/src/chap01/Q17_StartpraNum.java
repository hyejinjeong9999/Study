package chap01;

import java.util.Scanner;

public class Q17_StartpraNum {

	static void starPra(int n) {
		int num = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++)
				System.out.print(' ');
			for (int j = 1; j <= (i - 1) * 2 + 1; j++)
				System.out.print(num);
			System.out.println();
			num++;

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
