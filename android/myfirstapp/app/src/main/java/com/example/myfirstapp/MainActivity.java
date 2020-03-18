package com.example.myfirstapp;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.util.Log;

        import static android.util.Log.i;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MYTEST","onCreate()가 호출되었어요");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MYTEST","onStart()가 호출되었어요");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("MYTEST","onResume()가 호출되었어요");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MYTEST","onPause()가 호출되었어요");
   }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MYTEST","onStop()가 호출되었어요");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MYTEST","onReStart()가 호출되었어요");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MYTEST","onDestroy()가 호출되었어요");
    }
}
