package chap02;
import java.util.Scanner;
//배열 요소에 값을 읽어들여역순으로 정렬
public class Q2_ReverseArray {
	//배열 요소를 바꾸는 메서드
	static void swap(int[]a, int idx1, int idx2) {
		System.out.println("arr[ "+idx1+" ]과 arr[ "+ idx2+" ]를 교환합니다");
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	//배열을 역순으로 정렬하는 메서드
	static void reverse(int[] arr) {
		for (int i = 0; i< arr.length/2; i++) {
			swap(arr,i,arr.length-1-i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열 요솟 수");
		int a = sc.nextInt();
		
		int []arr = new int[a];
		
		//배열에 값 넣기
		for (int i = 0; i< a; i++) {
			System.out.print("배열 값"+i);
			arr[i] = sc.nextInt();
		}
		System.out.println("정렬 전");
		for(int num : arr) {
			System.out.print(num+ " ");
		}
		System.out.println();
		//배열 역순 정렬
	
		reverse(arr);
		System.out.println("정렬 후");
		for(int num : arr) {
			System.out.print(num+ " ");
		}
		
	}

}
