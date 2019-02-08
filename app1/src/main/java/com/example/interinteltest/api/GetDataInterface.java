package com.example.interinteltest.api;

import com.example.interinteltest.model.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataInterface {

    @GET("/get")
    Call <JSONResponse> getOrigin();
}
