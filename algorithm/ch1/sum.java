package ch1;
import java.util.*;

class sum {

    static int sumof(int a, int b){
        if(a>b){
            int temp = a;
            a = b;
            b = temp;
        }
        int total = 0;

        for(int i = a; i<=b; i++){
            total +=i;
        }
     return total;
        
            
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;

        
            a = sc.nextInt();
            b = sc.nextInt();
        
        System.out.println(sumof(a, b));

        sc.close();
    }
}