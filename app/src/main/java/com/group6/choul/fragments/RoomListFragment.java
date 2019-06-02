package com.group6.choul.fragments;

import android.os.Build;
import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
import com.group6.choul.adapters.RoomListAdapter;
import com.group6.choul.models.RoomModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RoomListFragment extends Fragment {

    private RecyclerView roomRecyclerView;
    private List<RoomModel> roomModelist;
    private RoomListAdapter adapter;
    private String url = "http://192.168.100.208:8000/api/rooms/get";


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_post_list, container, false);
        getActivity().overridePendingTransition(0, 0);
        roomRecyclerView = v.findViewById(R.id.post_recyclerView);
        roomModelist = new ArrayList<>();


        adapter = new RoomListAdapter(getContext(), roomModelist);
        roomRecyclerView.setHasFixedSize(true);
        adapter.setHasStableIds(true);
        roomRecyclerView.setItemViewCacheSize(20);
        roomRecyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        roomRecyclerView.setAdapter(adapter);

        getData(url);
        return v;

    }

    private void getData(String url) {
        final String ImgUrl = "http://192.168.100.208:8000";
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonResponse = new JSONArray(response);
                    for (int i = 0; i < jsonResponse.length(); i++) {
                        JSONObject each = jsonResponse.getJSONObject(i);
                        RoomModel room = new RoomModel();
                        room.setTitle(each.getString("title"));
                        room.setAddress(each.getString("address"));
                        room.setPrice(each.getString("price"));
                        room.setLocation(each.getString("location"));
                        room.setEstate_id(each.getInt("estate_id"));
                        room.setRoom_id(each.getInt("room_id"));
                        room.setImg_url(ImgUrl + each.getString("img"));
                        roomModelist.add(room);
                        adapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    Log.e("Json Error", e.toString());
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("MYError", error.toString());
                    }
                });
        requestQueue.add(request);


    }
}
