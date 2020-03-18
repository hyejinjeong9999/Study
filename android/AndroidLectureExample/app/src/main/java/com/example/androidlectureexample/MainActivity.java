package com.example.androidlectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                //버튼이 눌리면 이 부분이 실행되요
                //새로운 activity를 찾아서 실행
                //두가지 방식으로 activity를 찾을 수 있음
                //1. explicit(명시적) 방법과
                //2. implicit(묵시적) 방법
                //우리는 explicit에서만 사용할 예정
                //explicit///
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

           }
        });

    }

}