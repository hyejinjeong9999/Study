package chap01;
import java.util.*;
public class Exam05_SumWhile {
    //1부터 n까지의 합
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1부터 n까지의 합");
        System.out.print("n의 값 : ");
        int n = sc.nextInt();
        int sum = 0;
        int i = 1;
        while(i <=n){ //n이하일 때까지 반복
            sum+=i; //sum에서 1부터 증가값 더하기
            i++; //i 증가
        }
        System.out.println("1부터 "+n+"까지의합 : "+sum);

        sc.close();

    }
}