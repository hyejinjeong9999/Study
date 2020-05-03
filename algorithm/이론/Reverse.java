import java.util.Scanner;
public class Reverse {

    static String reverse(String str){
        String result="";

        for(int i = str.length()-1; i >= 0; i--){
            result+=str.charAt(i);
        }
        //StringBuffer로
        //StringBuffer sb = new StringBuffer();
        //sb.append(str);
        //sb.reverse();

        return result;
    }   
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println("입력"+str);
        System.out.println(reverse(str));

        scanner.close();
    }

}