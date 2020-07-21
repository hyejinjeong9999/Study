package chap01;
import java.util.*;

class Q01_03MaxMin{
    //네 값의 최댓 값을 구하는 메서드
    static int max4(int a, int b, int c, int d){
        int max = a;
        max = b>max? b : max;
        max = c>max? c : max;
        max = d> max? d:max;
        
        return max; 
    }

    static int min3(int a, int b, int c){
        //세 값의 최솟값을 구하는 메서드
        int min = a;
        min = b<min? b:min;
        min = c<min? c:min;
        return min;
    }

    static int min4(int a, int b, int c, int d){
        //네 값의 최솟값을 구하는 메서드
        int min = a;
        min = b<min? b:min;
        min = c<min? c:min;
        min = d<min? d:min;
        return min;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

       System.out.println( "max4 : "+max4(a, b, c, d));
       System.out.println( "min3 : "+min3(a, b, c));
       System.out.println( "min4 : "+min4(a, b, c,d));

       sc.close();
    }
}