import java.util.*;
public class Factorial {
    
    static int factorial(int num){
        if(num<=1) return num;
        else return factorial(num-1)*num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(factorial(num));
        
        sc.close();
    }
}