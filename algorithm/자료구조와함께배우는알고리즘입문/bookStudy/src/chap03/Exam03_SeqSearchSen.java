package chap03;

import java.util.Scanner;

public class Exam03_SeqSearchSen {
	// 선형검색 - 보초법
	static int seqSearchSen(int arr[], int n, int ky) {
		int i = 0;
		arr[n] = ky; //맨 뒷 값에 찾을 값 넣음

		while (true) {
			if (arr[i] == ky) //만약  ky를 찾는다면 whiel문 빠져나오기 
				break;
			i++;
		}
		return i == n ? -1 : i; 
		//i가 n(맨뒷값)이라면 -1(못찾음) 
		//아니면 i(index값) 반환

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("요솟 수");
		int n = sc.nextInt();
		int arr[] = new int[n + 1]; //// 찾을 값을 넣기 위해 배열 하나를 더 추가
		int ky;
		for (int i = 0; i < n; i++) {
			System.out.println("x[" + i + "]");
			arr[i] = sc.nextInt();
		}
		System.out.println("검색할 값");
		ky = sc.nextInt();
		int index = seqSearchSen(arr, n, ky);
		if (index == -1)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println(ky + "은[는]x[" + index + "]에 있습니다");
		sc.close();
	}

}
