package chap02;
import java.util.*;
class MaxOfArray{
//배열 요소의 최대값을 구하는 클래스
static int maxOf(int[]a){
    int max = a[0];
    for(int i = 1; i< a.length; i++){
        if(max<a[i]) max = a[i];
        
    }
    return max;    

}    

public static void main(String[] args) {
        System.out.println("키의 최댓값을 구합니다");
        Scanner sc = new Scanner(System.in);
        System.out.println("사람 수 입력");
        int cnt = sc.nextInt();
        int height[] = new int[cnt];
        
         
        for(int i = 0; i<cnt; i++){
            height[i] =  sc.nextInt();
            System.out.println("height["+i+"] : "+height[i]);
        }

        System.out.println("가장 큰 키 구하기");

 
        System.out.println("최대값은 "+maxOf(height)+"입니다");        

        sc.close();
        
    }

}