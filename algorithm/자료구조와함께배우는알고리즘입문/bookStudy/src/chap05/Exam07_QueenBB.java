package chap05;

//각 행에 퀸을 1개씩만 배치하는 8퀸
public class Exam07_QueenBB {
	static int[] pos = new int[8]; // 체스판
	static boolean[] flag_a = new boolean[8]; // 각 행에 퀸을 배치했는지 체크
	static boolean[] flag_b = new boolean[15]; // /대각선 방향으로 퀸을 배치했는지
	static boolean[] flag_c = new boolean[15]; // \대각선 방향으로 퀸을 배치했는지	// 출력

	static void print() {
		for (int i = 0; i < 8; i++)
			System.out.printf("%2d", pos[i]);
		System.out.println();

	}

	
	// i열에 퀸 놓기

	static void set(int i) {

		for (int j = 0; j < 8; j++) {
			if (flag_a[j] == false&&
				flag_b[i+j] ==false &&
				flag_c[i-j+7]==false) { // j행, 대각선에 아직 퀸을 배치 안한 경우
				pos[i] = j; // 퀸을 j에 배치

				if (i == 7) // 모든 열에 배치를 다 한 경우
					print();
				else {
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] =true;
					set(i + 1); // 다음 열에 배치
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = false;//false로 돌려놓기
				}
			}
		}

	}

	public static void main(String[] args) {
		set(0);

	}

}
