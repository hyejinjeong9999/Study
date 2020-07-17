package day05;

import java.util.Arrays;

public class A_Test01 {

	public static void main(String[] args) {

		int size = 5;

		if (args.length != 0) // 값이 0넘어오지 않는다면
		{
			size = Integer.parseInt(args[0]);
		}

		int[] num = new int[size];

		// 다섯개의 방이 생김 [ ] [] [] [] []

		for (int i = 0; i < num.length; i++) {

			num[i] = (int) (Math.random() * 45) + 1; // 1~45사이의 값

			for (int j = 0; j < i; j++) {

				if (num[i] == num[j]) {
					i--;
					break; // 수행횟수가 달라짐
				}
				// System.out.println(Arrays.toString(num));

			} // 랜덤값 중복시 다시!

		}

		for (int i = 0; i < num.length - 1; i++) {

			int min = i;

			for (int j = i + 1; j < num.length; j++) {

				if (num[min] > num[j]) {
					min = j;

				}

			}

			if (i != min) {

				int temp = num[i];
				num[i] = num[min];
				num[min] = temp;

			}

		}

		System.out.println(Arrays.toString(num));

	}

}
