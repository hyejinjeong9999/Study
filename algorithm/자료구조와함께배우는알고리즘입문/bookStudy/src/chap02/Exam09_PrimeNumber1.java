package chap02;

//1000 이하의 소수를 나열하는 프로그램
public class Exam09_PrimeNumber1 {

	public static void main(String[] args) {
		int counter = 0;
		for (int i = 2; i <= 1000; i++) {
			int j;
			for (j = 2; j < i; j++) {
				counter++;
				if (i % j == 0)
					break;
			}
			if (i == j)
				System.out.println(i);
		}
		System.out.println("총 나눗셈 횟수 : " + counter);
	}

}
