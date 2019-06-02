package com.group6.choul.fragments;

import android.content.Context;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.group6.choul.HouseDetailActivity;
import com.group6.choul.R;
import com.group6.choul.login_register_handling.TokenManager;
import com.group6.choul.models.HouseModel;
import com.group6.choul.adapters.HouseListAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class HouseListFragment extends Fragment {

    private RecyclerView houseRecyclerView ;
    private List<HouseModel> homeModelist;
    private HouseListAdapter adapter;
    private String url=  "http://192.168.100.208:8000/api/houses/get";
    private int user_id;

    private TokenManager tokenManager;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_post_list,container,false);
        getActivity().overridePendingTransition(0, 0);
        houseRecyclerView = v.findViewById(R.id.post_recyclerView);
        homeModelist = new ArrayList<>();

        tokenManager = TokenManager.getInstance(getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE));
        user_id = tokenManager.getUserId();

        adapter = new HouseListAdapter(homeModelist, getContext(),houseRecyclerView);
        houseRecyclerView.setHasFixedSize(true);
        adapter.setHasStableIds(true);
        houseRecyclerView.setItemViewCacheSize(20);
        houseRecyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        houseRecyclerView.setAdapter(adapter);


        getData(url);
        return v;
    }

    private void getData(String url ){
        final String baseImgUrl = "http://192.168.100.208:8000";
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("all data",response);
                try{
                    JSONArray jsonResponse = new JSONArray(response);
                    for(int i = 0 ;i < jsonResponse.length();i++){
                        JSONObject each = jsonResponse.getJSONObject(i);
                        HouseModel tmp = new HouseModel();
                        tmp.setTitle(each.getString("title"));
                        tmp.setAddress(each.getString("address"));
                        tmp.setPrice(each.getString("price"));
                        tmp.setType(each.getString("house_type"));
                        tmp.setLocation(each.getString("location"));
                        tmp.setFor_sale_rent_status(each.getString("for_sale_status"));
                        tmp.setEstaeId(each.getInt("estate_id"));

                        tmp.setImg_url(baseImgUrl + each.getString("img"));
                        homeModelist.add(tmp);
                        adapter.notifyDataSetChanged();
                    }
                }catch (Exception e){
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
