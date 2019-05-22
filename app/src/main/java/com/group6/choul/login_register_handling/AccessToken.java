package com.group6.choul.login_register_handling;

import com.squareup.moshi.Json;

public class AccessToken {
    @Json(name = "token_type")
    String tokenType;
    @Json(name = "expires_in")
    int expiresIn;
    @Json(name = "access_token")
    String accessToken;
    @Json(name = "refesh_token")
    String refreshToken;

}
