package com.example.androidlectureexample;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Example14_ImplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example14_implicit_intent);

        Button implicitIntentBtn = (Button)findViewById(R.id.implicitIntentBtn);
        implicitIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("MY_ACTION");
                i.addCategory("INTENT_TEST");
                i.putExtra("SEND DATA","안녕하세요");
                startActivity(i);


            }
        });

        Button dialBtn = (Button)findViewById(R.id.dialBtn);
        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:01052739474"));
                startActivity(i);
            }
        });


        Button callBtn = (Button)findViewById(R.id.callBtn);
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //현재 사용하는 안드로이드 버전이 M이상인지 확인
                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M){
                   //사용자의 안드로이드 버전이 6이상이 경우
                    //사용자 권한 중 전화걸기 권한이 설정되어 있느닞 확인
                    //
                    int permissionResult = ActivityCompat.checkSelfPermission(
                            getApplicationContext(), Manifest.permission.CALL_PHONE
                    );

                    if(permissionResult == PackageManager.PERMISSION_DENIED){
                        //권한이 없는 경우

                        //권한 설정을 거부한 적이 있는지 그렇지 않은지
                        if(shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)){
                            //임의로 add의 권한을 끄거나 혹은 권한 요청 화면에서 거절을 클릭했을 경우
                            AlertDialog.Builder dialog =
                                    new AlertDialog.Builder(Example14_ImplicitIntentActivity.this);
                            dialog.setTitle("권한 요청에 대한 Dialog"); //안내창 받기
                            dialog.setMessage("전화걸기 기능이 필요해요. 수락할까요?");
                            dialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
                                }
                            });

                            dialog.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                        }else{
                            //권한 설정을 처음 하는 경우

                           requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
                           //왜 배열을 만드나요?
                                //여러가지 권한을 한꺼번에 받을때 배열을 사용합니다
                            //한번에 배열 생성하는 방법 new 자료형[]{값}
                            //RequestCode에는 임의의 숫자를 입력합니다

                        }
                    }else {
                        //권한이 있는 경우

                        Intent i = new Intent();
                        i.setAction(Intent.ACTION_CALL);
                        i.setData(Uri.parse("tel:01052739474"));
                        startActivity(i);


                    }

               } else{
                    //미만인 경우

                    Intent i = new Intent();
                    i.setAction(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:01052739474"));
                    startActivity(i);

               }
            }
        });


        Button browserlBtn = (Button)findViewById(R.id.browserlBtn);
        browserlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.naver.com"));
                startActivity(i);

            }
        });



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==1000){
            //위에서 수행한 권한 요청에 대한 응답인지를 확인
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_DENIED){
                //허용을 눌렀을 때
                Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:01052739474"));
                startActivity(i);
            }

        }
    }
}
