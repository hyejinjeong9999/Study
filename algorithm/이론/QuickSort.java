<<<<<<< HEAD

public class QuickSort {
    // 특정한 값을 기준으로 큰 숫자와 작은 숫자를 서로 교환한 뒤에 배열을 반으로 나눔
    // pivot이라는 기준값을 지정함
    static void quickSort(int array[], int start, int end) {

        if (start >= end)
            return;

        int pivot = start;
        int i = start + 1, j = end, temp;

        // 엇갈릴때까지
        while (i <= j) {
            // 키 값보다 큰 값을 만날 때 까지
            while (i <= end && array[i] <= array[pivot]) {
                i++;
            }
            // 키 값보다 작은 값을 만날 때까지
            while (j > start && array[j] >= array[pivot]) {
                j--;
            }
            if (i > j) {/// 엇갈린 상태면
                temp = array[j];
                array[j] = array[pivot];
                array[pivot] = temp;

            } else { // 엇갈리지 않았다면

                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        quickSort(array, start, j - 1);
        quickSort(array, j + 1, end);

    }

    public static void main(String[] args) {
        int array[] = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

=======
class QuickSort{
    static void quickSort(int[]array, int start, int end){
        if(start>=end) return;
        int temp;
        int point = start;
        int i = start+1;
        int j = end;

        while(i<=j){
        while(i<=end &&array[i]<=array[point]){
            i++;
        }
    
        while(j> start && array[j]>=array[point]){
            j--;
        }
        if(i>j){
            temp = array[j];
            array[j] = array[point];
            array[point] = temp;
        } else{
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        quickSort(array, start, j-1);
        quickSort(array, j+1, end);
        
    }
    }
    public static void main(String[] args) {
        int[]array = {5,10,9,6,1,4,3,8,2,7};
        quickSort(array, 0, 9);
        for(int i = 0; i< array.length; i++){
            System.out.println(array[i]);
        }
        
    }
>>>>>>> 8d9b813a2c325da46fd00997474c2cb0ff0504b2
}