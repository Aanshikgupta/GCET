package com.example.gcet.Network;


import com.example.gcet.Network.POJOModels.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetNews {

    @GET("/v2/top-headlines?country=in&category=technology&apiKey=486c7c896e0144838b78b4cd3f4e588e")
    Call<Response> getResponse();
}
