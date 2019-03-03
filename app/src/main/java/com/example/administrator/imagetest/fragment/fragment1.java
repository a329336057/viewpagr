package com.example.administrator.imagetest.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.imagetest.Adatpter.FenleiAdapter;
import com.example.administrator.imagetest.Info.PersionInfo;
import com.example.administrator.imagetest.R;

import java.util.ArrayList;
import java.util.List;


public class fragment1 extends Fragment implements AdapterView.OnItemClickListener {

    FenleiAdapter fenleiAdapter;
    List<PersionInfo> list=new ArrayList<PersionInfo>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.news, container, false);
        list=new ArrayList<PersionInfo>();
        inint(v);       
        return v;
        
    }

    private void inint(View v) {
        for(int i=0;i<10;i++){
            PersionInfo persionInfo=new PersionInfo("常用分类"+i);
            list.add(persionInfo);
        }
        ListView listView=(ListView)v.findViewById(R.id.listview);
        list.get(0).setChick(true);
        fenleiAdapter=new FenleiAdapter(getContext(),list);
            listView.setAdapter(fenleiAdapter);
        
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        PersionInfo info=list.get(position);
        for (int i=0;i<list.size();i++){
            if(list.get(i).getNamestr().equals(info.getNamestr())){
                list.get(i).setChick(true);
            }else {
                list.get(i).setChick(false);
            }
        }
        fenleiAdapter.notifyDataSetChanged();
    }
    
    
}
