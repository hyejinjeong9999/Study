package chap02;
import java.util.*;
class cardConv{
   static int cardConvR(int num, int conv, char[] con){
    int i = 0;
    
    String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    do{
        con[i++] = dchar.charAt(num%conv);
        num = num/conv;
        
    }while(num>conv); 
        con[i] = dchar.charAt(num);
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
      result = cardConvR(num,conv,con);
    for(int i = result ; i>=0; i-- ){
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