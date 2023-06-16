package com.example.measurementconverter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author Liang
 * @date 2023/6/15 15:36
 * description
 * ViewPager适配器，和listView差不多
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<TabFragment> mFragmentList; // 各导航的Fragment
    private List<String> mTitle; //导航栏
    public ViewPagerAdapter(@NonNull FragmentManager fm, List<TabFragment> fragments, List<String> title){
        super(fm);
        mFragmentList = fragments;
        mTitle = title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
