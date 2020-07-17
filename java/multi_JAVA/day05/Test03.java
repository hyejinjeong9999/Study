package day05;

import java.util.Arrays;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(args.length); // 0 -> 비어있는 배열
		System.out.println(Arrays.toString(args));

		if (args.length == 0) {// 넘어오지 않았을 경우

			System.out.println("파라미터 넘겨주세요");
			return;

			// 파라미터가뭐얌

		}
		System.out.println(args[0].charAt(0) + "**");
		// args가 뭐야

		int[] num = new int[] { 9, 7, 1, 2, 3 };
		System.out.println(Arrays.toString(num));

		// 실직적으로 참조하는 실제 메모리는 하나
		// 둘이 같은 주소를 참조한다
		// 콜바이레퍼런스
		// num2값을 바꿔도 num값이 같이 바뀐다

		int[] num2 = num;
		int[] num3 = num.clone();
		num2[2] = 99;
		Arrays.sort(num3);

		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(num2));
		System.out.println(Arrays.toString(num3));

	/* 	String ur1 = "http://myweb/admin/login.do";
		String sub = ur1.substring(ur1.indexOf('m'), ur1.indexOf('/'));
		System.out.println(sub);
		sub = ur1.substring(13, 18);
		System.out.println(sub);
		sub = ur1.substring(19, 24);
		System.out.println(sub);*/

	}

}
