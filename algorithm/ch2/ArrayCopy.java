import java.util.*;
class ArrayCopy{

    static void copy(int[]a, int[]b){
        for(int i =0; i < a.length; i++){
            b[i] = a[i];
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num  =  sc.nextInt();
        int a[] = new int[num];
        int b[] = new int[num];

        for(int i = 0; i<a.length; i++){
            a[i] = sc.nextInt();
        }

        copy(a, b);

        for(int i = 0; i<a.length; i++){
            System.out.print("a : "+a[i]);
            System.out.println("b : "+b[i]);
        }

        sc.close();
        
    }
}