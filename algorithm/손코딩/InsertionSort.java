class InsertionSort{

    static void insertionSort(int array[]){
        int temp=0;
        
        for(int i = 0; i< array.length-1; i++){
            int j = i;
            while(j>=0&& array[j]>array[j+1]){
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] =temp;
                j--;
            }
        }
        for(int i = 0; i< array.length; i++){
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) {
        int array[] = {1,10,5,8,7,6,4,3,2,9};
        insertionSort(array);
    }
}