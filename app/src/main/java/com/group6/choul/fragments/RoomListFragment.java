package com.group6.choul.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.group6.choul.R;
import com.group6.choul.RoomDetailActivity;
import com.group6.choul.adapters.RoomListAdapter;
import com.group6.choul.models.HomeModel;

import java.util.ArrayList;
import java.util.List;

public class RoomListFragment extends Fragment {

    private ListView listView ;
    private List<HomeModel> HomeModelist;
    private RoomListAdapter adapter;
    private Context context;

    public RoomListFragment(){}

    @SuppressLint("ValidFragment")
    public RoomListFragment(Context context){
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_post_list,container,false);
        listView = v.findViewById(R.id.item_id);
        HomeModelist = new ArrayList<>();

        HomeModel model = new HomeModel("Full Of Bag", "$2000", "445 Mount Eden Road, Mount Eden, Auckland", "Phnom Penh", "Villa", "https://www.holprop.co.uk/cache/tav-img/9062838.jpg");
        HomeModel model1 = new HomeModel("Table", "$1000", "Toul Kork, Phnom Penh", "Phnom Penh", "Villa", "https://t-ec.bstatic.com/images/hotel/max1024x768/121/121383537.jpg");
        HomeModel model2 = new HomeModel("Full of Nothing", "$2000", "Toul Kork, Phnom Penh", "Phnom Penh", "Villa", "https://s-ec.bstatic.com/images/hotel/max1024x768/134/134402091.jpg");

        HomeModelist.add(model);
        HomeModelist.add(model1);
        HomeModelist.add(model2);

        adapter = new RoomListAdapter(getContext(),HomeModelist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), RoomDetailActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }



}
