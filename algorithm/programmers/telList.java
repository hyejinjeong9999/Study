//https://programmers.co.kr/learn/courses/30/lessons/42577
import java.util.*;
class telSolution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for(int i = 0; i< phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }        

       

        return answer;
    }
}

public class telList{
    public static void main(String[] args) {
        
        telSolution s = new telSolution();

        String []arr1 = {"119", "97674223", "1195524421"}; //false
        String [] arr2 = {"123","456","789"}; //true
        String[] arr3 = {"12","123","1235","567","88"}; //false

        System.out.println(s.solution(arr1));
       System.out.println(s.solution(arr2));
        System.out.println(s.solution(arr3));

    }
}