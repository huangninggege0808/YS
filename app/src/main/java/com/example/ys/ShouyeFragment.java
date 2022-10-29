package com.example.ys;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;


import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ShouyeFragment extends Fragment {
    private  RecyclerView recyclerView;
    private  RecentsAdapter recentsAdapter;
    public static final int TAKE_PHOTO=1;
    private Uri imageUri;
    private Context context;
    private ImageView takePhoto;
    private List<RecentsData> recentsDataList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_shou_ye, container, false);
        context=view.getContext();
        ImageView takePhoto1=view.findViewById(R.id.imageView36);
        takePhoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File outputImage = new File(context.getExternalCacheDir(), "output_image.jpg");
                try//判断图片是否存在，存在则删除在创建，不存在则直接创建
                {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //判断运行设备的系统版本是否低于Android7.0
                if (Build.VERSION.SDK_INT >= 24)
                {
                    imageUri = FileProvider.getUriForFile(context,
                            "com.example.ys.fileprovider", outputImage);
                } else {
                    imageUri = Uri.fromFile(outputImage);
                }
                //使用隐示的Intent，调用摄像头，并把它存储
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, TAKE_PHOTO);
            }
        });
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