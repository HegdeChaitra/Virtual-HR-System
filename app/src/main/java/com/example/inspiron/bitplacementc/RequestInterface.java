package com.example.inspiron.bitplacementc;

import com.example.inspiron.bitplacementc.Models.ServerRequest;
import com.example.inspiron.bitplacementc.Models.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Inspiron on 3/4/2017.
 */

public interface RequestInterface {
    @POST("android/login_registration/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
