package chap06;
//Bubble sort ver3
import java.util.Scanner;
public class Exam03_BubbleSort3 {
	//Swap
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	//BubbleSort
	static void bubbleSort(int[]a, int n) {
		int k = 0;
		while(k<n-1) {
			int last = n-1;
			for(int j = n-1; j>k; j--) 
				if(a[j-1]> a[j]) {
					swap(a,j-1,j);
					last=j;
				}
				k=last;
			
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=====Bubble Sort version 1=====");
		System.out.print("¿ä¼Ú ¼ö : ");
		int nx = sc.nextInt();
		int[]x = new int[nx];
		
		for(int i = 0; i< nx; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		
		bubbleSort(x, nx);
		
		System.out.println("=====Sort ASCE Complet=====");
		for(int i : x) {
			System.out.print(i+" ");
			
		}
		
		
		sc.close();
		
	}
}
