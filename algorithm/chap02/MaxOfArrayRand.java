package chap02;
import java.util.*;


class MaxOfArrayRand{
    static int max(int a[]){
        int max = a[0];
        for(int i=1; i<a.length; i++){
            if (max<a[i]) max = a[i];
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("키의 최대값을 구합니다");
        int i = rand.nextInt(20);
        System.out.print("사람 수 : "+i);
                
        //int i = sc.nextInt();
       
        int height[] = new int[i];
        for (int k = 0; k<i; k++){
            height[k] = 100+ rand.nextInt(90);
            System.out.println("height["+k+"] : "+height[k]);
        }
        System.out.println("최대 값은 "+max(height)+"입니다");

        sc.close();
    
            }
}