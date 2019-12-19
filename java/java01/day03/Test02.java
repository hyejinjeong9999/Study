package day03;

public class Test02 {

	public static void main(String[] args) {

		System.out.println(1<<0); //1
		System.out.println(1<<1);  //10
		System.out.println(1<<2); //100
		System.out.println(1<<3); //1000
		System.out.println(1<<4); //10000
		
		System.out.println(Integer.MIN_VALUE);  //int형의 최저값
		System.out.println(Integer.MAX_VALUE);  //int형의 최대값
		
		
		System.out.println(1>4 & 4<0); //true false
		System.out.println(1&4);  //0001<->0100 and 비트연산을함
		System.out.println(1|4);  //0001<->0100 or  비트연산을 함
	}

}
