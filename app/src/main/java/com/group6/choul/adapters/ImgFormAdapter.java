package com.group6.choul.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.flexbox.FlexboxLayoutManager;
import com.group6.choul.R;
import com.group6.choul.models.ImgFormModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImgFormAdapter extends RecyclerView.Adapter<ImgViewHolder> {
    private List<ImgFormModel> imgList;
    private Context context;

    public ImgFormAdapter(List<ImgFormModel> imgList,Context context) {
        this.imgList = imgList;
        this.context = context;
    }

    @NonNull
    @Override
    public ImgViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        Log.e("Seomthing","Nothing");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.img_each_post, null);
        return new ImgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImgViewHolder imgViewHolder, int i) {
        Picasso.get().load(imgList.get(i).getImgStr()).into(imgViewHolder.mImgView);
        final CardView tmpCardView = imgViewHolder.mCardView;

        imgViewHolder.mCardView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
//                mCardView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int cardWidth = tmpCardView.getWidth();
                int eachWidth = cardWidth / 2;
//                FlexboxLayoutManager.LayoutParams param = new FlexboxLayoutManager.LayoutParams(190, ViewGroup.LayoutParams.WRAP_CONTENT);
//                tmpCardView.setLayoutParams(param);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.imgList.size();
    }
}


class ImgViewHolder extends RecyclerView.ViewHolder {

    ImageView mImgView;
    ImageButton mImgBtn;
    public CardView mCardView;


    public ImgViewHolder(@NonNull View itemView) {
        super(itemView);
        mImgView = itemView.findViewById(R.id.img_view);
        mImgBtn = itemView.findViewById(R.id.delete_img_btn);
//        mCardView = itemView.findViewById(R.id.m_linear_layout);
        mCardView = itemView.findViewById(R.id.m_card_view);


    }

//    void bindTo(Drawable drawable) {
//        mImgView.setImageDrawable(drawable);
//        ViewGroup.LayoutParams lp = mImgView.getLayoutParams();
//        if (lp instanceof FlexboxLayoutManager.LayoutParams) {
//            FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams)lp;
//            flexboxLp.setFlexGrow(1.0f);
//        }
//    }
}
