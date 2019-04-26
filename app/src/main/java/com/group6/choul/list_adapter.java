package com.group6.choul;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class list_adapter extends BaseAdapter {
    private Context context;
    private List <radio_model> modeList;

    public list_adapter(Context context , List<radio_model> modeList){
        this.context = context;
        this.modeList = modeList;
    }
    @Override
    public int getCount() {
        return modeList.size();
    }

    @Override
    public Object getItem(int position) {
        radio_model model = modeList.get(position);
        return modeList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =View.inflate(context,R.layout.custom_listview,null);


        TextView textviewtitle = v.findViewById(R.id.tv_title);
        ImageView imageView = v.findViewById(R.id.image_view);

        radio_model obj = modeList.get(position);

        imageView.setImageResource(obj.getImg_id());
        textviewtitle.setText(obj.getTitle());
        return v;
    }
}
