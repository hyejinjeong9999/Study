package chap01;
import java.util.*;
public class Q10_Checkab {
	//두 변수 a,b를 입력받고 b-a를 구하기
	//b는 a보다 무조건 커야함

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		System.out.print("a값 입력 : ");
		a = sc.nextInt();
		//판단방법 2 : while(true)에 if문으로 빠져나간다
		while(true) {
			System.out.print("b값 입력 : ");
			b = sc.nextInt();
			if(a<b) break;
			System.out.println("a보다 더 큰 값을 입력하세요");
		}
		int result = b-a;
		System.out.println(b + " - " +  a + "는 " + result + "입니다");
		
	}
	

}
