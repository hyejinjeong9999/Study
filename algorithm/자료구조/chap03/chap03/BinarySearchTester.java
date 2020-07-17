package chap03;
import java.util.*;

class BinarySearchTester{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("요솟수");
        int num = sc.nextInt();
        int arr[] = new int[num];
        System.out.println("오름차순으로 입력하세요");
        for(int i = 0; i<num; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("검색할 값");
        int ky = sc.nextInt();

        int idx = Arrays.binarySearch(arr, ky);

        if(idx<0)
            System.out.println("그 값의요소가 없습니다");
        else
            System.out.println(ky+"은(는) x["+idx+"]에 있습니다");

        sc.close();
        
    }
}