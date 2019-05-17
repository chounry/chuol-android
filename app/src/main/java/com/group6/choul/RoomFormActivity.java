package com.group6.choul;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;


import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.group6.choul.adapters.ImgFormAdapter;
import com.group6.choul.models.ImgFormModel;

import java.util.ArrayList;
import java.util.List;

public class RoomFormActivity extends AppCompatActivity{
    Button service_btn;
//    TextView mItemSelected;
    String[] listItems = {"Free Wifi","Available Parking Space"};
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();

    private ImageButton map_imgBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_form_activity);

        // <------- handle toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        showActionBar();
        // <------- handle toolbar

        //<------------- Handle img upload layout
        List<ImgFormModel> img_models_list = new ArrayList<>();
        img_models_list.add(new ImgFormModel("https://images.unsplash.com/photo-1480074568708-e7b720bb3f09?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80"));
        img_models_list.add(new ImgFormModel("https://www.amaialand.com/wp-content/uploads/2017/04/series-novaliches-townhome-list-img-1.jpg"));
        img_models_list.add(new ImgFormModel("https://www.amaialand.com/wp-content/uploads/2017/04/series-novaliches-townhome-list-img-1.jpg"));
        img_models_list.add(new ImgFormModel("https://www.amaialand.com/wp-content/uploads/2017/04/series-novaliches-townhome-list-img-1.jpg"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.img_recyler_view);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager();
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setAlignItems(AlignItems.STRETCH);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        RecyclerView.Adapter adapter = new ImgFormAdapter(img_models_list,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        // Handle img upload layout ------------------->



        service_btn = findViewById(R.id.select_service_btn);

        map_imgBtn = findViewById(R.id.map_imgBtn);
        checkedItems = new boolean[listItems.length]; // var for multiple select

        // handle multiple select services
        service_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(RoomFormActivity.this);
                mBuilder.setTitle("Select All Available Services");

                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if(isChecked){

                            mUserItems.add(position);
                        }else{
                            mUserItems.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < mUserItems.size(); i++) {
                            item = item + listItems[mUserItems.get(i)];
                            if (i != mUserItems.size() - 1) {
                                item = item + ", ";
                            }
                        }
//                        mItemSelected.setText(item);
                    }
                });

                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setNeutralButton("Clear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            mUserItems.clear();
//                            mItemSelected.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();

                mDialog.show();
            }
        });

        map_imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapFormActivity.class);
                startActivity(intent);
            }
        });
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
