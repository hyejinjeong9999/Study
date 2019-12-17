package day05;

public class Test04 {

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4, 9, 12, 7 };
		// 향상된 for문 write안되고 read만 가능
		for (int data : num) {

			if (data % 2 == 0)
				System.out.print(data);

		}
		System.out.println();
		char[] c = "ABCD".toCharArray();

		for (char data : c) {
			System.out.print(data + " ");
		}

		String[] s = { "hello", "java", "test" };
		
		for(String data : s){
			if(data.charAt(0)=='t')
				System.out.println(data);
			
		}

	}

}
