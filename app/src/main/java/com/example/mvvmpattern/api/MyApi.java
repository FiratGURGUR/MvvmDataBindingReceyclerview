package com.example.mvvmpattern.api;

import com.example.mvvmpattern.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {

    @GET("marvel")
    Call<List<Hero>> getHeroes();

}
