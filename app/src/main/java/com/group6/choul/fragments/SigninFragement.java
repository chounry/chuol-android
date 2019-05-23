package com.group6.choul.fragments;

import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.group6.choul.R;
import com.group6.choul.adapters.SignupAdapter;

public class SigninFragement extends Fragment {
    private EditText editText;
    private TextView textView;
    private SignupAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.signup_fragement,container,false);
        editText = v.findViewById(R.id.si_ed_email);
        editText = v.findViewById(R.id.si_ed_password);
        textView = v.findViewById(R.id.si_txt_email);
        textView = v.findViewById(R.id.si_txt_password);


        return v;
    }

}
