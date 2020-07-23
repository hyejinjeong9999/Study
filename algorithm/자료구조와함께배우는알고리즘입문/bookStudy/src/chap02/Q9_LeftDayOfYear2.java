package chap02;

import java.util.Scanner;

public class Q9_LeftDayOfYear2 {
//그 해 경과 일 수를 구하기
	static int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } // 윤년

	};

	// 윤년 : 1 => 4로 나누어떨어지는 해이면서 100으로 나누어 떨어지고 400으로 나누어 떨어지지 않는 해
	// 평년 : 0
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	// m-1월 일수의 합 +d
	static int leftdayOfYear(int y, int m, int d) {

		int days = d;

		for (int i = 1; i < m; i++) {
			days += mdays[isLeap(y)][i - 1];
		}
		return 365 + isLeap(y) - days;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int retry;
		do {
			System.out.print("년 : ");
			int year = sc.nextInt();
			System.out.print("월 : ");
			int month = sc.nextInt();
			System.out.print("일 : ");
			int day = sc.nextInt();

			System.out.printf("그 해 %d 일 째 입니다 \n", leftdayOfYear(year, month, day));

			System.out.println(" 다시 하시겠 습니까 1. 예 2. 아니오");
			retry = sc.nextInt();
		} while (retry > 0);

		sc.close();
	}

}
