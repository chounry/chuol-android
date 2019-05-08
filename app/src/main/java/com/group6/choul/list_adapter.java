package com.group6.choul;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.group6.choul.models.HomeModel;

import java.util.List;

public class list_adapter extends BaseAdapter {
    private Context context;
    private List <HomeModel> modeList;

    public list_adapter(Context context , List<HomeModel> modeList){
        this.context = context;
        this.modeList = modeList;
    }
    @Override
    public int getCount() {
        return modeList.size();
    }

    @Override
    public Object getItem(int position) {
        HomeModel model = modeList.get(position);
        return modeList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =View.inflate(context,R.layout.home1,null);


        TextView textviewTitle = v.findViewById(R.id.title_home);
        TextView textviewPrice = v.findViewById(R.id.price);
        TextView textviewAddress = v.findViewById(R.id.address);
        TextView textviewLocation = v.findViewById(R.id.location);
        TextView textviewType = v.findViewById(R.id.type);
        ImageView imageView = v.findViewById(R.id.imgView);

        HomeModel obj = modeList.get(position);

        imageView.setImageResource(obj.getImg_id());
        textviewTitle.setText(obj.getTitle());
        textviewPrice.setText(obj.getPrice());
        textviewAddress.setText(obj.getAddress());
        textviewLocation.setText(obj.getLocation());
        textviewType.setText(obj.getType());
        return v;
    }
}
