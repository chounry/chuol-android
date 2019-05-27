package com.group6.choul;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.group6.choul.login_register_handling.AccessToken;
import com.group6.choul.login_register_handling.ApiService;
import com.group6.choul.login_register_handling.RetrofitBuilder;
import com.group6.choul.login_register_handling.TokenManager;
import com.group6.choul.models.ResponseStatus;
import com.group6.choul.models.UserModel;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PersonalInfoActivity extends AppCompatActivity {
    private EditText et_fname,et_lname,et_email,et_phone;
    private Button submit_btn;

    ApiService service;
    TokenManager tokenManager;
    Call<UserModel> call;
    Call<ResponseStatus> callResponse;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        et_fname = findViewById(R.id.et_fname);
        et_lname = findViewById(R.id.et_lname);
        et_email = findViewById(R.id.et_email);
        et_phone = findViewById(R.id.et_phone);
        submit_btn = findViewById(R.id.submit_btn);

        ButterKnife.bind(this);
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",MODE_PRIVATE));
        service = RetrofitBuilder.createServiceWithAuth(ApiService.class, tokenManager);

        call = service.get_user();
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(response.isSuccessful()){
                    userModel = response.body();
                    loadData(userModel);
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });

        // <------- handle toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        showActionBar();
        // <------- handle toolbar

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = userModel.getId();
                String fname = et_fname.getText().toString();
                String lname = et_lname.getText().toString();
                String email = et_email.getText().toString();
                String phone = et_phone.getText().toString();

                service = RetrofitBuilder.createService(ApiService.class);
                callResponse = service.update_user(id,fname, lname,email, phone);
                callResponse.enqueue(new Callback<ResponseStatus>() {
                    @Override
                    public void onResponse(Call<ResponseStatus> call, Response<ResponseStatus> response) {
                        if(response.isSuccessful()){
                            Log.e("Update Personal info : ", response.body().getStatus() );
                            String responseStatus = response.body().getStatus();
                            if(responseStatus.equals("success")){
                                finish();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseStatus> call, Throwable t) {

                    }
                });
            }
        });
    }



    private void loadData(UserModel responseBody){
        et_fname.setText(responseBody.getFname());
        et_lname.setText(responseBody.getLname());
        et_email.setText(responseBody.getEmail());
        et_phone.setText(responseBody.getPhone());
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
