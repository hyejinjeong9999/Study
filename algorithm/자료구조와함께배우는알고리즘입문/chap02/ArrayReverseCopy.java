import java.util.Scanner;

class ArrayReverseCopy{

    static void rcopy(int[]a, int[]b){

        for(int i = 0; i <a.length; i++){
            a[i] = b[b.length-1-i];
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num  =  sc.nextInt();
        int a[] = new int[num];
        int b[] = new int[num];

        for(int i = 0; i<b.length; i++){
            b[i] = sc.nextInt();
        }
        rcopy(a, b);

        for(int i = 0; i<b.length;i++){
            System.out.print("a : " +a[i]);
            System.out.println("b : " + b[i]);
        }

        sc.close();
        
    }
}