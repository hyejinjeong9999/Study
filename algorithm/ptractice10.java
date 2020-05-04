import java.util.*;
class practice10{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b;
        do{
            System.out.println("b값입력");
            b = sc.nextInt();
        }while(a>b);

        System.out.println(b-a);
        sc.close();
    }
}