package com.example.library.inter;

import com.example.library.bean.ChangePasswordBean;
import com.example.library.bean.CreateUserBean;
import com.example.library.bean.LoginBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @POST("login/register")
    Call<CreateUserBean> registerUser(@Body RequestBody body);

    @GET("login/login")
    Call<LoginBean> login(@Query("user_id") String userId, @Query("password") String passwoed);

    @POST("login/password")   //???
    Call<ChangePasswordBean> changePassword(@Body RequestBody body);
}
