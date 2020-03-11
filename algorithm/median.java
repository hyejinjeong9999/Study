import java.util.Scanner;

class median{

    static int median(int a, int b, int c){
        //1,3,2의 경우
        if(a>=b){ 
            if (b>=c) return b;
            //a>b>c
            else if(a<=c) return a;
            //c>a>b
            else return c;
        } 
        else if(a>c){
            //b>a>c 
            return a;
        }
        else if(b>c) return c; //b>c>a
        else return b;//c>b>a

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(median(a,b,c));    
    }
}