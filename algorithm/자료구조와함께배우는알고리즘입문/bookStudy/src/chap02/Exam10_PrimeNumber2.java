package chap02;

//1000 이하의 소수를 나열하는 프로그램
public class Exam10_PrimeNumber2 {

	public static void main(String[] args) {
		int counter = 0;
		int ptr = 0; // 소수 index
		int[] prime = new int[500]; // 소수가 담길 배열

		prime[ptr++] = 2;// 2를 기본으로 넣어줌

		for (int n = 3; n <= 1000; n += 2) {
			int i;
			for (i = 1; i < ptr; i++) { //1인 이유 2를 굳이 넣을 필요가 없어서
				counter++;				//3의 경우에는 for문을 바로 빠져나가고  
				if (n % prime[i] == 0)	//prt == i 를 충족식해셔 prime[2]에 바로 넣어진다
					break;
			}
			if (ptr == i)
				prime[ptr++] = n;
		}

		for (int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		System.out.println("총 나눗셈 횟수 : " + counter);
	}

}
