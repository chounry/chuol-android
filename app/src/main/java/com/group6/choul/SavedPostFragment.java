package com.group6.choul;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

public class SavedPostFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.saved_post,container,false);
        return v;
    }
}
