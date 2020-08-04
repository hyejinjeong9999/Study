import java.util.*;
class camouflage {

    public static int solutionCamoflage(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i<clothes.length; i++){
          map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }

        for(int val : map.values()){
            System.out.println("val : "+val);
            answer *= (val+1);
           System.out.println("answer : "+answer);
        }
        return answer-1;
    }

    public static void main(String args[]) {

        String clothes1[][] = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
                { "green_turban", "headgear" } };

        String clothes2[][] = { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } };

        System.out.println("정답 : "+solutionCamoflage(clothes1));
        System.out.println("정답 : "+solutionCamoflage(clothes2));

    }

}