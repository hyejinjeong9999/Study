package com.example.androidlectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Example16_ServiceDataTransferActivity extends AppCompatActivity {
    TextView dataFromServiceTV;
    //다른 메소드에서도 사용하기 위해 밖으로 빼낸다
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example16_service_data_transfer);

            //사용할 Component의 Reference 획득
        dataFromServiceTV = (TextView)findViewById(R.id.dataFromServiceTV);

        final EditText dataToServiceET = (EditText)findViewById(R.id.dataToServiceET);

        Button dataToServiceBtn = (Button)findViewById(R.id.dataToServiceBtn);

        //Button에 대한 click event 처리
        //anonymous inner class를 이용해 event 처리리
       dataToServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EditText안에 사용자가 입력한 데이터를 가지고 Service를 시작
                Intent intent = new Intent(getApplicationContext(),Example16_Service.class);
                //콘텍스트,서비스

                //startService는 Activity가 가지고 있는 메소드임 this.startServe()인데 생략한것
                //intent를 이용해 데이터를 전달해야 한다
                //key와 value의 형식으로 데이터를 intent에 붙이기
                intent.putExtra("data",dataToServiceET.getText().toString());
                        //키 : data, 값 : edittext에 잇는 값

                startService(intent); //서비스 시작





            }
        });

    }


    //Service로부터 intent가 도착하면 method가 호출
    @Override
    protected void onNewIntent(Intent intent) {
        //Service가 보내준 결과데이터를 받아서 화면처리한다

        String result = intent.getExtras().getString("RESULT");
        //추출한 결과를 TextView에 세팅해야 한다

        dataFromServiceTV.setText(result);


        super.onNewIntent(intent);

    }
}
