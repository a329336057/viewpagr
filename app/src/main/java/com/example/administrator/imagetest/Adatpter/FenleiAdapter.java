package com.example.administrator.imagetest.Adatpter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.imagetest.Info.PersionInfo;
import com.example.administrator.imagetest.R;
import com.example.administrator.imagetest.fragment.fragment1;

import java.util.ArrayList;
import java.util.List;

public class FenleiAdapter extends BaseAdapter {
    List<PersionInfo> list= new ArrayList<>();
    private Context context;
    RecyclerView recyclerView;
    public  FenleiAdapter(Context context, List<PersionInfo> list, RecyclerView recyclerView){
        this.context=context;
        this.list=list;
        this.recyclerView=recyclerView;
    }

    @Override
    public int getCount() { 
        return  list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.list_item,null);
        TextView t=(TextView)convertView.findViewById(R.id.fl);
        PersionInfo persionInfo=list.get(position);
        t.setText(persionInfo.getNamestr());
        if(persionInfo.isChick()){
            convertView.setBackgroundColor(Color.rgb(133,132,133));
        }else {
            convertView.setBackgroundColor(Color.parseColor("#f4f4f4"));
        }
        return convertView;
    }
}
