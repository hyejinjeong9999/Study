package chap02;

import java.util.Scanner;

public class Q6_CardConv {
	// x를 r진수로 변환하여 배열 d에 저장한다

	static int cardConvR(int x, int r, char[] d) {

		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x != 0);

		for (int i = 0; i < digits / 2; i++) {
			char temp = d[i];
			d[i] = d[digits - 1 - i];
			d[digits - 1 - i] = temp;
		}

		return digits;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no;
		int cd;
		int dno;
		int retry;
		char[] cno = new char[32];
		do {
			System.out.println("10진수를 기수 변환합니다");
			do {
				System.out.println("변환하려는 음이 아닌 정수 입력");
				no = sc.nextInt();
			} while (no < 0);

			do {
				System.out.println("어떤 진수로 변환할까요? 2~36");
				cd = sc.nextInt();
			} while (cd < 2 || cd > 36);

			dno = cardConvR(no, cd, cno);

			System.out.println(cd + "진수로는");
			for (int i = 0; i < dno; i++) {
				System.out.print(cno[i]);
			}

			System.out.println("입니다");

			System.out.println("한번 더 할까요? 1. 예 / 0. 아니오");
			retry = sc.nextInt();
		} while (retry == 1);

	}

}
