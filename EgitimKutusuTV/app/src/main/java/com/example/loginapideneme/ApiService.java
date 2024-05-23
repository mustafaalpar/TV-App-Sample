package com.example.loginapideneme;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("api.php")
    Call<LoginResponse> login(
            @Header("username") String username,
            @Header("password") String password,
            @Header("token") String token
    );
}