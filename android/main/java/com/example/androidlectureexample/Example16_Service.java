package com.example.androidlectureexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
//서비스가 존재핮 ㅣ않는다면 Service 생성
//Service를 생성하기 위해서 생성자가 호출된다
//onCreate()가 호출되고 그 다음에 onStartCommand()가 호출되면서 로직처리 시작
//만약 Service 객체가 이미 존재하고 있으면 onStartCommand()만 호출
public class Example16_Service extends Service {
    public Example16_Service() { //생성자
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //기본 3개의 메소드를 오버라이딩한다다

   @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //로직처리를 하는 부분
        //Activity로부터 전달된 intent가 이 method의 인자로 전달
        String data = intent.getExtras().getString("data");
        //data라는 이름으로 집어넣었던(put) 값을 가져온다
        //전달 받음ㄴ 데이터를 이용해 일반적인 로직처리를 진행하기
        //만약 로직처리가 길어지면 activity가 block된다
            //이런 경우를 방지하기 위해 일반적으로 thread를 활용해서 로직처리
        String resultData = data + "를 받았습니다.";
        //이 결과데이터를 Activity에 전달해야한다
        Intent resultIntent = new Intent(getApplicationContext(),
                Example16_ServiceDataTransferActivity.class);
        //결과 값을 intent에 부착
        resultIntent.putExtra("RESULT",resultData);

        //화면이 없는 Service에서 화면을 가지고 있는 Activity를 호출할때 TASK 필요
        //Activity를 새로 생성하는 것이 아니라 메모리에 존재하는 이전Activity를 찾아서 수행
        //  => 플래그 2개를 추가

        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //화면을 보여주게 함
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //activity 찾기
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        startActivity(resultIntent);


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
