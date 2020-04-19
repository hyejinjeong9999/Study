
public class BubbleSort {
    static void bubblesoer(int[]array){
        int temp;
        for(int i = 0; i< array.length; i++){
            for(int k = 0; k<array.length-1-i; k++){
                if(array[k]>array[k+1]){
                    temp = array[k];
                    array[k] = array[k+1];
                    array[k+1]=temp;
                }

            }

        }
        for(int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }

    }
    public static void main(String[] args) {
        int array[] = {1,10,5,8,7,6,4,3,2,9};
        bubblesoer(array);
    }

}