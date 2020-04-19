package chap02;
import java.util.*;
class ex06cardConv{
    static int cardConv(int x, int r, char[]d){
        String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String result="";
        int i = 0;
        do{
        result+= str.charAt(x%r);
        x=x/r;
        }while(x>r);
        result+=x%r;
    
    
        for(int k = result.length()-1; k>=0; k--){
            d[i++] = result.charAt(k);
        }
        return i;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int retry;     
        int num;
        int conv;
        char[]con = new char[32];
        int result;
        System.out.println("10진수를 기수 변환합니다");
      do{
        do{
        System.out.println("변환하는 음이 아닌 정수");
        num = sc.nextInt();
      }  while(num<0);

      
      do{
        System.out.println("어떤 진수로 변환할까요? 2~36");
        conv = sc.nextInt();
      } while(conv>36 && conv <2);

      System.out.print(conv +"진수로는 ");
      result = cardConv(num,conv,con);
    for(int i =0 ; i<=result; i++ ){
        System.out.print(con[i]);
    }
    System.out.println("입니다");
    do{
        System.out.println("한번 더 할까요? 1: 예, 2 아니요");
        retry = sc.nextInt();
    }while(retry !=1&&retry !=2);
      
      }while(retry==1);
      sc.close();
    }
}