package com.group6.choul.login_register_handling;

import com.group6.choul.models.ChatModel;
import com.group6.choul.models.MessageModel;
import com.group6.choul.models.ResponseStatus;
import com.group6.choul.models.UserModel;

import java.util.List;

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

    @POST("messages/get")
    @FormUrlEncoded
    Call<List<ChatModel>> get_chat_room(@Field("user_id") int user_id);

    @POST("messages/detail")
    @FormUrlEncoded
    Call<List<MessageModel>> get_messages(@Field("estate_id") int estate_id,@Field("user_id") int user_id);

    @POST("messages/create")
    @FormUrlEncoded
    Call<ResponseStatus> create_message(@Field("content") String content,@Field("from_self_user_id")int from_self_user_id,@Field("to_user_user_id") int to_user_user_id,@Field("estate_id")String estate_id);
}
