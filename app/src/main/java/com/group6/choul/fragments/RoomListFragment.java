package com.group6.choul.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.group6.choul.R;
import com.group6.choul.RoomDetailActivity;
import com.group6.choul.adapters.RoomListAdapter;
import com.group6.choul.models.HomeModel;
import com.group6.choul.models.RoomModel;

import java.util.ArrayList;
import java.util.List;

public class RoomListFragment extends Fragment {

    private RecyclerView roomRecyclerView;
    private List<RoomModel> RoomModelist;
    private RoomListAdapter adapter;
    private String url= "http://192.168.100.152:8000/api/rooms/get";

    public RoomListFragment(){}


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_post_list,container,false);
        roomRecyclerView = v.findViewById(R.id.post_recyclerView);
        RoomModelist = new ArrayList<>();

//        RoomModel model = new RoomModel(null, null, null, 12, null, "room", "120","Toul Kork, Phnom Penh", "Phnom Penh", "https://images.pexels.com/photos/186077/pexels-photo-186077.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" );
////        HomeModel model1 = new HomeModel("Table", "$1000", "Toul Kork, Phnom Penh", "Phnom Penh", "Villa", "https://t-ec.bstatic.com/images/hotel/max1024x768/121/121383537.jpg");
////        HomeModel model2 = new HomeModel("Full of Nothing", "$2000", "Toul Kork, Phnom Penh", "Phnom Penh", "Villa", "https://s-ec.bstatic.com/images/hotel/max1024x768/134/134402091.jpg");
//
//        RoomModelist.add(model);
////        HomeModelist.add(model1);
////        HomeModelist.add(model2);
//
//        adapter = new RoomListAdapter(getContext(),RoomModelist);
//        roomRecyclerView.setHasFixedSize(true);
//        roomRecyclerView.setItemViewCacheSize(20);
//        roomRecyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
//        roomRecyclerView.setAdapter(adapter);
//
//        roomRecyclerView.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Object item = parent.getItemAtPosition(position);
//                Intent intent = new Intent(getActivity(), RoomDetailActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        getData(url);
//
        return v;
    }

    private void getData(String url ){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("all data",response.toString());
            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.toString());
                    }
                });

        requestQueue.add(request);
    }



}
