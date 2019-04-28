package com.group6.choul;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class list_fragement extends Fragment {
    private ListView listView ;
    private List<radio_model> radioModelList;
    private list_adapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.listview,container,false);
        listView = v.findViewById(R.id.item_id);
        radioModelList = new ArrayList<>();

        adapter = new list_adapter(getContext(),radioModelList);
        listView.setAdapter(adapter);
        return v;
    }
}
