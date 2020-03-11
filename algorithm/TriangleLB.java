import java.util.*;
class TriangleLB{
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int num;

     do{
         System.out.println("몇단 삼각형?");
         num = sc.nextInt();
     }
     while(num<=0);

     for(int i = 0; i<num; i++){
         for(int j = 0; j<=i; j++){
         System.out.print("*");
        
     }
     System.out.println();
    }
 }
}