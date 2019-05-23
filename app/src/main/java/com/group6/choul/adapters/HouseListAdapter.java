package com.group6.choul.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.group6.choul.HouseDetailActivity;
import com.group6.choul.R;
import com.group6.choul.models.HomeModel;
import com.squareup.picasso.Picasso;

import java.util.List;

//class HouseListAdapter1 extends BaseAdapter {
//    private Context context;
//    private List <HomeModel> modeList;
//
//    public HouseListAdapter(Context context , List<HomeModel> modeList){
//        this.context = context;
//        this.modeList = modeList;
//    }
//    @Override
//    public int getCount() {
//        return modeList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        HomeModel model = modeList.get(position);
//        return modeList;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View v = View.inflate(context, R.layout.item_each_house,null);
//
//        TextView textviewTitle = v.findViewById(R.id.title_home);
//        TextView textviewPrice = v.findViewById(R.id.price);
//        TextView textviewAddress = v.findViewById(R.id.address);
//        TextView textviewLocation = v.findViewById(R.id.location);
//        TextView textviewType = v.findViewById(R.id.type);
//        ImageView imageView = v.findViewById(R.id.imgView);
//
//        HomeModel obj = modeList.get(position);
//
//        Picasso.get().load(obj.getImg_url()).into(imageView);
//        textviewTitle.setText(obj.getTitle());
//        textviewPrice.setText(obj.getPrice());
//        textviewAddress.setText(obj.getAddress());
//        textviewLocation.setText(obj.getLocation());
//        textviewType.setText(obj.getType());
//
//        return v;
//    }
//}

public class HouseListAdapter extends RecyclerView.Adapter<MyHomeRecyClerView>{

    private List<HomeModel> modelList;
    private Context context; // new


    public HouseListAdapter(List<HomeModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHomeRecyClerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_each_house,null);
        return new MyHomeRecyClerView(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHomeRecyClerView holder, int position) {
        HomeModel obj = modelList.get(position);
        Picasso.get().load(obj.getImg_url()).into(holder.imageView);
        holder.textviewTitle.setText(obj.getTitle());
        holder.textviewPrice.setText(obj.getPrice());
        holder.textviewAddress.setText(obj.getAddress());
        holder.textviewLocation.setText(obj.getLocation());
        holder.textviewType.setText(obj.getType());
    }

    @Override
    public int getItemCount() {
        return this.modelList.size();
    }
}

class MyHomeRecyClerView extends RecyclerView.ViewHolder{

    TextView textviewTitle;
    TextView textviewPrice;
    TextView textviewAddress;
    TextView textviewLocation;
    TextView textviewType;
    ImageView imageView;

    public MyHomeRecyClerView(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imgView);
        textviewType = itemView.findViewById(R.id.type);
        textviewLocation = itemView.findViewById(R.id.location);
        textviewAddress = itemView.findViewById(R.id.address);
        textviewPrice = itemView.findViewById(R.id.price);
        textviewTitle = itemView.findViewById(R.id.title_home);
    }
}


