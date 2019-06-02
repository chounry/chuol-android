package com.group6.choul.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;


import android.util.Log;
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
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class ChatOutFragment extends Fragment {

    private ListView listView ;
    private List<ChatModel> chatModelist;
    private ListChatAdapter adapter;

    ApiService service;
    TokenManager tokenManager;
    Call<List<ChatModel>> call;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat_out,container,false);
        listView = v.findViewById(R.id.item_chat_id);

        chatModelist = new ArrayList<>();

        ButterKnife.bind(getActivity());
        tokenManager = TokenManager.getInstance(getActivity().getSharedPreferences("prefs",MODE_PRIVATE));
        service = RetrofitBuilder.createService(ApiService.class);

        call = service.get_chat_room(tokenManager.getUserId());
        call.enqueue(new Callback<List<ChatModel>>() {
            @Override
            public void onResponse(Call<List<ChatModel>> call, Response<List<ChatModel>> response) {
                if(response.isSuccessful()){
                    chatModelist = response.body();

                    adapter = new ListChatAdapter(getContext(),chatModelist);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ChatModel>> call, Throwable t) {
                Log.e("Chat Out Fragment : ", t.toString());
            }
        });

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
