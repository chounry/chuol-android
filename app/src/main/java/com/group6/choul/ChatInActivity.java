package com.group6.choul;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group6.choul.adapters.MessageListAdapter;
import com.group6.choul.login_register_handling.ApiService;
import com.group6.choul.login_register_handling.TokenManager;
import com.group6.choul.models.MemberDataForChat;
import com.group6.choul.models.MessageModel;
import com.scaledrone.lib.Listener;
import com.scaledrone.lib.Message;
import com.scaledrone.lib.Room;
import com.scaledrone.lib.RoomListener;
import com.scaledrone.lib.Scaledrone;

import java.util.ArrayList;
import java.util.List;

public class ChatInActivity extends AppCompatActivity implements RoomListener {

    private String channelID = "DGIuZ5gOpwXwUfB1";
    private String roomName = "observable-room";
    private Scaledrone scaledrone;

    private EditText mstEt;
    private ImageButton sendBtn;
    private ListView listView;
    private List<MessageModel> messageModelList;
    private MessageListAdapter messageAdapter;

    private ApiService service;
    private TokenManager tokenManager;
//    private Call<>

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_in);
        mstEt = findViewById(R.id.msg_et);
        sendBtn = findViewById(R.id.send_btn);

        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",MODE_PRIVATE));


        //------------ Action bar thing
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        showActionBar();
        // Action bar thing ------------

        listView = findViewById(R.id.message_listView);
        sendBtn = findViewById(R.id.send_btn);
        messageModelList = new ArrayList<>();


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        messageAdapter = new MessageListAdapter(this, messageModelList);
        listView.setDivider(null);
        listView.setAdapter(messageAdapter);
    }


    private void initMessage(){
        MemberDataForChat data = new MemberDataForChat("","https://wowsciencecamp.org/wp-content/uploads/2018/07/dummy-user-img-1-400x400_x_acf_cropped.png");
        scaledrone = new Scaledrone(channelID, data);
        scaledrone.connect(new Listener() {
            @Override
            public void onOpen() {
                System.out.println("Scaledrone connection open");
                // Since the MainActivity itself already implement RoomListener we can pass it as a target
                scaledrone.subscribe(roomName, ChatInActivity.this);
            }

            @Override
            public void onOpenFailure(Exception ex) {
                System.err.println(ex);
            }

            @Override
            public void onFailure(Exception ex) {
                System.err.println(ex);
            }

            @Override
            public void onClosed(String reason) {
                System.err.println(reason);
            }
        });

    }

    @Override
    public void onOpen(Room room) {
        Log.e("Scale Drom onOpen Status : ", "Successful");

    }

    @Override
    public void onOpenFailure(Room room, Exception ex) {
        Log.e("Scale Drom onOpen Status : ", "Faild");
    }

    @Override
    public void onMessage(Room room, Message message) {

        final ObjectMapper mapper = new ObjectMapper();
        try {
            // member.clientData is a MemberData object, let's parse it as such
            final MemberDataForChat data = mapper.treeToValue(message.getMember().getClientData(), MemberDataForChat.class);
            Log.e("MData ", data.getName());
            // if the clientID of the message sender is the same as our's it was sent by us
            boolean belongsToCurrentUser = message.getClientID().equals(scaledrone.getClientID());
            // since the message body is a simple string in our case we can use json.asText() to parse it as such
            // if it was instead an object we could use a similar pattern to data parsing
            final MessageModel recieve_message = new MessageModel(message.getData().asText(), belongsToCurrentUser, data);
            if(belongsToCurrentUser){

            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mstEt.getText().clear(); // clear edit text
                    messageAdapter.add(recieve_message);
                    // scroll the ListView to the last added element
                    listView.setSelection(listView.getCount() - 1);
                }
            });
        } catch (JsonProcessingException e) {
            Toast.makeText(this, "No Connection", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void sendMessage(){
        String message = mstEt.getText().toString();
        if (message.length() > 0) {
//            messageAdapter.add(new MessageModel(message, false, new MemberData("Chounry","https://wowsciencecamp.org/wp-content/uploads/2018/07/dummy-user-img-1-400x400_x_acf_cropped.png")));
            scaledrone.publish(roomName, message);

        }
    }

    public void saveMyMessage(){

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
