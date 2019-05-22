package com.group6.choul.login_register_handling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.group6.choul.R;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.fname_et)
    private EditText fname_et;
    @BindView(R.id.lname_et)
    private EditText lname_et;
    @BindView(R.id.email_et)
    private EditText email_et;
    @BindView(R.id.phone_et)
    private EditText phone_et;
    @BindView(R.id.password_et)
    private EditText password_et;
    @BindView(R.id.confirm_password_et)
    private EditText confirm_password_et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }

    @OnClick(R.id.submit_btn)
    void register(){

    }
}
