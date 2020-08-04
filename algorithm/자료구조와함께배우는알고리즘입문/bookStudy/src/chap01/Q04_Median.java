package chap01;
public class Q04_Median {
    // 세개의 정수 값을 입력하고 중앙 값을 구한 다음 출력
    static int med3(int a, int b, int c) {
        // a>=b
        if (a >= b) {
            // a>b>c
            if (a >= c)
                return b;
            // c>a>b
            else if (c >= a)
                return a;
            // a>c>b
            else
                return c;

            // b>a, a>c
        } else if (a > c)
            return a;
        else if (b > c)
            return c;
        else
            return b;

    }

    public static void main(String[] args) {
        System.out.println("med3(3,2,1)" + med3(3, 2, 1));
        System.out.println("med3(3,2,1)" + med3(3, 2, 2));
        System.out.println("med3(3,2,1)" + med3(3, 1, 2));
        System.out.println("med3(3,2,1)" + med3(3, 2, 3));
        System.out.println("med3(3,2,1)" + med3(2, 1, 3));
        System.out.println("med3(3,2,1)" + med3(3, 3, 2));
        System.out.println("med3(3,2,1)" + med3(3, 3, 3));
        System.out.println("med3(3,2,1)" + med3(2, 2, 3));
        System.out.println("med3(3,2,1)" + med3(2, 3, 1));
        System.out.println("med3(3,2,1)" + med3(2, 3, 2));
        System.out.println("med3(3,2,1)" + med3(1, 3, 2));
        System.out.println("med3(3,2,1)" + med3(2, 3, 3));
        System.out.println("med3(3,2,1)" + med3(1, 2, 3));

    }
}
