package chap01;
import java.util.*;
public class Q11_Checkdigit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int digit=1;
		do {
			System.out.print("양의 정수 입력");
			a = sc.nextInt();
			
		}while(a <=0);
		
		while(a>10) {
			a /=10;
			digit++;
		
		}
		System.out.println(digit);
		

	}

}
