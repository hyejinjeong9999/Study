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
}