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

        radio_model model = new radio_model("វិទ្យុអេប៊ីសុី",R.drawable.photo6118543855524620535);
        radio_model model1 = new radio_model("វិទ្យុវីអូអេ",R.drawable.photo6118543855524620535);
        radio_model model2 = new radio_model("វិទ្យុអអាយហ្វេស",R.drawable.photo6118543855524620537);
        radio_model model3 = new radio_model("វិទ្យុអហ្វេសអេ",R.drawable.photo6118543855524620536);
        radioModelList.add(model);
        radioModelList.add(model1);
        radioModelList.add(model2);
        radioModelList.add(model3);

        adapter = new list_adapter(getContext(),radioModelList);
        listView.setAdapter(adapter);
        return v;
    }
}
