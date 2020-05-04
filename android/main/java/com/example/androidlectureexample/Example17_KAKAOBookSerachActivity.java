package com.example.androidlectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Example17_KAKAOBookSerachActivity extends AppCompatActivity {
    ListView kakaoBookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example17_kakao_book_serach);

        //위젯에 대한 reference 부터 얻어오기

        final EditText kakaoEt = (EditText) findViewById(R.id.kakaoEt);
        Button kakaoSearchBtn= (Button) findViewById(R.id.kakaoSearchBtn);
        kakaoBookList = (ListView)findViewById(R.id.kakaoBookList);

        kakaoSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Example17_Service.class);
                i.putExtra("KEYWORD",kakaoEt.getText().toString());
                startService(i);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ArrayList<String> booksTitle =
                (ArrayList<String>)intent.getExtras().get("BOOKRESULT");

        ArrayAdapter title = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1,booksTitle);

        kakaoBookList.setAdapter(title);

        kakaoBookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example17Sub_KAKAOBookSearchActivity");
                i.setComponent(cname);



            }
        });

    }


}
