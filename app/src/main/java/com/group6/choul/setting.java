package com.group6.choul;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class setting extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.setting,container,false);
        return v;
    }

    @Override
    public void onClick (View v) {
        Log.e("Something","No");
        switch (v.getId()) {
            case R.id.img_personalInfo:
                Log.e("Something","Nothiing");
//                Intent intent = new Intent(getActivity(), PersonalInfoActivity.class);
//                startActivity(intent);
                break;
        }
    }

}
