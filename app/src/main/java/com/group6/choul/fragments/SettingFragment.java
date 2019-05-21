package com.group6.choul.fragments;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.group6.choul.PersonalInfoActivity;
import com.group6.choul.R;

public class SettingFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.m_setting_fragment,container,false);

        return v;
    }



    @Override
    public void onClick (View v) {
        Log.e("Something","No");
        switch (v.getId()) {
            case R.id.txt_personalInfo:
                Log.e("Something","Nothiing");
                Intent intent = new Intent(getActivity(), PersonalInfoActivity.class);
                startActivity(intent);
                break;
        }
    }

}
