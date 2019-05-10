package com.group6.choul;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class list_chat_adapter extends BaseAdapter {

    private Context context;
    private List<ChatModel> modeList;

    public list_chat_adapter(Context context , List<ChatModel> modeList){
        this.context = context;
        this.modeList= modeList;
    }


    @Override
    public int getCount() {
        return modeList.size();
    }

    @Override
    public Object getItem(int position) {
        ChatModel model = modeList.get(position);
        return modeList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =View.inflate(context,R.layout.chat1,null);


        ImageView imageView  = v.findViewById(R.id.profile_image);
        TextView textviewName = v.findViewById(R.id.userName);
        TextView textviewTime = v.findViewById(R.id.chatTime);
        ImageView imgView  = v.findViewById(R.id.imgViewProduct);

        ChatModel obj = modeList.get(position);

        imageView.setImageResource(obj.getImg_id());
        textviewName.setText(obj.getName());
        textviewTime.setText(obj.getTime());
        imgView.setImageResource(obj.getImgProfile());

        return v;
    }

}
