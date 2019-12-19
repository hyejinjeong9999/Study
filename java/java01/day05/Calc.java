package day05;

public class Calc {

	// 실행시킬 땐 public을 사용한다

	public static int add(int a, int b) {
		return a + b;
	}

	public static int add(int... a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	public static double add(double a, double b) {
		return a + b;
	}
	// 메소드 오버로딩

}
