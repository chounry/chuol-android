package com.group6.choul.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.group6.choul.R;
import com.group6.choul.models.HomeModel;
import com.group6.choul.adapters.HouseListAdapter;

import java.util.ArrayList;
import java.util.List;

public class HouseListHomeFragment extends Fragment {

    private ListView listView ;
    private List<HomeModel> HomeModelist;
    private HouseListAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.house_list,container,false);
        listView = v.findViewById(R.id.item_id);
        HomeModelist = new ArrayList<>();

        HomeModel model = new HomeModel("Full Of Bag", "$2000", "445 Mount Eden Road, Mount Eden, Auckland", "Phnom Penh", "Villa", R.drawable.house1);
        HomeModel model1 = new HomeModel("Table", "$1000", "Toul Kork, Phnom Penh", "Phnom Penh", "Villa", R.drawable.house1);
        HomeModel model2 = new HomeModel("Full of Nothing", "$2000", "Toul Kork, Phnom Penh", "Phnom Penh", "Villa", R.drawable.house1);

        HomeModelist.add(model);
        HomeModelist.add(model1);
        HomeModelist.add(model2);

        adapter = new HouseListAdapter(getContext(),HomeModelist);
        listView.setAdapter(adapter);
        return v;
    }

}
