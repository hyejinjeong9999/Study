package com.example.androidlectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Example17Sub_KAKAOBookSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example17_sub_kakao_book_search);
        TextView booknameTV = findViewById(R.id.booknameTV);
        Intent i = getIntent();
        String book = i.getStringExtra("TITLE");
        booknameTV.setText(book);
    }
}
