//프로그래머스 - 124나라의 숫자
//https://programmers.co.kr/learn/courses/30/lessons/12899?language=java

//3으로 나누기
//나누어 떨어지면 4

class Solution_124 {
    public static String solution(int n) {

        String result = "";
        int rest = 0;

        while (n > 0) {
            // 3의 배수일때
            rest = n%3;
            n /= 3;
            if(rest ==0) {
                rest = 4;
                n-=1;
            }
            result = rest + result;

        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println("0  " + solution(0));
        System.out.println("1  " + solution(1));
        System.out.println("2  " + solution(2));
        System.out.println("3  " + solution(3));
        System.out.println("4  " + solution(4));
        System.out.println("5  " + solution(5));
        System.out.println("6  " + solution(6));
        System.out.println("7  " + solution(7));
        System.out.println("8  " + solution(8));
        System.out.println("9  " + solution(9));
        System.out.println("10  " + solution(10));
        System.out.println("11  " + solution(11));// 42
        System.out.println("13  " + solution(13));// 111
        System.out.println("21  " + solution(21));
        System.out.println("500000000  " + solution(500000000)); // 421211211121241112

    }
}