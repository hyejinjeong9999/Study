import java.util.*;
class Solution {
    public static void main(String[] args) {
        int array[] = {1,5,2,6,3,7,4};
        int commands[][] = {{2,5,3},{4,4,1},{1,7,3}};
        int first,last,pick;
        
        ArrayList <Integer> answer = new ArrayList<>();
        
        for(int i = 0; i<commands.length; i++){
            ArrayList <Integer> list = new ArrayList<Integer>();
            first = commands[i][0]-1;
            last = commands[i][1];
            pick = commands[i][2]-1;

            for (int j = first; j<last; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer.add(list.get(pick));
            
            System.out.println(answer);

        }
        int result[] = new int[answer.size()];
        for (int i =0; i<answer.size(); i++){
            
            result[i] = answer.get(i);
            System.out.println(result[i]);
        }

    }
}

