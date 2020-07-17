package day04;

import java.util.Arrays;

public class Prob3 {

	/*
	 * Prob3. Prob3 클래스의 main() 에서 주어진 문자열 배열을 생성하여 배열의 내용을 역순으로 출력하할 수 있도록 main
	 * 메서드를 작성하세요.
	 * 
	 * - 문자열 배열의 내용을 역순으로 출력하되 각 문자열 또한 역순으로 출력한다. - 입력으로 주어진 문자열 배열의 예 : {
	 * "Java Programming" , "JDBC", "Oracle10g", "JSP/Servlet" }
	 * 
	 * 처리 결과의 예 : 아래 참고. gnimmargorP avaJ (4)CBDJ(3) g01elcarO (2) telvreS/PSJ (1)
	 */

	public static void main(String[] args) {
		String[] strData = { "Java Programming", "JDBC", "Oracle10g", "JSP/Servlet" };

		String temp = "";
		String[] temp2 = new String[4];

		for (int j = strData.length - 1; j >= 0; j--) {
			for (int i = strData[j].length() - 1; i >= 0; i--) {

				temp += strData[j].charAt(i);
			}
			temp2[(temp2.length - 1) - j] = temp;
			temp = "";

		}
		System.arraycopy(temp2, 0, strData, 0, 4);
		System.out.println(Arrays.toString(strData));

//-------------  연습해보세요~~~  --------

//예제 )문자열 참조변수  msg 가 "yes" 일때 true 인  조건식 

		String msg = "";
		boolean yes = false;

		if (msg.equalsIgnoreCase("yes")) {
			yes = true;
		}
		System.out.println(yes);

//예제) 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때    몇까지 더해야 총합이  100  이상이 되는지 구하시오 .

		int totalSum = 0;
		int j = 0;
		int p = -1;

		while (totalSum < 100) {

			totalSum += j;
			j++;
			p = p * -1;

		}
		System.out.println(totalSum);
		System.out.println(j);

//예제)arr 배열 에 담긴 모든 값을 더하는 프로그램을 완성하시오  .

		int[] arr = { 10, 20, 30, 40, 50 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];
		}

		// TODO arr 배열 에 담긴 모든 값을 더하는 프로그램을 완성

		System.out.println("sum=" + sum);
	}

}
