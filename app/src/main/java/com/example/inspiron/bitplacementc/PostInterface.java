package com.example.inspiron.bitplacementc;

import com.example.inspiron.bitplacementc.Models.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Inspiron on 3/10/2017.
 */

public interface PostInterface {

    @GET("android/jsonandroid")
    Call<JSONResponse> getJSON();

}
