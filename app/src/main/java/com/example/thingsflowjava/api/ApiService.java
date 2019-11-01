package com.example.thingsflowjava.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/repos/google/dagger/issues")
    Call<List<Item>> itemLists();
}
