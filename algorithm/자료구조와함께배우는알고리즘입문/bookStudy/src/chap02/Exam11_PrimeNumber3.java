package chap02;

//1000 이하의 소수를 나열하는 프로그램
public class Exam11_PrimeNumber3 {

	public static void main(String[] args) {
		int counter = 0;
		int ptr = 0; // 소수 index

		int[] prime = new int[500]; // 소수가 담길 배열

		prime[ptr++] = 2;// 2,3를 기본으로 넣어줌
		prime[ptr++] = 3;

		for (int n = 5; n <= 1000; n += 2) { // 대상은 홀수
			boolean flag = false; //합성수 판단하기 위한 변수
			//n의 제곱 이하의 소수로 안떨어짐 => 소수* 소수 <= 판단값 
			for (int i = 1; prime[i] * prime[i] <= n; i++) { 
				counter += 2; // 곱셈, 나눗셈 카운트

				if (n % prime[i] == 0) {//만약 판단값 % 소수 = 0 이면  => 소수x
					flag = true;
					break;
				}
			}
			if (!flag) {// => 소수가 아닌 경우
				// prime[i] * prime[i] <=n 이 성립하지 않는 경우
				// 프로그램 흐름이 안쪽 for문의 루프 본문으루 들어가지 않아서
				// 곱셈 한번 한 것이 count 되지 않음

				prime[ptr++] = n;
				counter++;
			}

		}

		for (int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		System.out.println("총 곱셈나눗셈 횟수 : " + counter);
	}

}
