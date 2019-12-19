package util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MyUtil {

	public static int[] sort(int[] a) {
		int[] num = a.clone();
		// 배열 복사

		for (int i = 0; i < num.length - 1; i++) {

			int min = i;

			for (int j = i + 1; j < num.length; j++) {

				if (num[min] > num[j]) {
					min = j;

				}

			}

			if (i != min) {

				swap(num, i, min);

				// MyUil.swap(num, i, min)의 생략
				// static 같은 클래스기 때문에 가능

				// staitc을 빼면 인스턴스 자원이 됨

				// 인스턴스 자원으로 인식해서 this.swap 으로 인식
				// static은 this를 사용하지 않음

			}

		}

		return num;
	}

	public static void swap(int[] num, int i, int min) {

		int temp = num[i];
		num[i] = num[min];
		num[min] = temp;

	}

	// 두개의 정수를 입력받아 큰 값을 return해주는 max함수

	public static int max(int a, int b) {

		return a >= b ? a : b;

	}

	public static int min(int a, int b) {

		return a <= b ? a : b;

	}

	public static void iteratorPrint(Set<String> list) {
		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			String data = it.next();
			System.out.println(data + "");
		}
	}

	public static void iteratorPrint(List<String> list) {
		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			String data = it.next();
			System.out.println(data + "");
		}
	}
}