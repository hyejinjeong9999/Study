package ch4;

public class Exercise4_10 {

	public static void main(String[] args) {

		int num = 12345;
		int sum = 0;

		int div = 10000;
		int mok;

		for (int i = 0; i < 5; i++) {
			mok = num / div;
			sum += mok;
			num -= mok * div;
			div = div / 10;


		}

		System.out.println("sum=" + sum);

	}

}
