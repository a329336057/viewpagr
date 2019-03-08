package com.example.administrator.imagetest.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.imagetest.Adatpter.FenleiAdapter;
import com.example.administrator.imagetest.Adatpter.listApdater;
import com.example.administrator.imagetest.Info.PersionInfo;
import com.example.administrator.imagetest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class fragment1 extends Fragment implements AdapterView.OnItemClickListener {

    FenleiAdapter fenleiAdapter;
    List<PersionInfo> list = new ArrayList<PersionInfo>();
    List<HashMap<String, String>> l = new ArrayList<>();
    RecyclerView recyclerView;
    listApdater ad;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.news, container, false);
        list = new ArrayList<PersionInfo>();
        inint(v);
        adg(v);



        return v;
        }

   public   void adg(View v){
       ad = new listApdater(getContext(), l);
       recyclerView = v.findViewById(R.id.rec);
       LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
       layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
       recyclerView.setLayoutManager(layoutManager);
       recyclerView.setAdapter(ad);
       ad.notifyDataSetChanged();
       recyclerView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getActivity(),"你点击了",Toast.LENGTH_SHORT).show();
           }
       });

   }
    private void inint(View v) {
        for(int i=0;i<10;i++){
            PersionInfo persionInfo=new PersionInfo("常用分类"+i);
            list.add(persionInfo);

        }

        ListView listView=(ListView)v.findViewById(R.id.listview);
        list.get(0).setChick(true);
        ad = new listApdater(getContext(), l);

        RecyclerView rec=v.findViewById(R.id.rec);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rec.setLayoutManager(layoutManager);
        rec.setAdapter(ad);
        ad.notifyDataSetChanged();

        fenleiAdapter=new FenleiAdapter(getContext(),list,recyclerView);
        listView.setAdapter(fenleiAdapter);
        
        listView.setOnItemClickListener(this);
        adg(v);
    }
    private ArrayList<HashMap<String,String>> pr(){
        List<HashMap<String, String>> adt = new ArrayList<>();
        for(int j=0;j<10;j++){
            Random rn = new Random();
            HashMap<String,String> h=new HashMap();
            h.put("title","疯狂的石头"+j+rn.nextInt(100));
            h.put("hello","2019-3-6 10:44:"+j+rn.nextInt(100));
            adt.add(h);
        }
        return (ArrayList<HashMap<String, String>>) adt;
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

        Toast.makeText(parent.getContext(),list.get(position).getNamestr(), Toast.LENGTH_SHORT).show();
        fenleiAdapter.notifyDataSetChanged();
        l.clear();
        l.addAll(pr());
        ad=new listApdater(getContext(),l);
        recyclerView.setAdapter(ad);
        ad.notifyDataSetChanged();


//        secondAdapter.clear();
//        secondAdapter.addAll(dummy());
//        secondList.setSelectionAfterHeaderView();
    }
    
    
}
