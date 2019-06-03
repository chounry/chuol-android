package com.group6.choul.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.group6.choul.R;
import com.group6.choul.models.HouseModel;
import com.squareup.picasso.Picasso;

import java.util.List;


public class SavePostAdapter extends BaseAdapter {
    private Context context;
    private List<HouseModel> modeList;
    private String text = "Save";

    public SavePostAdapter(Context context, List<HouseModel> modeList) {
        this.context = context;
        this.modeList = modeList;
    }

    @Override
    public int getCount() {
        return modeList.size();
    }


    @Override
    public Object getItem(int position) {
        HouseModel model = modeList.get(position);
        return modeList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textviewTitle;
        TextView textviewPrice;
        TextView textviewAddress;
        TextView textviewLocation, for_sale_rent_status;
        TextView textviewType;
        ImageView imageView;
        TextView txtSave;
        View v ;

        if (modeList.get(position).getType() == null) {
            v = View.inflate(context, R.layout.item_room_each, null);
            imageView = v.findViewById(R.id.imgView_room);
            textviewLocation = v.findViewById(R.id.location_room);
            textviewAddress = v.findViewById(R.id.address_room);
            textviewPrice = v.findViewById(R.id.price_room);
            textviewTitle = v.findViewById(R.id.title_room);
            txtSave = v.findViewById(R.id.RoomSave);

            HouseModel obj = modeList.get(position);
            Picasso.get().load(obj.getImg_url()).into(imageView);
            textviewLocation.setText(obj.getLocation());
            textviewAddress.setText(obj.getAddress());
            textviewPrice.setText(obj.getPrice());
            textviewTitle.setText(obj.getTitle());
            txtSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (text == "Save") {

                        text = "unsave";
                        txtSave.setText(text);
                    } else {
                        text = "Save";
                        txtSave.setText(text);
                    }

                }
            });

        }
        else{
            v = View.inflate(context, R.layout.item_each_house, null);
            textviewTitle = v.findViewById(R.id.title_home);
            textviewPrice = v.findViewById(R.id.price_home);
            textviewAddress = v.findViewById(R.id.address_home);
            textviewLocation= v.findViewById(R.id.location_home);
            textviewType = v.findViewById(R.id.type_home);
            for_sale_rent_status = v.findViewById(R.id.for_sale_rent_tv);
            imageView = v.findViewById(R.id.imgView_house);

            HouseModel obj = modeList.get(position);
            Picasso.get().load(obj.getImg_url()).into(imageView);
            textviewLocation.setText(obj.getLocation());
            textviewAddress.setText(obj.getAddress());
            textviewPrice.setText(obj.getPrice());
            textviewTitle.setText(obj.getTitle());
            textviewType.setText(obj.getType());
            for_sale_rent_status.setText(obj.getFor_sale_rent_status());
        }
        return v;
    }

}


