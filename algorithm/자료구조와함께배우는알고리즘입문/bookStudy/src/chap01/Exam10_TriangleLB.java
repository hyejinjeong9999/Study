package chap01;

import java.util.Scanner;

public class Exam10_TriangleLB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		String star="";
		System.out.println("몇단삼각형입니까");
		a = sc.nextInt();
		
		for(int i = 0; i<a; i++) {
			star+="*";
			System.out.println(star);
		}
		
		

		sc.close();

	}

}
