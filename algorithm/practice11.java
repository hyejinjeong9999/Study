import java.util.*;
class practice11{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int cnt = 0;
        
        do{
            
            num = sc.nextInt(); 
        }

        while(num<0);

        while(num>0){
            num/=10;
            cnt++;
        }

        System.out.println("자릿수 : "+ cnt);

        sc.close();
    }
}