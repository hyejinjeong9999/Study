
package ch2;
import java.util.Scanner;

class PysicalExamination{
    static final int VMAX = 21;

    static class PhyscData{
        String name;
        int height;
        double vision;

        PhyscData(){}

        PhyscData(String name, int height, double vision){
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

    }
    //키의 평균 값 구하기
    static double aveHeight(PhyscData[] dat){
        double sum = 0;
        for(int i = 0; i<dat.length; i++)  
            sum+=dat[i].height;
 
        return sum / dat.length;
        }

    //시력 분포를 구함
    static void disVision(PhyscData[] dat, int[]dist){
        int i = 0;
        dist[i] = 0;
        for(i = 0; i<dat.length; i++){
            //입력한 값만큼
            if(dat[i].vision>=0.0 && dat[i].vision <=VMAX/10.0)
            //시야가 0보타 크고 시야가 2.1보다작아야함
                dist[(int)(dat[i].vision * 10)]++; 
                //시력 : 0.3 * 10 = 3>  dist[3]에 값 저장
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PhyscData[] x = {
            new PhyscData("박현규",162,0.3),
            new PhyscData("함진아",173,0.7),
            new PhyscData("최윤미",175,2.0),
            new PhyscData("홍연의",171,1.5),
            new PhyscData("이수진",168,0.4),
            new PhyscData("김영준",174,1.2),
            new PhyscData("박용규",169,0.8),
        };

        int [] vdist = new int[VMAX];
        //                  0.0~ 2.0

        System.out.println("---신체검사 리스트---");
        System.out.println("이름      키     시력");
        System.err.println("--------------------");
        for(int i = 0; i<x.length; i++){
            System.out.printf("%-8s%3d%5.1f\n",x[i].name,x[i].height,x[i].vision);
            //8글자 (뒤로공백), 3글자, 5글자,소숫점1글자
        }

        System.out.printf("\n평균키 : %5.1fcm\n", aveHeight(x));

        disVision(x, vdist);

        System.out.println("\n시력 분포");
        for(int i = 0; i<VMAX; i++)
            System.out.printf("%3.1f~ : %2d명\n",i/10.0, vdist[i]);
            //                                    0.1   
        
            sc.close();
    }

}