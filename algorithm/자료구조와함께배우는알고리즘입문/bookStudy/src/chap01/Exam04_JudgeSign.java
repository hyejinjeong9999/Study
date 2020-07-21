package chap01;
import java.util.*;
//입력한 정숫값의 부호를 판단해 출력하는 프로그램
public class Exam04_JudgeSign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수값을 입력하세요");
        int n = sc.nextInt();

        if(n>0) System.out.println("이 값은 양수 입니다");
        else if(n<0) System.out.println("이 값은 음수입니다");
        else System.out.println("이 값은 0 입니다");

        sc.close();
    }
}