package ch4;

public class Exercise4_15 {

	public static void main(String[] args) {

		int number = 12321;
		int tmp = number;
		int result = 0; // number 변수 를 거꾸로 변환해서 담을 변수

		while (tmp != 0) {

			result = result* 10 + tmp% 10;
			
			// 0* 10 + 1 = tmp = 1

			tmp /= 10; // 1232
			
			

			if (tmp == 0) {
				tmp = 0;

			}

		}
		if (number == result)
			System.out.println(number + "는 회문수 입니다");
		else
			System.out.println(number + "는 회문수가 아닙니다");

	}

}
