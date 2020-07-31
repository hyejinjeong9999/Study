package chap05;
//퀸을 배치하는 모든 조합 나타내기
public class Exam05_QueenB {
	static int[] pos = new int[8]; // 체스판
	// 출력

	static void print() {
		for (int i = 0; i < 8; i++)
			System.out.printf("%2d", pos[i]);
		System.out.println();

	}

	// i열에 퀸 놓기

	static void set(int i) {

		for (int j = 0; j < 8; j++) {
			pos[i] = j; // 퀸을 j행에 배치
			if (i == 7) // 모든 열에 배치를 다 한 경우
				print();
			else
				set(i + 1); // 다음 열에 배치
		}

	}

	public static void main(String[] args) {
		set(0);

	}

}
