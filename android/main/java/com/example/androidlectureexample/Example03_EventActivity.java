package com.example.androidlectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class Example03_EventActivity extends AppCompatActivity {
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example03_event);

        //Button에 대한 event 처리를 해야 한다
        //버튼에 리스너를 등록해야한다
        //findViewById() = this.findViewById
        //this : Example03_EventActivity (이 화면에서 찾는다)

       //Button btn = (Button)findViewById()는 setContentView 뒤에 나와야한다
        //일단 화면에  activity_example03__event가 깔려있어야 찾을 수 있으니까
        //이미지 뷰의 아이디 가져온다
        //지역변수기 때문에 상수화 -> 스택영역에 있던 애를 힙영역으로
        // final 선언 혹은 메서드 밖에서 선언
        // 필드들은 캡슐화를 위해 대부분 private로 선언

        iv = (ImageView)findViewById(R.id.iv);
        final Button btn = (Button)findViewById(R.id.imageChangeBtn);
        //final Button btn = (Button)findViewById(R.id.imageChangeBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(R.drawable.cat2);
                //자원에 대한 상수값을 이용해서 이미지 리소스를 바꾸기


               /* if(btn.isChecked()){
                    btn.setBackgroundDrawable(
                            getResources().
                                    getDrawable(R.drawable.cat1)
                    );
                }else{
                    btn.setBackgroundDrawable(
                            getResources().
                                    getDrawable(R.drawable.cat2)
                    );
                } // end if*/





            }
        });

    }


}
