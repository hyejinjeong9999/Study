package chap05;

//각 행에 퀸을 1개씩만 배치하는 8퀸
public class Exam06_EightQueen {
	static int[] pos = new int[8]; // 체스판
	static boolean[] flag = new boolean[8]; // 각 행에 퀸을 배치했는지 체크

	// 출력

	static void print() {
		for (int i = 0; i < 8; i++)
			System.out.printf("%2d", pos[i]);
		System.out.println();

	}

	// i열에 퀸 놓기

	static void set(int i) {

		for (int j = 0; j < 8; j++) {
			if (flag[j] == false) { // j행에 아직 퀸을 배치 안한 경우
				pos[i] = j; // 퀸을 j에 배치

				if (i == 7) // 모든 열에 배치를 다 한 경우
					print();
				else {
					flag[j] = true;
					set(i + 1); // 다음 열에 배치
					flag[j] = false;//false로 돌려놓기
				}
			}
		}

	}

	public static void main(String[] args) {
		set(0);

	}

}
