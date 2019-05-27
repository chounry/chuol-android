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
import com.group6.choul.MainActivity;
import com.group6.choul.R;
import com.group6.choul.models.HomeModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.OnClick;


public class HouseListAdapter extends RecyclerView.Adapter<MyHomeRecyClerView>{

    private List<HomeModel> modelList;
    private Context context; // new
    private RecyclerView recyclerViewHome;
    private View.OnClickListener mOnClickListener;


    public HouseListAdapter(List<HomeModel> modelList, Context context, RecyclerView recyclerViewHome) {
        this.modelList = modelList;
        this.context = context;
        this.recyclerViewHome = recyclerViewHome;
    }

    @NonNull
    @Override
    public MyHomeRecyClerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_each_house,null);
        mOnClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int itemPos = recyclerViewHome.getChildLayoutPosition(v);
                Intent intent = new Intent(context, HouseDetailActivity.class);
                context.startActivity(intent);
            }
        };
        myView.setOnClickListener(mOnClickListener);
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


