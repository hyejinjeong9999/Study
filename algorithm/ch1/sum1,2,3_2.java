import java.util.*;
class MainSum123_2{
    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-->0){
        int count=0, sum=0; 
        int goal = sc.nextInt();
        System.out.println(go(count, sum, goal));
        }

        sc.close();
    }

    static int go(int count, int sum, int goal){
        //불가능한 경우
        if(sum>goal) return 0;
        //정답 하나를 찾은 경우
        if(sum==goal) return 1;
        int now = 0;

        return now;  
            //1~3을 사용했을때 정답의 개수
        }
       

    }

