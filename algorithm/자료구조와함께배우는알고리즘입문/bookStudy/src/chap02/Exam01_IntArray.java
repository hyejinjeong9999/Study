package chap02;
class Exam01_IntArray{
    
  public static void main(String[] args) {
      
    int[] a= new int[5];
    //배열 a의 각 요소의 자료형은 int 고 a의 자료형은 int[5] 형임 

    a[1] = 37;
    a[2] = 51;
    a[4] = a[1] *2;   //a[4]에 a[1] * 2  =>(37*2)를 대입

    for(int i = 0; i<a.length; i++){
        System.out.println("a["+i+"] "+a[i]);
        //0 37 51 0 74
    }
    
  }  
}