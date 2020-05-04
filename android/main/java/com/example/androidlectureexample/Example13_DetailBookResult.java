package com.example.androidlectureexample;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Example13_DetailBookResult extends AppCompatActivity {

Handler bhandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example13_detail_book_result);

        //final ImageView bimg = (ImageView) findViewById(R.id.bimage);
        final TextView btitle = (TextView) findViewById(R.id.btitle);
        final TextView bauthor = (TextView) findViewById(R.id.bauthor);
        final TextView bprice = (TextView) findViewById(R.id.dprice);
        final TextView bisbn = (TextView) findViewById(R.id.bisbn);
        final ImageView bimage = (ImageView) findViewById(R.id.bimage);

        Intent i = getIntent();
        String isbn = i.getStringExtra("isbn");

        @SuppressLint("HandlerLeak") final Handler handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Bundle bundle = msg.getData();

                final BookVO[] bookList =
                        (BookVO[]) bundle.getSerializable("BOOKLIST");


                //////////////test///////////
                final String burl = bookList[0].getBimgurl();

                btitle.setText(bookList[0].getBtitle());
                bauthor.setText(bookList[0].getBauthor());
                bprice.setText(String.valueOf(bookList[0].getBprice()));
                bisbn.setText(bookList[0].getBisbn());

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{

                            URL url= new URL (burl);
                            InputStream is = url.openStream();
                            final Bitmap bm = BitmapFactory.decodeStream(is);
                            bhandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    bimage.setImageBitmap(bm);

                                }
                            });
                            bimage.setImageBitmap(bm);
                        } catch (Exception e) {
                            Log.i("BookSearch","error " + e);

                        }
                    }
                });
            t.start();

            }
        };




        BookDetailRunnable runnable = new BookDetailRunnable(handler, isbn);
        Thread t = new Thread(runnable);
        t.start();


    }

}


class BookDetailRunnable implements Runnable{
    private Handler handler;
    private String keyword;

    BookDetailRunnable(Handler handler, String keyword){
        this.handler = handler;
        this.keyword = keyword;
    }


    @Override
    public void run() {
        String url = "http://70.12.60.99:8080/bookSearch/bookdetail?keyword=" + keyword;

        Log.i("BookSearch","keyword : " +keyword);

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            Log.i("BookSearch","서버로부터 전달된 code : " + responseCode);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            String readLine = "";
            StringBuffer responseTxt = new StringBuffer();

            while((readLine = br.readLine()) != null) {

                responseTxt.append(readLine);
            }

            br.close();

            Log.i("BookSearch","얻어온 내용은 : " + responseTxt.toString());




            ObjectMapper mapper = new ObjectMapper();
            BookVO[] resultArr =
                    mapper.readValue(responseTxt.toString(),BookVO[].class);


            Bundle bundle = new Bundle();
            bundle.putSerializable("BOOKLIST",resultArr);
            Message msg = new Message();
            msg.setData(bundle);
            handler.sendMessage(msg);

        }catch (Exception e){
            Log.i("BookSearch",e.toString());

        }

    }
}


