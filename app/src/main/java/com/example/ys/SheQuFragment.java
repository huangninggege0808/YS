package com.example.ys;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;


public class SheQuFragment extends Fragment {
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private TopicAdapter topicAdapter;
    private TopicAdapter topicAdapter1;
    private Banner banner;
    private List<TopicData> topicDataList;
    private List<TopicData> topicDataList1;
    private Context context;
    private GlideImageLoader glideImageLoader;
    private List<Integer> imagePath;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_she_qu,container,false);
        context=view.getContext();
        recyclerView1=view.findViewById(R.id.recyclerview1);
        topicDataList=new ArrayList<>();
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        topicAdapter=new TopicAdapter(context,topicDataList);
        recyclerView1.setAdapter(topicAdapter);
        recyclerView1.setLayoutManager(layoutManager);


        recyclerView2=view.findViewById(R.id.recyclerview2);
        topicDataList1=new ArrayList<>();
        LinearLayoutManager layoutManager1=new LinearLayoutManager(context);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        topicAdapter1=new TopicAdapter(context,topicDataList1);
        recyclerView2.setAdapter(topicAdapter1);
        recyclerView2.setLayoutManager(layoutManager1);
        initDate();
        glideImageLoader=new GlideImageLoader();
        banner=view.findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(glideImageLoader);
        //banner.setBannerTitles(imageTitle);
        banner.setDelayTime(3000);
        banner.isAutoPlay(true);
        banner.setImages(imagePath);
        banner.start();
        return view;
    }

    private void initDate() {
            imagePath=new ArrayList<>();
            imagePath.add(R.drawable.dd);
            imagePath.add(R.drawable.ee);
            imagePath.add(R.drawable.hh);
            topicDataList.add(new TopicData("??????????????????",R.drawable.ra));
            topicDataList.add(new TopicData("?????????????????????",R.drawable.rb));
            topicDataList.add(new TopicData("?????????????????????",R.drawable.rc));
            topicDataList.add(new TopicData("?????????????????????",R.drawable.rd));
            topicDataList.add(new TopicData("??????????????????",R.drawable.re));
            topicDataList1.add(new TopicData("????????????????????????",R.drawable.rf));
            topicDataList1.add(new TopicData("???????????????",R.drawable.rg));
            topicDataList1.add(new TopicData("????????????????????????",R.drawable.rh));
            topicDataList1.add(new TopicData("?????????????????????",R.drawable.ri));
            topicDataList1.add(new TopicData("????????????????????????",R.drawable.rj));

    }

}