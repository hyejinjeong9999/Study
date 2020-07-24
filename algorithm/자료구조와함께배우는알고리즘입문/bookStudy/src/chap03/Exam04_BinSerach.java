package chap03;

import java.util.Scanner;

public class Exam04_BinSerach {
	static int binsearch(int[] x, int num, int ky) { // 배열, 크기, 찾을값 가져옴
		int pl = 0; // 첫 인덱스
		int pr = num - 1; // 끝 인덱스

		do {
			int pc = (pl + pr) / 2; // 중앙 인덱스
			
			if (x[pc] == ky) // 중앙 인덱스가 찾는값이면 중앙 인덱스 출력
				return pc;
			
			else if (x[pc] < ky) // 찾는 값이 중앙값보다 크면
				pl = pc + 1; // 첫인덱스 = 중앙값+1 ~끝 (뒷부분 탐색)
			
			else // 찾는 값이 중앙값보다 작으면
				pr = pc - 1; // 끝인덱스 = 중앙값-1 첫인덱스~중앙-1 (앞부분 탐색)
		} while (pl <= pr); // 첫인덱스가 끝인덱스보다 작을때까지

		return -1; // 검색 실패일경우 -1

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num;
		System.out.println("요솟수");
		num = sc.nextInt();
		int x[] = new int[num];
		System.out.println("오름차순으로 입력하세요");

		System.out.println("x[0]");
		x[0] = sc.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.println("x[" + i + "] :");
				x[i] = sc.nextInt();

			} while (x[i] < x[i - 1]); //바로 앞 요소보다 크게
		}

		System.out.println("검색할 값 : ");
		int ky = sc.nextInt();

		int idx = binsearch(x, num, ky);

		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println(ky + "은(는)[" + idx + "]에 있습니다");

		sc.close();

	}

}
