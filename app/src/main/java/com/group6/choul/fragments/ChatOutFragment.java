package com.group6.choul.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.group6.choul.ChatInActivity;
import com.group6.choul.R;
import com.group6.choul.login_register_handling.AccessToken;
import com.group6.choul.login_register_handling.ApiService;
import com.group6.choul.login_register_handling.RetrofitBuilder;
import com.group6.choul.login_register_handling.TokenManager;
import com.group6.choul.models.ChatModel;
import com.group6.choul.adapters.ListChatAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;

import static android.content.Context.MODE_PRIVATE;

public class ChatOutFragment extends Fragment {

    private ListView listView ;
    private List<ChatModel> ChatModelist;
    private ListChatAdapter adapter;

    ApiService service;
    TokenManager tokenManager;
    Call<AccessToken> call;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat_out,container,false);
        listView = v.findViewById(R.id.item_chat_id);

        ButterKnife.bind(getActivity());
        tokenManager = TokenManager.getInstance(getActivity().getSharedPreferences("prefs",MODE_PRIVATE));
        service = RetrofitBuilder.createService(ApiService.class);

//        call = service.

        ChatModelist = new ArrayList<>();

//        ChatModel model = new ChatModel(R.drawable.house1, "shimi", "11:11", R.drawable.house);
//        ChatModel model1 = new ChatModel(R.drawable.house1, "chounry", "11:11", R.drawable.house);
//        ChatModel model2 = new ChatModel(R.drawable.house1, "koung", "11:11", R.drawable.house);

//        ChatModelist.add(model);
//        ChatModelist.add(model1);
//        ChatModelist.add(model2);

        adapter = new ListChatAdapter(getContext(),ChatModelist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), ChatInActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
