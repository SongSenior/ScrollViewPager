package com.example.scrollviewviewpagerdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FragmentPagerAdapter mPageAdapter;

    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragmentList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData(){
        mTitleList.clear();
        mTitleList.add("一");
        mTitleList.add("二");
        mTitleList.add("三");
        mTitleList.add("四");

        mFragmentList.clear();
        mFragmentList.add(BlankFragment.newInstance("",""));
        mFragmentList.add(BlankFragment.newInstance("",""));
        mFragmentList.add(BlankFragment.newInstance("",""));
        mFragmentList.add(BlankFragment.newInstance("",""));

        mPageAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragmentList.get(i);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitleList.get(position);
            }

            @Override
            public int getCount() {
                return mTitleList.size();
            }
        };
    }

    private void initView(){
        mTabLayout =findViewById(R.id.tabLayout);
        mViewPager =findViewById(R.id.viewPager);
        mViewPager.setAdapter(mPageAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
