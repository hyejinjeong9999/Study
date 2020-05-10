
public class GCDLCM {
static int gcd(int num1, int num2){
   if(num2 == 0) return num1;
    else return gcd(num2,num1%num2);

}

static int gcd(int[]arr){
    if(arr.length<2) return arr[0];
    int result = gcd(arr[0],arr[1]);
    for(int i = 2; i<arr.length; ++i){
        result = gcd(result,arr[i]);
    }
    return result;

}
static int lcm(int num1, int num2){
    return num1*num2 / gcd(num1,num2);
}
    public static void main(String[] args) {

        System.out.println(gcd(20,4));
        System.out.println(lcm(20,4));
        
    }

}