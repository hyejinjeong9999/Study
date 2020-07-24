package chap03;

import java.util.Scanner;

public class Exam01_SeqSearch {
	static int seqSearch(int[] x, int num, int ky) { // while로
		int i = 0;

		while (true) { //찾을 때 까지 i 증가

			if (i == num) //검색 실패 : -1을 반환
				return -1;
			
			if (x[i] == ky) //검색 성공 ! 인덱스 값을 반환
				return i;

			i++;
		}

	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("요솟 수 : ");
		int num = sc.nextInt();

		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.println("x[" + i + "]:");
			x[i] = sc.nextInt();
		}

		System.out.println("검색할 값");
		int ky = sc.nextInt();

		int idx = seqSearch(x, num, ky);

		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println(ky + "은[는] x[" + idx + "]에 있습니다");
		sc.close();
	}

}
