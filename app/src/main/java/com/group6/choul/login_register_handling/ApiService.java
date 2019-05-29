package com.group6.choul.login_register_handling;

import com.group6.choul.models.ChatModel;
import com.group6.choul.models.ResponseStatus;
import com.group6.choul.models.UserModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @POST("auth/register")
    @FormUrlEncoded
    Call<AccessToken> register(@Field("fname") String fname, @Field("lname") String laname,@Field("email") String email, @Field("password") String password, @Field("password_confirmation") String password_confirmation , @Field("phone") String phone);

    @POST("auth/login")
    @FormUrlEncoded
    Call<AccessToken> login(@Field("email") String email,@Field("password") String password);

    @POST("auth/refresh")
    @FormUrlEncoded
    Call<AccessToken> refresh(@Field("refresh_token") String refreshToken);

    @POST("auth/logout")
    Call<AccessToken> logout();

    @POST("auth/get-user")
    Call<UserModel> get_user();

    @POST("auth/edit")
    @FormUrlEncoded
    Call<ResponseStatus> update_user(@Field("id") int id,@Field("fname") String fname,@Field("lname") String lname,@Field("email") String email,@Field("phone") String phone);

    @POST
    @FormUrlEncoded
    Call<ChatModel> get_chat_room(@Field("user_id") int user_id);
}
