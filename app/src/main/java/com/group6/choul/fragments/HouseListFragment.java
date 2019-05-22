package com.group6.choul.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.group6.choul.FilterActivity;
import com.group6.choul.HouseDetailActivity;
import com.group6.choul.R;
import com.group6.choul.RoomDetailActivity;
import com.group6.choul.models.HomeModel;
import com.group6.choul.adapters.HouseListAdapter;

import java.util.ArrayList;
import java.util.List;

public class HouseListFragment extends Fragment {

    private ListView listView ;
    private List<HomeModel> HomeModelist;
    private HouseListAdapter adapter;
    private LinearLayout filter_linear_btn;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.post_list_fragment,container,false);
        listView = v.findViewById(R.id.item_id);

        filter_linear_btn = v.findViewById(R.id.filter_linear_btn);
        HomeModelist = new ArrayList<>();


        HomeModel model = new HomeModel("Full Of Bag", "$2000", "445 Mount Eden Road, Mount Eden, Auckland", "Phnom Penh", "Villa", R.drawable.house1);
        HomeModel model1 = new HomeModel("Table", "$1000", "Toul Kork, Phnom Penh", "Phnom Penh", "Villa", R.drawable.house1);
        HomeModel model2 = new HomeModel("Full of Nothing", "$2000", "Toul Kork, Phnom Penh", "Phnom Penh", "Villa", R.drawable.house1);

        HomeModelist.add(model);
        HomeModelist.add(model1);
        HomeModelist.add(model2);

        adapter = new HouseListAdapter(getContext(),HomeModelist);
        listView.setAdapter(adapter);
        filter_linear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), FilterActivity.class);
                startActivity(intent);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), HouseDetailActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }

}
