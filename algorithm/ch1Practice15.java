class ch1Practice15{
    static void triangleLB(int n){
        for(int i = 0; i< n; i++){
            for(int j = 0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleLU(int n){
        for(int i = n; i>0; i--){
            for(int j = 0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void triangleRU(int n){
        for(int i = n; i>0; i--){
            for(int j = 0; j<i; j++){
                int num = j;
                while(num>=0){
                    
                    System.out.print(" ");
                    num--;
                    
                }
                System.out.print("*");
            }
            System.out.println();
        }

    }
    static void triangleRB(int n){}
    public static void main(String[] args) {
        //triangleLB(5);
        //triangleLU(5);
        triangleRU(5);
    }
}