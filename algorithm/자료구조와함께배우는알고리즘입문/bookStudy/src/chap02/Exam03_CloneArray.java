package chap02;
class Exam03_CloneArray{
    public static void main(String[] args) {
        int[]a = {1,2,3,4,5};
        int[]b = a.clone();
        //clone는 배열을 복사한다
        b[3] = 0;//한 요소에만 0을 대입
        System.out.print("a = ");
        for(int i = 0; i<a.length; i++)
        System.out.print(" "+a[i]);

        System.out.print("\nb = ");
        for(int i = 0; i< b.length; i++)
        System.out.print(" "+b[i]);
    }
}