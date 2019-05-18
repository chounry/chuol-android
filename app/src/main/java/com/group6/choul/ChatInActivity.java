package com.group6.choul;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.group6.choul.adapters.MessageListAdapter;
import com.group6.choul.models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class ChatInActivity extends AppCompatActivity {

    private ListView listView;
    private List<MessageModel> messageModelList;
    private MessageListAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_in);

        //------------ Action bar thing
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        showActionBar();
        // Action bar thing ------------

        listView = findViewById(R.id.message_listView);

        messageModelList = new ArrayList<>();

        MessageModel receive1 = new MessageModel("Hi","https://img.icons8.com/bubbles/2x/user.png",false);
        MessageModel receive2 = new MessageModel("What is your name?","https://img.icons8.com/bubbles/2x/user.png",false);
        MessageModel response1 = new MessageModel("Hi my name is Something",true);
        MessageModel receive3 = new MessageModel("Oh","https://img.icons8.com/bubbles/2x/user.png",false);


        messageModelList.add(receive1);
        messageModelList.add(receive2);
        messageModelList.add(response1);
        messageModelList.add(receive3);
        messageModelList.add(receive1);
        messageModelList.add(receive2);
        messageModelList.add(response1);
        messageModelList.add(receive3);
        messageModelList.add(receive1);
        messageModelList.add(receive2);
        messageModelList.add(response1);
        messageModelList.add(receive3);
        messageModelList.add(receive1);
        messageModelList.add(receive2);
        messageModelList.add(response1);
        messageModelList.add(receive3);
        messageAdapter = new MessageListAdapter(this,messageModelList);
        listView.setDivider(null);
        listView.setAdapter(messageAdapter);
    }

    private void showActionBar() {
        LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.custom_action_bar, null);
        ImageButton backBtn = v.findViewById(R.id.nav_back_btn);

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled (false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setCustomView(v);
    }
}
