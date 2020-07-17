import java.util.Arrays;
import java.util.Comparator;

//프로그래머스
//https://programmers.co.kr/learn/courses/30/lessons/42746
class MaxNum {
    public static String maxNum(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
               System.out.println( (o2+o1).compareTo(o1+o2));
               

                return (o2+o1).compareTo(o1+o2);
            }

        });

        if(arr[0].startsWith("0")){
            answer = "0";
        }else{
            for(int i = 0; i< arr.length; i++){
                answer += arr[i];


                
            }
        }


        return answer;

    }

    public static void main(String[] args) {
        int arr[] = { 6, 10, 2 };
     //   int arr2[] = { 3, 30, 34, 5, 9 };

        System.out.println(maxNum(arr));
   //     System.out.println(maxNum(arr2));

    }

}