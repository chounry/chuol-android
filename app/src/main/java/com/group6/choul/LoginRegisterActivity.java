package com.group6.choul;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.group6.choul.adapters.PageAdapter;
import com.group6.choul.adapters.SignupAdapter;

public class LoginRegisterActivity extends AppCompatActivity {

    private SignupAdapter tab_adapter;
    private TabLayout tabLayout;
    private ViewPager tabPageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        tabPageView = findViewById(R.id.viewPage_home);

        tabLayout = findViewById(R.id.login_signup_tab_layout);
        tab_adapter = new SignupAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        tabPageView.setAdapter(tab_adapter);
        tabPageView.setOffscreenPageLimit(0);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabPageView.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
