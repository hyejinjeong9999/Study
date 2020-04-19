package chap02;
import java.util.Scanner;
class DayOfYear{

    static int [][] mdays = {
    {31,28,31,30,31,30,31,31,30,31,30,31},
    {31,29,31,30,31,30,31,31,30,31,30,31}
    };

    static int isLeap(int y){
    if(y%4==0 || y%100==0|| y%400==0){
        return 1;
    }
    else return 0;
    }

    static int dayOfYear(int y, int m, int d){
        int days = 0;
        for(int i = 0; i<m-1; i++){
            days += mdays[isLeap(y)][i];
        }
        days +=d;

        
        return days;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("그 해 경과 일 수를 구합니다");
        System.out.println("년");
        int y = sc.nextInt();
        System.out.println("월");
        int m = sc.nextInt();
        System.out.println("일");
        int d = sc.nextInt();
       
       System.out.println( dayOfYear(y, m, d));
       sc.close();
    }
}