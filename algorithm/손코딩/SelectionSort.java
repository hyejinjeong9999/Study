
public class SelectionSort {
    //작은 것을 선택해 맨 앞으로 보내는 알고리즘

    static void selectsort(int []array){
        int temp = 0;
        int index = 0;
        int min;
        

        for(int i = 0; i<array.length; i++){
            min = 9999;
            for (int k = i; k<array.length; k++){
             
                if(min>array[k]){
                    System.out.println(min+" > "+ array[k]);
                    index = k;
                    min = array[k];
                }
            }
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;

        }

        for(int i = 0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int array[] = {1,10,5,8,7,6,4,3,2,9};
        selectsort(array);

 
    }

}