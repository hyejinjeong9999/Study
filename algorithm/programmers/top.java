//link : https://programmers.co.kr/learn/courses/30/lessons/42588


class Solution {
    public int[] solution(int[] heights){
        int [] answer = new int[heights.length];
        int num = heights.length-1;

        for(int i = heights.length-1; i>=1; i--){

            for(int j = i-1; j>=0; j--){
                if(heights[i]<heights[j]){
                    answer[num--] = j+1;
                    break;
                }
            }
            
        
        }
        
        return answer; 
    }
}

public class top{
    public static void main(String[] args) {

        int arr1 [] = {6,9,5,7,4};
        int arr2 [] = {3,9,9,3,5,7,2};
        int arr3 [] = {1,5,3,6,7,6,5};

        Solution s1 = new Solution();
       int answer[] =  s1.solution(arr1);
        int answer2[]  = s1.solution(arr2);
        int answer3[] =  s1.solution(arr3);

      for(int i = 0; i< answer.length; i++){
          System.out.println(answer[i]);
      }
      System.out.println("------------");

      for(int i = 0; i< answer2.length; i++){
        System.out.println(answer2[i]);
    }

    System.out.println("------------");

    for(int i = 0; i< answer3.length; i++){
        System.out.println(answer3[i]);
    }

        
    }

}