package chap01;
import java.util.*;
public class Exam03_Median {
    //세개의 정수 값을 입력하고 중앙 값을 구한 다음 출력
    static int med3(int a, int b, int c){
        //a >b 일 경우
        if(a>=b){
            // a>b>c
            if(b>=c)
                return b;
                //b >a > c
            else if(a<=c)
                return a;
                //그 외
            else return c; 
        }
        //a<b일때
        else if(a > c) return a;
        else if(b > c) return c;
    
        else return b;

    }

    
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    System.out.println("세 정수의 중앙 값 구하기");
    System.out.print("a값 : "); 
    int a = sc.nextInt();
    System.out.print("b값 : "); 
    int b = sc.nextInt();
    System.out.print("c값 : "); 
    int c = sc.nextInt();

    System.out.println("중앙값 : "+med3(a, b, c));

    sc.close();
        
    }
    
}