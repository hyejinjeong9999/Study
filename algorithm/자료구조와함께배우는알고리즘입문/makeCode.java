
import java.util.*;

class MainMakeCode {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 암호 입력 수
        int m = sc.nextInt();// 개수

        String alpha[] = new String[m];

        for (int i = 0; i < m; i++) {
            //alpha에 값을 넣음
            alpha[i] = sc.next();
        }

        Arrays.sort(alpha);
        //alpha를 정렬 (오름차순으로 된 암호를 만들기 위해)
        
        go(n, alpha, "", 0);

        sc.close();
    }

    public static void go (int n, String alpha[], String password, int i){
        if(password.length() == n){
            //password 배열의 길이가 암호 입력수락 같아질 때
            if(check(password)) System.out.println(password);
            //자음개수, 모음개수 확인 -> 개수가 맞으면 출력
            return;
            //아니면 되돌아간다
        }
        if(i>=alpha.length) return;
            //i 의 값이 암호값보다 큰 경우
            //더이상 선택할 알파벳이 없는경우
          
        go(n, alpha, password+alpha[i], i+1);
        //인덱스를 사용하는 경우
        //n,alpha는 그대로 
        //password에는 암호의 첫번째글자
        
        go(n, alpha, password, i+1);
        //인덱스를 사용하지 않는 경우
        //password에 값을 넣지 않고 바로 다음인덱스로 넘어감
        
    } 

    public static boolean check(String password){
       int ja = 0;
       int mo = 0;
       for(char x : password.toCharArray()){
        if(x =='a'||x =='e'||x =='i'||x =='o'||x =='u') mo++;
        else ja++;

       }
       return  ja>=2 && mo>=1;
    }

}