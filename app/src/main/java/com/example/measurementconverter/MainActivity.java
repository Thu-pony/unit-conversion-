package com.example.measurementconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<TabFragment> mFragments;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private List<String> mTitles;
    private String[] titles = {"长度","温度","功率","速度","体积"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTabLayout = findViewById(R.id.measure_choice);
        mViewPager = findViewById(R.id.pager);
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();
        for (int i = 0; i < titles.length; ++i) {
            mTitles.add(titles[i]);
            mFragments.add(new TabFragment(titles[i],i));
            mViewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager(),mFragments,mTitles);
            mViewPager.setAdapter(mViewPagerAdapter);
            //tablayout与viewpager建立练习
            mTabLayout.setupWithViewPager(mViewPager);

        }
    }
}