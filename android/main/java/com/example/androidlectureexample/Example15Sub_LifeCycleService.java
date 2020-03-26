package com.example.androidlectureexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Example15Sub_LifeCycleService extends Service {

    //thread에 바로 runnable 객체를 만들어서 사용

    private Thread myThread;
    public Example15Sub_LifeCycleService() {


    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i("ServiceExam","onCreate() 호출");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Thread가 시작되면 1초동안 잤다가 깨서 Log를 이용해서 숫자 출력
                for(int i = 0; i<10; i++){
                    try{
                        Thread.sleep(1000); //쓰레드를 쿨쿨 재우는거 1000ms = 1s
                        //sleep을 하려고 할대 만약 interrupt가 걸려있으면 Exception이 발생

                        Log.i("ServiceExam","현재 숫자는 : "+i);
                    }catch (Exception e){
                        Log.i("ServiceExam",e.toString());
                         break; //가장 가까운 loop를 벗어나는 키워드  => for문
                    }
                }
            }
        });



        myThread.start();


        Log.i("ServiceExam","onStartCommand() 호출");
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {
        //현재 서비스에 의해서 동작하고 있는 모든 Thread를 종료


        if(myThread !=null && myThread.isAlive()){
            //쓰레드가 존재하고 현재 Thread가 실행중이면
            myThread.interrupt(); //Thread야 상황되면 좀 멈춰봐;;;
        }
        Log.i("onDestroy","onDestroy() 호출");

        super.onDestroy();
    }
}
