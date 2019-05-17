package com.group6.choul;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class relatedadapter extends RecyclerView.Adapter<relatedadapter.MyViewHolder> {

    private List<realatedmodel> modelList;
    private Context context;

    public relatedadapter(List<realatedmodel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public relatedadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View myView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customraletedview, viewGroup,false );
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull relatedadapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.textViewTitle.setText(modelList.get(i).getTitle());
        myViewHolder.textViewDescription.setText(modelList.get(i).getDescriptino());
        Picasso.get().load(modelList.get(i).getImg()).into(myViewHolder.img);

    }

    @Override
    public int getItemCount() {
        return this.modelList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDescription;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.related_title);
            textViewDescription = itemView.findViewById(R.id.related_description);
            img = itemView.findViewById(R.id.house_related_img);

        }
    }

}
