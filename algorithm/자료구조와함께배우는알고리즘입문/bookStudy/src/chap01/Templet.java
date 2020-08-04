package chap01;

import java.util.*;

public class Templet{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;

		do {
			System.out.print("a의 값 :");
			a = sc.nextInt();
		} while (a <= 0);

		
		sc.close();

	}

}