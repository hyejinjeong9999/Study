import java.util.Scanner;

class Main2 {
    public static void main(String[] args) {
        int result = 0;

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int arr[][] = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr[i][j] = sc.nextInt();
            }

        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // 1. ㅁ모양
                if (i + 1 < x && j + 1 < y) {
                    int tmp = arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1];
                    if (tmp > result)
                        result = tmp;
                }
                // 2. ㅡ모양
                if (j + 3 < y) {
                    int tmp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3];
                    if (tmp > result)
                        result = tmp;
                }
                // 3. ㅣ모양
                if (i + 3 < x) {
                    int tmp = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j];
                    if (tmp > result)
                        result = tmp;
                }
                //4. ┌ 모양
                if (i+1<x && j + 2 < y ) {
                    int tmp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i+1][j];
                    if (tmp > result)
                        result = tmp;
                }
                //5. ┘모양
                if (i+1<x && j + 2 < y) {
                    int tmp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i+1][j];
                    if (tmp > result)
                        result = tmp;
                }
                //6. ㄴ모양
                if (i+1<x && j +2 < y) {
                    int tmp = arr[i][j] + arr[i+1][j] + arr[i+1][j + 1] + arr[i+1][j+2];
                    if (tmp > result)
                        result = tmp;
                }
                //7. ㄱ모양
                   
                   if (i+1<x && j + 2 < y) {
                    int tmp = arr[i][j] + arr[i][j+1] + arr[i][j + 2] + arr[i+1][j+2];
                    if (tmp > result)
                        result = tmp;
                }

                   //8. L모양
                   
                   if (i+2<x && j + 1 < y) {
                    int tmp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
                    if (tmp > result)
                        result = tmp;
                }

                    //9. j모양
                   
                    if (i+2<x && j + 1 < y) {
                        int tmp = arr[i+2][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
                        if (tmp > result)
                            result = tmp;
                    }

                   // 10. ┌모양
                    if (i+2<x && j + 1 < y) {
                        int tmp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i][j+1];
                        if (tmp > result)
                            result = tmp;
                    }
                    //11. 7모양
                    if (i+1<x && j + 2 < y) {
                        int tmp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2];
                        if (tmp > result)
                            result = tmp;
                    }
                    //12.ㅜ모양
                    if (i+1<x && j + 2 < y) {
                        int tmp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1];
                        if (tmp > result)
                            result = tmp;
                    }
                    //13.ㅗ모양
                    if (i+1<x && j + 2 < y) {
                        int tmp = arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
                        if (tmp > result)
                            result = tmp;
                    }
                     //14.ㅏ모양
                     if (i+2<x && j + 1 < y) {
                        int tmp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j];
                        if (tmp > result)
                            result = tmp;
                    }
                     //15.ㅓ모양
                     if (i+2<x && j + 1 < y) {
                        int tmp = arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j] + arr[i+2][j+1];
                        if (tmp > result)
                            result = tmp;
                    }
                    //16. 
                    if (i+2<x && j + 1 < y) {
                        int tmp = arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j];
                        if (tmp > result)
                            result = tmp;
                    }
                      //17. 
                      if (i+2<x && j + 1 < y) {
                        int tmp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
                        if (tmp > result)
                            result = tmp;
                    }
                     //18. 
                     if (i+1<x && j + 2 < y) {
                        int tmp = arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1] + arr[i][j+2];
                        if (tmp > result)
                            result = tmp;
                    }

                     //19
                     if (i+1<x && j + 2 < y) {
                        int tmp = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
                        if (tmp > result)
                            result = tmp;
                    }

            }
        }

        sc.close();
        System.out.println(result);
    }
}