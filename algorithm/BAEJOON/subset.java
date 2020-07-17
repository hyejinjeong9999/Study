import java.util.*;

class Mainsubset {
   public static void main(String args[]){
    
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int goal = sc.nextInt();
    int arr[] = new int[t];
   
    for(int i = 0; i<t; i++){
        arr[i] = sc.nextInt();
    }
    int total = subset(arr,goal,0,0);
    if(goal==0){
        total -=1;
    }
    System.out.println(total);
sc.close();

}

    static public int subset(int arr[], int goal, int index, int sum){
        if(index==arr.length){
            if(sum == goal) return 1;
            else return 0;
        }

        return subset(arr,goal,index+1,sum+arr[index]) + subset(arr,goal,index+1,sum);
}    }

