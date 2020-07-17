import java.util.*;

class MainLotto2 {
    static ArrayList <Integer>list = new ArrayList<>();
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            int t = sc.nextInt();
            if(t==0)break;
            int arr[] = new int[t];
            for(int i = 0; i< t; i++){
                arr[i] = sc.nextInt();
            }

            go(arr,0,0);
            System.out.println();

        }
       sc.close();
    }

    public static void go(int arr[], int index, int cnt) {
        if(cnt==6){
            for(int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        
        if(arr.length==index) return;

        list.add(arr[index]);
        go(arr,index+1,cnt+1);
        list.remove(list.size()-1);
        go(arr,index+1,cnt);


    }
}