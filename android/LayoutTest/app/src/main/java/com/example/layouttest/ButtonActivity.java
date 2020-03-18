package com.example.layouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button myBtn = findViewById(R.id.eventBtn);
        //event source 객체부터 얻어옴
        //return 값이 object임

        final TextView tv = (TextView)findViewById(R.id.myTV);
        //지역변수 : 메소드가 호출될때(onCreate) 생성됨
        //final 선언 :  지역변수를 상수화 해서 heap에 저장되게 한다!


        //event handler 객체를 생성한다
        MyEventHandler handler = new MyEventHandler(tv);

            //event Source Event Handler를 부착
        myBtn.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                tv.setText("이것은 소리없는 아우성");
                // tv.setText("이것은 소리없는 아우성"); 이 오류나는 이유
                // tv가 지역변수 이기 때문에
                //tv생성 = oncreate 할때 생성되고 사라짐
                //생성할때만 나타나고
                //클릭할때에는 tv가 이미 사라짐짐                //그걸 막기 위해 final 선언
            }
        });

        //click에 대한 handler(listner)를 부착해라
        // myBtn.setOnClickListener(new View.OnClickListener(){});
        //추상메소드기 때문에 객체생성이 불가능
    }

}
//일반 클래스임 : 우리가 원하는 것은 일반 클래스의 객체가 아닌 event를 처리할 수 있는
//특수한 능력을 가진 리스너객체(handler)임
//다시말하면 우리가 작성하는 class는 특수한 interface로 구현한 클래스가 되어야 한다
//특수한 interface는 여러개가 존재함 (이벤트 종류에 따라서 여러개가 존재)



//class MyEventHandler implements View.OnClickListener{
//    private TextView tv;
//    MyEventHandler(){} //default
//    //tv를 인자로 받는 생성자
//    MyEventHandler(TextView tv){
//        this.tv = tv;
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        //Log.i("myevent","버튼이 눌러졋어요");
//        tv.setText("이것은 소리없는 아우성");
//
//
//
//    }
//}
//
//
