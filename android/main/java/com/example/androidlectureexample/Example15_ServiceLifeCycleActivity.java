package com.example.androidlectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Example15_ServiceLifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example15_service_life_cycle);
        //시작
        Button StartServiceBtn = (Button) findViewById(R.id.startServiceBtn);
        StartServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),
                        Example15Sub_LifeCycleService.class);

                i.putExtra("MSG","소리없는 아우성!!");
                startService(i);


            }
        });

        //종료
        Button StopServiceBtn = (Button) findViewById(R.id.StopServiceBtn);
        StopServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Example15Sub_LifeCycleService.class);
                stopService(i);



            }
        });

    }
}
