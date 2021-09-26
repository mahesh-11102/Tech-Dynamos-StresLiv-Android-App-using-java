package com.example.tech_dynamosstresliv.Ai_Chat;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET
    Call<MsgModal> getMessage(@Url String url);
}
