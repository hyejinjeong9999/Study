class ch1Practice15 {
    // 왼쪽 아래가 직각인 이등변 삼각형
    static void triangleLB(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 왼쪽 위가 직각인 이등변 삼각형
    static void triangleLU(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 오른쪽 위가 직각인 이등변 삼각형
    static void triangleRU(int n) {
        for (int i = n; i > 0; i--) { // 5 4 3 2 1
            for (int j = 0; j < n - i; j++) // 0 1 2 3 4
                System.out.print(" ");
            for (int k = 0; k < i; k++)
                System.out.print("*");

            System.out.println();
        }
    }

    // 오른쪽 아래가 직각인 이등변 삼각형
    static void triangleRB(int n) {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n - i; k++)
                System.out.print(" ");
            for (int j = 0; j <= i; j++)
                System.out.print("*");

            System.out.println();
        }
    }

    // 피라미드 만들기

    static void spira(int n) {
        for (int i = 0; i < n; i++) {
            for (int k = i; k < n; k++)
                System.out.print(" ");
            for (int j = 0; j <= i*2; j++)
                System.out.print("*");

            System.out.println();
        }
    }

    

    // 숫자 피라미드 만들기

    static void npira(int n) {
        int num=1;
        for (int i = 0; i < n; i++) {
            
            for (int k = i; k < n; k++)
                System.out.print(" ");
            for (int j = 0; j <= i*2; j++)
                System.out.print(num);

            System.out.println();
            num++;
        }
    }

    public static void main(String[] args) {
        // triangleLB(5);
        // triangleLU(5);
        // triangleRU(5);
        // triangleRB(5);
        //spira(4);
        npira(4);
    }
}