package ch2;
import java.util.*;
class java{
    static int sumOf(final int a[]) {
        System.out.println("요소 합계 구하기");

        int sum = 0;
        for(int i = 0; i<a.length; i++){
            sum+=a[i];
        }
        return sum;
    }

    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("글자 개수");
        int num = sc.nextInt();
        int arr[] = new int[num];
       
        for(int i = 0; i<arr.length; i++){
            System.out.println("글자입력");
            arr[i] = sc.nextInt();
        }
        System.out.println(sumOf(arr));
        sc.close();
       
  
        
    }

}