package com.example.androidlectureexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button _01_linearlayoutBtn =
                (Button)findViewById(R.id._01_linearlayoutBtn);

        _01_linearlayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼이 눌리면 이 부분이 실행되요!!
                // 새로운 activity를 찾아서 실행!!
                // 2가지 방식으로 activity를 찾을 수 있는데..
                // explicit방식과 implicit방식이 있어요! (일단 explicit방식부터)
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example01_LayoutActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });

        Button _02_widgetBtn = (Button)findViewById(R.id._02_widgetBtn);
        _02_widgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example02_WidgetActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });

        Button _03_EventBtn = (Button)findViewById(R.id._03_EventBtn);
        _03_EventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example03_EventActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });

        Button _04_ActivityEventBtn = (Button)findViewById(R.id._04_ActivityEventBtn);
        _04_ActivityEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example04_TouchEventActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });

        Button _05_SwipeEventBtn = (Button)findViewById(R.id._05_SwipeEventBtn);
        _05_SwipeEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example05_SwipeActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });

        Button _06_SendMessageBtn = (Button)findViewById(R.id._06_SendMessageBtn);
        _06_SendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // alert창(dialog)를 이용해서 문자열을 입력받고
                // 입력받은 문자열을 다음 activity로 전달

                // 사용자가 문자열을 입력할 수 있는 widget을 일단 하나 생성
                final EditText edittext = new EditText(MainActivity.this);
                // AlertDialog를 하나 생성해야 해요
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Activity 데이터 전달");
                builder.setMessage("다음 Activity에 전달할 내용을 입력하세요");
                builder.setView(edittext);
                builder.setPositiveButton("전달",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 전달을 눌렀을때 수행되는 이벤트 처리작업을 하면되요!
                                Intent i = new Intent();
                                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                                        "com.example.androidlectureexample.Example06_SendMessageActivity");
                                i.setComponent(cname);
                                // 데이터를 전달해서 activity를 시작해야 해요!
                                i.putExtra("sendMSG",edittext.getText().toString());
                                startActivity(i);
                            }
                        });
                builder.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 취소버튼이기 때문에 특별한 이벤트처리를
                                // 할 필요가 없어요!!
                            }
                        });
                builder.show();
            }
        });

        Button _07_DataFromBtn = (Button)findViewById(R.id._07_DataFromBtn);
        _07_DataFromBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example07_DataFromActivity");
                i.setComponent(cname);
                // 새로 생성되는 activity로부터 데이터를 받아오기 위한 용도
                // 두번째 activity가 finish되는 순간 데이터를 받아와요!!

                startActivityForResult(i,3000);
            }
        });

        Button _08_ANRBtn = (Button)findViewById(R.id._08_ANRBtn);
        _08_ANRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example08_ANRActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });

        Button _09_CounterLogBtn = (Button)findViewById(R.id._09_CounterLogBtn);
        _09_CounterLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example09_CounterLogActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });

        Button _10_CounterLogProgressBtn = (Button)findViewById(R.id._10_CounterLogProgressBtn);
        _10_CounterLogProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example10_CounterLogProgressActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });

        Button _11_CounterLogHandlerBtn = (Button)findViewById(R.id._11_CounterLogHandlerBtn);
        _11_CounterLogHandlerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example11_CounterLogHandlerActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });

        Button _12_BookSearchSimpleBtn = (Button)findViewById(R.id._12_BookSearchSimpleBtn);
        _12_BookSearchSimpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example12_SimpleBookSearchActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });

        Button _13_BookSearchDetailBtn = (Button)findViewById(R.id._13_BookSearchDetailBtn);
        _13_BookSearchDetailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example13_DetailBookSearchActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });

        Button _14_ImpliciIntentBtn = (Button)findViewById(R.id._14_ImpliciIntentBtn);
        _14_ImpliciIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example14_ImplicitIntentActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });

        Button _15_ServiceLifeCycleBtn = (Button)findViewById(R.id._15_ServiceLifeCycleBtn);
        _15_ServiceLifeCycleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example15_ServiceLifeCycleActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });










    }    // end of onCreate()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 3000 && resultCode == 7000) {
            String msg = (String)data.getExtras().get("ResultValue");
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        }
    }
}
