package com.group6.choul.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.group6.choul.FilterActivity;
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
    private LinearLayout filter_linear_btn;
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

        adapter = new RoomListAdapter(getContext(),HomeModelist);
        listView.setAdapter(adapter);

        filter_linear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), FilterActivity.class);
                startActivity(intent);
            }
        });


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
