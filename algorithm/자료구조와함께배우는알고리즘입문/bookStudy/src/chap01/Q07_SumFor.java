package chap01;
import java.util.*;
class Q07_SumFor{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력");
        int num = sc.nextInt();
        String sumString="1";
        int sum=1;
        for(int i = 2; i<= num; i++){
            sumString += " + "+i;
            sum+=i;
        }
        System.out.println(sumString+" = "+sum);
        
        sc.close();
    
    }
    
}