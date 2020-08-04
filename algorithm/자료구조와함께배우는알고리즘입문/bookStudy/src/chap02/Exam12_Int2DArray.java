package chap02;

public class Exam12_Int2DArray {
//2차원 배열 출력해보기
	public static void main(String[] args) {
		// 2차원배열 2행 4열 선언
		int[][] x = new int[2][4];

		x[0][1] = 37;
		x[0][3] = 54;
		x[1][2] = 65;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println("x[" + i + "][" + j + "] : " + x[i][j]);
			}
		}

	}

}
