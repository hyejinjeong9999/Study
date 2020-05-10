//배열 a 가운데 a[left] ~ a[right]의 요소를 힙으로 만드는 메서드
//a[left]이외에는 모두 힘상태라고 가정하고 a[left]를 아랫부분의 알맞은 위치로 옮겨 힙상태로 만듦
//downHeap 메서드를 사용해 배열 a를 heap 으로 만든다
//루트(a[0])에 있는 가장 큰 값을 빼내 배열 마지막 요소와 바꾸고 배열의 나머지 부분을 다시 힘으로 만드는 과정을 반복한다
class HeapSort{
    static void downHeap(int a[], int left, int right){

        int temp = a[left]; //루트
        int child;          //큰 값을 가진 노드
        int parent;         //부모

        for(parent = left; parent <(right+1)/2; parent = child){
            //배열0번째가 parent , 배열의 절반까지 이동, 부모는 계속 자식으로 이동
            int cl = parent * 2+1;  //왼쪽자식
            int cr = cl +1;     //오른쪽 자식
            child = (cr<=right && a[cr] > a[cl])? cr:cl;
            //오른쪽자식이 맨 leaf와 크고 오른쪽자식이 왼쪽자식보다크면
         
            if(temp >= a[child]) break;
            //루트가 자식보다 크면 for문 break
            a[parent] = a[child];
            //아니면 parent에 자식값을 넣기
        }
        a[parent] = temp;

    }

    static void heapSort(int[]a, int n){ //heap 정렬
        for(int i = (n-1) /2; i>=0; i--){  //a[i] ~ a[n-1]를 heap으로 만들기
            downHeap(a,i,n-1);
        }
        for(int i = n-1; i>0; i-- ){ 
            int temp = a[0]; //가장 큰 요소와 가장 작은 요소를 교환
            a[0] = a[i];  
            a[i] = temp;  

            downHeap(a,0,i-1); // 가장 큰 요소를 제외하고 다시 정렬
        }

    }
    public static void main(String[] args) {
        int arr[] = {5,8,1,4,9,7,2,10,6,3};
        heapSort(arr, arr.length);
        for(int i = 0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}