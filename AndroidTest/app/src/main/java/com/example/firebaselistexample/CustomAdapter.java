package com.example.firebaselistexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    //객체 정보를 담을 arrayList
    private ArrayList<User> arrayList;
    //선택한 activity의 context를 가져오기 위해
    private Context context;

    public CustomAdapter(ArrayList<User> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    //어댑터에 연결된 다음 뷰 홀더를 최초로 만들어 냄
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    //xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    //실제적으로 아이템별 매칭
    //이미지 뷰를 서버로부터 불러올 예정
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        //user객체가 있는 arraylist에 담아 어댑터에 쏨
        ///서버로부터 이미지를 받아와서 삽입됨
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                 .into(holder.iv_profile);
        holder.tv_id.setText(arrayList.get(position).getId());
        holder.tv_pw.setText(String.valueOf(arrayList.get(position).getPw()));
        holder.tv_userName.setText(arrayList.get(position).getUserName());


    }

    @Override
    public int getItemCount() {
        //null이 아니면 size 가져오기 null이면 0
        return (arrayList !=null ? arrayList.size() : 0);
    }

    //list item을 불러들일 것
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_profile;
        TextView tv_id;
        TextView tv_pw;
        TextView tv_userName;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            //리사이클러뷰에 대한 아이디 값 가져옴
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.tv_id = itemView.findViewById(R.id.tv_id);
            this.tv_id = itemView.findViewById(R.id.tv_pw);
            this.tv_id = itemView.findViewById(R.id.tv_userName);


        }
    }
}
