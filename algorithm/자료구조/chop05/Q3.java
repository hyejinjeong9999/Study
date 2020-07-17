import java.util.*;
public class Q3 {
    static int gcdArr(int[]arr, int start, int no){
        if (no ==1)
            return arr[start];
        else if (no ==2)
            return gcd(arr[start],arr[start+1]);
        else return gcd(arr[start],gcdArr(arr, start+1, no-1));

    }

    static int gcd(int x, int y){
        if(y==0) return x;
        else return gcd(y,x%y);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("정수 몇개의 최대공약수를 구할까요");
        int num = sc.nextInt();
        int arr[] = new int[num];
        for(int i = 0; i<num; i++){
            System.out.print(i+1+"번째 요소값 입력");
            arr[i] = sc.nextInt();
        }
        System.out.println(gcdArr(arr,0,num));
        
        sc.close();
        
    }

}