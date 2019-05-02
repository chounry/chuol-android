package com.group6.choul;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment2 extends Fragment {
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.housedetail,container,false);
        viewPager = v.findViewById(R.id.slide);
        slideadapter sladapter = new slideadapter(v.getContext());
        Log.e("Something ", viewPager+"");
        viewPager.setAdapter(sladapter);
        return v;
    }
}
