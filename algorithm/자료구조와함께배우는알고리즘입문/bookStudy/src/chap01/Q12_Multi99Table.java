package chap01;

class Q12_Multi99Table{
    public static void main(String[] args) {

        System.out.printf(" |");
        for(int i = 1; i<=9; i++){
            System.out.printf("%3d",i);
        }
        System.out.println("\n-+--------------------------------");
        
        for(int i = 1; i<=9; i++){
            System.out.printf("%d|",i);
            for(int j = 1; j<=9; j++){
                
                System.out.printf("%3d",i+j);
            }
            System.out.println();
        }
    }
}