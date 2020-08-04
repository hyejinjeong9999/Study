package chap01;
//세개의 정수값 가운데 최댓값 구하는 함수
public class Exam02_Max3m {
   static int max3(int a, int b, int c){
      int max = a;
      if (max <b) max = b;
      if (max <c) max = c;
      return max;

   }
     public static void main(String[] args) {
         
      System.out.println(max3(1, 3, 2));
         
     }
}