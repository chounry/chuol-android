package com.group6.choul.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.group6.choul.HouseDetailActivity;
import com.group6.choul.R;
import com.group6.choul.models.HomeModel;
import com.group6.choul.adapters.HouseListAdapter;

import java.util.ArrayList;
import java.util.List;

public class HouseListFragment extends Fragment {

    private RecyclerView houseRecyclerView ;
    private List<HomeModel> homeModelist;
    private HouseListAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_post_list,container,false);
        getActivity().overridePendingTransition(0, 0);
        houseRecyclerView = v.findViewById(R.id.post_recyclerView);
        homeModelist = new ArrayList<>();


        HomeModel model = new HomeModel("Full Of Bag", "$2000", "445 Mount Eden Road", "Phnom Penh", "Villa","https://images.pexels.com/photos/186077/pexels-photo-186077.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" );
        HomeModel model1 = new HomeModel("Table", "$1000", "Toul Kork, Phnom Penh", "Phnom Penh", "Villa", "https://images.unsplash.com/photo-1475855581690-80accde3ae2b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        HomeModel model2 = new HomeModel("Full of Nothing", "$2000", "Toul Kork, Phnom Penh", "Phnom Penh", "Villa", "https://media.istockphoto.com/photos/beautiful-luxury-home-exterior-with-green-grass-and-landscaped-yard-picture-id856794670?k=6&m=856794670&s=612x612&w=0&h=gneLQSj2K6CzxU4r7DG_HUjd00ZMiZnYhYW_R0goPZ4=");

        homeModelist.add(model);
        homeModelist.add(model1);
        homeModelist.add(model2);

        adapter = new HouseListAdapter(homeModelist, getContext(),houseRecyclerView);
        houseRecyclerView.setHasFixedSize(true);
        adapter.setHasStableIds(true);
        houseRecyclerView.setItemViewCacheSize(20);
        houseRecyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        houseRecyclerView.setAdapter(adapter);

//        houseRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Object item = parent.getItemAtPosition(position);
//                Intent intent = new Intent(getActivity(), HouseDetailActivity.class);
//                startActivity(intent);
//            }
//        });
        return v;
    }

}
