package chap05;

import java.util.Scanner;
import java.util.Stack;

public class Exam03_Recur {

	static void recur(int n) {
		if (n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);
		}
	}

	static void recurX(int n) {
		Stack<Integer> s = new Stack<Integer>();

		while (true) {
			if (n > 0) {
				s.push(n);
				n = n - 1;
				continue;
			}

			if (!(s.isEmpty())) {
				n = s.pop();
				System.out.println(n);
				n = n - 2;
				continue;
			}
			break;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력");
		int x = sc.nextInt();
		// recur(x);
		recurX(x);
		sc.close();
	}

}
