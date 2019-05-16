package com.group6.choul.fragments;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group6.choul.R;
import com.group6.choul.adapters.PageAdapter;

public class HomeFragment extends Fragment {

    private PageAdapter tab_adapter;
    private TabLayout tabLayout;
    private ViewPager tabPageView;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        tabPageView = v.findViewById(R.id.viewPage_home);

        tabLayout = v.findViewById(R.id.tab_h);
        tab_adapter = new PageAdapter(getChildFragmentManager(),tabLayout.getTabCount());
        // <------------   handle tap
//        tab_adapter = new PageAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
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




        tabPageView.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return v;
    }
}