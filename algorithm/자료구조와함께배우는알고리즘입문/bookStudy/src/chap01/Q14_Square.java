package chap01;

import java.util.*;

public class Q14_Square {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단 수 : ");
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
