package com.example.androidlectureexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;

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

        Button _01_linearlayoutBtn=
                (Button)findViewById(R.id._01_linearlayoutBtn);
        _01_linearlayoutBtn.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){

                Intent i = new Intent();
                ComponentName cname = new ComponentName
                        ("com.example.androidlectureexample",
                                "com.example.androidlectureexample.Example01_LayoutActivity");
                        //내가 새롭게 호출할 component 패키지명, 클래스(패키지명을 포함한 풀네임)
                i.setComponent(cname);
                //intent가 cname을 가지고 있게 됨
                //=intent가 실행할 클래스를 가지고 있게 됨

                startActivity(i);
                //i에 가지고 있는 (cname) 을 가지고 Activity를 실행시켜라


                ///수정



            }
        });

        Button _02_widgetActivityBtn=
                (Button)findViewById(R.id._02_widgetBtn);
        _02_widgetActivityBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent();
                ComponentName cname = new ComponentName
                        ("com.example.androidlectureexample",
                                "com.example.androidlectureexample.Example02_widgetActivity");
                //내가 새롭게 호출할 component 패키지명, 클래스(패키지명을 포함한 풀네임)
                i.setComponent(cname);


                startActivity(i);




            }
        });


        Button _03_EventBtn = (Button)findViewById(R.id._03_EventBtn);

        _03_EventBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent();
                ComponentName cname = new ComponentName
                        ("com.example.androidlectureexample",
                                "com.example.androidlectureexample.Example03_EventActivity");
                //내가 새롭게 호출할 component 패키지명, 클래스(패키지명을 포함한 풀네임)
                i.setComponent(cname);


                startActivity(i);
            }
        });

        Button _04_ActivityEventBtn = (Button)findViewById(R.id._04_ActivityEvent);
        _04_ActivityEventBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent();
                ComponentName cname = new ComponentName
                        ("com.example.androidlectureexample",
                                "com.example.androidlectureexample.Example04_TouchEventActivity");
                //내가 새롭게 호출할 component 패키지명, 클래스(패키지명을 포함한 풀네임)
                i.setComponent(cname);


                startActivity(i);
            }
        });

        Button _05_SwipeEventBtn = (Button)findViewById(R.id._05_SwipeEventBtn);
        _05_SwipeEventBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent();
                ComponentName cname = new ComponentName
                        ("com.example.androidlectureexample",
                                "com.example.androidlectureexample.Example05_SwipeActivity");
                //내가 새롭게 호출할 component 패키지명, 클래스(패키지명을 포함한 풀네임)
                i.setComponent(cname);


                startActivity(i);
            }
        });

        Button _06_SendMessageBtn = (Button)findViewById(R.id._06_SendMessageBtn);
        _06_SendMessageBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final EditText editText = new EditText(MainActivity.this);


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Activity 데이터 전달");
                builder.setMessage("다음 Activity에 전달할 내용 입력");

                builder.setView(editText);

                builder.setPositiveButton("전달", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent i = new Intent();
                        ComponentName cname = new ComponentName("com.example.androidlectureexample", "com.example.androidlectureexample.Example06_SendMessageActivity");
                        i.setComponent(cname);
                        i.putExtra("sendMSG",editText.getText().toString());

                        startActivity(i);
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
            }
        });

        Button _07_DataFromBtn = (Button)findViewById(R.id._07_DataFromBtn);
        _07_DataFromBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent();
                ComponentName cname = new ComponentName
                        ("com.example.androidlectureexample",
                                "com.example.androidlectureexample.Example07_DataFromBtn");
                //내가 새롭게 호출할 component 패키지명, 클래스(패키지명을 포함한 풀네임)
                i.setComponent(cname);


                startActivityForResult(i,3000);
            }
        });

    } //oncreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==3000 && resultCode==7000){
            String msg = (String)data.getExtras().get("ResultValue");

            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        }
    }
}

