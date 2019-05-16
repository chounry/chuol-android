package com.group6.choul;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


@SuppressLint("ValidFragment")
public class setting extends Fragment implements View.OnClickListener {
    private TextView aboutUsTv;
    private Context context;

    public setting(){}

    public setting(Context context){
        this.context = context;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.setting,container,false);
        aboutUsTv = v.findViewById(R.id.about_us_tv);


        aboutUsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personalInfoIntent = new Intent(context, PersonalInfoActivity.class);
                startActivity(personalInfoIntent);
            }
        });

        return v;
    }



    @Override
    public void onClick (View v) {
        Log.e("Something","No");
        switch (v.getId()) {
            case R.id.txt_personalInfo:
                Log.e("Something","Nothiing");
//                Intent intent = new Intent(getActivity(), PersonalInfoActivity.class);
//                startActivity(intent);
                break;
        }
    }

}
