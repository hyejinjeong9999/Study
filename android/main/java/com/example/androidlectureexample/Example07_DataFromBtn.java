package com.example.androidlectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Example07_DataFromBtn extends AppCompatActivity {

    private String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example07_data_from_btn);
        //spinner생성을 위한 list생성
        final ArrayList<String> list = new ArrayList<>();
        list.add("포도");
        list.add("딸기");
        list.add("바나나");
        list.add("사과");

        //spinner 생성
        Spinner spinner = (Spinner)findViewById(R.id.mySpinner);

        //adapter 생성
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                list);


        //adapter를 spinner에 부착
        spinner.setAdapter(adapter);

        //spinner의 이벤트처리
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                result=list.get(position);
                Log.i("SELECTED",result+"가 선택되었어요");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button sendBtn = (Button)findViewById(R.id._07_02SendBtn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("ResultValue",result);
                        //키와 데이터의 한쌍으로 붙임
                setResult(7000,returnIntent);
                //결과로 세팅하겠다

                Example07_DataFromBtn.this.finish();
                //activity 닫기
            }
        });

    }
}
