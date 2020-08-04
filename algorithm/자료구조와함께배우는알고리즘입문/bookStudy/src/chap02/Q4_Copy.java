package chap02;

import java.util.Scanner;

//배열 요소의 모든 값 카피하기
public class Q4_Copy {

	  static void copy(int[]a, int[]b){
	        for(int i =0; i < a.length; i++){
	            b[i] = a[i];
	        }

	    }
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("배열의 개수 : ");
	        int num  =  sc.nextInt();
	        int a[] = new int[num];
	        int b[] = new int[num];

	        for(int i = 0; i<a.length; i++){
	        	System.out.println(i+"위치의 값 입력");
	            a[i] = sc.nextInt();
	        }

	        copy(a, b);
	        
	        System.out.println("배열 a");
	        for(int aa : a) {
	        	System.out.print(aa+" ");
	        }
	        System.out.println();
	        System.out.println("배열 b");
	        for(int bb : b) {
	        	System.out.print(bb+" ");
	        }

	      
	        sc.close();
	        
	    }

}
