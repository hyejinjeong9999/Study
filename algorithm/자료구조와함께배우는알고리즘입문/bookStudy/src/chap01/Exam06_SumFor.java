package chap01;
import java.util.*;
public class Exam06_SumFor {
    //1부터 n까지의 합
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1부터 n까지의 합");
        System.out.print("n의 값 : ");
        int n = sc.nextInt();
        int sum = 0;
       for(int i = 1; i<=n; i++){
           sum+=i;
       }
        System.out.println("1부터 "+n+"까지의합 : "+sum);

        sc.close();

    }
}