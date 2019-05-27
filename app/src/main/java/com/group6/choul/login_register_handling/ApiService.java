package com.group6.choul.login_register_handling;

import com.group6.choul.models.ResponseStatus;
import com.group6.choul.models.UserModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @POST("register")
    @FormUrlEncoded
    Call<AccessToken> register(@Field("fname") String fname, @Field("lname") String laname,@Field("email") String email, @Field("password") String password, @Field("password_confirmation") String password_confirmation , @Field("phone") String phone);

    @POST("login")
    @FormUrlEncoded
    Call<AccessToken> login(@Field("email") String email,@Field("password") String password);

    @POST("refresh")
    @FormUrlEncoded
    Call<AccessToken> refresh(@Field("refresh_token") String refreshToken);

    @POST("logout")
    Call<AccessToken> logout();

    @POST("get-user")
    Call<UserModel> get_user();

    @POST("edit")
    @FormUrlEncoded
    Call<ResponseStatus> update_user(@Field("id") int id,@Field("fname") String fname,@Field("lname") String lname,@Field("email") String email,@Field("phone") String phone);

}
