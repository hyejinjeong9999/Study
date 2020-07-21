package chap01;
import java.util.*;

public class Q08_SumGauss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 값 입력");
        int i = sc.nextInt();
        int num1 = i+1;
        int num2 = i/2;
        int num3 = i % 2 == 0? 0 : (i/2)+1;
        System.out.println((num1 * num2)+num3) ;
    
        sc.close();
    }
}