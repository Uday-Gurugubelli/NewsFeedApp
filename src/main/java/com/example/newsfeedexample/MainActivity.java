package com.example.newsfeedexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem mHome, mscience, mhealth, msports, mentertainment, mtechnology;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;
    ViewPager viewPager;

    String apiKey = "121a6637ca934bf495048e4e17d15e30";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHome = findViewById(R.id.home);
        mscience = findViewById(R.id.science);
        mhealth = findViewById(R.id.health);
        msports = findViewById(R.id.sports);
        mentertainment = findViewById(R.id.entertainment);
        mtechnology = findViewById(R.id.technology);

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.include);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition() == 2
                        || tab.getPosition()== 3 || tab.getPosition() == 4 || tab.getPosition()==5) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}