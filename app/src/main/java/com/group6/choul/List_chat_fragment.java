package com.group6.choul;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class List_chat_fragment extends Fragment {

    private ListView listView ;
    private List<ChatModel> ChatModelist;
    private list_chat_adapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.chat,container,false);
        listView = v.findViewById(R.id.item_chat_id);
        ChatModelist = new ArrayList<>();

        ChatModel model = new ChatModel(R.drawable.house1, "shimi", "11:11", R.drawable.house);
        ChatModel model1 = new ChatModel(R.drawable.house1, "chounry", "11:11", R.drawable.house);
        ChatModel model2 = new ChatModel(R.drawable.house1, "koung", "11:11", R.drawable.house);

        ChatModelist.add(model);
        ChatModelist.add(model1);
        ChatModelist.add(model2);

        adapter = new list_chat_adapter(getContext(),ChatModelist);
        listView.setAdapter(adapter);
        return v;
    }
}
