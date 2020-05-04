package chap03;
import java.util.Scanner;
class SeqSearchSen{
    //선형검색 - 보초법
    static int seqSearchSen(int arr[], int n, int ky){
        int i = 0; 
        arr[n] = ky;
        
         while(true){
            if(arr[i]==ky) break;
            i++;
        }
        return i==n? -1:i;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("요솟 수");
        int n = sc.nextInt();
        int arr[] = new int[n+1];   ////찾을 값을 넣기 위해 배열 하나를 더 추가
        int ky;
        for(int i = 0; i<n; i++){
            System.out.println("x["+i+"]");
            arr[i] = sc.nextInt();
        }
        System.out.println("검색할 값");
        ky = sc.nextInt();
        int index = seqSearchSen(arr,n,ky);
        if(index==-1) System.out.println("그 값의 요소가 없습니다");
        else System.out.println(ky+"은[는]x["+index+"]에 있습니다");
        sc.close();
    }
}