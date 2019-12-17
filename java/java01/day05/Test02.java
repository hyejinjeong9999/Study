package day05;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {

		int[][] t1 = new int[4][3];

		for (int i = 0; i < t1.length; i++) { // 행
			for (int j = 0; j < t1[i].length; j++) { // 열

				System.out.print(t1[i][j]);

			}
			System.out.println();
		}

		System.out.println("------------------");
		for (int i = 0; i < t1.length; i++) {
			System.out.println(Arrays.toString(t1[i]));
		}

		int[][] t2 = { { 1, 3, 3 }, { 4, 5, 6, 7, 8, 9, 10 }, { 1 }, { 9, 8, 7 } };

		for (int i = 0; i < t2.length; i++) {
			System.out.print("{");
			for (int j = 0; j < t2[i].length; j++) {
				System.out.printf(" %d ", t2[i][j]);
			}
			System.out.println("}");

		}

		System.out.println("-------string -> char의 배열로-------");
		// char[]c = new char[5];
		// c[0] = 'A';
		// c[1] = 'B';
		char[] c = { 'A', 'B', 'C', 'D' };

		System.out.println(Arrays.toString(c));

		String a = "abcdefghijklmnopqrstuvwxyz";

		char[] aa = a.toCharArray();

		System.out.println(a);
		System.out.println(Arrays.toString(aa));

		// String의 api

	}

}
