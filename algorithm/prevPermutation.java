import java.util.*;


class MainprevPermutation {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int arr[] = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = sc.nextInt();
        }

        prev_permutation(arr);
        sc.close();

    }

    public static void prev_permutation(int arr[]) {
        int i = arr.length - 1;
        int temp = 0;
        while (i > 0 && arr[i-1] <= arr[i]) {
            
            i--;
        }

        if (i <= 0) {
            System.out.println(-1);
            return;
        } 
        
        int j = arr.length-1;
        while(j !=0 && arr[j] >= arr[i-1]){
            j--;
        }

        temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length-1;
        while(i<j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        
    
        
        for(int num = 0; num < arr.length; num++){
            System.out.print(arr[num] + " ");
        }
        
        


        

    }

}