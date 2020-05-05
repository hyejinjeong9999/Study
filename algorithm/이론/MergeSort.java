<<<<<<< HEAD

public class MergeSort {
    static void mergeSort(int []arr){
    int[] tmp = new int [arr.length];
        mergeSort(arr, tmp, 0, arr.length -1 );
    }
    static void mergeSort(int[]arr, int[] tmp, int start, int end){
        if(start < end) {
            int mid = (start + end) /2;
            mergeSort(arr,tmp,start,mid); //배열 앞부분
            mergeSort(arr, tmp, mid + 1 , end ); //배열 뒷부분
            merge(arr, tmp, start, mid, end);
        }
        else return;

    }
    //두개로 나눈 배열을 순서대로 저장
   static void merge(int[]arr,int[]tmp,int start, int mid, int end){
       for(int i = start; i<= end; i++){
           tmp[i] = arr[i];
       }
       int part1 = start; //첫번째 방의 첫번째 idx
       int part2 = mid+1; //두번째 방의 첫번째idx
       int index = start; //결과 배열의idx

       while(part1<=mid && part2 <=end){
           if(tmp[part1] <= tmp[part2]){ //앞이 작으면 앖의 배열 넣기
               arr[index] = tmp[part1];
               part1++;
           }else{
            arr[index] = tmp[part2]; //뒤의 배열이 작으면 뒤의 값 넣기
            part2++;
           }
           index++; 
        }
        //두 배열 중 하나가 다 끝나고 한 배열만 남았을 경우
        for(int i = 0; i<= mid - part1; i++){ //앞쪽데이터 남는만큼 넣기
            arr[index+i] = tmp[part1 + i];      //뒤쪽데이터는 알아서채워짐
        }

   }

    public static void main(String[] args) {
        int arr [] = {1,8,7,6,9,4,3,2,5};
        mergeSort(arr);
        for(int i = 0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    
    }

=======
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

    

>>>>>>> 8d9b813a2c325da46fd00997474c2cb0ff0504b2
}