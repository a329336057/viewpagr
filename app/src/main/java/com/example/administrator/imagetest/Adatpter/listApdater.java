package com.example.administrator.imagetest.Adatpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.administrator.imagetest.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class listApdater extends RecyclerView.Adapter<listApdater.MyViewHolder> {
    List<HashMap<String,String>> l=new ArrayList<>();
    public  Context context;
    public listApdater(Context context,List<HashMap<String,String>> list){
        this.l=list;
        this.context=context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View  v=LayoutInflater.from(context).inflate(R.layout.meun_list,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        HashMap<String,String> as=l.get(i);
        myViewHolder.mTvTitle1.setText(as.get("title")) ;
        myViewHolder.mTvTitle2.setText(as.get("hello")) ;

    }



    @Override
    public int getItemCount() {
        return l==null?0:l.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvTitle1;
        private TextView mTvTitle2;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTvTitle1 = (TextView) itemView.findViewById(R.id.lefttest);
            mTvTitle2 = (TextView) itemView.findViewById(R.id.righttest);

        }
    }
}
