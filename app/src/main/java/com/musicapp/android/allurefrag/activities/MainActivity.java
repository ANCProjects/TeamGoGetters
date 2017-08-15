package com.musicapp.android.allurefrag.activities;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.musicapp.android.allurefrag.R;
import com.musicapp.android.allurefrag.adapters.ViewPagerAdapter;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        pager = (ViewPager) findViewById(R.id.view_pager);

        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), 3));

        tabLayout.setupWithViewPager(pager);
    }
}