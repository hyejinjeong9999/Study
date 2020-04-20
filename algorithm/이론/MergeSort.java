//일단 반으로 나누고 나중에 합쳐서 정렬하기
public class MergeSort {
    
    static void mergeSort(int[] array) {
        int [] tmp = new int[array.length];
        mergeSort(array,tmp,0,array.length-1);
    }
    static void mergeSort(int[]arr, int[]tmp, int start, int end){
        if(start<end){
            int mid = (start + end) /2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid+1, end);
            merge(arr,tmp,start,mid,end);
        }
    }

    static void merge(int arr[],int[]tmp,int start, int mid, int end){
        for(int i = start; i<=end; i++){
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid+1;
        int index = start;
        while(part1<=mid &&part2<=end){
            if(tmp[part1]<=tmp[part2]){
                arr[index] = tmp[part1];
                part1++;
            }else{
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for(int i = 0; i<=mid - part1; i++){
            arr[index +i] = tmp[part1+i];
        }


    }

    public static void main(String[] args) {
    int array[] = {7,6,4,8,3,5,9,1};
    mergeSort(array);
    for(int i = 0; i<array.length; i++){
        System.out.print(array[i]+" ");
    }
    }

    

}