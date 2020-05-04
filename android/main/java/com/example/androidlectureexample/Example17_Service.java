package com.example.androidlectureexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class Example17_Service extends Service {
    public Example17_Service() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String keyword = intent.getExtras().getString("KEYWORD");
        KaKaoBookSearchRunnable runnable = new KaKaoBookSearchRunnable(keyword);
        Thread t = new Thread(runnable);
        t.start();

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");


    }

    class KaKaoBookSearchRunnable implements Runnable{
        private String keyword;
        KaKaoBookSearchRunnable(){}
        KaKaoBookSearchRunnable(String keyword){
            this.keyword = keyword;
        }
        @Override
        public void run() {

            String url = "https://dapi.kakao.com/v3/search/book?target=title";
            url += ("&query=" + keyword) ;

            try{
                URL obj = new URL(url);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Authorization","KakaoAK ee95af4a8a65d073e832f2ec4e84c26e");

                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String line;
                StringBuffer sb = new StringBuffer();

                while ((line = br.readLine()) !=null){
                    sb.append(line);
                }

                Log.i("KAKAO",sb.toString());

                ObjectMapper mapper = new ObjectMapper();


                Map<String,Object> map =
                        mapper.readValue(sb.toString(),
                                new TypeReference<Map<String,Object>>(){});

                Object jsonObject = map.get("documents");

                String jasonString = mapper.writeValueAsString(jsonObject);

                Log.i("KAKAO",jasonString);

                ArrayList<KAKAOBookVO> searchBooks
                        = mapper.readValue(jasonString,
                        new TypeReference<ArrayList<KAKAOBookVO>>(){});

                ArrayList<String> title = new ArrayList<String>();
                ArrayList<ArrayList<String>> author =new ArrayList<>();
                ArrayList<String> publisher =new ArrayList<String>();



//ArrayList<String> authors, String isbn, String price,
// String publisher, String sale_price,String thumbnail,
// String title, ArrayList<String> translators
                for (KAKAOBookVO vo : searchBooks){
                    title.add(vo.getTitle());
                    author.add(vo.getAuthors());
                    publisher.add(vo.getPublisher());

                }

                Intent resultIntent = new Intent(getApplicationContext(),
                        Example17_KAKAOBookSerachActivity.class);

                resultIntent.putExtra("BOOKRESULT",title);
                resultIntent.putExtra("BOOKRESULT",author);
                resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                resultIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(resultIntent);




            }
            catch (Exception e){
                Log.i("KAKAO",e.toString());
            }



        }
    }

}



class KAKAOBookVO{

    private ArrayList<String> authors;
    private String contents;
    private String datetime;
    private String isbn;
    private String price;
    private String publisher;
    private String sale_price;
    private String status;
    private String thumbnail;
    private String title;
    private ArrayList<String> translators;
    private String url;

    public KAKAOBookVO(){} //기본생성자

    public KAKAOBookVO(ArrayList<String> authors, String contents, String datetime, String isbn, String price, String publisher, String sale_price, String status, String thumbnail, String title, ArrayList<String> translators, String url) {
        this.authors = authors;
        this.contents = contents;
        this.datetime = datetime;
        this.isbn = isbn;
        this.price = price;
        this.publisher = publisher;
        this.sale_price = sale_price;
        this.status = status;
        this.thumbnail = thumbnail;
        this.title = title;
        this.translators = translators;
        this.url = url;
    }




    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getTranslators() {
        return translators;
    }

    public void setTranslators(ArrayList<String> translators) {
        this.translators = translators;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}