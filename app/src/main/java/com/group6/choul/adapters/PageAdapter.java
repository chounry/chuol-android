package com.group6.choul.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.group6.choul.fragments.HouseListFragment;
import com.group6.choul.fragments.RoomListFragment;

public class PageAdapter extends FragmentPagerAdapter {

    int numTab;

    public PageAdapter(FragmentManager fm, int numTab) {
        super(fm);
        this.numTab = numTab;
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                return new HouseListFragment();
            case 1:
                return new RoomListFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return this.numTab;
    }
}
