package com.group6.choul.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.group6.choul.FilterActivity;
import com.group6.choul.HouseDetailActivity;
import com.group6.choul.R;
import com.group6.choul.adapters.HouseListAdapter;
import com.group6.choul.adapters.SignupAdapter;
import com.group6.choul.models.HomeModel;
import com.group6.choul.models.SignupModel;

import java.util.ArrayList;
import java.util.List;

public class SignupFragement extends Fragment {
    private EditText editText;
    private TextView textView;
    private SignupAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.signup_fragement,container,false);
        editText = v.findViewById(R.id.ed_firstname);
        editText = v.findViewById(R.id.ed_lastname);
        editText = v.findViewById(R.id.ed_email);
        editText = v.findViewById(R.id.ed_phone);
        editText = v.findViewById(R.id.ed_password);
        textView = v.findViewById(R.id.txt_firstname);
        textView = v.findViewById(R.id.txt_lastname);
        textView = v.findViewById(R.id.txt_email);
        textView = v.findViewById(R.id.txt_phone);
        textView = v.findViewById(R.id.txt_password);


        return v;
    }

}
