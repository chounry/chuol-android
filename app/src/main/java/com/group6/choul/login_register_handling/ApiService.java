package com.group6.choul.login_register_handling;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @POST("register")
    @FormUrlEncoded
    Call<AccessToken> register(@Field("fname") String fname, @Field("lname") String laname,@Field("email") String email, @Field("password") String password , @Field("phone") String phone);
}
