package chap02;

import sun.net.www.content.audio.basic;

class PrimeNumber3 {
    public static void main(String[] args) {
        
    
    int counter = 0;
    int ptr = 0;
    int[] prime = new int[500];

    prime[ptr++] = 2;
    prime[ptr++] = 3;

    for(int i = 5; i<=1000; i+=2){  //5 7 9 11 13 15 17
        boolean flag = false;
        for(int k = 1; prime[k]*prime[k]<=i; k++){  //prime :  2 3 5   7 11  13
            counter +=2;                                    // 4 9 25 49 121 169
            if(i % prime[k]==0){  //                           
                flag = true;
                break;
            }
        }

        if(!flag){
            prime[ptr++] = i;
            counter++;
        }

    }

    for(int i = 0; i<ptr; i++){
        System.out.println(prime[i]);
    }
    System.out.println("곱셈 나눗셈 : "+counter);

}
}