# API

## MATH

#### Math.floor(a)

* 버림

#### Math.abs(a)

* 절대값

#### Math.ceil(a)

* 올림

#### Math.round(a)

* 반올림

* Math.round(a * 100)/100 -> 소수 두번째 자리 까지출력

  ````java
  double pie = 3.14159265358979;
  System.out.println(Math.round(pie)); //결과 : 3
  System.out.println(Math.round(pie*100)/100.0); //결과 : 3.14
  System.out.println(Math.round(pie*1000)/1000.0); //결과 : 3.142
  ````

  > 예를들어 33.777*100을 하면 3377.7가 되겠죠. 여기서 round를 적용시키면 3378이라는 정수가 리턴될것입니다. 여기서 다시 100.0을 나눠주면 실수로 적용되어 나옵니다. (33.78이 나오게 됩니다.) 



## char

#### string.charAt(i)

* 문자열에서 인자로 주어진 값에 해당하는 문자를 리턴한다.

  ````java
  String str = "abcde";
  str.charAt(3); 
  ````

  > 출력 : d



## String

#### String.foramt(a)

*  리턴되는 문자열 형태를 지정하는 함수

  ````java
  double pie = 3.14159265358979;
  double money = 4424.243423;
  System.out.println(String.format("%.2f", pie)); //결과 : 3.14
  System.out.println(String.format("%.3f", pie)); //결과 : 3.142
  System.out.println(String.format("%,.3f", money)); //결과 : 4,424.243
  ````

#### String toUpperCase()

* 모든 문자열을 대문자로 변환

  ````java
  "hello java".toUpperCase();
  
  ````

  > 결과 : HELLO JAVA

#### String toLowerCase()

* 모든 문자열을 소문자로 변환

  ````java
  UPPER CASE TO LOWER CASE.toLowerCase();
  ````

  > 결과 : upper case to lower case

#### String.substring(start,end)

* 시작점에서 끝나는 위치 전의 문자열 반환

* end값을 비워두면 끝까지 출력

  ````java
  String str = "ABCDEFG";
  str.substring(3); 
   //DEFG
  
  str.substring(3, 6); 
  //DEF
  ````

  



## Scanner

````java
import java.util.Scanner;
Scanner scan = new Scanner(System.in);
````

* 문자 입력

  ````java
  scan.nextLine();
  ````

* 숫자 정수 입력

  ````java
  scan.nextInt();
  ````

* 숫자 Double형 입력

  ````java
  scan.nextDouble();
  ````

  

---

반올림 하는 방법

````java
(int)(getTotal() / 3f * 10 + 0.5f) / 10f;
````



> 236 / 3  →78   
>
> 236 / **3f** →78.666664 
>
> 236 / 3f * **10** →786.66664 
>
> 236 / 3f * 10 + **0.5** →787.16664 
>
> **(int)**(236 / 3f * 10 + 0.5) →787
>
> (int)(236 / 3f * 10 + 0.5) / **10** →78
>
>  (int)(236 / 3f * 10 + 0.5) / **10f** →78.7 