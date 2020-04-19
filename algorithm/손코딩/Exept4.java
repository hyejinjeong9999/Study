class Execpt4{
    static void except(int n){
        
      
            for(int j =1; j<=9;j++ ){
                if(!((3*j)%n==0)) {
                System.out.println(3 + " * "+ j+" = "+ 3*j);
                }
            }
    return;

    }
    public static void main(String[] args) {
        except(4);
    }
}