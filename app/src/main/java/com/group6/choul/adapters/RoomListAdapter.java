package com.group6.choul.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.group6.choul.R;
import com.group6.choul.models.RoomModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RoomListAdapter extends RecyclerView.Adapter<MyRoomRecyClerView> {

    private Context context;
    private List<RoomModel> modeList;

    public RoomListAdapter(Context context , List<RoomModel> modeList){
        this.context = context;
        this.modeList = modeList;
    }

    @NonNull
    @Override
    public MyRoomRecyClerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room_each,null);
        return new MyRoomRecyClerView(myView);
    }


    @Override
    public void onBindViewHolder(@NonNull MyRoomRecyClerView holder, int position) {
        RoomModel obj = modeList.get(position);
        Picasso.get().load(obj.getImg_url()).into(holder.imageView);
        holder.textviewTitle.setText(obj.getTitle());
        holder.textviewPrice.setText(obj.getPrice());
        holder.textviewAddress.setText(obj.getAddress());
        holder.textviewLocation.setText(obj.getLocation());
        Picasso.get().load(obj.getImg_url()).into(holder.imageView);

    }



    @Override
    public int getItemCount() {
        return this.modeList.size();
    }

}

class MyRoomRecyClerView extends RecyclerView.ViewHolder{

    TextView textviewTitle;
    TextView textviewPrice;
    TextView textviewAddress;
    TextView textviewLocation;
    ImageView imageView;
    TextView txtSave;
    String text;

    public MyRoomRecyClerView(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imgView);
        textviewLocation = itemView.findViewById(R.id.location);
        textviewAddress = itemView.findViewById(R.id.address);
        textviewPrice = itemView.findViewById(R.id.price);
        textviewTitle = itemView.findViewById(R.id.title_home);
        txtSave = itemView.findViewById(R.id.RoomSave);

        txtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text == "Save"){
                    text = "unsave";
                    txtSave.setText(text);
                }
                else{
                    text = "Save";
                    txtSave.setText(text);
                }

            }
        });
    }
}
