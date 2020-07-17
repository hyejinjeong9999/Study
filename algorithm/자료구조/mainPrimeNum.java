import java.util.*;

class MainPrimeNum {

    public static boolean isPrimeNum(int num) {
        if(num<2) return false;
        for(int i = 2; i*i <=num; i++){
            if(num%i==0) return false;
        }
        return true;
    

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int num2 = sc.nextInt();
        for (int i = num; i <= num2; i++) {

            if(isPrimeNum(i)) System.out.println(i);
        }

        sc.close();

    }

   

}