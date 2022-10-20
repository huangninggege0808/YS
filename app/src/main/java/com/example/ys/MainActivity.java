package com.example.ys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int TAKE_PHOTO=1;
    private Uri imageUri;
    ViewPager2 viewPager;
    private LinearLayout lshouye,lgeren,lyinshi,lshequ,lshezhi;
    private ImageView lvshouye,lvgeren,lvyinshi,lvshequ,lvshezhi,lvnow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPager();
        initTabView();
        Camera();
        /*List<RecentsData> recentsDataList=new ArrayList<>();
        recentsDataList.add(new RecentsData("手把手助您上手",R.drawable.zn,"使用指南"));
        recentsDataList.add(new RecentsData("优食分析为您保驾护航",R.drawable.ma3,"每日食品分析"));
        recentsDataList.add(new RecentsData("每周吃多少个鸡蛋有益健康",R.drawable.egg,"营养热线"));
        recentsDataList.add(new RecentsData("为您提供更好的饮食搭配",R.drawable.ma2,"搭配指南"));
        recentsDataList.add(new RecentsData("今天您有健康饮食吗",R.drawable.ma4,"每日一享"));
        recentsDataList.add(new RecentsData("营养食谱大作战",R.drawable.ma5,"社区活动"));
        setRecentRecycler(recentsDataList);*/
    }

    private void Camera() {
       /* ImageView takePhoto=findViewById(R.id.imageView36);
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File outputImage=new File(getExternalCacheDir(),"output_image.jpg");
                try{
                    if (outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(Build.VERSION.SDK_INT>=24){
                    imageUri= FileProvider.getUriForFile(MainActivity.this,
                            "com.workspace.hh.cameraalbumtest.fileprovider",outputImage);
                }else {
                    imageUri= Uri.fromFile(outputImage);
                }
                Intent intent10=new Intent("android.media.action.IMAGE_CAPTURE");
                intent10.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent10,TAKE_PHOTO);
            }
        });*/
    }

    private void initTabView() {
        lshouye=findViewById(R.id.shouye);
        lshouye.setOnClickListener(this);
        lgeren=findViewById(R.id.gerenzhongxin);
        lgeren.setOnClickListener(this);
        lyinshi=findViewById(R.id.yinshizixun);
        lyinshi.setOnClickListener(this);
        lshequ=findViewById(R.id.shequxiaoliu);
        lshequ.setOnClickListener(this);
        lshezhi=findViewById(R.id.shezhi);
        lshezhi.setOnClickListener(this);

        lvshouye=findViewById(R.id.tab_shouye);
        lvgeren=findViewById(R.id.tab_gerenzhongxin);
        lvyinshi=findViewById(R.id.tab_yinshizixun);
        lvshequ=findViewById(R.id.tab_shequjiaoliu);
        lvshezhi=findViewById(R.id.tab_shezhi);

        lvshouye.setSelected(true);
        lvnow=lvshouye;

    }

    private void initPager() {
        viewPager =findViewById(R.id.id_viewpager);
        ArrayList<Fragment> fragments=new ArrayList<>();
        /*fragments.add(BlankFragment.newInstance("首页"));
        fragments.add(BlankFragment.newInstance("个人中心"));
        fragments.add(BlankFragment.newInstance("饮食咨询"));
        fragments.add(BlankFragment.newInstance("社区交流"));
        fragments.add(BlankFragment.newInstance("设置"));*/
        fragments.add(new ShouyeFragment());
        fragments.add(new GeRenFragment());
        fragments.add(new YinShiFragment());
        fragments.add(new SheQuFragment());
        fragments.add(new SheZhiFragment());

        FragmentPagerAdapter pagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                chageTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void chageTab(int position) {
        lvnow.setSelected(false);
        switch (position){
            case R.id.shouye:
                viewPager.setCurrentItem(0);
            case 0:
                lvshouye.setSelected(true);
                lvnow=lvshouye;
                break;
            case R.id.gerenzhongxin:
                viewPager.setCurrentItem(1);
            case 1:
                lvgeren.setSelected(true);
                lvnow=lvgeren;
                break;
            case R.id.yinshizixun:
                viewPager.setCurrentItem(2);
            case 2:
                lvyinshi.setSelected(true);
                lvnow=lvyinshi;
                break;
            case R.id.shequxiaoliu:
                viewPager.setCurrentItem(3);
            case 3:
                lvshequ.setSelected(true);
                lvnow=lvshequ;
                break;
            case R.id.shezhi:
                viewPager.setCurrentItem(4);
            case 4:
                lvshezhi.setSelected(true);
                lvnow=lvshezhi;
                break;
        }

    }

    @Override
    public void onClick(View v) {
         chageTab(v.getId());
    }
}