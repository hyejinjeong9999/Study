import java.util.*;
class player {

    static String solutionPlayer(String[] participant, String[] completion) {
        HashMap<String,Integer> map =  new HashMap<>();

        for(String person : completion){
            map.put(person,map.getOrDefault(person, 0)+1);
            
        }

        for(String person : participant){
            map.put(person, map.getOrDefault(person, 0)-1);
            if(map.get(person)<0) return person;
        }

        return "";
       
    }

    public static void main(String args[]) {

        String[] participant1 = { "leo", "kiki", "eden" };
        String[] completion1 = { "eden", "kiki" };

        String[] participant2 = { "marina", "josipa", "nikola", "vinko", "filipa" };
        String[] completion2 = { "josipa", "filipa", "marina", "nikola" };

        String[] participant3 = { "mislav", "stanko", "mislav", "ana" };
        String[] completion3 = { "stanko", "ana", "mislav" };

        System.out.println("case1"+solutionPlayer(participant1, completion1));
        System.out.println("case2"+solutionPlayer(participant2, completion2));
        System.out.println("case3"+solutionPlayer(participant3, completion3));

    }

}