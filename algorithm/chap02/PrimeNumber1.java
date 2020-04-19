package chap02;
 class PrimeNumber1{
    public static void main(String[] args) {
        int counter = 0;
        for(int i = 2; i<=1000; i++){
            int k;
            for(k = 2; k<i; k++){
                counter++;
                if(i%k==0) break;
            }
            if(i==k)
            System.out.println(i);

        }

        System.out.println("나눗셈 횟수"+counter);
    }

 }