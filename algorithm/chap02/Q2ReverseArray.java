package chap02;
import java.util.*;
class Q2ReverseAray{
    static void swap(int a[], int x1, int x2){
        
        System.out.println("a["+x1+"]과(와) a["+x2 +"]를 교환합니다");
        int temp = x1;
        a[x1] = a[x2];
        a[x2] = temp;
        for (int i = 0; i< a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    static void reverse(int a[]){
        for(int i = 0; i<a.length/2; i++){
            swap(a,i,a.length-1-i);
        }
        System.out.println("역순 정렬을 마쳤습니다");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("값 개수");
        int num = sc.nextInt();
        int array [] = new int[num];
        System.out.println("값 입력");
        for(int i = 0; i<array.length; i++){
            array[i] = sc.nextInt();
            
        }

        reverse(array);

        sc.close();
        
    }
}