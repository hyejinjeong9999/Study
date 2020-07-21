package chap01;
import java.util.*;

public class Q09_SumOf {
    static int sumof(int a, int b) {
        int max = a;
        int min = b;
        int sum = 0;
        if (b > a) {
            max = b;
            min = a;
        }

        for (int i = min; i <= max; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("a 값 입력");
        int a = sc.nextInt();
        System.out.print("b 값 입력");
        int b = sc.nextInt();
        System.out.println( sumof(a, b));
       
        sc.close();
    }

}