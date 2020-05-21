package com.example.firebaselistexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.FileObserver;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//firebase - realtime database 연결
    //서버

    //Main Activity와 adapter는 list (통신매개체임)를 가지고 왔다갔다..
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<User> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //main.xml
        recyclerView = findViewById(R.id.recyclerView); //아이디 연결
        recyclerView.setHasFixedSize(true); //recyclerview 성능 강화
        layoutManager = new LinearLayoutManager(this); //context 입력 = this
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();//User 객체를 담을 ArrayList (어댑터쪽으로 보낼려고)

        //파이어베이스 데이터베이스 연동
        database = FirebaseDatabase.getInstance();
        //DB 테이블 연결하는 작업
        databaseReference = database.getReference("User");
        //이곳의 User : 파이어베이스 User -> 내부의 list들을 출력해달라는 의미

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); //기존 배열리스트가 존재하지 않게 초기화
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    //반복문으로 데이터 list를 추출해냄
                    User user = snapshot.getValue(User.class);
                    //User클래스 안에 firebase db에서 가져온 값 저장
                    arrayList.add(user); //담은 데이터를 배열 리스트에 넣고 리사이클러뷰로 보낼 준비
                }
                adapter.notifyDataSetChanged(); //리스트저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            //디비를 가져오던 중 에러 발생시 띄워줄 화면
                Log.e("MainActivity", String.valueOf(databaseError.toException()));
            }
        });
        //custom Adapter -> arrayList와 context 필요
        adapter = new CustomAdapter(arrayList, this);
        recyclerView.setAdapter(adapter); //리사이클러뷰에 어댑터 연결

    }
}
