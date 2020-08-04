package day04;

import java.util.Arrays;

public class Test05 {

	public static void main(String[] args) {

		int[] num = new int[10];
		for (int i = 0; i < num.length; i++) {

		
			
			num[i] = (int) (Math.random() * 20) + 1;
			
			for(int j = 0; j <i; j++) {
				if(num[i]==num[j])	i--;
			}
			
			

			
		

		}

		System.out.println(Arrays.toString(num));

		int[] temp = new int[(num.length) * 2];

		System.out.println();

		System.out.println(Arrays.toString(temp));

		System.arraycopy(num, 0, temp, 0, num.length);

		System.out.println(Arrays.toString(temp));

		num = temp;
		System.out.println(Arrays.toString(num));
		// num이 가르키고 있던 대상은 gc의 대상이 되고
		// num은 temp의 주소를 가르킨다

	}

}
