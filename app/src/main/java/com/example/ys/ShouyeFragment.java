package com.example.ys;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ShouyeFragment extends Fragment {
    private  RecyclerView recyclerView;
    private  RecentsAdapter recentsAdapter;
    private Context context;
    private List<RecentsData> recentsDataList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fshouye, container, false);
        context=view.getContext();
        recyclerView=view.findViewById(R.id.recyclerview1);
        recentsDataList=new ArrayList<>();
        initData();
        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recentsAdapter=new RecentsAdapter(context,recentsDataList);
        recyclerView.setAdapter(recentsAdapter);
        recyclerView.setLayoutManager(manager);
        return view;
    }

    private void initData() {
        recentsDataList.add(new RecentsData("手把手助您上手",R.drawable.zn,"使用指南"));
        recentsDataList.add(new RecentsData("优食分析为您保驾护航",R.drawable.ma3,"每日食品分析"));
        recentsDataList.add(new RecentsData("每周吃多少个鸡蛋有益健康",R.drawable.egg,"营养热线"));
        recentsDataList.add(new RecentsData("为您提供更好的饮食搭配",R.drawable.ma2,"搭配指南"));
        recentsDataList.add(new RecentsData("今天您有健康饮食吗",R.drawable.ma4,"每日一享"));
        recentsDataList.add(new RecentsData("营养食谱大作战",R.drawable.ma5,"社区活动"));
    }


}