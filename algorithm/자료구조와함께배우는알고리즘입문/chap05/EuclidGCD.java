import java.util.Scanner;

public class EuclidGCD {


    static int gcd(int x ,int y){

        if(y==0) return x;
        else return gcd(y,x%y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("두 정수의 최대 공약수를 구합니다");
        System.out.print("정수1 입력");
        int x = sc.nextInt();
        System.out.print("정수2 입력");
        int y = sc.nextInt();

        System.out.println(gcd(x,y));
        sc.close();
    }
}