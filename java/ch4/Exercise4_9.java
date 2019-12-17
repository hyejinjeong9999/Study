package ch4;

public class Exercise4_9 {

	public static void main(String[] args) {

		String str = "12345";
		int sum = 0;
		int num = 0;

		for (int i = 0; i < str.length(); i++) {

			num = Integer.parseInt(str.substring(i,i+1));
			sum+=num;
			
			System.out.println(num);
			

		}
		System.out.println("sum =" + sum);

	}

}
